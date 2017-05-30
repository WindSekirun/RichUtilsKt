package pyxis.uzuki.live.richutilskt

import android.content.Context
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

    fun createObject(token: String): JSONObject? = try { JSONObject(token) } catch (e: JSONException) { null }
    fun createObject(map: Map<*, *>): JSONObject? = try { JSONObject(map) } catch (e: JSONException) { null }
    fun createArray(token: String): JSONArray? = try { JSONArray(token) } catch (e: JSONException) { null }
    fun createArray(list: List<*>): JSONArray? = try { JSONArray(list) } catch (e: JSONException) { null }
    fun getObject(jsonObject: JSONObject, name: String): JSONObject? = try { jsonObject.getJSONObject(name) } catch (e: JSONException) { null }
    fun getObject(jsonArray: JSONArray, index: Int): JSONObject? = try { jsonArray.getJSONObject(index) } catch (e: JSONException) { null }
    fun getArray(jsonObject: JSONObject, name: String): JSONArray? = try { jsonObject.getJSONArray(name) } catch (e: JSONException) { null }
    fun getArray(jsonArray: JSONArray, index: Int): JSONArray? = try { jsonArray.getJSONArray(index) } catch (e: JSONException) { null }
    fun getString(jsonObject: JSONObject, name: String, def: String? = ""): String? = try { jsonObject.getString(name) } catch (e: JSONException) { def }
    fun getString(jsonArray: JSONArray, index: Int, def: String? = ""): String? = try { jsonArray.getString(index)} catch (e: JSONException) { def }
    fun getInt(jsonObject: JSONObject, name: String, def: Int? = 0): Int? = try { jsonObject.getInt(name) } catch (e: JSONException) { def }
    fun getInt(jsonArray: JSONArray, index: Int, def: Int? = 0): Int? = try { jsonArray.getInt(index)} catch (e: JSONException) { def }
    fun getBoolean(jsonObject: JSONObject, name: String, def: Boolean? = false): Boolean? = try { jsonObject.getBoolean(name) } catch (e: JSONException) { def }
    fun getBoolean(jsonArray: JSONArray, index: Int, def: Boolean? = false): Boolean? = try { jsonArray.getBoolean(index)} catch (e: JSONException) { def }
    fun getDouble(jsonObject: JSONObject, name: String, def: Double? = 0.toDouble()): Double? = try { jsonObject.getDouble(name) } catch (e: JSONException) { def }
    fun getDouble(jsonArray: JSONArray, index: Int, def: Double? = 0.toDouble()): Double? = try { jsonArray.getDouble(index)} catch (e: JSONException) { def }
    fun getLong(jsonObject: JSONObject, name: String, def: Long? = 0.toLong()): Long? = try { jsonObject.getLong(name) } catch (e: JSONException) { def }
    fun getLong(jsonArray: JSONArray, index: Int, def: Long? = 0.toLong()): Long? = try { jsonArray.getLong(index)} catch (e: JSONException) { def }
    fun put(jsonObject: JSONObject, name: String, value: Any) = jsonObject.put(name, value)
    fun put(jsonArray: JSONArray, index: Int, value: Any) = jsonArray.put(index, value)
    fun put(jsonArray: JSONArray, value: Any) = jsonArray.put(value)
