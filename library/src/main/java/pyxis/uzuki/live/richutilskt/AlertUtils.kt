package pyxis.uzuki.live.richutilskt

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.text.TextUtils
import android.widget.Toast

/**
 * AlertUtils
 *
 * toast, selector, confirm, progress
 * Created by pyxis on 2017. 5. 30..
 */

/**
 * Display Toast Message
 *
 * @param[message] to display
 * @param[length] Length of display time of Toast, Default is Toast.LENGTH_SHORT
 */
fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()

/**
 * Display Toast Message
 *
 * @param[message] to display
 * @param[length] Length of display time of Toast, Default is Toast.LENGTH_SHORT
 */
fun Context.toast(message: Int, length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, length).show()

/**
 * Display AlertDialog instantly
 *
 * @param[title] optional, title
 * @param[message] to display
 * @param[positiveButton] optional, button text
 * @param[callback] callback of click ok button
 */
fun Context.alert(title: String? = "", message: String, positiveButton: String? = null, callback: DialogInterface.() -> Unit = {}) {
    val builder = AlertDialog.Builder(this)
    if (!TextUtils.isEmpty(title))
        builder.setTitle(title)
    builder.setMessage(message)
    builder.setPositiveButton(positiveButton ?: getString(android.R.string.ok), { dialog, _ -> dialog.callback() })
    builder.setCancelable(true)
    builder.show()
}

/**
 * Display SelectorDialog instantly
 *
 * @param[title] optional, title
 * @param[items] list of display item
 * @param[callback] callback of click ok button
 */
fun Context.selector(title: String? = "", items: List<CharSequence>, callback: (DialogInterface, Int) -> Unit) {
    val builder = AlertDialog.Builder(this)
    if (!TextUtils.isEmpty(title))
        builder.setTitle(title)
    builder.setItems(Array(items.size) { i -> items[i].toString() }) { dialog, which ->
        callback(dialog, which)
    }
    builder.setCancelable(true)
    builder.show()
}

/**
 * Display SelectorDialog instantly
 *
 * @param[title] optional, title
 * @param[items] list of display item, working with generic. it will display item.toString()
 * @param[callback] callback of click ok button
 */
fun <T> Context.selector(title: String? = "", items: List<T>, callback: (DialogInterface, item: T, Int) -> Unit) {
    val builder = AlertDialog.Builder(this)
    if (!TextUtils.isEmpty(title))
        builder.setTitle(title)
    builder.setItems(Array(items.size) { i -> items[i].toString() }) { dialog, which ->
        callback(dialog, items[which], which)
    }
    builder.setCancelable(true)
    builder.show()
}

/**
 * Display AlertDialog instantly with confirm
 *
 * @param[title] optional, title
 * @param[message] to display
 * @param[positiveButton] optional, button text
 * @param[negativeButton] optional, button texxt
 * @param[callback] callback of click ok button
 */
fun Context.confirm(title: String? = "", message: String, positiveButton: String? = null, negativeButton: String? = null, callback: DialogInterface.() -> Unit) {
    val builder = AlertDialog.Builder(this)
    if (!TextUtils.isEmpty(title))
        builder.setTitle(title)
    builder.setMessage(message)
    builder.setPositiveButton(positiveButton ?: getString(android.R.string.ok), { dialog, _ -> dialog.callback() })
    builder.setNegativeButton(negativeButton ?: getString(android.R.string.no), { dialog, _ -> run {} })
    builder.setCancelable(true)
    builder.show()
}

/**
 * Display ProgressDialog
 *
 * @param[title] optional, title
 * @param[message] optional, message
 */
fun Context.progress(title: String? = null, message: String): DialogInterface {
    return ProgressDialog(this).apply {
        setProgressStyle(ProgressDialog.STYLE_SPINNER)
        setMessage(message)
        if (title != null) setTitle(title)
        show()
    }
}