package pyxis.uzuki.live.richutilskt

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
    val connMgr = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val now = connMgr.activeNetworkInfo

    when (now.type) {
        ConnectivityManager.TYPE_WIFI -> return 2
        ConnectivityManager.TYPE_MOBILE -> return 1
        else -> return 0
    }
}
