package pyxis.uzuki.live.richutilssample

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bitmap.*
import pyxis.uzuki.live.richutilskt.utils.bitmapToDrawable
import pyxis.uzuki.live.richutilskt.utils.downloadBitmap
import pyxis.uzuki.live.richutilskt.utils.runAsync
import pyxis.uzuki.live.richutilskt.utils.saveBitmapToFile

class BitmapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap)

        var bitmap: Bitmap?
        runAsync {
            bitmap = downloadBitmap("http://images.goodsmile.info/cgm/images/product/20160606/5715/39417/large/f75b5722baec63a2922a81c3c3ca8743.jpg")
            runOnUiThread { init(bitmap) }
        }
    }

    private fun init(bitmap: Bitmap?) {
        if (bitmap == null)
            return

        var drawable: Drawable? = bitmapToDrawable(bitmap)
        // it will be compile error cause drawable is Drawable?
        // var bitmap2 = drawableToBitmap(drawable = drawable)

        var file = saveBitmapToFile(bitmap = bitmap)

        imgView.setImageBitmap(bitmap)
    }
}

