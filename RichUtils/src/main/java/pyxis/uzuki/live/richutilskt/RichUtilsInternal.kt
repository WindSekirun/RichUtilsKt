@file:Suppress("UNCHECKED_CAST")

package pyxis.uzuki.live.richutilskt

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