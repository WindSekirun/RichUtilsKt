@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.graphics.Bitmap
import android.net.Uri
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

    if (conn.responseCode == HttpURLConnection.HTTP_OK) {
        bitmap = conn.inputStream.outAsBitmap()
    }
    conn.disconnect()

    return bitmap
}


/**
 * Download file from uri
 *
 * @param[urlPath] path of file
 * @param[localPath] full path of file to saved
 * @return Uri object
 */
fun downloadFile(urlPath: String, localPath: String, callback: (Uri) -> Unit = {}): Uri? {
    var uri: Uri? = null
    val url = URL(urlPath)
    val connection = url.openConnection() as HttpURLConnection;

    if (connection.responseCode == HttpURLConnection.HTTP_OK) {
        uri = Uri.fromFile(connection.inputStream.outAsFile(localPath.toFile()))
    }
    connection.disconnect()
    callback(uri as Uri)
    return uri
}