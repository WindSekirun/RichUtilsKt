package pyxis.uzuki.live.richutilskt.demo.item

import android.content.Context
import java.io.Serializable

/**
 * RichUtilsKt
 * Class: ExecuteItem
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */
data class ExecuteItem(val category: CategoryItem, val title: String, val message: String, val execute: ((Context) -> Unit)? = null,
                       val kotlinSample: String, val javaSample: String) : Serializable


fun generateExecuteItem(category: CategoryItem, title: String, message: String = "",
                        kotlinSample: String = "", javaSample: String = "", execute: ((Context) -> Unit)? = null): ExecuteItem {
    return ExecuteItem(category, title, message, execute, kotlinSample, javaSample)
}

fun String.toEscape() = "\"$this\""