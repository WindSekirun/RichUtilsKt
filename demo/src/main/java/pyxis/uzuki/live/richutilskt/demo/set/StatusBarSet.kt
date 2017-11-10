package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.getStatusBarHeight
import pyxis.uzuki.live.richutilskt.utils.toast

/**
 * RichUtilsKt
 * Class: StatusBarSet
 * Created by Pyxis on 2017-11-10.
 *
 * Description:
 */

fun Context.getStatusBarSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val setStatusNavBarColor = generateExecuteItem(CategoryItem.STATUSBAR, "setStatusNavBarColor",
            "Set Color of status bar and navigation bar",
            "setStatusNavBarColor(Color.parseColor(\"#303F9F\"))",
            "RichUtils.setStatusNavBarColor(this, Color.parseColor(\"#303F9F\"));")

    list.add(setStatusNavBarColor)

    val getStatusBarHeight = generateExecuteItem(CategoryItem.STATUSBAR, "getStatusBarColor",
            "get Height of status bar",
            "getStatusBarHeight()",
            "RichUtils.getStatusBarHeight(this);") {
        toast("StatusBar height = ${getStatusBarHeight()}")
    }

    list.add(getStatusBarHeight)

    return list
}