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
    val keyList = ArrayList<String>()

    init {
        editor = pref.edit()
        editor.apply()
    }

    fun put(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: CharSequence) {
        editor.putString(key, value.toString())
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Int) {
        editor.putInt(key, value)
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Long) {
        editor.putLong(key, value)
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Float) {
        editor.putFloat(key, value)
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Double) {
        editor.putString(key, value.toString())
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Char) {
        editor.putString(key, value.toString())
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: BigInteger) {
        editor.putString(key, Arrays.toString(value.toByteArray()))
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Array<Byte>) {
        editor.putString(key, Arrays.toString(value))
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Set<String>) {
        editor.putStringSet(key, value)
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Any) {
        editor.putString(key, value as String)
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: ArrayList<String>) {
        val list = HashSet(value)
        editor.putStringSet(key, list)
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: Array<String>) {
        val arraylist = ArrayList(Arrays.asList(*value))
        val list = HashSet(arraylist)
        editor.putStringSet(key, list)
        editor.commit()
        keyList.add(key)
    }

    fun put(key: String, value: CharArray) {
        val chars = ArrayList<Char>()
        val list = ArrayList<String>()
        for (aValue in value) {
            chars.add(aValue)
        }
        for (aChar in chars) {
            list.add(aChar.toString())
        }
        val setlist = HashSet(list)
        editor.putStringSet(key, setlist)
        editor.commit()
        keyList.add(key)
    }

    fun getValue(key: String, def: ArrayList<String>): ArrayList<String> {
        try {
            return ArrayList(pref.getStringSet(key, null)!!)
        } catch (e: Exception) {
            return def
        }

    }

    fun getValue(key: String, def: Array<String>): Array<String> {
        try {
            val stringSet = pref.getStringSet(key, null)
            return stringSet!!.toTypedArray()
        } catch (e: Exception) {
            return def
        }

    }

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
        if (keyList.contains(key))
            keyList.removeAt(keyList.indexOf(key))
    }

    fun clear() {
        editor.clear()
        editor.commit()
        keyList.clear()
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