@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

/**
 * Download bitmap from uri
 *
 * @param[imageUrl] imageUri
 * @return Bitmap object
 */
fun downloadBitmap(imageUrl: String): Bitmap? {
    var bitmap: Bitmap? = null
    val url = URL(imageUrl)
    val conn = url.openConnection() as HttpURLConnection

    conn.use {
        conn.connectTimeout = 10000
        conn.requestMethod = "GET"
        val resCode = conn.responseCode
        if (resCode == HttpURLConnection.HTTP_OK) {
            bitmap = conn.inputStream.outAsBitmap()
        }
    }

    return bitmap
}

/**
 * Download file from
 * @param[urlPath] path of file
 * @param[name] name of file
 * @param[isFullPath] true - custom path, false - name only (default - /sdcard/android/data/{package-name}/files
 * @return Uri object uri
 *
 */
@JvmOverloads fun Context.downloadFile(urlPath: String, name: String, isFullPath: Boolean = false): Uri? {
    var uri: Uri? = null
    val url = URL(urlPath)
    val conn = url.openConnection() as HttpURLConnection

    conn.use {
        conn.connectTimeout = 10000
        conn.requestMethod = "GET"
        val resCode = conn.responseCode

        if (resCode == HttpURLConnection.HTTP_OK) {

            val path = if (isFullPath) name else this.getExternalFilesDir(null).absolutePath + "/" + name
            uri = Uri.fromFile(conn.inputStream.outAsFile(File(path)))
        }
    }

    return uri
}

/**
 * Executes the given [block] function on this resource and then closes it down correctly whether an exception
 * is thrown or not.
 *
 * @param block a function to process this [HttpURLConnection] resource.
 * @return the result of [block] function invoked on this resource.
 */
inline fun <R> HttpURLConnection.use(block: (HttpURLConnection) -> R): R {
    var closed = false
    try {
        return block(this)
    } catch (e: Exception) {
        closed = true
        try {
            this.disconnect()
        } catch (closeException: Exception) {
        }
        throw e
    } finally {
        if (!closed) {
            this.disconnect()
        }
    }
}