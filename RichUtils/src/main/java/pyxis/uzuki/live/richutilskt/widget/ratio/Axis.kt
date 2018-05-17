package pyxis.uzuki.live.richutilskt.widget.ratio

import android.view.View

enum class Axis(val id: Int) {
    HORIZONTAL(1), VERTICAL(0)
}

internal fun findAxis(id: Int) = Axis.values().find { it.id == id }
        ?: throw IllegalArgumentException("id must not exceed 1")

internal fun Int.getMeasureSize() = View.MeasureSpec.getSize(this)
internal fun Int.calculateHeight(pair: Pair<Float, Float>) = (this * (pair.second / pair.first).toInt())
internal fun Int.calculateWidth(pair: Pair<Float, Float>) = (this * (pair.first / pair.second).toInt())
internal fun Int.makeSpec(spec: Int = View.MeasureSpec.EXACTLY) = View.MeasureSpec.makeMeasureSpec(this, spec)