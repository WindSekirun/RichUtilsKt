@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * get network connection check
 *
 * if wifi is connected, will return 2
 * if mobile (3G, LTE) is connect, will return 1
 * else, return 0
 *
 * @return network state (check legend above)
 */
fun Context.checkNetwork(): Int {
    val info = connectivityManager.activeNetworkInfo ?: return 0
    return when (info.type) {
        ConnectivityManager.TYPE_WIFI -> 2
        ConnectivityManager.TYPE_MOBILE -> 1
        else -> 0
    }
}

/**
 * get Wifi connection check
 */
fun Context.isWifiConnected(): Boolean = checkNetwork() == 2

/**
 * get Mobile connection check
 */
fun Context.isMobileConnected(): Boolean = checkNetwork() == 1

/**
 * get state of not connected
 */
fun Context.isNotConnected(): Boolean = isConnected().not()

/***
 * get state of connected
 */
fun Context.isConnected(): Boolean = checkNetwork() != 0
