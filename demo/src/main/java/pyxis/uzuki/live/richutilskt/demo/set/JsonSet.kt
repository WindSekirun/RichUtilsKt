package pyxis.uzuki.live.richutilskt.demo.set

import android.content.Context
import pyxis.uzuki.live.richutilskt.demo.item.CategoryItem
import pyxis.uzuki.live.richutilskt.demo.item.ExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.generateExecuteItem
import pyxis.uzuki.live.richutilskt.demo.item.toEscape
import pyxis.uzuki.live.richutilskt.utils.alert
import pyxis.uzuki.live.richutilskt.utils.createJSONArray
import pyxis.uzuki.live.richutilskt.utils.createJSONObject
import pyxis.uzuki.live.richutilskt.utils.fileAsString

/**
 * RichUtilsKt
 * Class: JsonSet
 * Created by Pyxis on 2017-11-09.
 *
 * Description:
 */

fun Context.getJSONSet(): ArrayList<ExecuteItem> {

    val list = arrayListOf<ExecuteItem>()

    val createJSONObject = generateExecuteItem(CategoryItem.JSON, "createJSONObject",
            "create JSONObject from String",
            "jsonStr.createJSONObject()",
            "RichUtils.createJSONObject(jsonStr);") {
        val jsonStr = this.assets.fileAsString("json", "customer.json")
        val jsonObject = jsonStr.createJSONObject()

        alert(jsonObject?.toString() ?: "empty json")
    }

    list.add(createJSONObject)

    val createJSONArray = generateExecuteItem(CategoryItem.JSON, "createJSONArray",
            "create JSONArray from String",
            "jsonStr.createJSONArray()",
            "RichUtils.createJSONArray(jsonStr);") {
        val jsonStr = this.assets.fileAsString("json", "customer_array.json")
        val jsonArray = jsonStr.createJSONArray()

        alert(jsonArray?.toString() ?: "empty json")
    }

    list.add(createJSONArray)

    val getJSONObject = generateExecuteItem(CategoryItem.JSON, "getJSONObject",
            "get JSONObject from JSONObject / JSONArray",
            "getJSONObject(jsonObject, \"address\")",
            "RichUtils.getJSONObject(jsonObject, \"address\");")

    list.add(getJSONObject)

    val getJSONString = generateExecuteItem(CategoryItem.JSON, "getJSONString",
            "get String from JSONObject / JSONArray",
            "jsonObject.getJSONString(\"firstName\")",
            "RichUtils.getJSONString(jsonObject, \"firstName\");")

    list.add(getJSONString)

    val getJSONInt = generateExecuteItem(CategoryItem.JSON, "getJSONInt",
            "get Int from JSONObject / JSONArray",
            "jsonObject.getJSONInt(\"number\")",
            "RichUtils.getJSONInt(jsonObject, \"number\");")

    list.add(getJSONInt)

    val getJSONBoolean = generateExecuteItem(CategoryItem.JSON, "getJSONBoolean",
            "get Boolean from JSONObject / JSONArray",
            "jsonObject.getJSONBoolean(\"boolean\")",
            "RichUtils.getJSONBoolean(jsonObject, \"boolean\");")

    list.add(getJSONBoolean)

    val getJSONDouble = generateExecuteItem(CategoryItem.JSON, "getJSONDouble",
            "get Double from JSONObject / JSONArray",
            "jsonObject.getJSONDouble(\"double\")",
            "RichUtils.getJSONDouble(jsonObject, \"double\");")

    list.add(getJSONDouble)

    val getJSONLong = generateExecuteItem(CategoryItem.JSON, "getJSONLong",
            "get Long from JSONObject / JSONArray",
            "jsonObject.getJSONLong(\"long\")",
            "RichUtils.getJSONLong(jsonObject, \"long\");")

    list.add(getJSONLong)

    val put = generateExecuteItem(CategoryItem.JSON, "put",
            "put value to JSONObject / JSONArray",
            "put(jsonObject, ${"name".toEscape()}, ${"John".toEscape()})",
            "RichUtils.put(jsonObject, ${"name".toEscape()}, ${"John".toEscape()});")

    list.add(put)

    val forEach = generateExecuteItem(CategoryItem.JSON, "forEach",
            "invoke [action] every JSONObject",
            "jsonArray.forEach { toast(it.getJSONString(\"type\")) }",
            "RichUtils.forObjectEach(jsonArray, object -> {\n" +
                    "            RichUtils.toast(DummyClass.this, RichUtils.getJSONString(object, \"type\"));\n" +
                    "});")

    list.add(forEach)

    val toList = generateExecuteItem(CategoryItem.JSON, "toList",
            "convert JSONArray to List<JSONObject>",
            "jsonArray.toList()",
            "List<JSONObject> objectList = RichUtils.toObjectList(jsonArray);")

    list.add(toList)

    return list
}