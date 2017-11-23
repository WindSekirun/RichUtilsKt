package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.toast
import pyxis.uzuki.live.richutilskt.utils.versionCode
import pyxis.uzuki.live.richutilskt.utils.versionName

/**
 * RichUtilsKt
 * Class: ViewSet
 * Created by Pyxis on 2017-11-17.
 *
 * Description:
 */

fun Context.getVersionSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val versionCode = generateExecuteItem(CategoryItem.VERSION, "versionCode",
            "get version code of this application",
            "versionCode()",
            "RichUtils.versionCode(this);") {
        toast("versionCode = ${versionCode()}")
    }

    list.add(versionCode)

    val versionName = generateExecuteItem(CategoryItem.VERSION, "versionName",
            "get version name of this application",
            "versionName()",
            "RichUtils.versionName(this);") {
        toast("versionName = ${versionName()}")
    }

    list.add(versionName)

    return list
}