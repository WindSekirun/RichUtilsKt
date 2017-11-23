package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * Created by pyxis on 07/11/2017.
 */

fun Context.getFileSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val downloadFile = generateExecuteItem(CategoryItem.FILE, "downloadFile",
            getString(R.string.file_message_downloadfile),
            "downloadFile(url, file.absolutePath, {uri -> }",
            "RichUtils.downloadFile(url, file.getAbsolutePath(), (uri) -> {}")

    list.add(downloadFile)

    val toFile = generateExecuteItem(CategoryItem.FILE, "toFile",
            getString(R.string.file_message_tofile),
            "\"${this.getExternalFilesDir(null)}/\$path\".toFile()",
            "RichUtils.toFile(localPath);")

    list.add(toFile)

    val saveFile = generateExecuteItem(CategoryItem.FILE, "saveFile",
            getString(R.string.file_message_savefile),
            "saveFile(path, content)",
            "RichUtils.saveFile(path, content);")

    list.add(saveFile)

    val readFile = generateExecuteItem(CategoryItem.FILE, "readFile",
            getString(R.string.file_message_readfile),
            "file.readFile()",
            "RichUtils.readFile(file);")

    list.add(readFile)

    val getRealPath = generateExecuteItem(CategoryItem.FILE, "getRealPath",
            getString(R.string.file_message_getrealpath),
            "Uri.parse(path) getRealPath this@PickMediaActivity",
            "RichUtils.getRealPath(Uri.parse(path), this);")

    list.add(getRealPath)

    return list
}