@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import java.util.*

/**
 * Return an immutable list containing vararg parameter
 *
 * @param <T> the class of the objects in the list
 * @param items the objects to be stored in the returned list
 */
fun <T> listOf(vararg items: T): List<T> = items.toList()

/**
 * Return an ArrayLIit containing vararg parameter
 *
 * @param <T> The class of the objects in the list
 * @param items the objects to be stored in the returned list
 */
fun <T> arrayListOf(vararg items: T) = ArrayList(items.toList())

/**
 * Return an Array<T> containing vararg parameter
 *
 * @param <T> The class of the objects in the list
 * @param items the objects to be stored in the returned list
 */
inline fun <reified T> arrayOf(vararg items: T) = items.toList().toTypedArray()

/**
 * Test if given all of vararg parameter are match given predicate
 *
 * Usages
 * testWithParams({ it.length > 3 }, "Steve", "Bobs") -> true
 * testWithParams({ it.length > 3 }, "Steve", "Bob") -> false
 *
 * @param <T> The class of the objects
 * @param predicate : Higher-order function that given single <T> and return as Boolean
 *
 */
fun <T> matchAllPredicate(predicate: (T) -> Boolean, vararg items: T): Boolean {
    return items.map { predicate(it) }.all { true }
}

/**
 * Test if given any of vararg parameter are match given predicate
 *
 * Usages
 * testWithParams({ it.length > 3 }, "Steve", "Bobs") -> true
 * testWithParams({ it.length > 3 }, "Steve", "Bob") -> true
 * testWithParams({ it.length > 3  }, "Eve", "Bob") -> false
 *
 * @param <T> The class of the objects
 * @param predicate : Higher-order function that given single <T> and return as Boolean
 *
 */
fun <T> matchAnyPredicate(predicate: (T) -> Boolean, vararg items: T): Boolean {
    return items.map { predicate(it) }.any { true }
}
