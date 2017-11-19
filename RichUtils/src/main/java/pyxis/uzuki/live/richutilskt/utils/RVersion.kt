@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import pyxis.uzuki.live.richutilskt.useGlobalContext

/**
 * get version code of this application
 * @return version code
 */
fun Context.versionCode(): Int = getValue({ this.packageManager.getPackageInfo(this.packageName, 0).versionCode }, 0)

/**
 * get version code of this application
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 *
 * @return version code
 */
fun versionCode() : Int = useGlobalContext { versionCode() }

/**
 * get version name of this application
 * @return version code
 */
fun Context.versionName(): String = getValue({ this.packageManager.getPackageInfo(this.packageName, 0).versionName }, "")

/**
 * get version name of this application
 *
 * this methods can use Global [android.content.Context].
 * You can initialize Global Context by
 * [RichUtils.initializeApplication][pyxis.uzuki.live.richutilskt.RichUtilsGlobal.initializeApplication]
 * @return version code
 */
fun versionName() : String = useGlobalContext { versionName() }