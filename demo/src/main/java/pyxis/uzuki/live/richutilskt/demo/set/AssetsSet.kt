package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

fun Context.getAssetsSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val fileAsString = generateExecuteItem(CategoryItem.ASSETS, "fileAsString",
            getString(R.string.assets_message_fileasstring),
            "this.assets.fileAsString(\"json\", \"customer.json\")",
            "RichUtils.fileAsString(this.getAssets(), \"json\", \"customer.json\")")

    list.add(fileAsString)

    val asList = generateExecuteItem(CategoryItem.ASSETS, "asList",
            getString(R.string.assets_message_aslist),
            "this.assets.asList()",
            "RichUtils.asAssetsList(this.assets)")

    list.add(asList)

    val copyAssets = generateExecuteItem(CategoryItem.ASSETS, "copyAssets",
            getString(R.string.assets_message_copyassets),
            "copyAssets(\"\")",
            "RichUtils.copyAssets(this, \"\")")

    list.add(copyAssets)

    return list
}