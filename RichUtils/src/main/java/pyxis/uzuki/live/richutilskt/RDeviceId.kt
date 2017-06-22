@file:JvmName("Utils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils

/**
 * get androidId of device
 *
 * @return androidId of device
 */
@SuppressLint("HardwareIds")
fun Context.getAndroidId(): String {
    var androidId = Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
    if (TextUtils.isEmpty(androidId))
        androidId = ""

    return androidId
}

/**
 * get IMEI of device
 *
 * this methods will grant READ_PHONE_STATE automatically if your application target SDK 23 and above.
 * @return IMEI of device
 */
@SuppressLint("HardwareIds")
fun Context.getIMEI() : String {
    val telephonyManager = this@getIMEI.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    var imei = ""

    val arrays : Array<String> = arrayOf(Manifest.permission.READ_PHONE_STATE)
    val value = RPermission.getInstance(this).checkPermission(array = arrays, callback = { _: Int, _: ArrayList<String> ->
        imei = if (TextUtils.isEmpty(telephonyManager.deviceId)) "" else telephonyManager.deviceId
    })

    if (value)
        imei = if (TextUtils.isEmpty(telephonyManager.deviceId)) "" else telephonyManager.deviceId
    return imei
}