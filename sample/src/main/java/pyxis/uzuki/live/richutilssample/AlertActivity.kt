package pyxis.uzuki.live.richutilssample

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_alert.*
import pyxis.uzuki.live.richutilskt.*

class AlertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)

        alert.setOnClickListener({alert(message = "Hello, world!")})

        selector.setOnClickListener({
            val items:ArrayList<String> = ArrayList()
            (1..5).mapTo(items) { it.toString() }

            selector(items = items, callback = { _: DialogInterface, i: Int ->
                toast(message = "click item -> $i")
            })
        })

        confirm.setOnClickListener({
            confirm(message = "Hello, world!", callback = {
                toast(message = "click confirm button")
            })
        })

        progress.setOnClickListener({
            val progress = progress(message = "Loading...")

            runDelayed(10000, {
                progress.dismiss()
            })

        })
    }
}


