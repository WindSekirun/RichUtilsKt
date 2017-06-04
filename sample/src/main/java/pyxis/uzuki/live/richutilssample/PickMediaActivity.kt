package pyxis.uzuki.live.richutilssample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pick.*
import pyxis.uzuki.live.richutilskt.RPickMedia

class PickMediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick)

        /*
         * You don't have to care about permission, RPickMedia auto granting pick permission.
         */

        class MediaCallback : RPickMedia.PickMediaCallback {
            override fun failPermissionGranted() {
                TODO("not implemented")
            }

            override fun pickMediaCallback(path: String?) {
                txtUrl.text = "uri -> " + path
            }
        }

        gallery.setOnClickListener {
            RPickMedia.getInstance(this).pickFromGallery(MediaCallback())
        }

        camera.setOnClickListener {
            RPickMedia.getInstance(this).pickFromCamera(MediaCallback())
        }

        video.setOnClickListener {
            RPickMedia.getInstance(this).pickFromVideo(MediaCallback())
        }

        videoc.setOnClickListener {
            RPickMedia.getInstance(this).pickFromVideoCamera(MediaCallback())
        }


    }
}
