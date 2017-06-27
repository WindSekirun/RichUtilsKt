package pyxis.uzuki.live.richutilskt.widget

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.text.TextUtils
import android.util.AttributeSet
import android.widget.Button

class CenteredIconButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = android.R.attr.buttonStyle) : Button(context, attrs, defStyle) {

    private val textBounds = Rect()
    private val drawableBounds = Rect()

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (!changed)
            return

        val text = text
        if (!TextUtils.isEmpty(text)) {
            val textPaint = paint
            textPaint.getTextBounds(text.toString(), 0, text.length, textBounds)
        } else {
            textBounds.setEmpty()
        }

        val width = width - (paddingLeft + paddingRight)
        val height = height - (paddingTop + paddingBottom)

        val drawables = compoundDrawables

        if (drawables[LEFT] != null) {
            drawables[LEFT].copyBounds(drawableBounds)
            val leftOffset = (width - (textBounds.width() + drawableBounds.width()) + rightPaddingOffset) / 2 - compoundDrawablePadding
            drawableBounds.offset(leftOffset, 0)
            drawables[LEFT].bounds = drawableBounds
        }

        if (drawables[RIGHT] != null) {
            drawables[RIGHT].copyBounds(drawableBounds)
            val rightOffset = (textBounds.width() + drawableBounds.width() - width + leftPaddingOffset) / 2 + compoundDrawablePadding
            drawableBounds.offset(rightOffset, 0)
            drawables[RIGHT].bounds = drawableBounds
        }

        if (drawables[TOP] != null) {
            drawables[TOP].copyBounds(drawableBounds)
            val topOffset = (height - (textBounds.height() + drawableBounds.height()) + bottomPaddingOffset) / 2 - compoundDrawablePadding

            drawableBounds.offsetTo(0, topOffset)
            drawables[TOP].bounds = drawableBounds
        }
    }

    companion object {
        private val LEFT = 0
        private val TOP = 1
        private val RIGHT = 2
        private val BOTTOM = 3
    }
}