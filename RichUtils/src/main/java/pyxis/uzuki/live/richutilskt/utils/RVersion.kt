@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context

/**
 * get version code of this application
 * @return version code
 */
fun Context.versionCode(): Int = getValue({ this.packageManager.getPackageInfo(this.packageName, 0).versionCode }, 0)

/**
 * get version name of this application
 * @return version code
 */
fun Context.versionName(): String = getValue({ this.packageManager.getPackageInfo(this.packageName, 0).versionName }, "")