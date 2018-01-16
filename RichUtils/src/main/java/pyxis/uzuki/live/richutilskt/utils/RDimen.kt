@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context

/**
 * convert dip to px
 *
 * @param[value] to convert
 * @return calculated dip
 */
fun Context.dip2px(value: Int): Int = (value * resources.displayMetrics.density).toInt()

/**
 * convert dip to px
 *
 * @param[value] to convert
 * @return calculated dip
 * @since 1.0.1
 */
fun Context.dip2px(value: Float): Int = (value * resources.displayMetrics.density).toInt()

/**
 * convert sp to px
 *
 * @param[value] to convert
 * @return calculated sp
 */
fun Context.sp2px(value: Int): Int = (value * resources.displayMetrics.scaledDensity).toInt()


/**
 * convert sp to px
 *
 * @param[value] to convert
 * @return calculated sp
 */
fun Context.sp2px(value: Float): Int = (value * resources.displayMetrics.scaledDensity).toInt()


/**
 * convert px to dip
 *
 * @param[px] to convert
 * @return calculated dip
 */
fun Context.px2dip(px: Int): Float = px.toFloat() / resources.displayMetrics.density

/**
 * convert px to sp
 *
 * @param[px] to convert
 * @return calculated sp
 */
fun Context.px2sp(px: Int): Float = px.toFloat() / resources.displayMetrics.scaledDensity

/**
 * get pixel size from DimenRes
 *
 * @param[resource] dimen res to convert
 * @return proper pixel size
 */
fun Context.dimen(resource: Int): Int = resources.getDimensionPixelSize(resource)
