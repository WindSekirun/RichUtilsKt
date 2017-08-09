@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.InputStream

/**
 * get response string from InputStream
 *
 * @return response string
 */
fun InputStream.getString(): String = this.bufferedReader().use {
    it.readText()
}

/**
 * write file from InputStream
 *
 * @param[file] to write File object
 * @return File object which gaven as parameter
 */
fun InputStream.outAsFile(file: File): File {
    file.createNewFile()

    use { input ->
        file.outputStream().use { fileOut ->
            input.copyTo(fileOut)
        }
    }
    return file
}

/**
 * get Bitmap from InputStream
 *
 * @return Bitmap object
 */
fun InputStream.outAsBitmap(): Bitmap? = use {
    BitmapFactory.decodeStream(it)
}