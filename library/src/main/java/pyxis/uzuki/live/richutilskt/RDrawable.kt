package pyxis.uzuki.live.richutilskt

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable

/**
 * Bitmap to Drawable
 *
 * @param[bitmap] to convert
 * @return Drawable Object
 */
fun Context.bitmapToDrawable(bitmap: Bitmap?): Drawable? = BitmapDrawable(this.resources, bitmap)
