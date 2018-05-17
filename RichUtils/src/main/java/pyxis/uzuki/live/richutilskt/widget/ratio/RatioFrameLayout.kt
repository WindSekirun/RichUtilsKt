package pyxis.uzuki.live.richutilskt.widget.ratio

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import pyxis.uzuki.live.richutilskt.R

/**
 * RichUtilsKt
 * Class: RatioLinearLayout
 * Created by pyxis on 18. 5. 16.
 *
 *
 * Description:
 */
class RatioFrameLayout constructor(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs), RatioInterface {
    private var mAxis: Axis = Axis.HORIZONTAL
    private var mVerticalRatio = 1f
    private var mHorizontalRatio = 1f

    init {
        if (attrs != null) {
            val array = context.obtainStyledAttributes(attrs, R.styleable.RatioFrameLayout)
            mAxis = findAxis(array.getInt(R.styleable.RatioFrameLayout_axis, 0))
            mVerticalRatio = array.getFloat(R.styleable.RatioFrameLayout_verticalRatio, 1f)
            mHorizontalRatio = array.getFloat(R.styleable.RatioFrameLayout_horizontalRatio, 1f)
            array.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val originalWidth = widthMeasureSpec.getMeasureSize()
        val originalHeight = heightMeasureSpec.getMeasureSize()
        if (mAxis == Axis.HORIZONTAL) {
            val height = originalWidth.calculateHeight(mHorizontalRatio to mVerticalRatio)
            super.onMeasure(widthMeasureSpec, height.makeSpec())
        } else {
            val height = originalHeight.calculateWidth(mHorizontalRatio to mVerticalRatio)
            super.onMeasure(height.makeSpec(), heightMeasureSpec)
        }
    }

    override fun setRatio(axis: Axis, horizontalRatio: Float, verticalRatio: Float) {
        mAxis = axis
        mVerticalRatio = verticalRatio
        mHorizontalRatio = horizontalRatio
        this.invalidate()
        this.requestLayout()
    }

    override fun setRatio(horizontalRatio: Float, verticalRatio: Float) {
        setRatio(mAxis, horizontalRatio, verticalRatio)
    }

    override fun getHorizontalRatio() = mHorizontalRatio
    override fun getVerticalRatio() = mVerticalRatio
    override fun getAxis() = mAxis
}