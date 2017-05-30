package pyxis.uzuki.live.richutilssample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pyxis.uzuki.live.richutilskt.dip

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dip5 = dip(5)
        println(dip5)
    }
}
