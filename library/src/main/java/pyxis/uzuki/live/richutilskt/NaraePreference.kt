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
    fun put(key: String, value: Array<Byte>) = editor.putString(key, Arrays.toString(value)).commit()
    fun put(key: String, value: Set<String>) = editor.putStringSet(key, value).commit()
    fun put(key: String, value: ArrayList<String>) = editor.putStringSet(key, HashSet(value)).commit()
    fun put(key: String, value: Array<String>) = editor.putStringSet(key, HashSet(ArrayList(Arrays.asList(*value)))).commit()
    fun getValue(key: String, def: ArrayList<String>? = ArrayList()): ArrayList<String>? = try { ArrayList(pref.getStringSet(key, null)) } catch (e: Exception) { def }
    fun getValue(key: String, def: Array<String>? = null): Array<String>? = try { pref.getStringSet(key, null).toTypedArray() } catch (e: Exception) { def }
    fun getValue(key: String, def: Set<String>? = null): Set<String>? = try { pref.getStringSet(key, def) } catch (e: Exception) { def }
    fun getValue(key: String, def: String? = ""): String? = try { pref.getString(key, def) } catch (e: Exception) { def }
    fun getValue(key: String, def: Char? = '\u0000'): Char? = try { pref.getString(key, def.toString())[0] } catch (e: Exception) { def }
    fun getValue(key: String, def: CharSequence? = ""): CharSequence? = try { pref.getString(key, def.toString()) } catch (e: Exception) { def }
    fun getValue(key: String, def: ByteArray? = null): ByteArray? = try { pref.getString(key, Arrays.toString(def)).toByteArray() } catch (e: Exception) { def }
    fun getValue(key: String, def: Int = 0): Int = try { pref.getInt(key, def) } catch (e: Exception) { def }
    fun getValue(key: String, def: Long = 0): Long = try { pref.getLong(key, def) } catch (e: Exception) { def }
    fun getValue(key: String, def: Float = 0f): Float = try { pref.getFloat(key, def) } catch (e: Exception) { def }
    fun getValue(key: String, def: Double = 0.toDouble()): Double = try { pref.getString(key, def.toString()).toDouble() } catch (e: Exception) { def }
    fun getValue(key: String, def: Boolean = false): Boolean = try { pref.getBoolean(key, def) } catch (e: Exception) { def }
    fun delete(key: String) = editor.remove(key).commit()
    fun clear() = editor.clear().commit()

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