package pyxis.uzuki.live.richutilssample

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_date.*
import pyxis.uzuki.live.richutilskt.utils.*
import java.util.*

class DateActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val date: Date? = "2016-11-23 11:11:11".parseDate()
        val string1 = date?.asDateString()
        val formatted = "2016-11-23 11:11:11".toDateString("yyyy-MM-dd HH:mm:ss", "yyyy.mm.dd")
        val timestamp = 1496488887.toLong() * 1000
        val tsStr = timestamp.asDateString()

        btnCopy.setOnClickListener {
            copyText(editCopy.text.toString())
        }

        btnLoad.setOnClickListener {
            val value = getTextFromClipboard()
            editCopy.setText(value)
            editCopy.setSelection(editCopy.length())
        }

        txtResult.text = "parseDate -> $date \n asString -> $string1 \n toDateString -> $formatted \n timestamp -> $timestamp \n asDateString-> $tsStr"
    }
}
