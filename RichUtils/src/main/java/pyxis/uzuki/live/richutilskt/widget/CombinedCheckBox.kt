package pyxis.uzuki.live.richutilskt.widget

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.MetricAffectingSpan
import android.util.AttributeSet
import android.util.LruCache
import android.widget.CheckBox
import pyxis.uzuki.live.richutilskt.R

/*
        app:textPrimary="WindSekirun"
        app:textPrimaryColor="#0fb2fb"
        app:textPrimarySize="15sp"
        app:textSecondary="\@WindSekirun"
        app:textSecondaryColor="#828282"
        app:textSecondarySize="10sp"
 */
class CombinedCheckBox constructor(context: Context, val attrs: AttributeSet? = null) : CheckBox(context, attrs) {
    var textPrimary: String = ""
    var textSecondary = ""
    var textPrimaryColor: Int = 0
    var textSecondaryColor: Int = 0
    var textPrimarySize: Float = 0.toFloat()
    var textSecondarySize: Float = 0.toFloat()
    var textExtraSpace: Int = 0
    var fontPrimaryText: String? = ""
    var fontSecondaryText: String? = ""
    var fontPrimaryTypeface: Typeface? = null
    var fontSecondaryTypeface: Typeface? = null

    init {
        initView()
    }

    private fun initView() {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CombinedTextView)
        textPrimary = typedArray.getString(R.styleable.CombinedTextView_textPrimary)
        textSecondary = typedArray.getString(R.styleable.CombinedTextView_textSecondary)
        textPrimaryColor = typedArray.getColor(R.styleable.CombinedTextView_textPrimaryColor, Color.BLACK)
        textSecondaryColor = typedArray.getColor(R.styleable.CombinedTextView_textSecondaryColor, Color.BLACK)
        textPrimarySize = typedArray.getDimension(R.styleable.CombinedTextView_textPrimarySize, resources.getDimensionPixelSize(R.dimen.combined_text_view_default_size).toFloat())
        textSecondarySize = typedArray.getDimension(R.styleable.CombinedTextView_textSecondarySize, resources.getDimensionPixelSize(R.dimen.combined_text_view_default_size).toFloat())
        textExtraSpace = typedArray.getInt(R.styleable.CombinedTextView_textExtraSpace, 1)
        fontPrimaryText = typedArray.getString(R.styleable.CombinedTextView_fontPrimaryText)
        fontSecondaryText = typedArray.getString(R.styleable.CombinedTextView_fontSecondaryText)

        typedArray.recycle()
    }

    /**
     * Display in Layout Editor Preview
     */
    override fun onFinishInflate() {
        super.onFinishInflate()
        apply()
    }

    private val primaryFontSpan: TypefaceSpan?
        get() {
            if (fontPrimaryText == null || fontPrimaryText!!.isEmpty())
                return null

            val typeface = getTypefaceFromAsset(context, fontPrimaryText as String) ?: return null
            return TypefaceSpan(typeface)
        }

    private val secondaryFontSpan: TypefaceSpan?
        get() {
            if (fontSecondaryText == null || fontSecondaryText!!.isEmpty())
                return null

            val typeface = getTypefaceFromAsset(context, fontSecondaryText as String) ?: return null
            return TypefaceSpan(typeface)
        }

    @Synchronized private fun getTypefaceFromAsset(context: Context, name: String): Typeface? {
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

    /**
     * Inflate SpannableString using provided value (either TypedArray(XML) or setter(Java)
     */
    fun apply() {
        if (textPrimary.isEmpty())
            return

        if (textSecondary.isEmpty())
            return

        var contentString = textPrimary
        if (textExtraSpace != 0)
            for (i in 0 until textExtraSpace)
                contentString += " "

        contentString += textSecondary

        val primarySpan = if (fontPrimaryTypeface != null) TypefaceSpan(fontSecondaryTypeface) else primaryFontSpan
        val secondarySpan = if (fontSecondaryTypeface != null) TypefaceSpan(fontSecondaryTypeface) else secondaryFontSpan

        val spannableStringBuilder = SpannableStringBuilder(contentString)
        spannableStringBuilder.clearSpans()

        spannableStringBuilder.setSpan(AbsoluteSizeSpan(textPrimarySize.toInt()), 0, textPrimary.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(AbsoluteSizeSpan(textSecondarySize.toInt()), textPrimary.length, contentString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(ForegroundColorSpan(textPrimaryColor), 0, textPrimary.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(ForegroundColorSpan(textSecondaryColor), textPrimary.length, contentString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        if (primarySpan != null)
            spannableStringBuilder.setSpan(primarySpan, 0, textPrimary.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        if (secondarySpan != null)
            spannableStringBuilder.setSpan(secondarySpan, textPrimary.length, contentString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        text = spannableStringBuilder
    }


    /**
     * Custom Typeface span class
     */
    private inner class TypefaceSpan internal constructor(inputTypeface: Typeface?) : MetricAffectingSpan() {
        private var mTypeface: Typeface? = null

        init {
            if (inputTypeface != null)
                mTypeface = inputTypeface
        }

        /**
         * Passes updateMeasureState through to the underlying [MetricAffectingSpan].
         */
        override fun updateMeasureState(p: TextPaint?) {
            if (p != null && mTypeface != null) {
                p.typeface = mTypeface
                p.flags = p.flags or Paint.FILTER_BITMAP_FLAG
            }

        }

        /**
         * Passes updateDrawState through to the underlying [MetricAffectingSpan].
         */
        override fun updateDrawState(tp: TextPaint?) {
            if (tp != null && mTypeface != null) {
                tp.typeface = mTypeface
                tp.flags = tp.flags or Paint.FILTER_BITMAP_FLAG
            }
        }
    }

    companion object {
        private val sStringCache = LruCache<String, Typeface>(12)
    }
}