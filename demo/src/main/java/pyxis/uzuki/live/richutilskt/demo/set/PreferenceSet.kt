package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.utils.RPreference
import pyxis.uzuki.live.richutilskt.utils.toast

/**
 * RichUtilsKt
 * Class: PreferenceSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getPreferenceSet() : ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()
    val key = "PREF_KEY"

    val put = generateExecuteItem(CategoryItem.PREFERENCE, "put",
            "Put any value to SharedPreference",
            "RPreference.getInstance(this).put(key to editPref.text.toString())",
            "RPreference.getInstance(this).put(key, editPref.getText().toString());") {

        RPreference.getInstance(this).put("${key}String" to "abc")
        RPreference.getInstance(this).put("${key}CharSequence" to "abc")
        RPreference.getInstance(this).put("${key}Boolean" to true)
        RPreference.getInstance(this).put("${key}Int" to 1)
        RPreference.getInstance(this).put("${key}Long" to 2L)
        RPreference.getInstance(this).put("${key}Float" to 3f)
        RPreference.getInstance(this).put("${key}Double" to 4.0)
        RPreference.getInstance(this).put("${key}Char" to 'a')
    }

    list.add(put)

    val getString = generateExecuteItem(CategoryItem.PREFERENCE, "getString",
            "get String value from SharedPreference",
            "RPreference.getInstance(this).getString(key)",
            "RPreference.getInstance(this).getString(key);") {
        toast("$key = ${RPreference.getInstance(this).getString("${key}String")}")
    }

    list.add(getString)

    val getChar = generateExecuteItem(CategoryItem.PREFERENCE, "getChar",
            "get Char value from SharedPreference",
            "RPreference.getInstance(this).getChar(key)",
            "RPreference.getInstance(this).getChar(key);") {
        toast("$key = ${RPreference.getInstance(this).getChar("${key}Char")}")
    }

    list.add(getChar)

    val getCharSequence = generateExecuteItem(CategoryItem.PREFERENCE, "getCharSequence",
            "get CharSequence value from SharedPreference",
            "RPreference.getInstance(this).getCharSequence(key)",
            "RPreference.getInstance(this).getCharSequence(key);") {
        toast("$key = ${RPreference.getInstance(this).getCharSequence("${key}CharSequence")}")
    }

    list.add(getCharSequence)

    val getInt = generateExecuteItem(CategoryItem.PREFERENCE, "getInt",
            "get Int value from SharedPreference",
            "RPreference.getInstance(this).getInt(key)",
            "RPreference.getInstance(this).getInt(key);") {
        toast("$key = ${RPreference.getInstance(this).getInt("${key}Int")}")
    }

    list.add(getInt)

    val getLong = generateExecuteItem(CategoryItem.PREFERENCE, "getLong",
            "get Long value from SharedPreference",
            "RPreference.getInstance(this).getLong(key)",
            "RPreference.getInstance(this).getLong(key);") {
        toast("$key = ${RPreference.getInstance(this).getLong("${key}Long")}")
    }

    list.add(getLong)

    val getFloat = generateExecuteItem(CategoryItem.PREFERENCE, "getFloat",
            "get Float value from SharedPreference",
            "RPreference.getInstance(this).getFloat(key)",
            "RPreference.getInstance(this).getFloat(key);") {
        toast("$key = ${RPreference.getInstance(this).getFloat("${key}Float")}")
    }

    list.add(getFloat)

    val getDouble = generateExecuteItem(CategoryItem.PREFERENCE, "getDouble",
            "get Double value from SharedPreference",
            "RPreference.getInstance(this).getDouble(key)",
            "RPreference.getInstance(this).getDouble(key);") {
        toast("$key = ${RPreference.getInstance(this).getDouble("${key}Double")}")
    }

    list.add(getDouble)

    val getBoolean = generateExecuteItem(CategoryItem.PREFERENCE, "getBoolean",
            "get Boolean value from SharedPreference",
            "RPreference.getInstance(this).getBoolean(key)",
            "RPreference.getInstance(this).getBoolean(key);") {
        toast("$key = ${RPreference.getInstance(this).getBoolean("${key}Boolean")}")
    }

    list.add(getBoolean)

    val delete = generateExecuteItem(CategoryItem.PREFERENCE, "delete",
            "delete key-value from SharedPreference",
            "RPreference.getInstance(this).delete(key)",
            "RPreference.getInstance(this).delete(key);")

    list.add(delete)

    val clear = generateExecuteItem(CategoryItem.PREFERENCE, "clear",
            "clear all of preferences",
            "RPreference.getInstance(this).clear()",
            "RPreference.getInstance(this).clear();")

    list.add(clear)

    return list
}