@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.support.annotation.ColorInt
import android.support.annotation.IntRange

/**
 * RichUtilsKt
 * Class: RColor
 * Created by Pyxis on 2017-11-10.
 *
 * Description:
 */

fun applyAlphaIntoColor(@ColorInt color: Int, @IntRange(from = 0, to = 255) alpha: Int): Int {
    if (alpha == 0) return color
    val a = 1 - alpha / 255f
    var red = color shr 16 and 0xff
    var green = color shr 8 and 0xff
    var blue = color and 0xff
    red = (red * a + 0.5).toInt()
    green = (green * a + 0.5).toInt()
    blue = (blue * a + 0.5).toInt()

    return 0xff shl 24 or (red shl 16) or (green shl 8) or blue
}

/**
 * apply alpha value within percentage
 * range of percent is 0 to 100
 *
 * @param[color] desire color to apply
 * @param[percent] percentage value
 * @return applied color
 */
fun applyAlphaPercentageIntoColor(@ColorInt color: Int, @IntRange(from = 0, to = 100) percent: Int): Int {
    val d10 = (Math.round((percent * 2.55) + 0.1)).toInt()
    return applyAlphaIntoColor(color, d10)
}
