package pyxis.uzuki.live.richutilskt.demo.set

import android.Manifest
import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.*

/**
 * Created by pyxis on 06/11/2017.
 */

fun Context.getDeviceIdSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val getAndroidId = generateExecuteItem(CategoryItem.DEVICEID, "getAndroidId",
            getString(R.string.deviceid_message_androidid),
            "getAndroidId()",
            "RichUtils.getAndroidId(this)'") {
        it.toast(it.getAndroidId())
    }

    list.add(getAndroidId)

    val getIMEI = generateExecuteItem(CategoryItem.DEVICEID, "getIMEI",
            getString(R.string.deviceid_message_imei),
            "getIMEI()",
            "RichUtils.getIMEI(this);") {
        it.toast(it.getIMEI())
    }

    list.add(getIMEI)

    val getLine1Number = generateExecuteItem(CategoryItem.DEVICEID, "getLine1Number",
            getString(R.string.deviceid_message_line1number),
            "getLine1Number()",
            "RichUtils.getLine1Number(this);") {
        it.toast(it.getLine1Number())
    }

    list.add(getLine1Number)

    return list
}