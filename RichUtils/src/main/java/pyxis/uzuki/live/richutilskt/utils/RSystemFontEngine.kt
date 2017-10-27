package pyxis.uzuki.live.richutilskt.utils

import android.app.Application
import android.content.Context
import android.graphics.Paint
import android.graphics.Typeface
import android.support.annotation.LayoutRes
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.MetricAffectingSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

internal class RSystemFontEngine private constructor(private val mApplication: Application) {
    internal var use = false

    val refresh: RSystemFontEngine?
        @Synchronized get() = sHelper

    private fun <V : TextView> setTypefaceTextView(view: V) {
        view.typeface = Typeface.DEFAULT
    }

    private fun <V : ViewGroup> setTypefaceViewGroup(viewGroup: V) {
        val count = viewGroup.childCount

        for (i in 0 until count) {
            val child = viewGroup.getChildAt(i)

            if (child is ViewGroup) {
                setTypefaceViewGroup(child)
                continue
            }
            if (child !is TextView) {
                continue
            }
            setTypefaceTextView(child)
        }
    }

    @JvmOverloads fun setTypeface(context: Context, @LayoutRes layoutRes: Int, parent: ViewGroup? = null, isAttachedRoot: Boolean = false): View {
        val view = LayoutInflater.from(context).inflate(layoutRes, parent, isAttachedRoot) as ViewGroup
        setTypefaceViewGroup(view)
        return view
    }

    @Suppress("UNUSED_PARAMETER")
    fun setTypeface(context: Context, view: ViewGroup, parent: ViewGroup? = null, isAttachedRoot: Boolean = false): View {
        setTypefaceViewGroup(view)
        return view
    }

    private val typefaceSpan: TypefaceSpan
        get() = TypefaceSpan(typeface)

    fun String.getStringTypeface(): SpannableString {
        val s = SpannableString(this)
        s.setSpan(typefaceSpan, 0, s.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return s
    }

    val typeface: Typeface
        get() = Typeface.DEFAULT

    /**
     * Style a [Spannable] with a custom [Typeface].

     * @author Tristan Waddington
     */
    inner class TypefaceSpan(private val mTypeface: Typeface) : MetricAffectingSpan() {

        override fun updateMeasureState(p: TextPaint) {
            p.typeface = mTypeface
            p.flags = p.flags or Paint.FILTER_BITMAP_FLAG
        }

        override fun updateDrawState(tp: TextPaint) {
            tp.typeface = mTypeface
            tp.flags = tp.flags or Paint.FILTER_BITMAP_FLAG
        }
    }

    companion object {
        val TAG = "RSystemFontEngine"
        private var sHelper: RSystemFontEngine? = null

        @JvmStatic fun initialize(application: Application) {
            sHelper = RSystemFontEngine(application)
        }

        @JvmStatic fun destroy() = sHelper?.let { sHelper = null }

        @JvmStatic val instance: RSystemFontEngine?
            get() {
                if (sHelper == null) {
                    throw NullPointerException("Are you put initialize in your application class?")
                }
                return sHelper
            }
    }
}