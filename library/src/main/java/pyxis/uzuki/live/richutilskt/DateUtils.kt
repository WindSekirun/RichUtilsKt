package pyxis.uzuki.live.richutilskt

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by pyxis on 2017. 6. 2..
 */

fun Date.asString(format: DateFormat): String = format.format(this)
fun Date.asString(format: String): String = asString(SimpleDateFormat(format))
fun Date.asString(): String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(this)
fun Long.asDateString(): String = Date(this).asString()
fun String.parseDate(format: String): Date? = try { SimpleDateFormat(format).parse(this) } catch (e: Exception) { null }

fun toDateString(dateString: String, fromFormat: String, toFormat: String): String {
    val result: String;
    val df: SimpleDateFormat = SimpleDateFormat(fromFormat, Locale.getDefault())
    val df2: SimpleDateFormat = SimpleDateFormat(toFormat, Locale.getDefault())
    try {
        result = df2.format(df.parse(dateString))
    } catch (e: ParseException) {
        return dateString
    }
    return result
}