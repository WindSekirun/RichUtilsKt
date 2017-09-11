package pyxis.uzuki.live.richutilssample

import android.Manifest
import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.location.Location
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_location.*
import pyxis.uzuki.live.richutilskt.service.RLocationService
import pyxis.uzuki.live.richutilskt.utils.RPermission
import pyxis.uzuki.live.richutilskt.utils.asString
import java.util.*

@SuppressLint("SetTextI18n")
class LocationActivity : AppCompatActivity() {
    lateinit var locationService: RLocationService
    var mBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        txtLocation.text = "Ready for fetch... \nnow time is ${Calendar.getInstance().time.asString()}\n========================="

        val arrays: Array<String> = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
        val isGranted = RPermission.getInstance(this).checkPermission(array = arrays, callback = { _: Int, _: List<String> ->
            start()
        })

        if (isGranted) {
            start()
        }

    }

    private fun start() {
        val serviceIntent = Intent(applicationContext, RLocationService::class.java)
        startService(serviceIntent)
        bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE)
    }


    private fun init() {
        locationService.setLocationCallback({ location: Location ->
            txtLocation.text =
                    "${txtLocation.text} \n Location changed! -> \n lat: ${location.latitude}\n " +
                            "lng: ${location.longitude}\n provider: ${location.provider}\n " +
                            "time: ${Calendar.getInstance().time.asString()}"
        })

        if (locationService.currentBestLocation != null) {
            val location = locationService.currentBestLocation
            txtLocation.text =
                    "${txtLocation.text}\n Location fetch! -> \n lat: ${location?.latitude}\n " +
                            "lng: ${location?.longitude}\n provider: ${location?.provider}\n " +
                            "time: ${Calendar.getInstance().time.asString()}"
        } else {
            txtLocation.text = "${txtLocation.text}\nNot fetched..."
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mBound) {
            locationService.stopUpdates()
            unbindService(mConnection)
            mBound = false
        }
    }

    private val mConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as RLocationService.LocalBinder
            locationService = binder.service
            mBound = true
            println("service connected!")

            if (mBound)
                init()
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }
}