@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import java.io.Serializable

/**
 * return Bundle which contain contents of Map<String, Any>
 */
fun put(map: Map<String, Any>): Bundle = Bundle().apply { put(map) }


/**
 * put contents of Map<String, Any> into given Bundle
 *
 */
fun Bundle.put(map: Map<String, Any>) {
    map.entries.forEach { this.put(it.key, it.value) }
}

/**
 * Convert Bundle to HashMap<String, Any>
 */
fun Bundle.toMap(): HashMap<String, Any> = hashMapOf<String, Any>().apply {
    val keySet = keySet()
    for (item in keySet) {
        put(item, this@toMap.get(item))
    }
}

/**
 * put 'key to value' into Bundle with automatically smart castig
 */
fun Bundle.put(key: String, value: Any) {
    if (value is Array<*>) {
        this.putExtraArray(key, value)
        return
    }

    if (value is ArrayList<*>) {
        this.putExtraList(key, value)
        return
    }

    if (value is java.util.ArrayList<*>) {
        this.putExtraList(key, value)
        return
    }

    when (value) {
        is String -> this.putString(key, value)
        is Int -> this.putInt(key, value)
        is IBinder -> this.putBinder(key, value)
        is Bundle -> this.putBundle(key, value)
        is Byte -> this.putByte(key, value)
        is ByteArray -> this.putByteArray(key, value)
        is Char -> this.putChar(key, value)
        is CharArray -> this.putCharArray(key, value)
        is CharSequence -> this.putCharSequence(key, value)
        is Float -> this.putFloat(key, value)
        is FloatArray -> this.putFloatArray(key, value)
        is Parcelable -> this.putParcelable(key, value)
        is Serializable -> this.putSerializable(key, value)
        is Short -> this.putShort(key, value)
        is ShortArray -> this.putShortArray(key, value)
    }
}

private fun Bundle.putExtraArray(key: String, value: Array<*>) {
    if (isEmpty) {
        return
    }

    val element = value[0]

    when (element) {
        is CharSequence -> this.putCharSequenceArray(key, value as Array<CharSequence>)
        is Parcelable -> this.putParcelableArray(key, value as Array<Parcelable>)
    }
}

private fun Bundle.putExtraList(key: String, value: ArrayList<*>) {
    if (isEmpty) {
        return
    }

    val element = value[0]

    when (element) {
        is CharSequence -> this.putCharSequenceArrayList(key, value as ArrayList<CharSequence>)
        is Integer -> this.putIntegerArrayList(key, value as java.util.ArrayList<Int>)
        is Parcelable -> this.putParcelableArrayList(key, value as java.util.ArrayList<Parcelable>)
        is String -> this.putStringArrayList(key, value as java.util.ArrayList<String>)
    }
}