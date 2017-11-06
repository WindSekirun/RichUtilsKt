package pyxis.uzuki.live.richutilskt.demo

import android.content.Context
import pyxis.uzuki.live.richutilskt.utils.browse

internal fun Context.browseToFile(fileName: String) {
    browse("https://github.com/WindSekirun/RichUtilsKt/blob/master/RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/%s".format(fileName))
}