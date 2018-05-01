package pyxis.uzuki.live.richutilskt.widget

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.util.AttributeSet
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