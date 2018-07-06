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
    private val excludedName = arrayOf("\$default", "hashCode", "getClass", "equals", "notify",
            "toString", "wait")

    data class MethodsInfo(val modifier: String, val returnName: String, val name: String, val parameters: String) {
        override fun toString(): String {
            return "$modifier $returnName $name($parameters)"
        }
    }

    fun parser(methods: Array<Method>): List<MethodsInfo> {
        val list = arrayListOf<MethodsInfo>()

        for (method in methods) {
            if (excludedName.map { method.name.contains(it, true) }.any { it }) continue

            val parameters = method.parameters
            val pairs = parameters.map { "${it.type.simpleName} ${it.name}" }
            val join = TextUtils.join(", ", pairs)
            val info = MethodsInfo("", method.returnType.simpleName, method.name, join)
            list.add(info)
        }
        return list
    }

    @JvmStatic
    fun writeMethods(methods: Array<Method>) : String{
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

        return builder.toString()
    }
}

