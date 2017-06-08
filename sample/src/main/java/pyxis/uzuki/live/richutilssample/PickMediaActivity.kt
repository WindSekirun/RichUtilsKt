package pyxis.uzuki.live.richutilssample

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pick.*
import pyxis.uzuki.live.richutilskt.RPickMedia
import pyxis.uzuki.live.richutilskt.*

class PickMediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick)

        /*
         * You don't have to care about permission, RPickMedia will auto granting pick permission.
         */
        class MediaCallback : RPickMedia.PickMediaCallback {
            override fun failPermissionGranted() {
                TODO("not implemented")
            }

            @SuppressLint("SetTextI18n")
            override fun pickMediaCallback(path: String?) {
                val realPath = Uri.parse(path) getRealPath this@PickMediaActivity
                val width = getPhotoWidth(realPath)
                val height = getPhotoHeight(realPath)
                val degree = getPhotoOrientationDegree(realPath)

                txtUrl.text = "uri -> $realPath , width -> $width , height -> $height , degree -> $degree"

                var bitmap = BitmapFactory.decodeFile(realPath)
                imgView.setImageBitmap(bitmap)
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
