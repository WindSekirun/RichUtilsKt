package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.reboot

/**
 * RichUtilsKt
 * Class: RebootSet
 * Created by Pyxis on 2017-11-10.
 *
 * Description:
 */

fun Context.getRebootSet() : ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val reboot = generateExecuteItem(CategoryItem.REBOOT, "reboot",
            "Reboot application within Intent",
            "this.reboot()",
            "RichUtils.reboot(this)") {
        this.reboot()
    }

    list.add(reboot)

    return list
}