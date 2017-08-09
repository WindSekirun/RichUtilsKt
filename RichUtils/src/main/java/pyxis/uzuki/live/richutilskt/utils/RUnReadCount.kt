@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.content.Intent
import android.text.TextUtils

/**
 * apply count of UnRead
 *
 * @param[count] count of setting count
 */
fun Context.applyUnReadCount(count: Int) {
    val launcherClassName = getLauncherClassName(this)
    if (TextUtils.isEmpty(launcherClassName)) return
    applyDefault(this, count, launcherClassName)
}

/**
 * remove count of UnRead
 */
fun Context.removeUnReadCount() {
    this.applyUnReadCount(0)
}

private fun applyDefault(context: Context, count: Int, launcherClassName: String) {
    val intent = Intent("android.intent.action.BADGE_COUNT_UPDATE")
    intent.putExtra("badge_count_package_name", context.packageName)
    intent.putExtra("badge_count_class_name", launcherClassName)
    intent.putExtra("badge_count", count)
    intent.flags = 0x00000020

    context.sendBroadcast(intent)
}

private fun getLauncherClassName(context: Context): String {
    val intent = Intent(Intent.ACTION_MAIN)
    intent.addCategory(Intent.CATEGORY_LAUNCHER)
    intent.`package` = context.packageName
    val resolveInfoList = context.packageManager.queryIntentActivities(intent, 0)
    if (resolveInfoList != null && resolveInfoList.size > 0) {
        return resolveInfoList[0].activityInfo.name
    }
    return ""
}