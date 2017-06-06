package pyxis.uzuki.live.richutilssample

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pick.*
import pyxis.uzuki.live.richutilskt.RPickMedia
import pyxis.uzuki.live.richutilskt.getRealPath

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

            @SuppressLint("SetTextI18n")
            override fun pickMediaCallback(path: String?) {
                txtUrl.text = "uri -> ${Uri.parse(path) getRealPath(this@PickMediaActivity)}"
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
