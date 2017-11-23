package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.isProcessRunning
import pyxis.uzuki.live.richutilskt.utils.toast

/**
 * RichUtilsKt
 * Class: ProcessSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getProcessSet() : ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val isProcessRunning = generateExecuteItem(CategoryItem.PROCESS, "isProcessRunning",
            "get boolean value for whatever application process is running",
            "isProcessRunning()",
            "RichUtils.isProcessRunning()") {
        toast("isProcessRunning = ${isProcessRunning()}")
    }

    list.add(isProcessRunning)

    return list
}