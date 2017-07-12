package pyxis.uzuki.live.richutilskt.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class CloseDetectorService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onTaskRemoved(rootIntent: Intent) {
        println("onTaskRemoved called")

        super.onTaskRemoved(rootIntent)
        this.stopSelf()
    }
}