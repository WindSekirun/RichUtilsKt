@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.os.Handler
import android.os.Looper
import pyxis.uzuki.live.richutilskt.impl.F0

/**
 * run code inside of UI Thread
 *
 * @param[action] code to execute
 */
fun runOnUiThread(action: () -> Unit) = Handler(Looper.getMainLooper()).post(Runnable(action))

/**
 * run code inside of UI Thread
 *
 * @param[action] code to execute
 */
fun runOnUiThread(action: F0) = Handler(Looper.getMainLooper()).post({ action.invoke() })

/**
 * run code inside of Background Thread after given delay
 *
 * @param[delayMillis] delay in ms
 * @param[action] code to execute
 */
fun runDelayed(delayMillis: Long, action: () -> Unit) = Handler().postDelayed(Runnable(action), delayMillis)

/**
 * run code inside of Background Thread after given delay
 *
 * @param[delayMillis] delay in ms
 * @param[action] code to execute
 */
fun runDelayed( delayMillis: Long, action: F0) = Handler().postDelayed({ action.invoke() }, delayMillis)

/**
 * run code inside of UI Thread after given delay
 *
 * @param[delayMillis] delay in ms
 * @param[action] code to execute
 */
fun runDelayedOnUiThread(action: () -> Unit, delayMillis: Long) = Handler(Looper.getMainLooper()).postDelayed(Runnable(action), delayMillis)

/**
 * run code inside of UI Thread after given delay
 *
 * @param[delayMillis] delay in ms
 * @param[action] code to execute
 */
fun runDelayedOnUiThread(action: F0, delayMillis: Long) = Handler(Looper.getMainLooper()).postDelayed({ action.invoke() }, delayMillis)

/**
 * run code inside of Background thread with custom pool size
 * this will help in multi-threading working
 */
fun runAsync(poolSize: Int = RAsync.instance.settingPoolSize, action: () -> Unit) {
    RAsync.instance.execute(action, poolSize)
}

/**
 * run code inside of Background thread with custom pool size
 * this will help in multi-threading working
 */
fun runAsync(poolSize: Int = RAsync.instance.settingPoolSize, action: F0) {
    RAsync.instance.execute({action.invoke()}, poolSize)
}

/**
 * run code inside of Background thread with default pool size
 * this will help in multi-threading working
 */
fun runAsync(action: () -> Unit) {
    RAsync.instance.execute(action, RAsync.instance.settingPoolSize)
}

/**
 * run code inside of Background thread with default pool size
 * this will help in multi-threading working
 */
fun runAsync(action: F0) {
    RAsync.instance.execute({action.invoke()}, RAsync.instance.settingPoolSize)
}

