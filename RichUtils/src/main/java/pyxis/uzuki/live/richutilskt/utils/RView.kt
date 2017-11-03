@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.os.Build
import android.view.View
import android.view.ViewGroup
import java.util.concurrent.atomic.AtomicInteger

/**
 * Convert ViewGroup's Children to List<Child>
 */
fun ViewGroup.convertChildrenList() : List<View> = (0 until childCount).map { getChildAt(it) }.toList()


private val nextGeneratedId = AtomicInteger(1)

/**
 * Generate View ID
 *
 * @return generated View ID
 */
fun generateViewId(): Int {
    if (Build.VERSION.SDK_INT > 17) {
        return View.generateViewId()
    } else {
        while (true) {
            val result = nextGeneratedId.get()
            var newValue = result + 1
            if (newValue > 0x00FFFFFF) newValue = 1
            if (nextGeneratedId.compareAndSet(result, newValue)) {
                return result
            }
        }
    }
}