@file:JvmName("Utils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.app.Activity
import android.content.Context
import android.view.WindowManager
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.IntRange
import android.view.Window
import android.support.annotation.NonNull



/**
 * Set Color of status bar and navigation bar
 *
 * @param[statusBarColor] desire color of status bar
 * @param[window] Window object of Activity
 * @param[navigationBarColor] desire color of navigation bar (if color value isn't provided, set color by statusBarColor)
 */
@JvmOverloads fun Activity.setStatusNavBarColor(@ColorInt statusBarColor: Int, window: Window = this.window, @ColorInt navigationBarColor: Int = statusBarColor) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = statusBarColor
        window.navigationBarColor = navigationBarColor
    }
}

/**
 * apply alpha value
 * range of alpha is 0 to 255.
 *
 * @param[color] desire color to apply
 * @param[alpha] alpha value
 * @return applyed color
 */
fun applyAlphaIntoColor(@ColorInt color: Int, @IntRange(from = 0, to=255) alpha: Int): Int {
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
 * get Height of status bar
 *
 * @return height of status bar
 */
fun Context.getStatusBarHeight(): Int {
    val resourceId = this.resources.getIdentifier("status_bar_height", "dimen", "android")
    return this.resources.getDimensionPixelSize(resourceId)
}