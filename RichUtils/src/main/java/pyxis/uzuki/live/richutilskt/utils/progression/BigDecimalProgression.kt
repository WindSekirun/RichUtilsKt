@file:JvmName("BigDecimalProgression")
@file:JvmMultifileClass
@file:Suppress("MemberVisibilityCanBePrivate")

package pyxis.uzuki.live.richutilskt.utils.progression

import java.math.BigDecimal

open class BigDecimalProgression
internal constructor(start: BigDecimal, endInclusive: BigDecimal, val step: BigDecimal) : Iterable<BigDecimal> {
    init {
        if (step == BigDecimal.ZERO) throw IllegalArgumentException("Step must be non-zero")
    }

    val first: BigDecimal = start
    val last: BigDecimal = getProgressionLastElement(start, endInclusive, step)

    override fun iterator(): BigDecimalIterator = BigDecimalProgressionIterator(first, last, step)

    /** Checks if the progression is empty. */
    open fun isEmpty(): Boolean = if (step > BigDecimal.ZERO) first > last else first < last

    override fun equals(other: Any?) =
            other is BigDecimalProgression && (isEmpty() && other.isEmpty() ||
                    first == other.first && last == other.last && step == other.step)

    override fun hashCode() = if (isEmpty()) -1 else (31 * (31 * first.hashCode() + last.hashCode()) + step.hashCode())

    override fun toString() = if (step > BigDecimal.ZERO) "$first..$last step $step" else "$first downTo $last step ${-step}"

    private fun getProgressionLastElement(start: BigDecimal, end: BigDecimal, step: BigDecimal): BigDecimal {
        return when {
            step > BigDecimal.ZERO -> start + BigDecimal(((end - start) / step).toInt()) * step
            step < BigDecimal.ZERO -> start - BigDecimal(((start - end) / -step).toInt()) * -step
            else -> throw IllegalArgumentException("Step is zero.")
        }
    }

    companion object {
        /**
         * Creates BigDecimalProgression within the specified bounds of a closed range.

         * The progression starts with the [rangeStart] value and goes toward the [rangeEnd] value not excluding it, with the specified [step].
         * In order to go backwards the [step] must be negative.
         */
        fun fromClosedRange(rangeStart: BigDecimal, rangeEnd: BigDecimal, step: BigDecimal) = BigDecimalProgression(rangeStart, rangeEnd, step)
    }
}

/** An iterator over a sequence of values of type `BigDecimal`. */
abstract class BigDecimalIterator : Iterator<BigDecimal> {
    final override fun next() = nextBigDecimal()

    abstract fun nextBigDecimal(): BigDecimal
}

/**
 * An iterator over a progression of values of type `BigDecimal`.
 * @property step the number by which the value is incremented on each step.
 */
class BigDecimalProgressionIterator(first: BigDecimal, last: BigDecimal, val step: BigDecimal) : BigDecimalIterator() {
    private val finalElement = last
    private var hasNext: Boolean = if (step > BigDecimal.ZERO) first <= last else first >= last
    private var next = if (hasNext) first else finalElement

    override fun hasNext(): Boolean = hasNext

    override fun nextBigDecimal(): BigDecimal {
        val value = next
        if (value >= finalElement) {
            if (!hasNext) throw NoSuchElementException()
            hasNext = false
        } else {
            next += step
        }
        return value
    }
}