@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * copy text to clipboard
 *
 * @param[text] to copy
 */
fun Context.copyText(text: CharSequence) {
    val clipboard = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    clipboard.primaryClip = ClipData.newPlainText("text", text)
}

/**
 * get text of clipboard list
 *
 * @return first object of primaryClip list
 */
fun Context.getTextFromClipboard(): String {
    val clipboard = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = clipboard.primaryClip

    return if (clip != null && clip.itemCount > 0) clip.getItemAt(0).coerceToText(this).toString() else  ""
}