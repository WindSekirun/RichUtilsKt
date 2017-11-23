package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.getKeyHash
import pyxis.uzuki.live.richutilskt.utils.toast

/**
 * RichUtilsKt
 * Class: KeyHashSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getKeyHashSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val keyhash = generateExecuteItem(CategoryItem.KEYHASH, "getKeyHash",
            "get key hash of application",
            "getKeyHash()",
            "RichUtils.getKeyHash(this);") {
        toast(getKeyHash())
    }

    list.add(keyhash)

    return list
}