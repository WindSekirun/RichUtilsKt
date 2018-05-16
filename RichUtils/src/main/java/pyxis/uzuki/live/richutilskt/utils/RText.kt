@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.text.TextUtils

/**
 * get string with empty handling
 */
@JvmOverloads
fun String.isEmptyOrReturn(default: String = "") = if (TextUtils.isEmpty(this)) default else this

/**
 * return string empty state
 */
fun String.isEmpty() = TextUtils.isEmpty(this)

/**
 * Returns `true` if at least one element matches condition of contains string
 */
fun anyContainsString(inputStr: String, items: Array<String>) = matchAnyPredicate({ inputStr.contains(it, false) }, *items)

/**
 * Returns `true` if at least one element matches condition of contains string
 */
fun anyContainsString(inputStr: String, items: List<String>) = items.any { inputStr.contains(it, false) }

/**
 * Returns `true` if at least one element matches condition of matches regex
 */
fun anyMatchRegex(regex: String, items: Array<String>) = matchAnyPredicate({ it.contains(regex) }, *items)

/**
 * Returns `true` if at least one element matches condition of matches regex
 */
fun anyMatchRegex(regex: String, items: List<String>) = items.any { it.contains(regex) }

/**
 * Test `target` equals all condition of `items`
 *
 * @param target
 * @param items
 * @return
 */
fun allEquals(target: String, vararg items: String): Boolean {
    return items.map { target == it }.all { true }
}

/**
 * Test `target` equals any condition of `items`
 *
 * @param target
 * @param items
 * @return
 */
fun anyEquals(target: String, vararg items: String): Boolean {
    return items.map { target == it }.any { true }
}

/**
 * Test `target` contains all condition of `items`
 *
 * @param target
 * @param items
 * @return
 */
fun allContains(target: String, vararg items: String): Boolean {
    return items.map { target.contains(it, true) }.all { true }
}


/**
 * Test `target` contains any condition of `items`
 *
 * @param target
 * @param items
 * @return
 */
fun anyContains(target: String, vararg items: String): Boolean {
    return items.map { target.contains(it, true) }.any { true }
}

/**
 * Test all element of target is empty
 *
 * @param target
 * @return
 */
fun allEmpty(vararg target: String): Boolean {
    return target.map { it.isEmpty() }.all { true }
}

/**
 * Test any element of target is empty
 *
 * @param target
 * @return
 */
fun anyEmpty(vararg target: String): Boolean {
    return target.map { it.isEmpty() }.any { true }
}

/**
 * Test all element of target is not empty
 *
 * @param target
 * @return
 */
fun allNotEmpty(vararg target: String): Boolean {
    return target.map { it.isNotEmpty() }.all { true }
}

/**
 * Test any element of target is not empty
 *
 * @param target
 * @return
 */
fun anyNotEmpty(vararg target: String): Boolean {
    return target.map { it.isNotEmpty() }.any { true }
}