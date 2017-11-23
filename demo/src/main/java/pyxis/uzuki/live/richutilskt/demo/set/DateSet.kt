package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * Created by pyxis on 06/11/2017.
 */

fun Context.getDateSet(): ArrayList<ExecuteItem> {
    val list = arrayListOf<ExecuteItem>()

    val asDateString = generateExecuteItem(CategoryItem.DATE, "asDateString",
            getString(R.string.date_message_asdatestring_date),
            "date?.asDateString()",
            "RichUtils.asDateString(date);")

    list.add(asDateString)

    val asDateString2 = generateExecuteItem(CategoryItem.DATE, "asDateString",
            getString(R.string.date_message_asdatestring_long),
            "System.currentTimeMillis().asDateString()",
            "RichUtils.asDateString(timestamp);")

    list.add(asDateString2)

    val parseDate = generateExecuteItem(CategoryItem.DATE, "parseDate",
            getString(R.string.date_message_parsedate),
            "\"2016-11-23 11:11:11\".parseDate()",
            "RichUtils.parseDate(\"2016-11-23 11:11:11\")")

    list.add(parseDate)

    val toDateString = generateExecuteItem(CategoryItem.DATE, "toDateString",
            getString(R.string.date_message_todatestring),
            "\"2016-11-23 11:11:11\".toDateString(\"yyyy-MM-dd HH:mm:ss\", \"yyyy.mm.dd\")",
            "RichUtils.toDateString(\"2016-11-23 11:11:11\", \"yyyy-Mm-dd HH:mm:ss\", \"yyyy.MM.dd\")")

    list.add(toDateString)
    return list
}
