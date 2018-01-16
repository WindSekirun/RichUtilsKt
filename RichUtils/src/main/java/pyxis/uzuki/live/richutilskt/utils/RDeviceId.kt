@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings

/**
 * get androidId of device
 *
 * @return androidId of device
 */
@SuppressLint("HardwareIds")
fun Context.getAndroidId(): String = Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID) ?: ""

/**
 * get IMEI of device
 *
 * this methods will grant READ_PHONE_STATE automatically if your application target SDK 23 and above.
 * @return IMEI of device
 */
@SuppressLint("HardwareIds", "MissingPermission")
fun Context.getIMEI(): String {
    var imei = ""

    val arrays: Array<String> = arrayOf(Manifest.permission.READ_PHONE_STATE)
    RPermission.instance.checkPermission(this, array = arrays, callback = { _: Int, _: List<String> ->
        imei = telephonyManager.deviceId.isEmptyOrReturn()
    })
    return imei
}

/**
 * get Line1Number (as know as PhoneNumber) of device
 *
 * this methods will grant READ_PHONE_STATE automatically if your application target SDK 23 and above.
 * @return Line1Number of device
 */
@SuppressLint("HardwareIds", "MissingPermission")
fun Context.getLine1Number(): String {
    var number = ""

    val arrays: Array<String> = arrayOf(Manifest.permission.READ_PHONE_STATE)
    RPermission.instance.checkPermission(this, array = arrays, callback = { _: Int, _: List<String> ->
        number = telephonyManager.line1Number.isEmptyOrReturn()
    })

    return number
}