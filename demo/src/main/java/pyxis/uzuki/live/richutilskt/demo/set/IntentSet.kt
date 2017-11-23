package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.toEscape

/**
 * RichUtilsKt
 * Class: IntentSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getIntentSet() : ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val browse = generateExecuteItem(CategoryItem.INTENT, "browse",
            "Browse given url with internal browser",
            "browse(\"https://github.com/windsekirun/RichUtilsKt\")",
            "RichUtils.browse(this, \"https://github.com/windsekirun/RichUtilsKt\");")

    list.add(browse)

    val makeCall = generateExecuteItem(CategoryItem.INTENT, "makeCall",
            "Make phone call with given phone number",
            "makeCall(${"112".toEscape()})",
            "RichUtils.makeCall(${"112".toEscape()});")

    list.add(makeCall)

    val dialCall = generateExecuteItem(CategoryItem.INTENT, "dialCall",
            "Make phone dial with given phone number",
            "dialCall(${"112".toEscape()})",
            "RichUtils.dialCall(${"112".toEscape()});")

    list.add(dialCall)

    return list
}