package pyxis.uzuki.live.richutilskt.demo.set

import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.MainItem

/**
 * RichUtilsKt
 * Class: MainSet
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */
fun getMainData(): ArrayList<MainItem> {
    val list = arrayListOf<MainItem>()

    list.add(MainItem(CategoryItem.ALERT, "Alert", "Display Toast / Dialog"))

    return list
}
