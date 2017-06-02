package pyxis.uzuki.live.richutilskt

import android.text.InputFilter
import android.text.Spanned

import java.io.UnsupportedEncodingException

class ByteFilter(protected var mMaxByte: Int, private val mCharset: String) : InputFilter {

    override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dstart: Int, dend: Int): CharSequence? {
        var expected = String()
        expected += dest.subSequence(0, dstart)
        expected += source.subSequence(start, end)
        expected += dest.subSequence(dend, dest.length)
        var keep = calculateMaxLength(expected) - (dest.length - (dend - dstart))
        if (keep < 0) {
            keep = 0
        }
        val Rekeep = plusMaxLength(dest.toString(), source.toString(), start)

        if (keep <= 0 && Rekeep <= 0) {
            return ""

        } else if (keep >= end - start) {
            return null
        } else {
            if (dest.isEmpty() && Rekeep <= 0) {
                return source.subSequence(start, start + keep)
            } else if (Rekeep <= 0) {
                return source.subSequence(start, start + (source.length - 1))
            } else {
                return source.subSequence(start, start + Rekeep) // source중 일부만입력 허용
            }
        }
    }

    private fun plusMaxLength(expected: String, source: String, start: Int): Int {
        var keep = source.length
        val maxByte = mMaxByte - getByteLength(str = expected) //입력가능한 byte

        while (getByteLength(source.subSequence(start, start + keep).toString()) > maxByte) {
            keep--
        }
        return keep
    }

    private fun calculateMaxLength(expected: String): Int {
        val expectedByte = getByteLength(expected)
        if (expectedByte == 0) {
            return 0
        }
        return mMaxByte - (getByteLength(expected) - expected.length)
    }

    private fun getByteLength(str: String): Int {
        try {
            return str.toByteArray(charset(mCharset)).size
        } catch (e: UnsupportedEncodingException) {

        }

        return 0
    }
}
