@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.text.TextUtils

fun String.isEmptyOrReturn() = if (TextUtils.isEmpty(this)) "" else this

fun String.isEmpty() = TextUtils.isEmpty(this)