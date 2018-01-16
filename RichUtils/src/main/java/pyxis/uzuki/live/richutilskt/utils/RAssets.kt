@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.content.res.AssetManager
import java.nio.charset.Charset

/**
 * get String from Assets file
 *
 * @param[subdirectory] name of directory
 * @param[filename] name of file
 * @return String object
 */
fun AssetManager.fileAsString(subdirectory: String, filename: String): String {
    return open("$subdirectory/$filename").use {
        it.readBytes().toString(Charset.defaultCharset())
    }
}

/**
 * get File list of specific folder in Assets
 *
 * @param[subdirectory] name of directory
 * @return list of file name
 */
@JvmName("asAssetsList")
fun AssetManager.asList(subdirectory: String) = list(subdirectory).toList()

/**
 * Assets to Internal storage
 * @param [path] path to copy
 */
fun Context.copyAssets(path: String) {
    this.assets.list(path).tryCatch {
        if (it.isEmpty()) {
            copyFile(path)
            return
        }

        "${this.getExternalFilesDir(null)}/$path".toFile().mkdirs()
        it.forEach {
            val dirPath = if (path == "") "" else path + "/"
            copyAssets("$dirPath$it")
        }
    }
}

private fun Context.copyFile(filename: String) {
    this.assets.open(filename).use { stream ->
        "${this.getExternalFilesDir(null)}/$filename".toFile().outputStream().use { stream.copyTo(it) }
    }
}