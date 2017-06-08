package pyxis.uzuki.live.richutilssample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pyxis.uzuki.live.richutilskt.*

class MiscActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var versionCode = versionCode()
        var versionName = versionName()

        var dip15 = dip(15)
        var sp12 = sp(12)
        var dip15f = dip(15f)
        var sp12f = sp(12f)

        var px2dip15 = px2dip(15)
        var px2sp12 = px2sp(12)

        var networkState = checkNetwork()
        var hash = getKeyHash()
    }
}
