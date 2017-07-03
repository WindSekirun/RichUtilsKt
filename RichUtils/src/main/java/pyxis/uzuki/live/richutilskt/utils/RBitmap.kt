@file:JvmName("Utils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.util.*
import android.text.TextUtils


/**
 * Save Bitmap to file
 *
 * @param[bitmap] to save
 * @return path of file
 */
fun Context.saveBitmapToFile(bitmap: Bitmap): String? {
    try {
        val file = saveBitmapToFile(this, bitmap)
        return file?.absolutePath
    } catch (e: Exception) {
    }

    return ""
}

/**
 * get bitmap from filePath
 * @return Bitmap object
 */
fun getBitmap(filePath: String): Bitmap? {
    if (TextUtils.isEmpty(filePath)) return null
    return BitmapFactory.decodeFile(filePath)
}

/**
 * Make bitmap corner
 * @return Bitmap object
 */
fun toRoundCorner(original: Bitmap?, radius: Float): Bitmap? {
    if (original == null)
        return null
    val width = original.width
    val height = original.height
    val bitmap = Bitmap.createBitmap(width, height, original.config)
    val paint = Paint()
    val canvas = Canvas(bitmap)
    val rect = Rect(0, 0, width, height)

    paint.isAntiAlias = true
    canvas.drawRoundRect(RectF(rect), radius, radius, paint)
    paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    canvas.drawBitmap(original, rect, rect, paint)

    original.recycle()
    return bitmap
}

private fun saveBitmapToFile(context: Context, bitmap: Bitmap): File? {
    try {
        val photo = getOutputMediaFile(context)
        val out = FileOutputStream(photo)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
        out.close()

        return photo
    } catch (exception: FileNotFoundException) {
        Log.e("FileNotFoundException", exception.message)
    } catch (exception: IOException) {
        Log.e("IOException", exception.message)
    }

    return null
}

private fun getOutputMediaFile(context: Context): File {
    val picName = UUID.randomUUID().toString().replace("-".toRegex(), "") + ".jpg"

    val folder = context.getExternalFilesDir(null)
    if (!folder.isDirectory) {
        folder.mkdirs()
    }

    return File(folder, picName)
}

/**
 * Convert Drawable to Bitmap in safe way
 *
 * @param[drawable] to convert
 * @return Bitmap object
 */
fun drawableToBitmap(drawable: Drawable): Bitmap {
    if (drawable is BitmapDrawable) {
        return drawable.bitmap
    }

    var width = drawable.intrinsicWidth
    width = if (width > 0) width else 1
    var height = drawable.intrinsicHeight
    height = if (height > 0) height else 1

    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)

    return bitmap
}

/**
 * Request MediaScanning
 *
 * @param[url] to request
 */
fun Context.requestMediaScanner(url: String) {
    val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
    val f = File(url)
    val contentUri = Uri.fromFile(f)
    mediaScanIntent.data = contentUri
    this.sendBroadcast(mediaScanIntent)
}