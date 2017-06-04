package pyxis.uzuki.live.richutilskt

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * create JSONObject from String
 *
 * @param[token] String of JSON
 * @return JSONObject object
 */
fun createJSONObject(token: String): JSONObject? = try {
    JSONObject(token)
} catch (e: JSONException) {
    null
}

/**
 * create JSONObject from Map
 *
 * @param[map] map (key-value) to create
 * @return JSONObject object
 */
fun createJSONObject(map: Map<*, *>): JSONObject? = try {
    JSONObject(map)
} catch (e: JSONException) {
    null
}

/**
 * create JSONArray from String
 *
 * @param[token] String of JSON
 * @return JSONObject object
 */
fun createJSONArray(token: String): JSONArray? = try {
    JSONArray(token)
} catch (e: JSONException) {
    null
}

/**
 * create JSONArray from Map
 *
 * @param[list] list to create
 * @return JSONArray object
 */
fun createJSONArray(list: List<*>): JSONArray? = try {
    JSONArray(list)
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
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return String object
 */
fun getJSONString(jsonObject: JSONObject?, name: String, def: String? = ""): String? = try {
    jsonObject?.getString(name)
} catch (e: JSONException) {
    def
}

/**
 * get String from JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return String object
 */
fun getJSONString(jsonArray: JSONArray?, index: Int, def: String? = ""): String? = try {
    jsonArray?.getString(index)
} catch (e: JSONException) {
    def
}

/**
 * get Int from JSONObject
 *
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Int object
 */
fun getJSONInt(jsonObject: JSONObject?, name: String, def: Int? = 0): Int? = try {
    jsonObject?.getInt(name)
} catch (e: JSONException) {
    def
}

/**
 * get Int from JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Int object
 */
fun getJSONInt(jsonArray: JSONArray?, index: Int, def: Int? = 0): Int? = try {
    jsonArray?.getInt(index)
} catch (e: JSONException) {
    def
}

/**
 * get Boolean from JSONObject
 *
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Boolean object
 */
fun getJSONBoolean(jsonObject: JSONObject?, name: String, def: Boolean? = false): Boolean? = try {
    jsonObject?.getBoolean(name)
} catch (e: JSONException) {
    def
}

/**
 * get Boolean from JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Boolean object
 */
fun getJSONBoolean(jsonArray: JSONArray?, index: Int, def: Boolean? = false): Boolean? = try {
    jsonArray?.getBoolean(index)
} catch (e: JSONException) {
    def
}

/**
 * get Double from JSONObject
 *
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Double object
 */
fun getJSONDouble(jsonObject: JSONObject?, name: String, def: Double? = 0.toDouble()): Double? = try {
    jsonObject?.getDouble(name)
} catch (e: JSONException) {
    def
}

/**
 * get Double from JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Double object
 */
fun getJSONDouble(jsonArray: JSONArray?, index: Int, def: Double? = 0.toDouble()): Double? = try {
    jsonArray?.getDouble(index)
} catch (e: JSONException) {
    def
}

/**
 * get Long from JSONObject
 *
 * @param[jsonObject] target JSONObject
 * @param[name] name of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Long object
 */
fun getJSONLong(jsonObject: JSONObject?, name: String, def: Long? = 0.toLong()): Long? = try {
    jsonObject?.getLong(name)
} catch (e: JSONException) {
    def
}

/**
 * get Long from JSONArray
 *
 * @param[jsonArray] target JSONArray
 * @param[index] index of key
 * @param[def] optional, if key is not presented or some unexpected problem happened, it will be return
 * @return Long object
 */
fun getJSONLong(jsonArray: JSONArray?, index: Int, def: Long? = 0.toLong()): Long? = try {
    jsonArray?.getLong(index)
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
