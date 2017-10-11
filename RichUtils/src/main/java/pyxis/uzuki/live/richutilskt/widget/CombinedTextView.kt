package pyxis.uzuki.live.richutilskt.widget

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.AttributeSet
import android.util.LruCache
import android.widget.TextView
import pyxis.uzuki.live.richutilskt.R

class CombinedTextView constructor(context: Context, private val attrs: AttributeSet? = null) : TextView(context, attrs) {
    private var fontPrimaryTypeface: Typeface? = null
    private var fontSecondaryTypeface: Typeface? = null

    var textPrimary: String = ""
        set(value) {
            field = value
            apply()
        }

    var textSecondary = ""
        set(value) {
            field = value
            apply()
        }

    var textPrimaryColor: Int = 0
        set(value) {
            field = value
            apply()
        }

    var textSecondaryColor: Int = 0
        set(value) {
            field = value
            apply()
        }

    var textPrimarySize: Float = 0.toFloat()
        set(value) {
            field = value
            apply()
        }

    var textSecondarySize: Float = 0.toFloat()
        set(value) {
            field = value
            apply()
        }

    var textExtraSpace: Int = 0
        set(value) {
            field = value
            apply()
        }

    var fontPrimaryText: String? = ""
        set(value) {
            field = value
            apply()
        }

    var fontSecondaryText: String? = ""
        set(value) {
            field = value
            apply()
        }

    var textPrimaryStyle = 0
        set(value) {
            field = value
            apply()
        }

    var textSecondaryStyle = 0
        set(value) {
            field = value
            apply()
        }


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
        textPrimaryStyle = typedArray.getInt(R.styleable.CombinedTextView_textPrimaryStyle, 0)
        textSecondaryStyle = typedArray.getInt(R.styleable.CombinedTextView_textSecondaryStyle, 0)

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

        if (primarySpan != null) {
            spannableStringBuilder.setSpan(primarySpan, 0, textPrimary.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        } else {
            when (textPrimaryStyle) {
                1 -> spannableStringBuilder.setSpan(StyleSpan(Typeface.BOLD), 0, textPrimary.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                2 -> spannableStringBuilder.setSpan(StyleSpan(Typeface.ITALIC), 0, textPrimary.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                3 -> spannableStringBuilder.setSpan(StyleSpan(Typeface.BOLD_ITALIC), 0, textPrimary.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }

        if (secondarySpan != null) {
            spannableStringBuilder.setSpan(secondarySpan, textPrimary.length, contentString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        } else {
            when (textSecondaryStyle) {
                1 -> spannableStringBuilder.setSpan(StyleSpan(Typeface.BOLD), textPrimary.length, contentString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                2 -> spannableStringBuilder.setSpan(StyleSpan(Typeface.ITALIC), textPrimary.length, contentString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                3 -> spannableStringBuilder.setSpan(StyleSpan(Typeface.BOLD_ITALIC), textPrimary.length, contentString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }

        text = spannableStringBuilder
    }


    companion object {
        private val sStringCache = LruCache<String, Typeface>(12)
    }
}