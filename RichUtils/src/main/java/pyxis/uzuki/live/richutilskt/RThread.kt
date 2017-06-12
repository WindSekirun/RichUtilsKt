@file:JvmName("Utils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt

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
