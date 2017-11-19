@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.ClipData
import android.content.Context
import pyxis.uzuki.live.richutilskt.useGlobalContext

/**
 * copy text to clipboard
 *
 * @param[text] to copy
 */
fun Context.copyText(text: CharSequence) {
    clipboardManager.primaryClip = ClipData.newPlainText("text", text)
}

/**
 * copy text to clipboard
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @param[text] to copy
 */
fun copyText(text: CharSequence) {
    useGlobalContext { copyText(text) }
}

/**
 * get text of clipboard list
 *
 * @return first object of primaryClip list
 */
fun Context.getTextFromClipboard(): String {
    val clip = clipboardManager.primaryClip

    return if (clip != null && clip.itemCount > 0) clip.getItemAt(0).coerceToText(this).toString() else ""
}

/**
 * get text of clipboard list
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @return first object of primaryClip list
 */
fun getTextFromClipboard() : String {
    return useGlobalContext { getTextFromClipboard() }
}