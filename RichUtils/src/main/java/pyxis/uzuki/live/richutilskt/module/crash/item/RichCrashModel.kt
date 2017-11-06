package pyxis.uzuki.live.richutilskt.module.crash.item

import android.icu.text.SimpleDateFormat
import android.os.Build

import com.github.windsekirun.richcrashcollector.CrashConfig

import java.io.PrintWriter
import java.io.Serializable
import java.io.StringWriter
import java.io.Writer
import java.util.Date

/**
 * RichCrashCollector
 * RichCrashModel
 * Created by DonggilSeo on 2017-03-20.
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

        try {
            val cause = ex.cause
            cause.printStackTrace(printWriter)
        } catch (e: NullPointerException) {
        } finally {
            printWriter.close()
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
        this.packageName = config.getPackageName()
        this.versionStr = config.getVersionStr()
    }

    fun setTime(date: Date, crashConfig: CrashConfig) {
        val dateFormat = SimpleDateFormat(crashConfig.getTimeFormat())
        this.timeStr = dateFormat.format(date)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as RichCrashModel?

        if (sdkNum != that!!.sdkNum) return false
        if (if (packageName != null) packageName != that.packageName else that.packageName != null)
            return false
        if (if (versionStr != null) versionStr != that.versionStr else that.versionStr != null)
            return false
        if (if (modelStr != null) modelStr != that.modelStr else that.modelStr != null)
            return false
        if (if (productStr != null) productStr != that.productStr else that.productStr != null)
            return false
        if (if (deviceStr != null) deviceStr != that.deviceStr else that.deviceStr != null)
            return false
        if (if (sdkStr != null) sdkStr != that.sdkStr else that.sdkStr != null)
            return false
        if (if (manufacturerStr != null) manufacturerStr != that.manufacturerStr else that.manufacturerStr != null)
            return false
        if (if (timeStr != null) timeStr != that.timeStr else that.timeStr != null)
            return false
        if (if (message != null) message != that.message else that.message != null)
            return false
        if (if (localizedMessage != null) localizedMessage != that.localizedMessage else that.localizedMessage != null)
            return false
        return if (stackTrace != null) stackTrace == that.stackTrace else that.stackTrace == null

    }

    override fun hashCode(): Int {
        var result = if (packageName != null) packageName!!.hashCode() else 0
        result = 31 * result + if (versionStr != null) versionStr!!.hashCode() else 0
        result = 31 * result + if (modelStr != null) modelStr!!.hashCode() else 0
        result = 31 * result + if (productStr != null) productStr!!.hashCode() else 0
        result = 31 * result + if (deviceStr != null) deviceStr!!.hashCode() else 0
        result = 31 * result + if (sdkStr != null) sdkStr!!.hashCode() else 0
        result = 31 * result + sdkNum
        result = 31 * result + if (manufacturerStr != null) manufacturerStr!!.hashCode() else 0
        result = 31 * result + if (timeStr != null) timeStr!!.hashCode() else 0
        result = 31 * result + if (message != null) message!!.hashCode() else 0
        result = 31 * result + if (localizedMessage != null) localizedMessage!!.hashCode() else 0
        result = 31 * result + if (stackTrace != null) stackTrace!!.hashCode() else 0
        return result
    }

    override fun toString(): String {
        return "RichCrashModel{" +
                "packageName='" + packageName + '\'' +
                ", versionStr='" + versionStr + '\'' +
                ", modelStr='" + modelStr + '\'' +
                ", productStr='" + productStr + '\'' +
                ", deviceStr='" + deviceStr + '\'' +
                ", sdkStr='" + sdkStr + '\'' +
                ", sdkNum=" + sdkNum +
                ", manufacturerStr='" + manufacturerStr + '\'' +
                ", timeStr='" + timeStr + '\'' +
                ", message='" + message + '\'' +
                ", localizedMessage='" + localizedMessage + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                '}'
    }

    companion object {
        private const val serialVersionUID = 44612820179919067L
    }
}
