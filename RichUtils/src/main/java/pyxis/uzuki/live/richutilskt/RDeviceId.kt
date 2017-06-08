package pyxis.uzuki.live.richutilskt

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
 * Notice! -> you have to grant READ_PHONE_STATE if your application target 23 or above (Runtime permission)
 * you can use RPermission to grant Runtime permission easily.
 *
 * @return IMEI of device
 */
@SuppressLint("HardwareIds")
fun Context.getIMEI() : String {
    val telephonyManager = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    var imei = telephonyManager.deviceId
    if (TextUtils.isEmpty(imei))
        imei = ""

    return imei
}