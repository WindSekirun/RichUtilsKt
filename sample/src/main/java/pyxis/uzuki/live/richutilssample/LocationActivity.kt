package pyxis.uzuki.live.richutilssample

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import pyxis.uzuki.live.richutilskt.service.RLocationService
import pyxis.uzuki.live.richutilskt.service.RLocationService.LocalBinder

class LocationActivity : AppCompatActivity() {
    var locationService: RLocationService? = null
    var mBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        val intent = Intent(this, RLocationService::class.java)
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStart() {
        super.onStart()

        init()
    }

    private fun init() {

    }

    private val mConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as LocalBinder
            locationService = binder.service
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }
}