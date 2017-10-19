package pyxis.uzuki.live.richutilskt.widget

import android.content.Context
import android.os.Build
import android.support.annotation.StringRes
import android.text.Html
import android.util.AttributeSet
import android.widget.TextView

class HTMLTextView constructor(context: Context, attrs: AttributeSet? = null) : TextView(context, attrs) {

    init {
        init()
    }

    private fun init() {
        text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(text.toString(), Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(text.toString())
        }
    }

    /**
     * Set HTML Text
     * @param text text to set
     */
    fun setHtmlText(text: String) {
        setText(text)
        init()
    }

    /**
     * Set HTML Text
     * @param text resources id to set
     */
    fun setHtmlText(@StringRes text: Int) {
        setText(text)
        init()
    }
}
