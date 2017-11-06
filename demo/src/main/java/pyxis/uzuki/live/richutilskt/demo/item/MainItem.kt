package pyxis.uzuki.live.richutilskt.demo.item

import java.io.Serializable

/**
 * RichUtilsKt
 * Class: MainItem
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */
data class MainItem(val categoryItem: CategoryItem, val link: String = "",
                    val title: String = categoryItem.name, val content: String = "") : Serializable