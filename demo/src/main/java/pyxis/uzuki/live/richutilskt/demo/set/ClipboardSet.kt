package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.copyText
import pyxis.uzuki.live.richutilskt.utils.getTextFromClipboard
import pyxis.uzuki.live.richutilskt.utils.toast

/**
 * Created by pyxis on 06/11/2017.
 */

fun Context.getClipboardSet(): ArrayList<ExecuteItem> {
    val list = arrayListOf<ExecuteItem>()

    val copyText = generateExecuteItem(CategoryItem.CLIPBOARD, "copyText",
            getString(R.string.clipboard_message_copytext),
            "copyText(text)",
            "RichUtils.copyText(context, text);") {
        it.copyText("RichUtils")
    }

    list.add(copyText)

    val getTextFromClipboard = generateExecuteItem(CategoryItem.CLIPBOARD, "getTextFromClipboard",
            getString(R.string.clipboard_message_gettextfromclipboard),
            "getTextFromClipboard()",
            "RichUtils.getTextFromClipboard(this);") {
        it.toast(it.getTextFromClipboard())
    }

    list.add(getTextFromClipboard)

    return list
}