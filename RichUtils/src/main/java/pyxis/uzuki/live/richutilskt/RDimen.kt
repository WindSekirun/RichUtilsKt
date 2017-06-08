package pyxis.uzuki.live.richutilskt

import android.content.Context

/**
 * convert int to dip
 *
 * @param[value] to convert
 * @return calculated dip
 * @since 1.0.1
 */
fun Context.dip(value: Int): Int = (value * resources.displayMetrics.density).toInt()

/**
 * convert float to dip
 *
 * @param[value] to convert
 * @return calculated dip
 * @since 1.0.1
 */
fun Context.dip(value: Float): Int = (value * resources.displayMetrics.density).toInt()

/**
 * convert int to sp
 *
 * @param[value] to convert
 * @return calculated sp
 * @since 1.0.1
 */
fun Context.sp(value: Int): Int = (value * resources.displayMetrics.scaledDensity).toInt()

/**
 * convert float to sp
 *
 * @param[value] to convert
 * @return calculated sp
 * @since 1.0.1
 */
fun Context.sp(value: Float): Int = (value * resources.displayMetrics.scaledDensity).toInt()

/**
 * convert px to dip
 *
 * @param[value] to convert
 * @return calculated dip
 * @since 1.0.1
 */
fun Context.px2dip(px: Int): Float = px.toFloat() / resources.displayMetrics.density

/**
 * convert px to sp
 *
 * @param[value] to convert
 * @return calculated sp
 * @since 1.0.1
 */
fun Context.px2sp(px: Int): Float = px.toFloat() / resources.displayMetrics.scaledDensity

/**
 * get pixel size from DimenRes
 *
 * @param[resource] dimen res to convert
 * @return proper pixel size
 * @since 1.0.1
 */
fun Context.dimen(resource: Int): Int = resources.getDimensionPixelSize(resource)