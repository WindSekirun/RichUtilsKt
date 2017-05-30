package pyxis.uzuki.live.richutilskt

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import java.math.BigInteger
import java.util.ArrayList
import java.util.Arrays
import java.util.HashSet

class NaraePreference private constructor(c: Context) {
    private val editor: SharedPreferences.Editor
    private val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(c)

    init {
        editor = pref.edit()
        editor.apply()
    }

    fun put(key: String, value: String) = editor.putString(key, value).commit()
    fun put(key: String, value: CharSequence) = editor.putString(key, value.toString()).commit()
    fun put(key: String, value: Boolean) = editor.putBoolean(key, value).commit()
    fun put(key: String, value: Int) = editor.putInt(key, value).commit()
    fun put(key: String, value: Long) = editor.putLong(key, value).commit()
    fun put(key: String, value: Float) = editor.putFloat(key, value)
    fun put(key: String, value: Double) = editor.putString(key, value.toString())
    fun put(key: String, value: Char) = editor.putString(key, value.toString()).commit()
    fun put(key: String, value: BigInteger) = editor.putString(key, Arrays.toString(value.toByteArray())).commit()
    fun put(key: String, value: Array<Byte>) = editor.putString(key, Arrays.toString(value)).commit()
    fun put(key: String, value: Set<String>) = editor.putStringSet(key, value).commit()
    fun put(key: String, value: ArrayList<String>) = editor.putStringSet(key, HashSet(value)).commit()
    fun put(key: String, value: Array<String>) = editor.putStringSet(key, HashSet(ArrayList(Arrays.asList(*value)))).commit()
    fun put(key: String, value: CharArray) = editor.putStringSet(key, HashSet(value.toList().map { it.toString() })).commit()
    fun getValue(key: String, def: ArrayList<String>? = ArrayList()): ArrayList<String>? = try { ArrayList(pref.getStringSet(key, null)) } catch (e: Exception) { def }
    fun getValue(key: String, def: Array<String>? = null): Array<String>? = try { pref.getStringSet(key, null)!!.toTypedArray() } catch (e: Exception) { def }

    fun getValue(key: String, def: CharArray): CharArray {
        try {
            val arraylist = ArrayList(pref.getStringSet(key, null)!!)
            val stringlist = arraylist.toTypedArray()
            val target = charArrayOf()

            for (i in stringlist.indices) {
                target[i] = stringlist[i][i]
            }
            return target
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: Set<String>): Set<String> {
        try {
            return pref.getStringSet(key, def)
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: String): String {
        try {
            return pref.getString(key, def)
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: Char): Char {
        try {
            val s = pref.getString(key, def.toString())
            return s!![0]
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: CharSequence): CharSequence {
        try {
            return pref.getString(key, def.toString())
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: BigInteger): BigInteger {
        try {
            val str = pref.getLong(key, 0)
            return BigInteger.valueOf(str)
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: ByteArray): ByteArray {
        try {
            val str = pref.getString(key, Arrays.toString(def))
            return str!!.toByteArray()
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: Int): Int {
        try {
            return pref.getInt(key, def)
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: Boolean): Boolean {
        try {
            return pref.getBoolean(key, def)
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: Long): Long {
        try {
            return pref.getLong(key, def)
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: Float): Float {
        try {
            return pref.getFloat(key, def)
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: Double): Double {
        try {
            val str = pref.getString(key, def.toString())
            return java.lang.Double.parseDouble(str)
        } catch (e: Exception) {
            return def
        }

    }

    operator fun getValue(key: String, def: Any): Any {
        try {
            return pref.getString(key, def.toString())
        } catch (e: Exception) {
            return def
        }

    }

    fun delete(key: String) {
        editor.remove(key)
        editor.commit()
    }

    fun clear() {
        editor.clear()
        editor.commit()
    }

    companion object {

        private var instance: NaraePreference? = null

        fun getInstance(c: Context): NaraePreference {
            if (instance == null) {
                instance = NaraePreference(c)
            }
            return instance as NaraePreference
        }
    }
}