@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

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
fun Context.getAndroidId(): String = Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID) ?: ""

/**
 * get IMEI of device
 *
 * this methods will grant READ_PHONE_STATE automatically if your application target SDK 23 and above.
 * @return IMEI of device
 */
@SuppressLint("HardwareIds", "MissingPermission")
fun Context.getIMEI() : String {
    val telephonyManager = this@getIMEI.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    var imei = ""

    val arrays : Array<String> = arrayOf(Manifest.permission.READ_PHONE_STATE)
    val value = RPermission.getInstance(this).checkPermission(array = arrays, callback = { _: Int, _: List<String> ->
        imei = if (TextUtils.isEmpty(telephonyManager.deviceId)) "" else telephonyManager.deviceId
    })

    if (value)
        imei = if (TextUtils.isEmpty(telephonyManager.deviceId)) "" else telephonyManager.deviceId
    return imei
}

/**
 * get Line1Number (as know as PhoneNumber) of device
 *
 * this methods will grant READ_PHONE_STATE automatically if your application target SDK 23 and above.
 * @return Line1Number of device
 */
@SuppressLint("HardwareIds", "MissingPermission")
fun Context.getLine1Number() : String {
    val telephonyManager = this@getLine1Number.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    var number = ""

    val arrays : Array<String> = arrayOf(Manifest.permission.READ_PHONE_STATE)
    val value = RPermission.getInstance(this).checkPermission(array = arrays, callback = { _: Int, _: List<String> ->
        number = if (TextUtils.isEmpty(telephonyManager.line1Number)) "" else telephonyManager.line1Number
    })

    if (value)
        number = if (TextUtils.isEmpty(telephonyManager.line1Number)) "" else telephonyManager.line1Number
    return number
}