package pyxis.uzuki.live.rpickimagedemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import pyxis.uzuki.live.richutilskt.module.image.OrientationFixer
import pyxis.uzuki.live.richutilskt.utils.RPickMedia
import pyxis.uzuki.live.richutilskt.utils.getPhotoOrientationDegree
import pyxis.uzuki.live.richutilskt.utils.runAsync
import pyxis.uzuki.live.richutilskt.utils.toFile
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSelect.setOnClickListener {
            RPickMedia.instance.pickFromCamera(this) { code, path ->
                val fixedPath = OrientationFixer.execute(path, this)
                txtPath.text = "code: $code, path: $fixedPath"
                imgPicture.setImageURI(Uri.fromFile(fixedPath.toFile()))
            }
        }

        btnSelectGallery.setOnClickListener {
            RPickMedia.instance.pickFromGallery(this) { code, path ->
                val fixedPath = OrientationFixer.execute(path, this)
                txtPath.text = "code: $code, path: $fixedPath"
                imgPicture.setImageURI(Uri.fromFile(fixedPath.toFile()))
            }
        }

        btnSelectGalleryVideo.setOnClickListener {
            RPickMedia.instance.pickFromVideo(this) { code, path ->
                txtPath.text = "code: $code, path: $path"
            }
        }


        btnTest.setOnClickListener {
            startActivity(Intent(this, JavaActivity::class.java))
        }
    }
}
