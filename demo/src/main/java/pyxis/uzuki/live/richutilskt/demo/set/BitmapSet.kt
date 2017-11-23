package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem


fun Context.getBitmapSet(): ArrayList<ExecuteItem> {
    val list = arrayListOf<ExecuteItem>()

    val getBitmap = generateExecuteItem(CategoryItem.BITMAP, "getBitmap",
            getString(R.string.bitmap_message_getbitmap),
            "realPath.getBitmap()",
            "RichUtils.getBitmap(realPath)")

    list.add(getBitmap)

    val toRoundCorner = generateExecuteItem(CategoryItem.BITMAP, "toRoundCorner",
            getString(R.string.bitmap_message_toroundcorner),
            "bitmap.toRoundCorner(10f)",
            "RichUtils.toRoundCorner(bitmap, 10f);")

    list.add(toRoundCorner)

    val saveBitmapToFile = generateExecuteItem(CategoryItem.BITMAP, "saveBitmapToFile",
            getString(R.string.bitmap_message_savebitmaptofile),
            "saveBitmapToFile(bitmap)",
            "RichUtils.saveBitmapToFile(this, bitmap)")

    list.add(saveBitmapToFile)

    val drawableToBitmap = generateExecuteItem(CategoryItem.BITMAP, "drawableToBitmap",
            getString(R.string.bitmap_message_drawabletobitmap),
            "drawableToBitmap(drawable)",
            "RichUtils.drawableToBitmap(drawable);")

    list.add(drawableToBitmap)

    val requestMediaScanner = generateExecuteItem(CategoryItem.BITMAP, "requestMediaScanner",
            getString(R.string.bitmap_message_mediascanning),
            "requestMediaScanner(realPath)",
            "RichUtils.requestMediaScanner(this, realPath);")

    list.add(requestMediaScanner)

    val downloadBitmap = generateExecuteItem(CategoryItem.BITMAP, "downloadBitmap",
            getString(R.string.bitmap_message_downloadbitmap),
            "downloadBitmap(url)",
            "RichUtils.downloadBitmap(url);")

    list.add(downloadBitmap)

    val resize = generateExecuteItem(CategoryItem.BITMAP, "resize",
            getString(R.string.bitmap_message_resize),
            "bitmap.resize(100, 100)",
            "RichUtils.resize(bitmap, 100, 100)")

    list.add(resize)

    return list
}