package pyxis.uzuki.live.richutilssample

import android.app.Application
import pyxis.uzuki.live.richutilskt.utils.initializeFontEngine

/**
 * Created by pyxis on 2017. 7. 13..
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeFontEngine()
    }
}