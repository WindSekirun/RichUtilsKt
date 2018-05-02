@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.RequiresApi
import android.view.View
import android.view.Window
import android.view.WindowManager


/**
 * Set Color of status bar and navigation bar
 *
 * @param[statusBarColor] desire color of status bar
 * @param[window] Window object of Activity
 * @param[navigationBarColor] desire color of navigation bar (if color value isn't provided, set color by statusBarColor)
 */
@JvmOverloads
fun Activity.setStatusNavBarColor(@ColorInt statusBarColor: Int, window: Window = this.window, @ColorInt navigationBarColor: Int = statusBarColor) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = statusBarColor
        window.navigationBarColor = navigationBarColor
    }
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

/**
 * change theme of StatusBar
 * it will available android 23 and above.
 */
@RequiresApi(Build.VERSION_CODES.M)
fun Activity.setStatusBarTheme(isDark: Boolean) {
    val lFlags = window.decorView.systemUiVisibility
    window.decorView.systemUiVisibility = if (isDark)
        lFlags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
    else
        lFlags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}