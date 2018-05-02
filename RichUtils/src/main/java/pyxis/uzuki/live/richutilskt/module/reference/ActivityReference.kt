package pyxis.uzuki.live.richutilskt.module.reference

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import java.lang.ref.WeakReference
import java.util.*

/**
 * RichUtilsKt
 * Class: ActivityReference
 * Created by Pyxis on 2/4/18.
 *
 * Description:
 */

object ActivityReference {
    private var mTopActivityWeakRef: WeakReference<Activity>? = null
    private val mActivityList: LinkedList<Activity> = LinkedList()
    private var mApplicationWeakRef: WeakReference<Application>? = null

    private val mCallbacks = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
            mActivityList.add(activity)
            setTopActivityWeakRef(activity)
        }

        override fun onActivityStarted(activity: Activity) {
            setTopActivityWeakRef(activity)
        }

        override fun onActivityResumed(activity: Activity) {
            setTopActivityWeakRef(activity)
        }

        override fun onActivityDestroyed(activity: Activity) {
            mActivityList.remove(activity)
        }

        override fun onActivityPaused(activity: Activity) {}
        override fun onActivityStopped(activity: Activity) {}
        override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle?) {}
    }

    @JvmStatic
    fun initialize(application: Application) {
        mApplicationWeakRef = WeakReference(application)
        application.registerActivityLifecycleCallbacks(mCallbacks)
    }

    @JvmStatic
    fun getActivtyReference(): Activity? {
        if (mTopActivityWeakRef != null) {
            val activity = (mTopActivityWeakRef as WeakReference<Activity>).get()
            if (activity != null) {
                return activity
            }
        }

        val size = mActivityList.size
        return if (size > 0) mActivityList[size - 1] else null
    }

    @JvmStatic
    fun getContext(): Context {
        return getActivtyReference() ?: mApplicationWeakRef?.get() as Context
    }

    @JvmStatic
    fun getActivityList() = mActivityList

    private fun setTopActivityWeakRef(activity: Activity) {
        if (mTopActivityWeakRef == null || activity != (mTopActivityWeakRef as WeakReference<Activity>).get()) {
            mTopActivityWeakRef = WeakReference(activity)
        }
    }
}