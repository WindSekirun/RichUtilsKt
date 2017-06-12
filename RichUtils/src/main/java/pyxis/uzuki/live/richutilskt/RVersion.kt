@file:JvmName("Utils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt

import android.content.Context
import android.content.pm.PackageManager

/**
 * get version code of this application
 *
 * @return version code
 * @since 1.0.2
 */
fun Context.versionCode(): Int = try {
    this.packageManager.getPackageInfo(this.packageName, 0).versionCode
} catch (e: PackageManager.NameNotFoundException) {
    0
}

/**
 * get version name of this application
 *
 * @return version code
 * @since 1.0.2
 */
fun Context.versionName(): String = try {
    this.packageManager.getPackageInfo(this.packageName, 0).versionName
} catch (e: PackageManager.NameNotFoundException) {
    ""
}

