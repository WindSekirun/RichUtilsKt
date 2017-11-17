package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * RichUtilsKt
 * Class: StreamSet
 * Created by Pyxis on 2017-11-17.
 *
 * Description:
 */

fun Context.getStreamSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val getString = generateExecuteItem(CategoryItem.STREAM, "getString",
            "get response string from InputStream",
            "stream.getString()",
            "RichUtils.getString(stream);")

    list.add(getString)

    val outAsFile = generateExecuteItem(CategoryItem.STREAM, "outAsFile",
            "write file from InputStream",
            "inputStream.outAsFile(localPath.toFile())",
            "RichUtils.outAsFile(inputStream, new File(localpath));")

    list.add(outAsFile)

    val outAsBitmap = generateExecuteItem(CategoryItem.STREAM, "outAsBitmap",
            "get Bitmap from InputStream",
            "inputStream.outAsBitmap()",
            "RichUtils.outAsBitmap(inputStream)")

    list.add(outAsBitmap)
    return list
}