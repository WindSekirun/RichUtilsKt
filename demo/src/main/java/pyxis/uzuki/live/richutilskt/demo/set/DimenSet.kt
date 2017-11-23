package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.*

/**
 * Created by pyxis on 06/11/2017.
 */

fun Context.getDimenSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val dip2px = generateExecuteItem(CategoryItem.DIMEN, "dip2px", getString(R.string.dimen_message_dip2px),
            "dip2px(15)",
            "RichUtils.dip2px(this, 15);") {
        it.toast(it.dip2px(15).toString())
    }

    list.add(dip2px)

    val sp2px = generateExecuteItem(CategoryItem.DIMEN, "sp2px", getString(R.string.dimen_message_sp2px),
            "sp2px(15)",
            "RichUtils.sp2px(this, 15);") {
        it.toast(it.sp2px(15).toString())
    }

    list.add(sp2px)

    val px2dip = generateExecuteItem(CategoryItem.DIMEN, "px2dip", getString(R.string.dimen_message_px2dip),
            "px2dip(15)",
            "RichUtils.px2dip(this, 15);") {
        it.toast(it.px2dip(15).toString())
    }

    list.add(px2dip)

    val px2sp = generateExecuteItem(CategoryItem.DIMEN, "px2sp", getString(R.string.dimen_message_px2sp),
            "px2sp(15)",
            "RichUtils.px2sp(this, 15);") {
        it.toast(it.px2sp(15).toString())
    }

    list.add(px2sp)

    val dimen = generateExecuteItem(CategoryItem.DIMEN, "dimen", getString(R.string.dimen_message_dimen),
            "dimen(R.dimen.pixel_size)",
            "RichUtils.dimen(this, R.dimen.pixel_size);")

    list.add(dimen)


    return list
}