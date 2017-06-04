package pyxis.uzuki.live.richutilskt

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build

/**
 * Reboot application
 *
 * @param[restartIntent] optional, desire activity for reboot
 */
@JvmOverloads fun Context.reboot(restartIntent: Intent = this.packageManager.getLaunchIntentForPackage(this.packageName)) {
    restartIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    if (this is Activity) {
        this.startActivity(restartIntent)
        finishAffinity(this)
    } else {
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        this.startActivity(restartIntent)
    }
}

private fun finishAffinity(activity: Activity) {
    activity.setResult(Activity.RESULT_CANCELED)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        activity.finishAffinity()
    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        activity.runOnUiThread { activity.finishAffinity() }
    }
}
