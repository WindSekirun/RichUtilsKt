@file:JvmName("Utils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import java.io.File
import java.io.InputStream

/**
 * get response string from InputStream
 *
 * @return response string
 */
fun InputStream.getString(): String {
    var response: String = ""

    try {
        this.bufferedReader().use {
            response = it.readText()
        }
    } catch (e: Exception) {
        println(e.message)
    } finally {
        this.close()
    }

    return response
}

/**
 * write file from InputStream
 *
 * @param[file] to write File object
 * @return File object which gaven as parameter
 */
fun InputStream.outAsFile(file: File): File {
    try {
        use { input ->
            file.outputStream().use { fileOut ->
                input.copyTo(fileOut)
            }
        }
    } catch (e: Exception) {
        println(e.message)
    } finally {
        this.close()
    }

    return file
}