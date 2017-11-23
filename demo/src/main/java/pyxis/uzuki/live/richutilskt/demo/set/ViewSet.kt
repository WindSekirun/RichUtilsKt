package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * RichUtilsKt
 * Class: ViewSet
 * Created by Pyxis on 2017-11-17.
 *
 * Description:
 */

fun Context.getViewSet() : ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val convertChildrenList = generateExecuteItem(CategoryItem.VIEW, "convertChildrenList",
            "Convert ViewGroup's Children to List<Child>",
            "container.convertChildrenList()",
            "RichUtils.convertChildrenList(container);")

    list.add(convertChildrenList)

    val generateViewId = generateExecuteItem(CategoryItem.VIEW, "generateViewId",
            "Generate View ID",
            "generateViewId()",
            "generateViewId();")

    list.add(generateViewId)

    return list
}