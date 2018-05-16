package pyxis.uzuki.live.richutilskt.widget.ratio

interface RatioInterface {

    fun setRatio(axis: Axis, horizontalRatio: Float, verticalRatio: Float)
    fun setRatio(horizontalRatio: Float, verticalRatio: Float)
    fun getHorizontalRatio(): Float
    fun getVerticalRatio(): Float
    fun getAxis(): Axis
}