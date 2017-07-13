package pyxis.uzuki.live.richutilssample

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_misc.*
import pyxis.uzuki.live.richutilskt.utils.*

class MiscActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misc)

        val versionCode = versionCode()
        val versionName = versionName()

        val dip15 = dip2px(15)
        val sp12: Int = sp2px(12)
        val dip15f = dip2px(15f)
        val sp12f = sp2px(12f)

        val px2dip15 = px2dip(15)
        val px2sp12 = px2sp(12)

        val networkState = checkNetwork()
        val hash = getKeyHash()

        txtResult.text = "versionCode $versionCode, versionName $versionName, dip15 $dip15, sp12 $sp12," +
                "dip15f $dip15f, sp12f $sp12f, px2dip15 $px2dip15, px2sp12 $px2sp12, networkState $networkState, hash $hash"

        applyUnReadCount(5)

    }

}
