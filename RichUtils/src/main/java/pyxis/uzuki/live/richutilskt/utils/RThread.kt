@file:JvmName("Utils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.os.Handler
import android.os.Looper

/**
 * run code inside of Background Thread
 *
 * @param[action] code to execute
 */
fun runAsync(action: () -> Unit) = Thread(Runnable(action)).start()

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
fun runDelayed(delayMillis: Long, action: () -> Unit) = Handler().postDelayed(Runnable(action), delayMillis)

/**
 * run code inside of UI Thread after given delay
 *
 * @param[delayMillis] delay in ms
 * @param[action] code to execute
 */
fun runDelayedOnUiThread(delayMillis: Long, action: () -> Unit) = Handler(Looper.getMainLooper()).postDelayed(Runnable(action), delayMillis)

/**
 * run code inside of Background thread with custom pool size and tasksa
 * this will help in multi-threading working
 */
@JvmOverloads fun runNaraeAsync(action: () -> Unit,  poolSize: Int = RAsync.instance.settingPoolSize, taskType: String = RAsync.instance.settingTaskType) {
    RAsync.instance.execute(action , 5)
}
