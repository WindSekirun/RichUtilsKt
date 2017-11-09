package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * RichUtilsKt
 * Class: PhotoSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getPhotoSet() : ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val getImageWidth = generateExecuteItem(CategoryItem.PHOTO, "getImageWidth",
            "get Width of Image which given String",
            "realPath.getImageWidth()",
            "RichUtils.getImageWidth(realPath);")

    list.add(getImageWidth)

    val getImageWidth2 = generateExecuteItem(CategoryItem.PHOTO, "getImageWidth",
            "get Width of Image which given Drawable Resources",
            "getImageWidth(R.drawable.img_icon)",
            "RichUtils.getImageWidth(this, R.drwable.img_icon);")

    list.add(getImageWidth2)

    val getImageHeight = generateExecuteItem(CategoryItem.PHOTO, "getImageHeight",
            "get Height of Image which given String",
            "realPath.getImageHeight()",
            "RichUtils.getImageHeight(realPath);")

    list.add(getImageHeight)

    val getImageHeight2 = generateExecuteItem(CategoryItem.PHOTO, "getImageHeight",
            "get Height of Image which given Drawable Resources",
            "getImageHeight(R.drawable.img_icon)",
            "RichUtils.getImageHeight(this, R.drwable.img_icon);")

    list.add(getImageHeight2)

    val getImageMimeType = generateExecuteItem(CategoryItem.PHOTO, "getImageMimeType",
            "get Mimetype of Image which given String",
            "realPath.getImageMimeType()",
            "RichUtils.getImageMimeType(realPath);")

    list.add(getImageMimeType)

    val getImageMimeType2 = generateExecuteItem(CategoryItem.PHOTO, "getImageMimeType",
            "get Mimetype of Image which given Drawable Resources",
            "getImageMimeType(R.drawable.img_icon)",
            "RichUtils.getImageMimeType(this, R.drwable.img_icon);")

    list.add(getImageMimeType2)

    val getPhotoOrientationDegree = generateExecuteItem(CategoryItem.PHOTO, "getPhotoOrientationDegree",
            "get orientation degree of photo from ExifInterface",
            "getPhotoOrientationDegree(realPath)",
            "RichUtils.getPhotoOrientationDegree(realPath);")

    list.add(getPhotoOrientationDegree)

    val rotate = generateExecuteItem(CategoryItem.PHOTO, "rotate",
            "rotate bitmap",
            "rotate(bitmap, degree)",
            "RichUtils.rotate(bitmap, degree);")

    list.add(rotate)


    return list
}