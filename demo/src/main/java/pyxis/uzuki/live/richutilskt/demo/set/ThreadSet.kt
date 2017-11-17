package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem

/**
 * RichUtilsKt
 * Class: ThreadSet
 * Created by Pyxis on 2017-11-17.
 *
 * Description:
 */

fun Context.getThreadSet() : ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val runOnUiThread = generateExecuteItem(CategoryItem.THREAD, "runOnUiThread",
            "run code inside of UI Thread",
            "runOnUiThread {}",
            "runOnUiThread(() -> {});")

    list.add(runOnUiThread)

    val runDelayed = generateExecuteItem(CategoryItem.THREAD, "runDelayed",
            "run code inside of Background Thread after given delay",
            "runDelayed(1000) {}",
            "runDelayed(1000, () -> {});")

    list.add(runDelayed)

    val runDelayedOnUiThread = generateExecuteItem(CategoryItem.THREAD, "runDelayedOnUiThread",
            "run code inside of UI Thread after given delay",
            "runDelayedOnUiThread(1000) {}",
            "runDelayedOnUiThread(1000, () -> {});")

    list.add(runDelayedOnUiThread)

    val runAsync = generateExecuteItem(CategoryItem.THREAD, "runAsync",
            "run code inside of Background thread with custom pool size",
            "runAsync(5) {}",
            "runAsync(5, () -> {});")

    list.add(runAsync)

    return list
}