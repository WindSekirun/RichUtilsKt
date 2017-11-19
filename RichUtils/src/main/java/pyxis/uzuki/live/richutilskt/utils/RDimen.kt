@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import pyxis.uzuki.live.richutilskt.useGlobalContext

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
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @param[value] to convert
 * @return calculated dip
 */
fun dip2px(value: Int) : Int = useGlobalContext { dip2px(value) }

/**
 * convert dip to px
 *
 * @param[value] to convert
 * @return calculated dip
 * @since 1.0.1
 */
fun Context.dip2px(value: Float): Int = (value * resources.displayMetrics.density).toInt()

/**
 * convert dip to px
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @param[value] to convert
 * @return calculated dip
 */
fun dip2px(value: Float) : Int = useGlobalContext { dip2px(value) }

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
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @param[value] to convert
 * @return calculated sp
 */
fun sp2px(value: Int): Int = useGlobalContext { sp2px(value) }

/**
 * convert sp to px
 *
 * @param[value] to convert
 * @return calculated sp
 */
fun Context.sp2px(value: Float): Int = (value * resources.displayMetrics.scaledDensity).toInt()

/**
 * convert sp to px
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @param[value] to convert
 * @return calculated sp
 */
fun sp2px(value: Float): Int = useGlobalContext { sp2px(value) }

/**
 * convert px to dip
 *
 * @param[px] to convert
 * @return calculated dip
 */
fun Context.px2dip(px: Int): Float = px.toFloat() / resources.displayMetrics.density

/**
 * convert px to dip
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @param[px] to convert
 * @return calculated dip
 */
fun px2dip(px: Int) : Float = useGlobalContext { px2dip(px) }

/**
 * convert px to sp
 *
 * @param[px] to convert
 * @return calculated sp
 */
fun Context.px2sp(px: Int): Float = px.toFloat() / resources.displayMetrics.scaledDensity

/**
 * convert px to sp
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @param[px] to convert
 * @return calculated sp
 */
fun px2sp(px: Int): Float = useGlobalContext { px2sp(px) }

/**
 * get pixel size from DimenRes
 *
 * @param[resource] dimen res to convert
 * @return proper pixel size
 */
fun Context.dimen(resource: Int): Int = resources.getDimensionPixelSize(resource)

/**
 * get pixel size from DimenRes
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @param[resource] dimen res to convert
 * @return proper pixel size
 */
fun dimen(resource: Int) : Int = useGlobalContext { dimen(resource) }