package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.vibrate

/**
 * RichUtilsKt
 * Class: ViewSet
 * Created by Pyxis on 2017-11-17.
 *
 * Description:
 */

fun Context.getVibrateSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val vibrate = generateExecuteItem(CategoryItem.VERSION, "vibrate",
            "Vibrate",
            "vibrate(1000)",
            "RichUtils.vibrate(1000);") {
        vibrate(1000)
    }

    list.add(vibrate)

    return list
}