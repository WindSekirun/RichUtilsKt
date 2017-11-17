@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.text.TextUtils

/**
 * get string with empty handling
 */
fun String.isEmptyOrReturn() = if (TextUtils.isEmpty(this)) "" else this

/**
 * return string empty state
 */
fun String.isEmpty() = TextUtils.isEmpty(this)