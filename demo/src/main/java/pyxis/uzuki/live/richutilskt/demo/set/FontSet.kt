package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * Created by pyxis on 07/11/2017.
 */

fun Context.getFontSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val initializeFontEngine = generateExecuteItem(CategoryItem.FONT, "initializeFontEngine",
            getString(R.string.font_message_initializefontengine),
            "initializeFontEngine()",
            "RichUtils.initializeFontEngine(this);")

    list.add(initializeFontEngine)

    val setTypeface = generateExecuteItem(CategoryItem.FONT, "setTypeface",
            getString(R.string.font_message_settypeface),
            "setContentView(setTypeface(R.layout.activity_main))",
            "setContentView(RichUtils.setTypeface(this, R.layout.activity_main));")

    list.add(setTypeface)

    return list
}