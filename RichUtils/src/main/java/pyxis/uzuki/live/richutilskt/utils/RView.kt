@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.view.View
import android.view.ViewGroup

/**
 * Convert ViewGroup's Children to List<Child>
 */
fun ViewGroup.convertChildrenList() : List<View> = (0 until childCount).map { getChildAt(it) }.toList()
