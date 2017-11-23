package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.R
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.toEscape
import pyxis.uzuki.live.richutilskt.utils.*

/**
 * RichUtilsKt
 * Class: AlertSet
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */

fun Context.getAlertSet(): ArrayList<ExecuteItem> {
    val list = arrayListOf<ExecuteItem>()

    val toast = generateExecuteItem(CategoryItem.ALERT, "toast",
            getString(R.string.alert_message_toast), "toast(${"Toast!".toEscape()})",
            "RichUtils.toast(context, ${"Toast!".toEscape()})") {
        it.toast("Toast!")
    }

    list.add(toast)

    val alert = generateExecuteItem(CategoryItem.ALERT, "alert",
            getString(R.string.alert_message_alert),
            "alert(${"Alert!".toEscape()})",
            "RichUtils.alert(context, ${"Alert!".toEscape()})") {
        it.alert("Alert!")
    }

    list.add(alert)

    val selector = generateExecuteItem(CategoryItem.ALERT, "selector",
            getString(R.string.alert_message_selector),
            "selector(arrayListOf(\"a\", \"b\"), {_, _, pos ->  it.toast(\"selected \$pos\") })",
            "ArrayList<String> objects = new ArrayList<String>();\n" +
                    "object.add(\"a\");\n" +
                    "object.add(\"b\");\n" +
                    "RichUtils.selector(this, objects, (dialog, item, position) -> {RichUtils.toast(this, \"selected \" + position);});") {
        it.selector(arrayListOf("a", "b"), { _, _, pos ->
            it.toast("selected $pos")
        })
    }

    list.add(selector)

    val confirm = generateExecuteItem(CategoryItem.ALERT, "confirm",
            getString(R.string.alert_message_confirm),
            "confirm(${"Confirm?".toEscape()}, {})",
            "RichUtils.confirm(this, ${"Confirm?".toEscape()}, object -> {});") {
        it.confirm("Confirm?", {})
    }

    list.add(confirm)

    val progress = generateExecuteItem(CategoryItem.ALERT, "progress",
            getString(R.string.alert_message_progress), "progress(${"loading".toEscape()})",
            "RichUtils.progress(this, ${"loading".toEscape()});"
    ) { it.progress("loading") }

    list.add(progress)

    return list
}
