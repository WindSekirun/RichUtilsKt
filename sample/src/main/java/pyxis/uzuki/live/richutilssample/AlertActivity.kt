package pyxis.uzuki.live.richutilssample

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pyxis.uzuki.live.richutilskt.*

class AlertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        alert(message = "Hello, world!")

        confirm(message = "Hello, world!", callback = {
            toast(message = "click confirm button")
        })

        val items:ArrayList<String> = ArrayList()
        (1..5).mapTo(items) { it.toString() }

        selector(items = items, callback = { _: DialogInterface, i: Int ->
            toast(message = "click item -> $i")
        })

        val progress = progress(message = "Loading...")
        progress.dismiss()
    }
}


