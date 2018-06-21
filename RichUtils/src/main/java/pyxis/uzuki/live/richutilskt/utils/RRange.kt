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
fun list(start: Int, end: Int, step: Int = 1) = IntProgression.fromClosedRange(start, end, step).toList()

/**
 * generate list with given start, end, step
 * @param start Double
 * @param end Double
 * @param step Double
 * @return List<Double>
 */
@JvmOverloads
fun list(start: Double, end: Double, step: Double = 1.0): List<Double> =
        BigDecimalProgression.fromClosedRange(start.toBigDecimal(), end.toBigDecimal(), step.toBigDecimal())
                .toList()
                .map { it.toDouble() }