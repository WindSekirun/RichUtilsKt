@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import java.io.File

fun File.getSizeByMb(): String {
    var size: Long = 0

    if (this.exists() && this.canRead()) {
        size = this.length()
    }

    return size.toNumInUnits()
}

fun Long.toNumInUnits(): String {
    var bytes = this
    var u = 0
    while (bytes > 1024 * 1024) {
        u++
        bytes = bytes shr 10
    }
    if (bytes > 1024) {
        u++
    }
    return String.format("%.1f %cB", bytes / 1024f, " kMGTPE"[u])
}