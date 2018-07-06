@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri


/**
 * Browse given url with internal browser
 *
 * @param [url] url to browse
 * @param [newTask] flag to newTask
 */
@JvmOverloads fun Context.browse(url: String, newTask: Boolean = false): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        if (newTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        true
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        false
    }
}

/**
 * Make phone call with given phone number
 *
 * this feature need CALL_PHONE permission.
 *
 * @param[number] Phone number to call
 */
@SuppressLint("MissingPermission")
fun Context.makeCall(number: String): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
        startActivity(intent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

/**
 * Make phone dial with given phone number
 *
 * @param[number] Phone number to dial
 */
fun Context.dialCall(number: String): Boolean {
    return try {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
        startActivity(intent)
        true
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}