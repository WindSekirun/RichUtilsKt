package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * RichUtilsKt
 * Class: TextSet
 * Created by Pyxis on 2017-11-17.
 *
 * Description:
 */

fun Context.getTextSet() : ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val isEmptyOrReturn = generateExecuteItem(CategoryItem.TEXT, "isEmptyOrReturn",
            "get string with empty handling",
            "line1Number.isEmptyOrReturn()",
            "RichUtils.isEmptyOrReturn(line1Number);")

    list.add(isEmptyOrReturn)

    val isEmpty = generateExecuteItem(CategoryItem.TEXT, "isEmpty",
            "return string empty state",
            "title.isEmpty()",
            "RichUtils.isEmpty(title)")

    list.add(isEmpty)

    return list
}