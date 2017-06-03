package pyxis.uzuki.live.richutilskt

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build

fun reboot(context: Context, gotoActivityName: Class<out Activity>) {
    reboot(context, Intent(context, gotoActivityName))
}

@JvmOverloads fun reboot(context: Context, restartIntent: Intent = context.packageManager.getLaunchIntentForPackage(context.packageName)) {
    restartIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    if (context is Activity) {
        context.startActivity(restartIntent)
        finishAffinity(context)
    } else {
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(restartIntent)
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
