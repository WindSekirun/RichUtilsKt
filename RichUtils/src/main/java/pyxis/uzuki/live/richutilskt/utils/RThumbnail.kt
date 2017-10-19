package pyxis.uzuki.live.richutilskt.utils

import android.content.ContentValues.TAG
import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.webkit.MimeTypeMap
import java.io.File

/**
 * check uri is media uri
 * @return True if Uri is a MediaStore Uri.
 */
fun isMediaUri(uri: Uri?): Boolean = if (uri != null) {
    "media".equals(uri.authority, ignoreCase = true)
} else false


/**
 * Convert File into Uri.
 *
 * @param file
 * @return uri
 */
fun getUri(file: File?): Uri? {
    return if (file != null) {
        Uri.fromFile(file)
    } else null
}

/**
 * @return The MIME type for the given file.
 */
fun Context.getMimeType(file: File): String {
    val extension = getExtension(file.name)
    return if (extension.isNotEmpty()) MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.substring(1)) else "application/octet-stream"
}

/**
 * Gets the extension of a file name, like ".png" or ".jpg".
 *
 * @param uri
 * @return Extension including the dot("."); "" if there is no extension;
 * null if uri was null.
 */
fun Context.getExtension(uri: String?): String {
    if (uri == null) {
        return ""
    }

    val dot = uri.lastIndexOf(".")
    return if (dot >= 0) {
        uri.substring(dot)
    } else {
        ""
    }
}

/**
 * Attempt to retrieve the thumbnail of given File from the MediaStore. This
 * should not be called on the UI thread.
 *
 * @param context
 * @param file
 * @return
 * @author paulburke
 */
fun Context.getThumbnail(file: File): Bitmap? {
    return getThumbnail(getUri(file), getMimeType(file))
}

/**
 * Attempt to retrieve the thumbnail of given Uri from the MediaStore. This
 * should not be called on the UI thread.
 *
 * @param context
 * @param uri
 * @return
 * @author paulburke
 */
fun Context.getThumbnail(uri: Uri): Bitmap? {
    return getThumbnail(uri, getMimeType(File(uri.path)))
}

/**
 * Attempt to retrieve the thumbnail of given Uri from the MediaStore. This
 * should not be called on the UI thread.
 *
 * @param context
 * @param uri
 * @param mimeType
 * @return
 * @author paulburke
 */
fun Context.getThumbnail(uri: Uri?, mimeType: String): Bitmap? {
    if (!isMediaUri(uri)) {
        Log.e(TAG, "You can only retrieve thumbnails for images and videos.")
        return null
    }

    val cursor = this.contentResolver.query(uri, null, null, null, null)
    val list = generateSequence { if (cursor.moveToNext()) cursor else null }
            .map {  }

    var bm: Bitmap? = null
    if (uri != null) {
        val resolver = contentResolver
        var cursor: Cursor? = null
        try {
            cursor = resolver.query(uri, null, null, null, null)
            if (cursor!!.moveToFirst()) {
                val id = cursor!!.getInt(0)
                if (mimeType.contains("video")) {
                    bm = MediaStore.Video.Thumbnails.getThumbnail(resolver, id.toLong(), MediaStore.Video.Thumbnails.MINI_KIND, null)
                } else if (mimeType.contains("image/*")) {
                    bm = MediaStore.Images.Thumbnails.getThumbnail(resolver, id.toLong(), MediaStore.Images.Thumbnails.MINI_KIND, null)
                }
            }
        } catch (e: Exception) {
        } finally {
            if (cursor != null)
                cursor!!.close()
        }
    }
    return bm
}