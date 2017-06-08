package pyxis.uzuki.live.richutilskt

import java.io.File
import java.io.InputStream

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