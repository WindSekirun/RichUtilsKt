package pyxis.uzuki.live.richutilskt

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import java.security.MessageDigest

/**
 * get key hash of application
 *
 * it will help to integrate with Facebook, Kakao SDK
 *
 * @return key hash of application
 */
@SuppressLint("PackageManagerGetSignatures")
fun Context.getKeyHash() : String {
    val hashList:ArrayList<String> = ArrayList()
    try {
        val info = this.packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
        for (signature in info.signatures) {
            val md = MessageDigest.getInstance("SHA")
            md.update(signature.toByteArray())
            hashList.add(String(Base64.encode(md.digest(), 0)))
        }

        return if (hashList.isNotEmpty()) hashList[0] else ""
    } catch (e: Exception) {
        Log.e("name not found", e.toString())
    }

    return ""
}