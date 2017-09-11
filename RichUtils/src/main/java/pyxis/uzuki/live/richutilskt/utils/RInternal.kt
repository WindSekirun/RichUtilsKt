@file:JvmName("RichUtils")
@file:JvmMultifileClass


package pyxis.uzuki.live.richutilskt.utils

import android.util.Log
import java.io.File

inline fun <T, R> T.tryCatch(block: (T) -> R): R {
    try {
        return block(this)
    } catch (e: Exception) {
        Log.e("tag", "I/O Exception", e)
        throw e
    }
}

internal inline fun <R> getValue(block: () -> R, def: Any?): R =
        try {
            block()
        } catch (e: Exception) {
            def as R
        }

internal inline fun <T, R> T.convert(block: (T) -> R, def: Any?): R =
        try {
            block(this)
        } catch (e: Exception) {
            def as R
        }

internal inline fun <T, R> T.convertAcceptNull(block: (T) -> R, def: Any?): R? =
        try {
            block(this)
        } catch (e: Exception) {
            def as R
        }

fun String.toFile() = File(this)