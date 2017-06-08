package pyxis.uzuki.live.richutilskt

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

/**
 * hide keyboard
 */
fun Activity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}