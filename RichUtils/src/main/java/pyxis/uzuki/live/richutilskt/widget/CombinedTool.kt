package pyxis.uzuki.live.richutilskt.widget

import android.content.Context
import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.LruCache
import android.view.View
import pyxis.uzuki.live.richutilskt.utils.isEmpty

/**
 * RichUtilsKt
 * Class: CombinedTool
 * Created by Pyxis on 2017-10-27.
 *
 * Description:
 */

fun SpannableStringBuilder.setSpan(what: Any, start: Int, end: Int) {
    this.setSpan(what, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
}

fun SpannableStringBuilder.setFontSpan(span: TypefaceSpan?, textStyle: Int, start: Int, end: Int) {
    if (span != null) {
        this.setSpan(span, start, end)
    } else {
        when (textStyle) {
            1 -> this.setSpan(StyleSpan(Typeface.BOLD), start, end)
            2 -> this.setSpan(StyleSpan(Typeface.ITALIC), start, end)
            3 -> this.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, end)
        }
    }
}

fun SpannableStringBuilder.setSizeSpan(size: Float, start: Int, end: Int) {
    this.setSpan(AbsoluteSizeSpan(size.toInt()), start, end)
}

fun SpannableStringBuilder.setColorSpan(color: Int, start: Int, end: Int) {
    this.setSpan(ForegroundColorSpan(color), start, end)
}

fun View.getTypefaceSpan(fontTypefaceText: String?, fontTypeface: Typeface?): TypefaceSpan? {
    val fontTypefaceTextWrapped = if (fontTypefaceText == null) "" else fontTypefaceText

    return if (fontTypefaceTextWrapped.isEmpty()) {
        if (fontTypeface != null) TypefaceSpan(fontTypeface) else null
    } else {
        val typeface = FontCache.getTypefaceFromAsset(this.context, fontTypefaceTextWrapped)
        TypefaceSpan(typeface)
    }
}


class FontCache {
    companion object {
        private val sStringCache = LruCache<String, Typeface>(12)

        @Synchronized
        fun getTypefaceFromAsset(context: Context, name: String): Typeface? {
            var typeface: Typeface? = sStringCache.get(name)
            if (typeface == null) {
                try {
                    typeface = Typeface.createFromAsset(context.assets, name)
                } catch (exp: Exception) {
                    return null
                }

                sStringCache.put(name, typeface)
            }
            return typeface
        }
    }
}