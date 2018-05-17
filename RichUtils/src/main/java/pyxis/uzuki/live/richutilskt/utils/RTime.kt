@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.text.format.DateUtils
import pyxis.uzuki.live.richutilskt.R

/**
 * convert time (in millis) into Relative Time
 *
 * @param receiver Target Time
 * @param context Context object
 */
fun Long.convertToRelativeTime(context: Context): String {
    return getRelativeTimeSpanString(context)
}

private fun Long.getRelativeTimeSpanString(context: Context, now: Long = System.currentTimeMillis(),
                                           minResolution: Long = DateUtils.SECOND_IN_MILLIS,
                                           flags: Int = DateUtils.FORMAT_SHOW_DATE or DateUtils.FORMAT_SHOW_YEAR): String {
    val r = context.resources

    val past = now >= this
    val duration = Math.abs(now - this)
    val resId: Int
    val count: Long

    if (duration < DateUtils.MINUTE_IN_MILLIS && minResolution < DateUtils.MINUTE_IN_MILLIS) {
        count = duration / DateUtils.SECOND_IN_MILLIS
        resId = compareWithPredicate(R.plurals.num_seconds_ago, R.plurals.in_num_seconds, { past })
    } else if (duration < DateUtils.HOUR_IN_MILLIS && minResolution < DateUtils.HOUR_IN_MILLIS) {
        count = duration / DateUtils.MINUTE_IN_MILLIS
        resId = compareWithPredicate(R.plurals.num_minutes_ago, R.plurals.in_num_minutes, { past })
    } else if (duration < DateUtils.DAY_IN_MILLIS && minResolution < DateUtils.DAY_IN_MILLIS) {
        count = duration / DateUtils.HOUR_IN_MILLIS
        resId = compareWithPredicate(R.plurals.num_hours_ago, R.plurals.in_num_hours, { past })
    } else if (duration < DateUtils.WEEK_IN_MILLIS && minResolution < DateUtils.WEEK_IN_MILLIS) {
        return getRelativeDayString(context, this, now)
    } else {
        return DateUtils.formatDateRange(null, this, this, flags)
    }

    val format = r.getQuantityString(resId, count.toInt())
    return String.format(format, count)
}

private fun getRelativeDayString(context: Context, day: Long, today: Long): String {
    val past = today > day
    val r = context.resources
    val days = getRelativeDay(day, today)

    if (days == 1) {
        return r.getString(compareWithPredicate(R.string.rtime_yesterday, R.string.rtime_tomorrow, { past }))
    } else if (days == 0) {
        return r.getString(R.string.rtime_today)
    }

    val resId: Int = compareWithPredicate(R.plurals.num_days_ago, R.plurals.in_num_days, { past })
    val format = r.getQuantityString(resId, days)
    return String.format(format, days)
}

private fun getRelativeDay(day: Long, today: Long): Int {
    val startDay = day.normalizeDate()
    val currentDay = today.normalizeDate()

    return Math.abs(currentDay - startDay).toInt()
}

private fun <T> compareWithPredicate(A: T, B: T, predicate: () -> Boolean) = if (predicate()) A else B