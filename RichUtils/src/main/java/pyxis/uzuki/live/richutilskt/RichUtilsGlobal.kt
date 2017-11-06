package pyxis.uzuki.live.richutilskt

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object RichUtilsGlobal {
    internal var context: Context? = null

    fun initializeApplication(context: Context) {
        this.context = context
    }

    fun getContext(): Context {
        if (context == null) {
            throw NotInitializedException("Context is not initialized. ")
        }

        return context as Context
    }
}

class NotInitializedException(override var message: String) : Exception()