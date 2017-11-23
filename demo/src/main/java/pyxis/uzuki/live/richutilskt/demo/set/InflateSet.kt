package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * RichUtilsKt
 * Class: InflateSet
 * Created by Pyxis on 2017-11-08.
 *
 * Description:
 */

fun Context.getInflateSet() : ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val inflate = generateExecuteItem(CategoryItem.INFLATER, "infalte", "inflate view",
            "inflate(R.layout.activity_index_item, parent)",
            "RichUtils.inflate(this, R.layout.activity_index_item)")

    list.add(inflate)

    return list
}