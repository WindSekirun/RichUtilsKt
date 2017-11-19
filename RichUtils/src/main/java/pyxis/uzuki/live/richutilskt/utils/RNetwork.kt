@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.net.ConnectivityManager
import pyxis.uzuki.live.richutilskt.useGlobalContext

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
    return when (connectivityManager.activeNetworkInfo.type) {
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
 * get Wifi connection check
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 */
fun isWifiConnected(): Boolean = useGlobalContext { isWifiConnected() }

/**
 * get Mobile connection check
 */
fun Context.isMobileConnected(): Boolean = checkNetwork() == 1

/**
 * get Mobile connection check
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 */
fun isMobileConnected(): Boolean = useGlobalContext { isMobileConnected() }

/**
 * get state of not connected
 */
fun Context.isNotConnected(): Boolean = isConnected().not()

/**
 * get state of not connected
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 */
fun isNotConnected(): Boolean = useGlobalContext { isNotConnected() }

/***
 * get state of connected
 */
fun Context.isConnected(): Boolean = checkNetwork() != 0

/**
 * get state of connected
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 */
fun isConnected(): Boolean = useGlobalContext { isConnected() }

