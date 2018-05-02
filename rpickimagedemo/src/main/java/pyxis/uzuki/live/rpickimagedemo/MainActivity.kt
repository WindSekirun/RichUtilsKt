package pyxis.uzuki.live.rpickimagedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import pyxis.uzuki.live.richutilskt.utils.RPickMedia

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSelect.setOnClickListener {
            RPickMedia.instance.pickFromCamera(this, { code, path ->
                Log.d(MainActivity::class.java.simpleName, "code: %s, path: %s".format(code, path))
                Glide.with(this).load(path).into(imgPicture)
            })
        }
    }
}
