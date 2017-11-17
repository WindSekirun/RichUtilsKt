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