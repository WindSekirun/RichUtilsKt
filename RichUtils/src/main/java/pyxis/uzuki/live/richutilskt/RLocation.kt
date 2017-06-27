package pyxis.uzuki.live.richutilskt

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder

class RLocation : Service() {
    private var locationManager: LocationManager? = null
    private var isGPSEnabled = false
    private var isNetworkEnabled = false
    private var isGPSTrackingEnabled = false
    private var providerInfo: String = ""

    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate() {
        super.onCreate()
        getLocation()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        return START_STICKY
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        isGPSEnabled = (locationManager as LocationManager).isProviderEnabled(LocationManager.GPS_PROVIDER)
        isNetworkEnabled = (locationManager as LocationManager).isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (isGPSEnabled and isNetworkEnabled) {
            isGPSTrackingEnabled = true
            getBestMatchGPSLocation()
        } else if (isNetworkEnabled) {
            isGPSTrackingEnabled = true
            providerInfo = LocationManager.NETWORK_PROVIDER
        } else if (isGPSEnabled) {
            isGPSTrackingEnabled = true
            providerInfo = LocationManager.GPS_PROVIDER
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,  0.toFloat(),  locationListener)
    }


    private fun getBestMatchGPSLocation() {

    }

    object locationListener : LocationListener {
        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderEnabled(p0: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderDisabled(p0: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onLocationChanged(p0: Location?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}