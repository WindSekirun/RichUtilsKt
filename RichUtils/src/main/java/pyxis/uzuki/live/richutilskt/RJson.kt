package pyxis.uzuki.live.richutilskt

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * create JSONObject from String
 *
 * @return JSONObject object
 */
fun String.createJSONObject(): JSONObject? = try {
    JSONObject(this)
} catch (e: JSONException) {
    null
}

/**
 * create JSONObject from Map
 *
 * @return JSONObject object
 */
fun Map<*, *>.createJSONObject(): JSONObject? = try {
    JSONObject(this)
} catch (e: JSONException) {
    null
}

/**
 * create JSONArray from String
 *
 * @return JSONObject object
 */
fun String.createJSONArray(): JSONArray? = try {
    JSONArray(this)
} catch (e: JSONException) {
    null
}

/**
 * create JSONArray from Map
 *
 * @return JSONArray object
 */
fun List<*>.createJSONArray(): JSONArray? = try {
    JSONArray(this)
} catch (e: JSONException) {
    null
}

/**
 * get JSONObject from JSONObject
 *
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @return JSONObject object
 */
fun getJSONObject(jsonObject: JSONObject?, name: String): JSONObject? = try {
    jsonObject?.getJSONObject(name)
} catch (e: JSONException) {
    null
}

/**
 * get JSONObject from JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @return JSONObject object
 */
fun getJSONObject(jsonArray: JSONArray?, index: Int): JSONObject? = try {
    jsonArray?.getJSONObject(index)
} catch (e: JSONException) {
    null
}

/**
 * get JSONArray from JSONObject
 *
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @return JSONArray object
 */
fun getJSONArray(jsonObject: JSONObject?, name: String): JSONArray? = try {
    jsonObject?.getJSONArray(name)
} catch (e: JSONException) {
    null
}

/**
 * get JSONArray from JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @return JSONArray object
 */
fun getJSONArray(jsonArray: JSONArray?, index: Int): JSONArray? = try {
    jsonArray?.getJSONArray(index)
} catch (e: JSONException) {
    null
}

/**
 * get String from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return String object
 */
fun JSONObject.getJSONString(name: String, def: String? = ""): String? = try {
    this.getString(name)
} catch (e: JSONException) {
    def
}

/**
 * get String from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return String object
 */
fun JSONArray.getJSONString(index: Int, def: String? = ""): String? = try {
    this.getString(index)
} catch (e: JSONException) {
    def
}

/**
 * get Int from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Int object
 */
fun JSONObject.getJSONInt(name: String, def: Int? = 0): Int? = try {
    this.getInt(name)
} catch (e: JSONException) {
    def
}

/**
 * get Int from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Int object
 */
fun JSONArray.getJSONInt(index: Int, def: Int? = 0): Int? = try {
    this.getInt(index)
} catch (e: JSONException) {
    def
}

/**
 * get Boolean from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Boolean object
 */
fun JSONObject.getJSONBoolean(name: String, def: Boolean? = false): Boolean? = try {
    this.getBoolean(name)
} catch (e: JSONException) {
    def
}

/**
 * get Boolean from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Boolean object
 */
fun JSONArray.getJSONBoolean(index: Int, def: Boolean? = false): Boolean? = try {
    this.getBoolean(index)
} catch (e: JSONException) {
    def
}

/**
 * get Double from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Double object
 */
fun JSONObject.getJSONDouble(name: String, def: Double? = 0.toDouble()): Double? = try {
    this.getDouble(name)
} catch (e: JSONException) {
    def
}

/**
 * get Double from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Double object
 */
fun JSONArray.getJSONDouble(index: Int, def: Double? = 0.toDouble()): Double? = try {
    this.getDouble(index)
} catch (e: JSONException) {
    def
}

/**
 * get Long from JSONObject
 *
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Long object
 */
fun JSONObject.getJSONLong(name: String, def: Long? = 0.toLong()): Long? = try {
    this.getLong(name)
} catch (e: JSONException) {
    def
}

/**
 * get Long from JSONArray
 *
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Long object
 */
fun JSONArray.getJSONLong(index: Int, def: Long? = 0.toLong()): Long? = try {
    this.getLong(index)
} catch (e: JSONException) {
    def
}

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
