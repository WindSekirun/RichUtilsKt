@file:JvmName("RAsync")

package pyxis.uzuki.live.richutilskt.utils

import kotlin.reflect.KClass

/**
 * Class for generate Instance of given Class object
 *
 * Usages:
 * 1. Constructor hasn't any parameter
 * val sampleClassObj = RConstructorBuilder(SampleClass::class.java).newInstance()
 *
 * 2. Constructor has at least one parameter
 * val sampleClass2Obj = RConstructorBuilder(SampleClass2::class.java)
 *         .addParameter(String::class.java, "ABC")
 *         .addParameter(Int::class, 20)
 *         .newInstance()
 *
 */
class RConstructorBuilder<T>(private val targetCls: Class<T>) {
    private val mMap = LinkedHashMap<Class<*>, Any?>()

    fun addParameter(cls: Class<*>, value: Any?): RConstructorBuilder<T> = this.apply { mMap[cls] = value }
    fun addParameter(cls: KClass<*>, value: Any?): RConstructorBuilder<T> = this.apply { mMap[cls.java] = value }

    fun newInstance(map: Map<Class<*>, Any?> = mMap): T {
        val keyArray = map.keys.toTypedArray()
        val objArray = map.values.toTypedArray()

        return targetCls.getConstructor(*keyArray).newInstance(*objArray)
    }
}