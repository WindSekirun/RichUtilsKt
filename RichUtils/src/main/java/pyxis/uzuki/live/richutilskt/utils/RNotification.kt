@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi

/**
 * create Notification Channel for Android Oreo and above.
 * every options is optional, if you doesn't matter whatever value,
 * leave them no parameters.
 *
 * @param[id] channel id, if this value is not present, it will be package name
 * @param[name] channel name, if this value is not present, it will be app name
 * @param[description] channel description, if this value is not present, it will be app name
 * @param[importance] importance of channel, if this value is not present, it will be IMPORTANCE_LOW
 * @return generated channel id
 */
@RequiresApi(Build.VERSION_CODES.O)
@JvmOverloads
fun Context.createNotificationChannel(id: String = "", name: String = "", description: String = "", importance: Int = NotificationManager.IMPORTANCE_LOW): String {
    if (Build.VERSION.SDK_INT < 26) {
        return ""
    }

    val newId = id.isEmptyOrReturn(this.packageName)
    val appName = if (applicationInfo.labelRes != 0) getString(applicationInfo.labelRes) else applicationInfo.nonLocalizedLabel.toString()
    val newName = name.isEmptyOrReturn(appName)
    val newDescription = description.isEmptyOrReturn(appName)

    val notificationManager = this.notificationManager
    val mChannel = NotificationChannel(newId, newName, importance)
    mChannel.description = newDescription
    notificationManager.createNotificationChannel(mChannel)

    return newId
}