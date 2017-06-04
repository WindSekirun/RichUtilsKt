package pyxis.uzuki.live.richutilskt

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