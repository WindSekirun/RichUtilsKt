package pyxis.uzuki.live.richutilssample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.startActivity
import pyxis.uzuki.live.richutilskt.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alert.setOnClickListener { startActivity<AlertActivity>() }
        bitmap.setOnClickListener { startActivity<BitmapActivity>() }
        date.setOnClickListener { startActivity<DateActivity>() }
        media.setOnClickListener { startActivity<PickMediaActivity>() }
        btnReboot.setOnClickListener { this.reboot() }
        logo.setOnClickListener { browse("https://github.com/WindSekirun/RichUtilsKt") }
    }
}

