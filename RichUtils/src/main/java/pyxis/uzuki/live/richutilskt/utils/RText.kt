@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.text.TextUtils

/**
 * get string with empty handling
 */
@JvmOverloads fun String.isEmptyOrReturn(default: String = "") = if (TextUtils.isEmpty(this)) default else this

/**
 * return string empty state
 */
fun String.isEmpty() = TextUtils.isEmpty(this)

/**
 * Returns `true` if at least one element matches condition of contains string
 */
fun anyContainsString(inputStr: String, items: Array<String>) = items.any { inputStr.contains(it, false) }

/**
 * Returns `true` if at least one element matches condition of contains string
 */
fun anyContainsString(inputStr: String, items: List<String>) = items.any { inputStr.contains(it, false) }

/**
 * Returns `true` if at least one element matches condition of matches regex
 */
fun anyMatchRegex(regex: String, items: Array<String>) = items.any { it.contains(regex) }

/**
 * Returns `true` if at least one element matches condition of matches regex
 */
fun anyMatchRegex(regex: String, items: List<String>) = items.any { it.contains(regex) }