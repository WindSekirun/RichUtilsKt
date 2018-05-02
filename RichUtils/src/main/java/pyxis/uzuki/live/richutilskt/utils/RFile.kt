@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.annotation.TargetApi
import android.content.ContentUris
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import pyxis.uzuki.live.richutilskt.impl.F1
import java.io.ByteArrayOutputStream
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset

/**
 * Download file from uri
 *
 * @param[urlPath] path of file
 * @param[localPath] full path of file to saved
 * @return Uri object
 */
fun downloadFile(urlPath: String, localPath: String, callback: (Uri?) -> Unit = {}): Uri? {
    var uri: Uri? = null
    val connection = URL(urlPath).openConnection() as HttpURLConnection;

    if (connection.responseCode == HttpURLConnection.HTTP_OK) {
        uri = Uri.fromFile(connection.inputStream.outAsFile(localPath.toFile()))
    }
    connection.disconnect()
    if (uri is Uri) {
        callback(uri)
    } else {
        callback(null)
    }
    return uri
}

/**
 * Download file from uri
 *
 * @param[urlPath] path of file
 * @param[localPath] full path of file to saved
 * @return Uri object
 */
fun downloadFile(urlPath: String, localPath: String, callback: F1<Uri>?): Uri? {
    var uri: Uri? = null
    val connection = URL(urlPath).openConnection() as HttpURLConnection

    if (connection.responseCode == HttpURLConnection.HTTP_OK) {
        uri = Uri.fromFile(connection.inputStream.outAsFile(localPath.toFile()))
    }
    connection.disconnect()
    callback?.invoke(uri)
    return uri
}

/**
 * make String to File
 */
fun String.toFile() = File(this)

/**
 * save file with content
 */
fun saveFile(fullPath: String, content: String): File = fullPath.toFile().apply {
    writeText(content, Charset.defaultCharset())
}

/**
 * read file to string
 */
fun File.readFile(): String = this.readText(Charset.defaultCharset())

/**
 * Get the value of the data column for this Uri. This is useful for
 * MediaStore Uris, and other file-based ContentProviders.

 * @param[context] The context.
 * @param[uri] The Uri to query.
 * @param[selection] (Optional) Filter used in the query.
 * @param[selectionArgs] (Optional) Selection arguments used in the query.
 * @return The value of the _data column, which is typically a file path.
 * @author paulburke, windsekirun
 */
private fun getDataColumn(context: Context, uri: Uri?, selection: String?, selectionArgs: Array<String>?): String {
    context.contentResolver.query(uri, arrayOf("_data"), selection, selectionArgs, null).use {
        try {
            if (it != null && it.moveToFirst()) {
                val columnIndex = it.getColumnIndexOrThrow("_data")
                return it.getString(columnIndex)
            }
        } catch (e: IllegalStateException) {
            // fallback when it.getString(columnIndex) must be not null
            // most case, user tried to fetch an image that does not exist on physical device
            // See issue #47.
            return getImageUrlWithAuthority(context, uri!!) ?: ""
        }
    }
    return ""
}

/**
 * Get real sd-card path from DocumentsProvider, MediaStore Uris,
 * and other file-based ContentProviders.
 *
 * infix supported.
 *
 * @param[context] The context.
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
infix fun Uri.getRealPath(context: Context): String {
    val isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT

    if (cloudAuthorityProvider.containsIgnoreCase(authority)) {
        return getImageUrlWithAuthority(context, this) ?: ""
    }

    if (isKitKat && DocumentsContract.isDocumentUri(context, this)) {
        return checkAuthority(context)
    }

    if (this.scheme.equals("content", ignoreCase = true)) {
        return getDataColumn(context, this, null, null)
    }

    if (this.scheme.equals("file", ignoreCase = true)) {
        return this.path
    }

    return this.path
}

private fun List<String>.containsIgnoreCase(item: String): Boolean {
    return this.map { it.equals(item, true) }.any { true }
}

private val cloudAuthorityProvider = arrayListOf("com.google.android.apps.photos.content",
        "com.google.android.apps.photos.contentprovider",
        "com.sec.android.gallery3d.provider")

private fun getImageUrlWithAuthority(context: Context, uri: Uri): String? {
    uri.tryCatch {
        val inputStream = context.contentResolver.openInputStream(uri)
        val bmp = BitmapFactory.decodeStream(inputStream)
        val url = bmp.writeImageIntoMediaStore(context)
        inputStream.close()

        return getDataColumn(context, url, null, null)
    }
}

private fun Bitmap.writeImageIntoMediaStore(inContext: Context): Uri {
    val bytes = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
    val path = MediaStore.Images.Media.insertImage(inContext.contentResolver, this, System.currentTimeMillis().asDateString(), null)
    return Uri.parse(path)
}

private fun Uri.checkAuthority(context: Context): String {
    val docId = DocumentsContract.getDocumentId(this)
    val split = docId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

    if ("com.android.externalstorage.documents" == this.authority) {

        val type = split[0]

        if ("primary".equals(type, ignoreCase = true))
            return Environment.getExternalStorageDirectory().toString() + "/" + split[1]

    } else if ("com.android.providers.downloads.documents" == this.authority) {
        return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), docId.toLong()), null, null)
    } else if ("com.android.providers.media.documents" == this.authority) {
        val contentUri = when (split[0]) {
            "image" -> MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            "video" -> MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            "audio" -> MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            else -> MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }

        return getDataColumn(context, contentUri, "_id=?", arrayOf(split[1]))
    }

    return this.path
}