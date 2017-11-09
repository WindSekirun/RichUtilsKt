package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import android.net.Uri
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.RPickMedia
import pyxis.uzuki.live.richutilskt.utils.getRealPath
import pyxis.uzuki.live.richutilskt.utils.toast

/**
 * RichUtilsKt
 * Class: PickMediaSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getPickMediaSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val pickFromCamera = generateExecuteItem(CategoryItem.PICKMEDIA, "pickFromCamera",
            "pick image from Camera",
            "RPickMedia.instance.pickFromCamera(this, { resultCode, path -> resultMessage(resultCode, path)})",
            "RPickMedia.instance.pickFromCamera(this, this::resultMessage)") {
        RPickMedia.instance.pickFromCamera(this, { resultCode, path -> resultMesage(resultCode, path) })
    }

    list.add(pickFromCamera)

    val pickFromGallery = generateExecuteItem(CategoryItem.PICKMEDIA, "pickFromGallery",
            "pick image from Gallery",
            "RPickMedia.instance.pickFromGallery(this, { resultCode, path -> resultMessage(resultCode, path)})",
            "RPickMedia.instance.pickFromGallery(this, this::resultMessage)") {
        RPickMedia.instance.pickFromGallery(this, { resultCode, path -> resultMesage(resultCode, path) })
    }

    list.add(pickFromGallery)

    val pickFromVideo = generateExecuteItem(CategoryItem.PICKMEDIA, "pickFromVideo",
            "pick image from Video",
            "RPickMedia.instance.pickFromVideo(this, { resultCode, path -> resultMessage(resultCode, path)})",
            "RPickMedia.instance.pickFromVideo(this, this::resultMessage)") {
        RPickMedia.instance.pickFromVideo(this, { resultCode, path -> resultMesage(resultCode, path) })
    }

    list.add(pickFromVideo)

    val pickFromVideoCamera = generateExecuteItem(CategoryItem.PICKMEDIA, "pickFromVideoCamera",
            "pick image from Camera (Video Mode)",
            "RPickMedia.instance.pickFromVideoCamera(this, { resultCode, path -> resultMessage(resultCode, path)})",
            "RPickMedia.instance.pickFromVideoCamera(this, this::resultMessage)") {
        RPickMedia.instance.pickFromVideoCamera(this, { resultCode, path -> resultMesage(resultCode, path) })
    }

    list.add(pickFromVideoCamera)

    val setInternalStorage = generateExecuteItem(CategoryItem.PICKMEDIA, "setInternalStorage",
            "enable internal storage mode",
            "RPickMedia.instance.setInternalStorage(true)",
            "RPickMedia.instance.setInternalStorage(true);")

    list.add(setInternalStorage)

    return list
}

private fun Context.resultMesage(resultCode: Int, path: String) {
    if (resultCode == RPickMedia.PICK_FAILED) {
        throw SecurityException("not granted permission to pick media files")
    }

    toast("Picked path: ${Uri.parse(path) getRealPath this}")
}