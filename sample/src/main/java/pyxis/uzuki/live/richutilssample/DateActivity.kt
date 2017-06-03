package pyxis.uzuki.live.richutilssample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pyxis.uzuki.live.richutilskt.*
import java.util.*

class DateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var date: Date? = "2016-11-23 11:11:11".parseDate()
        var string1 = date?.asString()
        var formatted = "2016-11-23 11:11:11".toDateString(fromFormat = "yyyy-MM-dd HH:mm:ss", toFormat = "yyyy.mm.dd")
        var timestamp = 1496488887.toLong()
        var tsStr = timestamp.asDateString()

        copyText(tsStr)
        var text = getTextFromClipboard()
    }
}
