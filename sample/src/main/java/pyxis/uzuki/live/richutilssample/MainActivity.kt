package pyxis.uzuki.live.richutilssample

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import pyxis.uzuki.live.richutilskt.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dip5 = dip(5)
        val sp12 = sp(12)

        alert(message = "dd", callback = {})
        alert(message = "dd")
        confirm(message = "", callback = {})
        val p = progress(message = "")
        p.dismiss()

        var np = NaraePreference.getInstance(c = this)
        var version = versionName()

        class pickCallback : PickMediaManager.PickMediaCallback {
            override fun failPermissionGranted() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun pickMediaCallback(path: String?) {
                var orig = getPath(this@MainActivity, Uri.parse(path))

            }
        }

        PickMediaManager.getInstance(this).pickFromCamera(this, callback = pickCallback())
    }
}

