@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.support.annotation.DrawableRes
import java.io.IOException

private val options: BitmapFactory.Options by lazy {
    val opt = BitmapFactory.Options()
    opt.inJustDecodeBounds = true
    opt
}

/**
 * get Width of Image which given String
 *
 * @return Width of Image
 */
fun String.getImageWidth(): Int {
    BitmapFactory.decodeFile(this, options)
    return options.outWidth
}

/**
 * get Height of Image which given String
 *
 * @return Height of Image
 */
fun String.getImageHeight(): Int {
    BitmapFactory.decodeFile(this, options)
    return options.outHeight
}

/**
 * get MimeType of Image which given String
 *
 * @return MimeType of Image
 */
fun String.getImageMimeType(): String {
    BitmapFactory.decodeFile(this, options)
    return options.outMimeType ?: ""
}

/**
 * get Width of Image which given Drawable Resources
 *
 * @return Width of Image
 */
fun Context.getImageWidth(@DrawableRes resId: Int): Int {
    BitmapFactory.decodeResource(this.resources, resId, options)
    return options.outWidth
}

/**
 * get Height of Image which given Drawable Resources
 *
 * @return Height of Image
 */
fun Context.getImageHeight(@DrawableRes resId: Int): Int {
    BitmapFactory.decodeResource(this.resources, resId, options)
    return options.outHeight
}

/**
 * get MimeType of Image which given Drawable Resources
 *
 * @return MimeType of Image
 */
fun Context.getImageMimeType(@DrawableRes resId: Int): String {
    BitmapFactory.decodeResource(this.resources, resId, options)
    return options.outMimeType ?: ""
}

/**
 * get orientation degree of photo from ExifInterface
 *
 * @param[filePath] real path of photo
 * @return orientation degree of photo
 */
fun getPhotoOrientationDegree(filePath: String?): Int {
    var degree = 0
    var exif: ExifInterface? = null

    if (filePath == null)
        return degree

    try {
        exif = ExifInterface(filePath)
    } catch (e: IOException) {
        println("Error: " + e.message)
    }

    if (exif != null) {
        val orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1)
        if (orientation != -1) {
            degree = when (orientation) {
                ExifInterface.ORIENTATION_NORMAL, ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> 0
                ExifInterface.ORIENTATION_ROTATE_180, ExifInterface.ORIENTATION_FLIP_VERTICAL -> 180
                ExifInterface.ORIENTATION_ROTATE_90, ExifInterface.ORIENTATION_TRANSPOSE -> 90
                ExifInterface.ORIENTATION_ROTATE_270, ExifInterface.ORIENTATION_TRANSVERSE -> 270
                else -> 0
            }
        }
    }
    return degree
}

/**
 * rotate bitmap
 *
 * @param[bitmap] Bitmap which rotate
 * @param[degree] rotate amount
 */
fun rotate(bitmap: Bitmap, degree: Int): Bitmap {
    val mat = Matrix()
    mat.postRotate(degree.toFloat())
    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, mat, true)
}