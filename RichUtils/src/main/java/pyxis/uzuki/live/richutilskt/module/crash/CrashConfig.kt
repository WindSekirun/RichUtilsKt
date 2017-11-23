package pyxis.uzuki.live.richutilskt.module.crash

import android.content.Context
import pyxis.uzuki.live.richutilskt.module.crash.item.LogLevel

/**
 * RichUtilsKt
 * Class: CrashConfig
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */
class CrashConfig private constructor(builder: Builder) {
    val isDisplayDeviceInfo: Boolean
    val logLevel: LogLevel
    val timeFormat: String
    val versionStr: String
    val packageName: String
    val logLocation: String?

    init {
        this.isDisplayDeviceInfo = builder.displayDeviceInfo
        this.logLevel = builder.logLevel
        this.timeFormat = builder.timeFormat
        this.packageName = builder.packageName
        this.versionStr = builder.versionStr
        this.logLocation = builder.logLocation
    }

    class Builder {
        var displayDeviceInfo = true
        var logLevel = LogLevel.NONE
        var timeFormat = "yyyy-MM-dd (E) a hh:mm:ss.SSS"
        var packageName = "pyxis.uzuki.live.richutilskt"
        var versionStr = "1.0.0(1)"
        var logLocation: String? = null

        fun setDisplayDeviceInfo(displayDeviceInfo: Boolean): Builder {
            this.displayDeviceInfo = displayDeviceInfo
            return this
        }

        fun setLogLevel(logLevel: LogLevel): Builder {
            this.logLevel = logLevel
            return this
        }

        fun setTimeFormat(timeFormat: String): Builder {
            this.timeFormat = timeFormat
            return this
        }

        fun setPackageName(packageName: String): Builder {
            this.packageName = packageName
            return this
        }

        fun setVersionStr(versionStr: String): Builder {
            this.versionStr = versionStr
            return this
        }

        fun setLogLocation(logLocation: String): Builder {
            this.logLocation = logLocation
            return this
        }

        fun build(context: Context): CrashConfig {
            if (logLocation == null)
                logLocation = context.getExternalFilesDir("crash")!!.toString()

            return CrashConfig(this)
        }
    }
}

