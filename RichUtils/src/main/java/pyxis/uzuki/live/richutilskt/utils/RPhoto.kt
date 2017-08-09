@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.graphics.Bitmap
import android.graphics.Matrix
import android.media.ExifInterface
import java.io.IOException

/**
 * get width of photo from ExifInterface
 *
 * @param[filePath] real path of photo
 * @return width of photo
 */
fun getPhotoWidth(filePath: String?): Int {
    var width = 0
    var exif: ExifInterface? = null

    if (filePath == null)
        return width

    try {
        exif = ExifInterface(filePath)
    } catch (e: IOException) {
        println("Error: " + e.message)
    }

    if (exif != null)
        width = exif.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, -1)

    return width
}

/**
 * get height of photo from ExifInterface
 *
 * @param[filePath] real path of photo
 * @return height of photo
 */
fun getPhotoHeight(filePath: String?): Int {
    var height = 0
    var exif: ExifInterface? = null

    if (filePath == null)
        return height

    try {
        exif = ExifInterface(filePath)
    } catch (e: IOException) {
        println("Error: " + e.message)
    }

    if (exif != null)
        height = exif.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, -1)

    return height
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
            when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> degree = 90
                ExifInterface.ORIENTATION_ROTATE_180 -> degree = 180
                ExifInterface.ORIENTATION_ROTATE_270 -> degree = 270
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
