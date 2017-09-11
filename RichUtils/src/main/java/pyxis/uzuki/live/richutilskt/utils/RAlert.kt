@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.text.TextUtils
import android.widget.Toast

/**
 * Display Toast Message
 *
 * @param[message] to display
 * @param[length] Length of display time of Toast, Default is Toast.LENGTH_SHORT
 */
@JvmOverloads
fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()

/**
 * Display Toast Message
 *
 * @param[message] to display
 * @param[length] Length of display time of Toast, Default is Toast.LENGTH_SHORT
 */
@JvmOverloads
fun Context.toast(message: Int, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()

/**
 * Display AlertDialog instantly
 *
 * @param[title] optional, title
 * @param[message] to display
 * @param[positiveButton] optional, button text
 * @param[cancelable] able to cancel
 * @param[callback] callback of click ok button
 */
@JvmOverloads
fun Context.alert(message: String, title: String? = "", positiveButton: String? = null, cancelable: Boolean = true, callback: DialogInterface.() -> Unit = {}) =
        AlertDialog.Builder(this).apply {
            if (!TextUtils.isEmpty(title))
                setTitle(title)
            setMessage(message)
            setPositiveButton(positiveButton ?: getString(android.R.string.ok), { dialog, _ -> dialog.callback() })
            setCancelable(cancelable)
            show()
        }

/**
 * Display SelectorDialog instantly
 *
 * @param[title] optional, title
 * @param[items] list of display item, working with generic. it will display item.toString()
 * @param[cancelable] able to cancel
 * @param[callback] callback of click ok button
 */
@JvmOverloads
fun <T> Context.selector(items: List<T>, callback: (DialogInterface, item: T, Int) -> Unit, title: String? = "", cancelable: Boolean = true) =
        AlertDialog.Builder(this).apply {
            if (!TextUtils.isEmpty(title))
                setTitle(title)
            setItems(Array(items.size) { i -> items[i].toString() }) { dialog, which ->
                callback(dialog, items[which], which)
            }
            setCancelable(cancelable)
            show()
        }

/**
 * Display AlertDialog instantly with confirm
 *
 * @param[title] optional, title
 * @param[message] to display
 * @param[positiveButton] optional, button text
 * @param[negativeButton] optional, button text
 * @param[cancelable] able to cancel
 * @param[callback] callback of click ok button
 */
@JvmOverloads
fun Context.confirm(message: String, callback: DialogInterface.() -> Unit, title: String? = "", positiveButton: String? = null, negativeButton: String? = null, cancelable: Boolean = true) =
        AlertDialog.Builder(this).apply {
            if (!TextUtils.isEmpty(title))
                setTitle(title)
            setMessage(message)
            setPositiveButton(positiveButton ?: getString(android.R.string.ok), { dialog, _ -> dialog.callback() })
            setNegativeButton(negativeButton ?: getString(android.R.string.no), { _, _ -> })
            setCancelable(cancelable)
            show()
        }

/**
 * Display ProgressDialog
 *
 * @param[title] optional, title
 * @param[message] message
 * @return DialogInterface
 */
@JvmOverloads
fun Context.progress(title: String? = null, message: String): DialogInterface {
    return ProgressDialog(this).apply {
        setProgressStyle(ProgressDialog.STYLE_SPINNER)
        setMessage(message)
        if (title != null)
            setTitle(title)
        show()
    }
}