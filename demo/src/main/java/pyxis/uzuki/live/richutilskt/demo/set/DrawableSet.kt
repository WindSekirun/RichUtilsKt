package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * Created by pyxis on 07/11/2017.
 */

fun Context.getDrawableSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val bitmapToDrawable = generateExecuteItem(CategoryItem.DRAWABLE, "bitmapToDrawable",
            getString(R.string.category_message_bitmaptodrawable),
            "bitmapToDrawable(bitmap)",
            "RichUtils.bitmapToDrawable(this, bitmap);");

    list.add(bitmapToDrawable)

    return list
}