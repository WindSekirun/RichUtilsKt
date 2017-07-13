@file:JvmName("Utils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

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
fun AssetManager.asList(subdirectory: String): ArrayList<String> {
    val list = list(subdirectory)
    val toReturn = ArrayList<String>()
    toReturn.addAll(list)
    return toReturn
}
