@file:JvmName("RPreference")

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class RPreference private constructor(c: Context) {
    private val editor: SharedPreferences.Editor
    private val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(c)

    init {
        editor = pref.edit()
        editor.apply()
    }

    /**
     * put String to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: String) = editor.putString(key, value).commit()

    /**
     * put CharSequence to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: CharSequence) = editor.putString(key, value.toString()).commit()

    /**
     * put Boolean to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Boolean) = editor.putBoolean(key, value).commit()

    /**
     * put Int to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Int) = editor.putInt(key, value).commit()

    /**
     * put Long to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Long) = editor.putLong(key, value).commit()

    /**
     * put Float to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Float) = editor.putFloat(key, value)

    /**
     * put Double to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Double) = editor.putString(key, value.toString())

    /**
     * put Char to SharedPreference
     *
     * @param[key] key of preference
     * @param[value] value to input
     */
    fun put(key: String, value: Char) = editor.putString(key, value.toString()).commit()

    /**
     * get String value from SharedPreference
     *
     * @param[key] key of preference
     * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
     * @return String object
     */
    fun getValue(key: String, def: String = ""): String = try {
        pref.getString(key, def)
    } catch (e: Exception) {
        def
    }

    /**
     * get Char value from SharedPreference
     *
     * @param[key] key of preference
     * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
     * @return Char object
     */
    fun getValue(key: String, def: Char = '\u0000'): Char = try {
        pref.getString(key, def.toString())[0]
    } catch (e: Exception) {
        def
    }

    /**
     * get CharSequence value from SharedPreference
     *
     * @param[key] key of preference
     * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
     * @return CharSequence object
     */
    fun getValue(key: String, def: CharSequence = ""): CharSequence = try {
        pref.getString(key, def.toString())
    } catch (e: Exception) {
        def
    }

    /**
     * get Int value from SharedPreference
     *
     * @param[key] key of preference
     * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
     * @return Int object
     */
    fun getValue(key: String, def: Int = 0): Int = try {
        pref.getInt(key, def)
    } catch (e: Exception) {
        def
    }

    /**
     * get Long value from SharedPreference
     *
     * @param[key] key of preference
     * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
     * @return Long object
     */
    fun getValue(key: String, def: Long = 0): Long = try {
        pref.getLong(key, def)
    } catch (e: Exception) {
        def
    }

    /**
     * get Float value from SharedPreference
     *
     * @param[key] key of preference
     * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
     * @return Float object
     */
    fun getValue(key: String, def: Float = 0f): Float = try {
        pref.getFloat(key, def)
    } catch (e: Exception) {
        def
    }

    /**
     * get Double value from SharedPreference
     *
     * @param[key] key of preference
     * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
     * @return Double object
     */
    fun getValue(key: String, def: Double = 0.toDouble()): Double = try {
        pref.getString(key, def.toString()).toDouble()
    } catch (e: Exception) {
        def
    }

    /**
     * get Boolean value from SharedPreference
     *
     * @param[key] key of preference
     * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
     * @return Boolean object
     */
    fun getValue(key: String, def: Boolean = false): Boolean = try {
        pref.getBoolean(key, def)
    } catch (e: Exception) {
        def
    }

    /**
     * delete key-value from SharedPreference
     *
     * @param[key] key to delete
     */
    fun delete(key: String) = editor.remove(key).commit()

    /**
     * clear all of preferences
     */
    fun clear() = editor.clear().commit()

    companion object {

        private var instance: RPreference? = null

        @JvmStatic fun getInstance(c: Context): RPreference {
            if (instance == null) {
                instance = RPreference(c)
            }
            return instance as RPreference
        }
    }
}