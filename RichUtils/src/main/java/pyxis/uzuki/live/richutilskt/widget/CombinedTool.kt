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

fun View.getTypefaceSpan(fontTypefaceText: String, fontTypeface: Typeface?): TypefaceSpan? =
        if (fontTypefaceText.isEmpty()) {
            if (fontTypeface != null) TypefaceSpan(fontTypeface) else null
        } else {
            val typeface = FontCache.getTypefaceFromAsset(this.context, fontTypefaceText)
            TypefaceSpan(typeface)
        }

fun CombinedItem.applyCombined(): SpannableStringBuilder? {
    if (textPrimary.isEmpty()) {
        return null
    }

    if (textSecondary.isEmpty()) {
        return null
    }

    var contentString = textPrimary
    if (textExtraSpace != 0) {
        for (i in 0 until textExtraSpace) {
            contentString += " "
        }
    }

    contentString += textSecondary

    val primarySpan = this.view?.getTypefaceSpan(fontPrimaryText, fontPrimaryTypeface)
    val secondarySpan = this.view?.getTypefaceSpan(fontSecondaryText, fontSecondaryTypeface)

    val builder = SpannableStringBuilder(contentString)
    builder.clearSpans()

    builder.setSizeSpan(textPrimarySize, 0, textPrimary.length)
    builder.setSizeSpan(textSecondarySize, textPrimary.length, contentString.length)
    builder.setColorSpan(textPrimaryColor, 0, textPrimary.length)
    builder.setColorSpan(textSecondaryColor, textPrimary.length, contentString.length)
    builder.setFontSpan(primarySpan, textPrimaryStyle, 0, textPrimary.length)
    builder.setFontSpan(secondarySpan, textSecondaryStyle, textPrimary.length, contentString.length)

    return builder
}

class CombinedItem() {
    var view: View? = null
    var fontPrimaryTypeface: Typeface? = null
    var fontSecondaryTypeface: Typeface? = null
    var textPrimary: String = ""
    var textSecondary = ""
    var textPrimaryColor: Int = 0
    var textSecondaryColor: Int = 0
    var textPrimarySize: Float = 0.toFloat()
    var textSecondarySize: Float = 0.toFloat()
    var textExtraSpace: Int = 0
    var fontPrimaryText: String = ""
    var fontSecondaryText: String = ""
    var textPrimaryStyle = 0
    var textSecondaryStyle = 0

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