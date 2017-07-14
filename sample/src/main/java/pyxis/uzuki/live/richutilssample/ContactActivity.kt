package pyxis.uzuki.live.richutilssample

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contacts.*
import pyxis.uzuki.live.richutilskt.utils.*

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val arrays: Array<String> = arrayOf(Manifest.permission.READ_CONTACTS)
        val isGranted = RPermission.getInstance(this).checkPermission(array = arrays, callback = { _: Int, _: ArrayList<String> ->
            init()
        })

        if (isGranted)
            init()
    }

    private fun init() {
        var text = ""
        val progress = progress(message = "Loading...")
        runAsync {
            val list = getContactsList()
            list.forEach { text = "$text \n$it" }

            runOnUiThread {
                progress.dismiss()
                txtResult.text = text
            }
        }
    }
}