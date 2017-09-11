@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.os.Handler
import android.os.Looper

/**
 * run code inside of UI Thread
 *
 * @param[action] code to execute
 */
fun runOnUiThread(action: () -> Unit) = Handler(Looper.getMainLooper()).post(Runnable(action))

/**
 * run code inside of Background Thread after given delay
 *
 * @param[delayMillis] delay in ms
 * @param[action] code to execute
 */
fun runDelayed(action: () -> Unit, delayMillis: Long) = Handler().postDelayed(Runnable(action), delayMillis)

/**
 * run code inside of UI Thread after given delay
 *
 * @param[delayMillis] delay in ms
 * @param[action] code to execute
 */
fun runDelayedOnUiThread(action: () -> Unit, delayMillis: Long) = Handler(Looper.getMainLooper()).postDelayed(Runnable(action), delayMillis)

/**
 * run code inside of Background thread with custom pool size and tasksa
 * this will help in multi-threading working
 */
@JvmOverloads fun runAsync(poolSize: Int = RAsync.instance.settingPoolSize, taskType: String = RAsync.instance.settingTaskType, action: () -> Unit) {
    RAsync.instance.execute(action , 5)
}
