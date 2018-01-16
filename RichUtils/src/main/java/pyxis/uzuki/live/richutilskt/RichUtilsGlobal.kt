package pyxis.uzuki.live.richutilskt

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object RichUtilsGlobal {
    internal var context: Context? = null

    fun initializeApplication(context: Context) {
        this.context = context
    }
}

//fun <R> useGlobalContext(action: (Context) -> R): R {
//    val context = RichUtilsGlobal.context ?:
//            throw NotInitializedException("Not initialized global Context. Please add RichUtilsGlobal.initializeApplication(this) in Application Class")
//    return action(context)
//}

class NotInitializedException(override var message: String) : Exception()