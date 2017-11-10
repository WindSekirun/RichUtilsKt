package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import android.graphics.Color
import android.support.v4.graphics.ColorUtils
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.applyAlphaIntoColor
import pyxis.uzuki.live.richutilskt.utils.applyAlphaPercentageIntoColor
import pyxis.uzuki.live.richutilskt.utils.toast

/**
 * RichUtilsKt
 * Class: ColorSet
 * Created by Pyxis on 2017-11-10.
 *
 * Description:
 */

fun Context.getColorSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val applyAlphaIntoColor = generateExecuteItem(CategoryItem.COLOR, "applyAlphaIntoColor",
            "apply alpha value",
            "applyAlphaIntoColor(Color.parseColor(\"#303F9F\"), 144)",
            "RichUtils.applyAlphaIntoColor(Color.parseColor(\"#303F9F\"), 144);") {
        val alphaColor = ColorUtils.setAlphaComponent(0x303F9F, 144);
        val strColor = kotlin.String.format("#%06X", 0xFFFFFF and alphaColor)
        toast(strColor)
    }

    list.add(applyAlphaIntoColor)

    val applyAlphaPercentageIntoColor = generateExecuteItem(CategoryItem.COLOR, "applyAlphaPercentageIntoColor",
            "apply alpha value within percentage",
            "applyAlphaPercentageIntoColor(Color.parseColor(\"#303F9F\"), 80)",
            "RichUtils.applyAlphaPercentageIntoColor(Color.parseColor(\"#303F9F\"), 80);") {
        val alphaColor = applyAlphaPercentageIntoColor(Color.parseColor("#303F9F"), 80).toLong()
        val strColor = kotlin.String.format("#%08X", 0xFFFFFFFF and alphaColor)
        toast(strColor)
    }

    list.add(applyAlphaPercentageIntoColor)

    return list
}