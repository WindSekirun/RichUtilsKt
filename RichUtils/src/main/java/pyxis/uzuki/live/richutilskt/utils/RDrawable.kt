@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import pyxis.uzuki.live.richutilskt.useGlobalContext

/**
 * Bitmap to Drawable
 *
 * @param[bitmap] to convert
 * @return Drawable Object
 */
fun Context.bitmapToDrawable(bitmap: Bitmap): Drawable = BitmapDrawable(this.resources, bitmap)

/**
 * Bitmap to Drawable
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @param[bitmap] to convert
 * @return Drawable Object
 */
fun bitmapToDrawable(bitmap: Bitmap): Drawable = useGlobalContext { bitmapToDrawable(bitmap) }