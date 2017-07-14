package pyxis.uzuki.live.richutilskt.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import pyxis.uzuki.live.richutilskt.utils.runDelayed

class RollingViewPager @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {
    private var flingAble = true
    private var smoothScroll = true
    private var delay = 2900L
    private var moveDelay = 100L
    private val autoScrolling: AutoScrolling = AutoScrolling()

    init {

    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        try {
            return flingAble && super.onInterceptTouchEvent(event)
        } catch (e: Exception) {
            return false
        }

    }

    override fun onTouchEvent(arg0: MotionEvent): Boolean {
        return flingAble && super.onTouchEvent(arg0)
    }

    private inner class AutoScrolling : Runnable {
        override fun run() {
            runDelayed({
                setCurrentItem(currentItem + 1, smoothScroll)
            }, moveDelay)

            handler.removeCallbacks(this)
            handler.postDelayed(this, delay)
        }
    }

    private fun startAutoScrolling() {
        handler.removeCallbacks(autoScrolling)
        handler.postDelayed(autoScrolling, delay)
    }

    private fun stopAutoScrolling() {
        handler.removeCallbacks(autoScrolling)
    }

    fun setFlingAble(flag: Boolean) {
        flingAble = flag
    }

    fun enableAutoScrolling(enable: Boolean) {
        if (enable) {
            startAutoScrolling()
        } else {
            stopAutoScrolling()
        }
    }

    fun setAutoScrollingSmooth(smoothScroll: Boolean) {
        this.smoothScroll = smoothScroll
    }

    fun setDelay(delay: Long) {
        this.delay = delay - 100L
        this.moveDelay = 100L
    }
}