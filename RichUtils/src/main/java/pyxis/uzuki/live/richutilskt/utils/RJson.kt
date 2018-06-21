@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import org.json.JSONArray
import org.json.JSONObject
import pyxis.uzuki.live.richutilskt.impl.F1

/**
 * create JSONObject from String
 * @return JSONObject object
 */
fun String.createJSONObject(): JSONObject? = this.convertAcceptNull({ JSONObject(this) }, null)

/**
 * create JSONObject from Map
 * @return JSONObject object
 */
fun Map<*, *>.createJSONObject(): JSONObject? = this.convertAcceptNull({ JSONObject(this) }, null)

/**
 * create JSONArray from String
 * @return JSONObject object
 */
fun String.createJSONArray(): JSONArray? = this.convertAcceptNull({ JSONArray(this) }, null)

/**
 * create JSONArray from Map
 * @return JSONArray object
 */
fun List<*>.createJSONArray(): JSONArray? = this.convertAcceptNull({ JSONArray(this) }, null)

/**
 * get JSONObject from JSONObject
 *
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @return JSONObject object
 */
fun getJSONObject(jsonObject: JSONObject?, name: String): JSONObject? = jsonObject.convertAcceptNull({ it?.getJSONObject(name) }, null)

/**
 * get JSONObject from JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @return JSONObject object
 */
fun getJSONObject(jsonArray: JSONArray?, index: Int): JSONObject? = jsonArray.convertAcceptNull({ it?.getJSONObject(index) }, null)

/**
 * get JSONArray from JSONObject
 *
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @return JSONArray object
 */
fun getJSONArray(jsonObject: JSONObject?, name: String): JSONArray? = jsonObject.convertAcceptNull({ it?.getJSONArray(name) }, null)

/**
 * get JSONArray from JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @return JSONArray object
 */
fun getJSONArray(jsonArray: JSONArray?, index: Int): JSONArray? = jsonArray.convertAcceptNull({ it?.getJSONArray(index) }, null)

/**
 * get String from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return String object
 */
@JvmOverloads
fun JSONObject.getJSONString(name: String, def: String = ""): String = this.convert({ it.getString(name) }, def)

/**
 * get String from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return String object
 */
@JvmOverloads
fun JSONArray.getJSONString(index: Int, def: String = ""): String = this.convert({ it.getString(index) }, def)

/**
 * get Int from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Int object
 */
@JvmOverloads
fun JSONObject.getJSONInt(name: String, def: Int = 0): Int = this.convert({ it.getInt(name) }, def)

/**
 * get Int from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Int object
 */
@JvmOverloads
fun JSONArray.getJSONInt(index: Int, def: Int = 0): Int = this.convert({ it.getInt(index) }, def)

/**
 * get Boolean from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Boolean object
 */
@JvmOverloads
fun JSONObject.getJSONBoolean(name: String, def: Boolean = false): Boolean = this.convert({ it.getBoolean(name) }, def)

/**
 * get Boolean from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Boolean object
 */
@JvmOverloads
fun JSONArray.getJSONBoolean(index: Int, def: Boolean = false): Boolean = this.convert({ it.getBoolean(index) }, def)

/**
 * get Double from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Double object
 */
@JvmOverloads
fun JSONObject.getJSONDouble(name: String, def: Double = 0.toDouble()): Double = this.convert({ it.getDouble(name) }, def)

/**
 * get Double from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Double object
 */
@JvmOverloads
fun JSONArray.getJSONDouble(index: Int, def: Double = 0.toDouble()): Double = this.convert({ it.getDouble(index) }, def)

/**
 * get Long from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Long object
 */
@JvmOverloads
fun JSONObject.getJSONLong(name: String, def: Long = 0.toLong()): Long = this.convert({ it.getLong(name) }, def)

/**
 * get Long from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Long object
 */
@JvmOverloads
fun JSONArray.getJSONLong(index: Int, def: Long = 0.toLong()): Long = this.convert({ it.getLong(index) }, def)

/**
 * put value to JSONObject
 *
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @param[value] actual value to input
 */
fun put(jsonObject: JSONObject?, name: String, value: Any) = jsonObject?.put(name, value)

/**
 * put value to JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @param[value] actual value to input
 */
fun put(jsonArray: JSONArray?, index: Int, value: Any) = jsonArray?.put(index, value)

/**
 * put value to JSONArray without ordering
 *
 * @param[jsonArray] target JSONArray
 * @param[value] actual value to input
 */
fun put(jsonArray: JSONArray?, value: Any) = jsonArray?.put(value)

/**
 * invoke [action] every JSONObject
 */
@JvmName("forObjectEach")
inline fun JSONArray.forEach(action: (JSONObject) -> Unit) {
    for (i in 0 until this.length()) action(getJSONObject(i))
}

/**
 * invoke [action] every JSONObject
 */
@JvmName("forObjectEach")
inline fun JSONArray.forEach(action: F1<JSONObject>) {
    for (i in 0 until this.length()) action(getJSONObject(i))
}


/**
 * convert JSONArray to List<JSONObject>
 */
@JvmName("toObjectList")
fun JSONArray.toList(): List<JSONObject> = List<JSONObject>(length()) { index -> getJSONObject(index) }

/**
 * DSL-Style JSONObject builder
 */
class Json() : JSONObject() {

    constructor(init: Json.() -> Unit) : this() {
        this.init()
    }

    infix fun <T> String.to(value: T) {
        put(this, value)
    }
}
