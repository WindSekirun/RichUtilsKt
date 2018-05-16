@file:JvmName("RichUtils")
@file:JvmMultifileClass

import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.reflect.KClass

/**
 * get list of Field which attached any annotation in Runtime
 *
 * @param target target instance to search Annotation'd field
 * @param includeSuperClass optional, true - increase scope into their superclass. default is true
 */
fun getAnnotationFieldList(target: Any, includeSuperClass: Boolean = true): List<Field> {
    var cls: Class<in Any>? = target.javaClass

    val list = mutableListOf<Field>()
    do {
        if (cls == null) break
        list.addAll(cls.declaredFields.filter { it.declaredAnnotations.isNotEmpty() }.toList())
        cls = if (includeSuperClass) cls.superclass else null
    } while (cls != null)

    return list
}

/**
 * get list of Method which attached any annotation in Runtime
 *
 * @param target target instance to search Annotation'd method
 * @param includeSuperClass optional, true - increase scope into their superclass. default is true
 */
fun getAnnotationMethodList(target: Any, includeSuperClass: Boolean = true): List<Method> {
    var cls: Class<in Any>? = target.javaClass

    val list = mutableListOf<Method>()
    do {
        if (cls == null) break
        list.addAll(cls.declaredMethods.filter { it.declaredAnnotations.isNotEmpty() }.toList())
        cls = if (includeSuperClass) cls.superclass else null
    } while (cls != null)

    return list
}

/**
 * get list of Field which attached given annotation in Runtime
 *
 * @param target target instance to search Annotation'd field
 * @param annotation target class of annotation
 * @param includeSuperClass optional, true - increase scope into their superclass, default is true
 */
fun <T : Annotation> findAnnotationInFields(target: Any, annotation: Class<T>, includeSuperClass: Boolean = true): List<Field> {
    return mutableListOf<Field>().apply {
        getAnnotationFieldList(target, includeSuperClass).forEach { field ->
            if (field.declaredAnnotations.filterIsInstance(annotation).isNotEmpty()) add(field)
        }
    }
}

/**
 * get list of field which attached given annotation in Runtime
 *
 * @param target target instance to search Annotation'd field
 * @param annotation target KClass of annotation
 * @param includeSuperClass optional, true - increase scope into their superclass, default is true
 */
fun <T : Annotation> findAnnotationInFields(target: Any, annotation: KClass<T>, includeSuperClass: Boolean = true) = findAnnotationInFields(target, annotation.java, includeSuperClass)

/**
 * get list of Method which attached given annotation in Runtime
 *
 * @param target target instance to search Annotation'd method
 * @param annotation target class of annotation
 * @param includeSuperClass optional, true - increase scope into their superclass, default is true
 */
fun <T : Annotation> findAnnotationInMethods(target: Any, annotation: Class<T>, includeSuperClass: Boolean = true): List<Method> {
    return mutableListOf<Method>().apply {
        getAnnotationMethodList(target, includeSuperClass).forEach { method ->
            if (method.declaredAnnotations.filterIsInstance(annotation).isNotEmpty()) add(method)
        }
    }
}

/**
 * get list of Method which attached given annotation in Runtime
 *
 * @param target target instance to search Annotation'd method
 * @param annotation target KClass of annotation
 * @param includeSuperClass optional, true - increase scope into their superclass, default is true
 */
fun <T : Annotation> findAnnotationInMethods(target: Any, annotation: KClass<T>, includeSuperClass: Boolean = true) = findAnnotationInMethods(target, annotation.java, includeSuperClass)

