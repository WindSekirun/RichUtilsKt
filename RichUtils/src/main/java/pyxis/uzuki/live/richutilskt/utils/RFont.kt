@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.app.Application
import android.content.Context
import android.view.View
import android.view.ViewGroup

/**
 * Set system font into ViewGroup
 *
 * before use this methods, you should initialize SystemFontEngine, using [Application.initializeFontEngine()] method
 *
 * @param[layoutRes] layout file
 * @param[parent] ViewGroup object
 * @param[isAttachedRoot] isAttachedRoot
 */
@JvmOverloads fun Context.setTypeface(layoutRes: Int, parent: ViewGroup? = null, isAttachedRoot: Boolean = false): View? =
        RSystemFontEngine.instance?.setTypeface(this, layoutRes, parent, isAttachedRoot)

/**
 * Set system font into ViewGroup
 *
 * before use this methods, you should initialize SystemFontEngine, using [Application.initializeFontEngine()] method
 *
 * @param[view] ViewGroup object
 * @param[parent] ViewGroup object
 * @param[isAttachedRoot] isAttachedRoot
 */
@JvmOverloads fun Context.setTypeface(view: ViewGroup, parent: ViewGroup? = null, isAttachedRoot: Boolean = false): View? =
        RSystemFontEngine.instance?.setTypeface(this, view, parent, isAttachedRoot)

/**
 * Initialize SystemFontEngine
 */
fun Application.initializeFontEngine() {
    RSystemFontEngine.initialize(this)
}