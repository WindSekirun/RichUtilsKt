@file:JvmName("Utils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
    var bmp: Bitmap? = null
    try {
        val url = URL(imageUrl)
        val conn = url.openConnection() as HttpURLConnection

        conn.connectTimeout = 10000
        conn.requestMethod = "GET"

        val resCode = conn.responseCode
        if (resCode == HttpURLConnection.HTTP_OK) {
            bmp = conn.inputStream.outAsBitmap()
        }
    } catch (e: Exception) {
        println(e.toString())
    }

    return bmp
}

/**
 * Download file from uri
 *
 * @param[urlPath] path of file
 * @param[name] name of file
 * @return Uri object
 */
fun Context.downloadFile(urlPath: String, name: String): Uri? {
    var uri: Uri? = null
    try {
        val url = URL(urlPath)
        val conn = url.openConnection() as HttpURLConnection

        conn.connectTimeout = 10000
        conn.requestMethod = "GET"
        val resCode = conn.responseCode

        if (resCode == HttpURLConnection.HTTP_OK) {

            val inputStream = conn.inputStream

            try {
                val path = this.getExternalFilesDir(null).absolutePath + "/" + name
                var file = File(path)
                file.createNewFile()

                file = inputStream.outAsFile(file)
                uri = Uri.fromFile(file)
            } finally {
                conn.disconnect()
            }
        }
    } catch (e: Exception) {
        println(e.toString())
    }

    return uri
}