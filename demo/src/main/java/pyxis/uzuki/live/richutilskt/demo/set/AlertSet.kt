package pyxis.uzuki.live.richutilskt.demo.set

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

fun getAlertSet(): ArrayList<ExecuteItem> {
    val list = arrayListOf<ExecuteItem>()

    val toast = generateExecuteItem(
            CategoryItem.ALERT,
            "Toast",
            "Display Toast Message",
            { it.toast("Toast!") },
            "Context.toast(${"Toast!".toEscape()})",
            "RichUtils.toast(context, ${"Toast!".toEscape()})"
    )

    list.add(toast)

    val alert = generateExecuteItem(
            CategoryItem.ALERT,
            "Alert",
            "Display AlertDialog instantly",
            { it.alert("Alert!") },
            "Context.alert(${"Alert!".toEscape()})",
            "RichUtils.alert(context, ${"Toast!".toEscape()})"
    )

    list.add(alert)

    val selector = generateExecuteItem(
            CategoryItem.ALERT,
            "Selector",
            "Dialog SelectorDialog instantly",
            { it.selector(arrayListOf("a", "b"), { _, _, pos -> it.toast("selected $pos") }) },
            "Context.selector(arrayListOf(\"a\", \"b\"), {_, _,pos ->  it.toast(\"selected \$pos\") })",
            "ArrayList<String> objects = new ArrayList<String>();\n" +
                    "object.add(\"a\");\n" +
                    "object.add(\"b\");\n" +
                    "RichUtils.selector(this, objects, (dialog, item, position) -> {RichUtils.toast(this, \"selected \" + position);});"
    )

    list.add(selector)

    val confirm = generateExecuteItem(
            CategoryItem.ALERT,
            "Confirm",
            "Display AlertDialog instantly with confirm",
            { it.confirm("Confirm?", {}) },
            "Context.confirm(\"Confirm?\", {})",
            "RichUtils.confirm(this, \"Confirm?\", object -> {});"
    )

    list.add(confirm)

    val progress = generateExecuteItem(
            CategoryItem.ALERT,
            "Progress",
            "Display ProgressDialog",
            { it.progress("loading") },
            "Context.progress(\"loading\")",
            "RichUtils.progress(this, \"loading\");"
    )

    list.add(progress)

    return list
}
