package pyxis.uzuki.live.richutilskt

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager

/**
 * Created by pyxis on 2017. 5. 31..
 */

fun Context.versionCode(): Int = try {  this.packageManager.getPackageInfo(this.packageName, 0).versionCode } catch (e: PackageManager.NameNotFoundException) { 0 }
fun Context.versionName(): String = try {  this.packageManager.getPackageInfo(this.packageName, 0).versionName } catch (e: PackageManager.NameNotFoundException) { "" }

