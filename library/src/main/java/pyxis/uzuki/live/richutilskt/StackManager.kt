package pyxis.uzuki.live.richutilskt

import android.app.Activity

import java.util.ArrayList

class StackManager {
    internal var activityList: ArrayList<Activity>? = null

    init {
        activityList = ArrayList<Activity>()
    }

    fun addActivity(activity: Activity) {
        activityList!!.add(activity)
    }

    fun removeActivity(activity: Activity): Boolean {
        return activityList!!.remove(activity)
    }

    fun finishAllActivity() {
        for (activity in activityList!!) {
            activity.finish()
        }
    }

    companion object {
        internal var activityMananger: StackManager? = null
        val instance: StackManager?
            get() {
                if (activityMananger == null) {
                    activityMananger = StackManager()
                }
                return activityMananger
            }
    }
}