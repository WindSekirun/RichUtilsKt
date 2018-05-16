package pyxis.uzuki.live.rpickimagedemo

import android.content.Context
import android.os.Environment
import android.text.TextUtils
import java.io.File
import java.lang.reflect.Method

/**
 * RichUtilsKt
 * Class: PrintMethodList
 * Created by Pyxis on 5/2/18.
 *
 * Description:
 */

object PrintMethodList {
    data class MethodsInfo(val modifier: String, val returnName: String, val name: String, val parameters: String) {
        override fun toString(): String {
            return "$modifier $returnName $name($parameters)"
        }
    }

    fun parser(methods: Array<Method>): List<MethodsInfo> {
        val list = arrayListOf<MethodsInfo>()

        for (method in methods) {
            if (method.name.contains("\$default")) continue
            if (method.name.contains("hashCode")) continue
            if (method.name.contains("getClass")) continue
            if (method.name.contains("equals")) continue
            if (method.name.contains("notify")) continue
            if (method.name.contains("toString")) continue
            if (method.name.contains("wait")) continue

            val parameters = method.parameters
            val pairs = parameters.map { "${it.type.simpleName} ${it.name}" }
            val join = TextUtils.join(", ", pairs)
            val info = MethodsInfo("", method.returnType.simpleName, method.name, join)
            list.add(info)
        }
        return list
    }

    @JvmStatic
    fun writeMethods(context: Context, methods: Array<Method>) {
        val list = parser(methods)
        val folder = Environment.getExternalStorageDirectory()
        val file = File(folder, "RichUtils.txt")
        file.createNewFile()
        val builder = StringBuilder()

        list.sortedBy { it.name }

        (0 until list.size)
                .map { list[it] }
                .forEach {
                    builder.append(it.toString())
                            .append("\n")
                }

        file.writeText(builder.toString())
    }
}

