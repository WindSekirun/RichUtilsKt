@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.os.Vibrator

/**
 * Vibrate
 * need VIBRATE permission
 *
 * @param[millSec] duration of vibrate
 */
fun Context.vibrate(millSec: Long) {
    val vibrator = getVibrator(this)
    vibrator.vibrate(millSec)
}

/**
 * Vibrate
 * need VIBRATE permission
 *
 * @param[pattern] vibrate pattern
 * @param[repeat] count of repeat, if once, give repeat as -1
 */
@JvmOverloads fun Context.vibrate(pattern: LongArray, repeat: Int = -1) {
    val vibrator = getVibrator(this)
    vibrator.vibrate(pattern, repeat)
}

private fun getVibrator(context: Context) : Vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

/**
 * get Intensity (Desired Strength) of Vibrate
 * NOTE: Some device's default value may 0.7f (Tested in Galaxy S6),
 *
 * @param intensity Desired strength of vibration. There are 5 Options.
 * @param duration Time to vibrate.
 * @return long[] array of Pattern of Vibrate.
 */
fun getVibratorPattern(intensity: Intensity, duration: Long): LongArray {
    return when (intensity) {
        Intensity.VERYSOFT -> getVibratorPattern(0.1f, duration)
        Intensity.SOFT -> getVibratorPattern(0.3f, duration)
        Intensity.NORMAL -> getVibratorPattern(0.5f, duration)
        Intensity.HARD -> getVibratorPattern(0.7f, duration)
        Intensity.VERYHARD -> getVibratorPattern(0.9f, duration)
    }
}

/**
 * get Intensity (Desired Strength) of Vibrate
 * Normal Way, just use getVibratorPattern(Intensity, long) for easy work.
 *
 * @param intensity Float value. Range is 0.0f ~ 1.0f
 * @param duration Time to vibrate
 * @return long[] array of Pattern of Vibrate
 */
fun getVibratorPattern(intensity: Float, duration: Long): LongArray {
    val pattern: LongArray

    if (intensity in 0.0f..1.0f) {
        val dutyCycle = Math.abs(intensity * 2.0f - 1.0f)
        val hWidth = (dutyCycle * (duration - 1)).toLong() + 1
        val lWidth = (if (dutyCycle == 1.0f) 0 else 1).toLong()

        val pulseCount = (2.0f * (duration.toFloat() / (hWidth + lWidth).toFloat())).toInt()
        pattern = LongArray(pulseCount)

        for (i in 0..pulseCount - 1)
            pattern[i] = if (intensity < 0.5f) if (i % 2 == 0) hWidth else lWidth else if (i % 2 == 0) lWidth else hWidth

        return pattern
    } else {
        throw RuntimeException("Abnormal intensity value! check your method")
    }
}

enum class Intensity {
    VERYSOFT, SOFT, NORMAL, HARD, VERYHARD
}