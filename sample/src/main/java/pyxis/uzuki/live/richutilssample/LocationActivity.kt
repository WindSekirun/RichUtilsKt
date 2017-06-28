package pyxis.uzuki.live.richutilssample

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
import pyxis.uzuki.live.richutilskt.service.RLocationService.LocalBinder
import pyxis.uzuki.live.richutilskt.utils.asString
import java.util.*

class LocationActivity : AppCompatActivity() {
    var locationService: RLocationService? = null
    var mBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        txtLocation.text = "Not fetched..."

        val intent = Intent(this, RLocationService::class.java)
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }

    @SuppressLint("SetTextI18n")
    private fun init() {
        locationService?.setLocationCallback({ location:Location ->
            txtLocation.text =
                    "${txtLocation.text} \n Location changed! -> \n lat: ${location.latitude}\n " +
                            "lng: ${location.longitude}\n provider: ${location.provider}\n time: ${Calendar.getInstance().time.asString()}"
        })

        if (locationService?.currentBestLocation != null) {
            val location = locationService?.currentBestLocation
            txtLocation.text =
                    "Location fetch! -> \n lat: ${location?.latitude}\n " +
                            "lng: ${location?.longitude}\n provider: ${location?.provider}\n time: ${Calendar.getInstance().time.asString()}"
        } else {
            txtLocation.text = "Not fetched..."
        }
    }

    private val mConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as LocalBinder
            locationService = binder.service
            mBound = true

            if (mBound && locationService != null)
                init()
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }
}