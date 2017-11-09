package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.*

/**
 * RichUtilsKt
 * Class: NetworkSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getNetworkSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val checkNetwork = generateExecuteItem(CategoryItem.NETWORK, "checkNetwork",
            "get network connection check",
            "checkNetwork()",
            "RichUtils.checkNetwork(this)") {
        val message = when (checkNetwork()) {
            2 -> "Wifi"
            1 -> "Mobile"
            else -> "Not Connected"
        }

        toast("Connection status = $message")
    }

    list.add(checkNetwork)

    val isWifiConnected = generateExecuteItem(CategoryItem.NETWORK, "isWifiConnected",
            "get Wifi connection check",
            "isWifiConnected()",
            "RichUtils.isWifiConnected()") {
        toast("isWifiConnected ? = ${isWifiConnected()}")
    }

    list.add(isWifiConnected)

    val isMobileConnected = generateExecuteItem(CategoryItem.NETWORK, "isMobileConnected",
            "get Mobile connection check",
            "isMobileConnected()",
            "RichUtils.isMobileConnected()") {
        toast("isMobileConnected ? = ${isMobileConnected()}")
    }

    list.add(isMobileConnected)

    val isNotConnected = generateExecuteItem(CategoryItem.NETWORK, "isNotConnected",
            "get state of not connected",
            "isNotConnected()",
            "RichUtils.isNotConnected()") {
        toast("isNotConnected ? = ${isNotConnected()}")
    }

    list.add(isNotConnected)

    val isConnected = generateExecuteItem(CategoryItem.NETWORK, "isConnected",
            "get state of connected",
            "isConnected()",
            "RichUtils.isConnected()") {
        toast("isConnected ? = ${isConnected()}")
    }

    list.add(isConnected)

    return list
}