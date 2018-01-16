@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.ClipData
import android.content.Context

/**
 * copy text to clipboard
 *
 * @param[text] to copy
 */
fun Context.copyText(text: CharSequence) {
    clipboardManager.primaryClip = ClipData.newPlainText("text", text)
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
