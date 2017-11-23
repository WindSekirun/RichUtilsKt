package pyxis.uzuki.live.richutilskt.demo

import android.app.Application
import pyxis.uzuki.live.richutilskt.RichUtilsGlobal
import pyxis.uzuki.live.richutilskt.module.crash.CrashCollector

/**
 * RichUtilsKt1
 * Class: MainApplication
 * Created by pyxis on 19/11/2017.
 *
 * Description:
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrashCollector.initCrashCollector(this)
        RichUtilsGlobal.initializeApplication(this)
    }
}