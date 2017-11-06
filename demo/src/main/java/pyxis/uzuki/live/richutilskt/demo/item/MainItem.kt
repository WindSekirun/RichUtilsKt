package pyxis.uzuki.live.richutilskt.demo.item

/**
 * RichUtilsKt
 * Class: MainItem
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */
data class MainItem(val categoryItem: CategoryItem, val title: String = categoryItem.name, val content: String = "")