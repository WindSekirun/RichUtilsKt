package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * RichUtilsKt
 * Class: KeyboardSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getKeyboardSet() : ArrayList<ExecuteItem> {
    val list = arrayListOf<ExecuteItem>()

    val hideKeyboard = generateExecuteItem(CategoryItem.KEYBOARD, "hideKeyboard",
            "hide keyboard",
            "hideKeyboard()",
            "RichUtils.hideKeyboard(this);")

    list.add(hideKeyboard)

    val toggleKeyboard = generateExecuteItem(CategoryItem.KEYBOARD, "toggleKeyboard",
            "toggle keyboard open / close",
            "toggleKeyboard()",
            "RichUtils.toggleKeyboard(this)")

    list.add(toggleKeyboard)

    return list
}