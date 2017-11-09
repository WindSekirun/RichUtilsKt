package pyxis.uzuki.live.richutilssample

import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pick.*
import pyxis.uzuki.live.richutilskt.utils.*

class PickMediaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick)
        
        gallery.setOnClickListener {
            RPickMedia.instance.pickFromGallery(this, { resultCode: Int, path: String -> resultMesage(resultCode, path) })
        }

        camera.setOnClickListener {
            RPickMedia.instance.pickFromCamera(this, { resultCode, path -> resultMesage(resultCode, path) })
        }

        video.setOnClickListener {
            RPickMedia.instance.pickFromVideo(this, { resultCode: Int, path: String -> resultMesage(resultCode, path) })
        }

        videoc.setOnClickListener {
            RPickMedia.instance.pickFromVideoCamera(this, { resultCode: Int, path: String -> resultMesage(resultCode, path) })
        }
    }

    private fun resultMesage(resultCode: Int, path: String) {
        if (resultCode == RPickMedia.PICK_FAILED) {
            throw SecurityException("not granted permission to pick media files")
        }

        val realPath = Uri.parse(path) getRealPath this@PickMediaActivity
        val width = realPath.getImageWidth()
        val height = realPath.getImageHeight()
        val degree = getPhotoOrientationDegree(realPath)

        txtUrl.text = "uri -> $realPath , width -> $width , height -> $height , degree -> $degree"

        val bitmap = BitmapFactory.decodeFile(realPath)
        imgView.setImageBitmap(bitmap)

        requestMediaScanner(realPath)
    }
}
