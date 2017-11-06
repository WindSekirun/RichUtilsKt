package pyxis.uzuki.live.richutilskt.module.crash.item

import android.annotation.SuppressLint
import android.os.Build
import pyxis.uzuki.live.richutilskt.module.crash.CrashConfig
import java.io.PrintWriter
import java.io.Serializable
import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.*

/**
 * RichUtilsKt
 * Class: CrashConfig
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */

class RichCrashModel : Serializable, Cloneable {
    var packageName: String? = null
        private set
    var versionStr: String? = null
        private set
    var modelStr: String? = null
        private set
    var productStr: String? = null
        private set
    var deviceStr: String? = null
        private set
    var sdkStr: String? = null
        private set
    var sdkNum: Int = 0
        private set
    var manufacturerStr: String? = null
        private set
    var timeStr: String? = null
        private set
    var message: String? = null
        private set
    var localizedMessage: String? = null
        private set
    var stackTrace: String? = null
        private set

    fun setThrowable(ex: Throwable) {
        val result = StringWriter()
        val printWriter = PrintWriter(result)
        ex.printStackTrace(printWriter)

        printWriter.use {
            val cause = ex.cause
            cause?.printStackTrace(it)
        }

        this.message = ex.message
        this.localizedMessage = ex.localizedMessage
        this.stackTrace = result.toString()
    }

    fun setDeviceInfo(build: Build) {
        this.modelStr = Build.MODEL
        this.productStr = Build.PRODUCT
        this.deviceStr = Build.DEVICE
        this.sdkStr = Build.VERSION.SDK
        this.sdkNum = Build.VERSION.SDK_INT
        this.manufacturerStr = Build.MANUFACTURER
    }

    fun setConfig(config: CrashConfig) {
        this.packageName = config.packageName
        this.versionStr = config.versionStr
    }

    @SuppressLint("SimpleDateFormat")
    fun setTime(date: Date, crashConfig: CrashConfig) {
        val dateFormat = SimpleDateFormat(crashConfig.timeFormat)
        this.timeStr = dateFormat.format(date)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RichCrashModel

        if (packageName != other.packageName) return false
        if (versionStr != other.versionStr) return false
        if (modelStr != other.modelStr) return false
        if (productStr != other.productStr) return false
        if (deviceStr != other.deviceStr) return false
        if (sdkStr != other.sdkStr) return false
        if (sdkNum != other.sdkNum) return false
        if (manufacturerStr != other.manufacturerStr) return false
        if (timeStr != other.timeStr) return false
        if (message != other.message) return false
        if (localizedMessage != other.localizedMessage) return false
        if (stackTrace != other.stackTrace) return false

        return true
    }

    override fun hashCode(): Int {
        var result = packageName?.hashCode() ?: 0
        result = 31 * result + (versionStr?.hashCode() ?: 0)
        result = 31 * result + (modelStr?.hashCode() ?: 0)
        result = 31 * result + (productStr?.hashCode() ?: 0)
        result = 31 * result + (deviceStr?.hashCode() ?: 0)
        result = 31 * result + (sdkStr?.hashCode() ?: 0)
        result = 31 * result + sdkNum
        result = 31 * result + (manufacturerStr?.hashCode() ?: 0)
        result = 31 * result + (timeStr?.hashCode() ?: 0)
        result = 31 * result + (message?.hashCode() ?: 0)
        result = 31 * result + (localizedMessage?.hashCode() ?: 0)
        result = 31 * result + (stackTrace?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "RichCrashModel(packageName=$packageName, versionStr=$versionStr, modelStr=$modelStr, productStr=$productStr, " +
                "deviceStr=$deviceStr, sdkStr=$sdkStr, sdkNum=$sdkNum, manufacturerStr=$manufacturerStr, timeStr=$timeStr, " +
                "message=$message, localizedMessage=$localizedMessage, stackTrace=$stackTrace)"
    }

}
