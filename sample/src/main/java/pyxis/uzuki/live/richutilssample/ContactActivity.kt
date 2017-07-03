package pyxis.uzuki.live.richutilssample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contacts.*
import pyxis.uzuki.live.richutilskt.utils.getContactsList
import pyxis.uzuki.live.richutilskt.utils.progress
import pyxis.uzuki.live.richutilskt.utils.runAsync

/**
 * Created by winds on 2017-06-26.
 */
class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        var text = ""
        val progress = progress("Loading...")

        runAsync {
            val list = getContactsList()
            list.forEach {
                text = "$text \n$it"
            }

            runOnUiThread {
                progress.dismiss()
                txtResult.text = text
            }
        }


    }
}