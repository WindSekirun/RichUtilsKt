@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import java.math.BigDecimal
import java.math.BigInteger

/**
 * safe cast String to Byte
 * @receiver String
 * @param radix Int
 * @param default Byte
 * @return Byte
 */
@JvmOverloads
fun String.safeByte(radix: Int = 10, default: Byte = 0): Byte = this.toByteOrNull(radix) ?: default

/**
 * safe cast String to Short
 * @receiver String
 * @param radix Int
 * @param default Short
 * @return Short
 */
@JvmOverloads
fun String.safeShort(radix: Int = 10, default: Short = 0): Short = this.toShortOrNull(radix)
        ?: default

/**
 * safe cast String to Int
 * @receiver String
 * @param radix Int
 * @param default Int
 * @return Int
 */
@JvmOverloads
fun String.safeInt(radix: Int = 10, default: Int = 0): Int = this.toIntOrNull(radix) ?: default

/**
 * safe cast String to Long
 * @receiver String
 * @param radix Int
 * @param default Long
 * @return Long
 */
@JvmOverloads
fun String.safeLong(radix: Int = 10, default: Long = 0L): Long = this.toLongOrNull(radix) ?: default

/**
 * safe cast String to Float
 * @receiver String
 * @param default Float
 * @return Float
 */
@JvmOverloads
fun String.safeFloat(default: Float = 0.0f) = this.toFloatOrNull() ?: default

/**
 * safe cast String to Double
 * @receiver String
 * @param default Double
 * @return Double
 */
@JvmOverloads
fun String.safeDouble(default: Double = 0.0) = this.toDoubleOrNull() ?: default

/**
 * safe cast String to BigInteger
 * @receiver String
 * @param radix Int
 * @param default BigInteger
 * @return BigInteger
 */
@JvmOverloads
fun String.safeBigInteger(radix: Int = 10, default: BigInteger = BigInteger.ZERO) = this.toBigIntegerOrNull(radix)
        ?: default

/**
 * safe cast String to BigDecimal
 * @receiver String
 * @param default BigDecimal
 * @return BigDecimal
 */
@JvmOverloads
fun String.safeBigDecimal(default: BigDecimal = BigDecimal.ZERO) = this.toBigDecimalOrNull()
        ?: default
