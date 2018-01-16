package pyxis.uzuki.live.richutilskt.widget

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.AttributeSet
import android.widget.Button
import pyxis.uzuki.live.richutilskt.R

class CombinedButton constructor(context: Context, private val attrs: AttributeSet? = null) : Button(context, attrs) {
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

    var fontPrimaryText: String = ""
        set(value) {
            field = value
            apply()
        }

    var fontSecondaryText: String = ""
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
        if (attrs == null) {
            return
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CombinedButton) ?: return
        textPrimary = typedArray.getString(R.styleable.CombinedButton_textPrimary)
        textSecondary = typedArray.getString(R.styleable.CombinedButton_textSecondary)
        textPrimaryColor = typedArray.getColor(R.styleable.CombinedButton_textPrimaryColor, Color.BLACK)
        textSecondaryColor = typedArray.getColor(R.styleable.CombinedButton_textSecondaryColor, Color.BLACK)
        textPrimarySize = typedArray.getDimension(R.styleable.CombinedButton_textPrimarySize, resources.getDimensionPixelSize(R.dimen.combined_text_view_default_size).toFloat())
        textSecondarySize = typedArray.getDimension(R.styleable.CombinedButton_textSecondarySize, resources.getDimensionPixelSize(R.dimen.combined_text_view_default_size).toFloat())
        textExtraSpace = typedArray.getInt(R.styleable.CombinedButton_textExtraSpace, 1)
        fontPrimaryText = typedArray.getString(R.styleable.CombinedButton_fontPrimaryText)
        fontSecondaryText = typedArray.getString(R.styleable.CombinedButton_fontSecondaryText)
        textPrimaryStyle = typedArray.getInt(R.styleable.CombinedButton_textPrimaryStyle, 0)
        textSecondaryStyle = typedArray.getInt(R.styleable.CombinedButton_textSecondaryStyle, 0)

        typedArray.recycle()
    }

    /**
     * Display in Layout Editor Preview
     */
    override fun onFinishInflate() {
        super.onFinishInflate()
        apply()
    }

    /**
     * Inflate SpannableString using provided value (either TypedArray(XML) or setter(Java)
     */
    fun apply() {
        val combindedItem = CombinedItem()
        combindedItem.view = this
        combindedItem.fontSecondaryTypeface = fontSecondaryTypeface
        combindedItem.fontPrimaryTypeface = fontPrimaryTypeface
        combindedItem.textPrimary = textPrimary
        combindedItem.textSecondary = textSecondary
        combindedItem.textPrimaryColor = textPrimaryColor
        combindedItem.textSecondaryColor = textSecondaryColor
        combindedItem.textPrimarySize = textPrimarySize
        combindedItem.textSecondarySize = textSecondarySize
        combindedItem.textExtraSpace = textExtraSpace
        combindedItem.fontPrimaryText = fontPrimaryText
        combindedItem.fontSecondaryText = fontSecondaryText
        combindedItem.textPrimaryStyle = textPrimaryStyle
        combindedItem.textSecondaryStyle = textSecondaryStyle

        val builder = combindedItem.applyCombined()
        if (builder != null) {
            text = builder
        }
    }
}