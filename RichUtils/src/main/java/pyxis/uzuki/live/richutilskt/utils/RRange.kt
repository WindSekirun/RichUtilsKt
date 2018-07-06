@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import pyxis.uzuki.live.richutilskt.utils.progression.BigDecimalProgression

/**
 * generate list with given start, end, step
 * @param start Int
 * @param end Int
 * @param step Int
 * @return List<Int>
 */
@JvmOverloads
fun rangeList(start: Int, end: Int, step: Int = 1) = IntProgression.fromClosedRange(start, end, step).toList()

/**
 * generate list with given start, end, step
 * @param start Double
 * @param end Double
 * @param step Double
 * @return List<Double>
 */
@JvmOverloads
fun rangeList(start: Double, end: Double, step: Double = 1.0): List<Double> =
        BigDecimalProgression.fromClosedRange(start.toBigDecimal(), end.toBigDecimal(), step.toBigDecimal())
                .toList()
                .map { it.toDouble() }

/**
 * Adjust the given number so that it does not go out of range with given min, max
 * @receiver Int
 * @param min Int
 * @param max Int
 * @return Int
 */
@JvmOverloads
fun Int.makeLimit(min: Int = 0, max: Int = 0) = this.let {
    Math.min(Math.max(this, min), max)
}

/**
 * Adjust the given number so that it does not go out of range with given min, max
 * @receiver Long
 * @param min Long
 * @param max Long
 * @return Long
 */
@JvmOverloads
fun Long.makeLimit(min: Long = 0, max: Long = 0) = this.let {
    Math.min(Math.max(this, min), max)
}

/**
 * Adjust the given number so that it does not go out of range with given min, max
 * @receiver Double
 * @param min Double
 * @param max Double
 * @return Double
 */
@JvmOverloads
fun Double.makeLimit(min: Double = 0.0, max: Double = 0.0) = this.let {
    Math.min(Math.max(this, min), max)
}

/**
 * Adjust the given number so that it does not go out of range with given min, max
 * @receiver Float
 * @param min Float
 * @param max Float
 * @return Float
 */
@JvmOverloads
fun Float.makeLimit(min: Float = 0.0f, max: Float = 0.0f) = this.let {
    Math.min(Math.max(this, min), max)
}
