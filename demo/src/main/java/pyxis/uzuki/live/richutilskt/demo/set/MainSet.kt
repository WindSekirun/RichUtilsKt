package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.MainItem

/**
 * RichUtilsKt
 * Class: MainSet
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */
fun Context.getMainData(): ArrayList<MainItem> {
    val list = arrayListOf<MainItem>()

    list.add(MainItem(CategoryItem.ALERT, "utils/RAlert.kt", "Alert", getString(R.string.alert_category_content), getAlertSet()))
    list.add(MainItem(CategoryItem.ASSETS, "utils/RAssets.kt", "Assets", getString(R.string.assets_category_content), getAssetsSet()))

    return list
}
