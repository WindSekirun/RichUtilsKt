package pyxis.uzuki.live.richutilskt

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

fun downloadBitmap(imageUrl: String): Bitmap? {
    var bmp: Bitmap? = null
    try {
        val url = URL(imageUrl)
        val conn = url.openConnection() as HttpURLConnection

        if (conn != null) {
            conn.connectTimeout = 10000
            conn.requestMethod = "GET"

            val resCode = conn.responseCode
            if (resCode == HttpURLConnection.HTTP_OK) {
                val inputStream = conn.inputStream
                try {
                    val bitmap = BitmapFactory.decodeStream(inputStream)
                    bmp = bitmap
                } finally {
                    inputStream?.close()
                    conn.disconnect()
                }
            }
        }
    } catch (e: Exception) {
        println(e.toString())
    }

    return bmp
}


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

                val path = this.externalCacheDir.absolutePath + "/" + name
                val file = File(path)
                file.createNewFile()

                inputStream.use { input ->
                    file.outputStream().use { fileOut ->
                        input.copyTo(fileOut)
                    }
                }

                uri = Uri.fromFile(file)
            } finally {
                inputStream?.close()
                conn.disconnect()
            }
        }
    } catch (e: Exception) {
        println(e.toString())
    }

    return uri
}