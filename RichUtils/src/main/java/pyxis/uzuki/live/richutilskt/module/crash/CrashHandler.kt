package pyxis.uzuki.live.richutilskt.module.crash

import android.annotation.SuppressLint
import android.os.Build
import pyxis.uzuki.live.richutilskt.module.crash.item.LogLevel
import pyxis.uzuki.live.richutilskt.module.crash.item.RichCrashModel
import pyxis.uzuki.live.richutilskt.utils.asDateString
import pyxis.uzuki.live.richutilskt.utils.tryCatch
import java.io.File
import java.util.*

/**
 * RichUtilsKt
 * Class: CrashConfig
 * Created by Pyxis on 2017-11-06.
 *
 * Description:
 */

internal class CrashHandler private constructor(private val crashConfig: CrashConfig) : Thread.UncaughtExceptionHandler {
    private var now: Calendar
    private lateinit var richCrashModel: RichCrashModel

    private val fileName: String
        get() = "crash_$timeForPrint.md"

    private val lineBreak: String
        get() = System.getProperty("line.separator")

    init {
        now = Calendar.getInstance()
    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        now = Calendar.getInstance()
        handleException(e)
    }

    private fun handleException(ex: Throwable?) {
        if (ex == null) {
            return
        }

        richCrashModel = generateRichCrashModel(ex)
        object : Thread() {
            override fun run() {
                saveLocal(writeLogIntoMarkdown())
            }
        }.start()
    }

    private fun saveLocal(message: String) {
        val fileName = fileName
        val file = File(crashConfig.logLocation, fileName)

        if (!file.exists()) {
            tryCatch {
                file.createNewFile()
                file.setWritable(java.lang.Boolean.TRUE)
            }
        }

        val messageBytes = message.toByteArray()
        file.writeBytes(messageBytes)

        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(10)
    }

    private fun generateRichCrashModel(ex: Throwable): RichCrashModel {
        val richCrashModel = RichCrashModel()
        richCrashModel.setConfig(crashConfig)
        richCrashModel.setDeviceInfo(Build())
        richCrashModel.setThrowable(ex)
        richCrashModel.setTime(now.time, crashConfig)
        return richCrashModel
    }

    @SuppressLint("InlinedApi")
    private fun writeLogIntoMarkdown(): String {
        val builder = StringBuilder()

        builder.append("## Crash Log in ")
                .append(richCrashModel.packageName)
                .append(lineBreak)
                .append("### Application Info")
                .append(lineBreak)
                .append("* Package Name: **")
                .append(richCrashModel.packageName)
                .append("**")
                .append(lineBreak)
                .append("* Version: **")
                .append(richCrashModel.versionStr)
                .append("**")
                .append(lineBreak)
                .append(lineBreak)

        if (crashConfig.isDisplayDeviceInfo) {
            builder.append("### Device Info")
                    .append(lineBreak)
                    .append("* Device: **")
                    .append(richCrashModel.modelStr)
                    .append(" (a.k.a ")
                    .append(richCrashModel.productStr)
                    .append(" or ")
                    .append(richCrashModel.deviceStr)
                    .append(")**")
                    .append(lineBreak)
                    .append("* Version: **")
                    .append(richCrashModel.sdkStr)
                    .append(" (")
                    .append(richCrashModel.sdkNum)
                    .append(")**")
                    .append(lineBreak)
                    .append("* Manufacturer: **")
                    .append(richCrashModel.manufacturerStr)
                    .append("**")
                    .append(lineBreak)
                    .append(lineBreak)
        }

        builder.append("### Crash Info")
                .append(lineBreak)
                .append("* When: **")
                .append(richCrashModel.timeStr)
                .append("**")
                .append(lineBreak)
                .append("* Message: **")
                .append(richCrashModel.message)
                .append("**")
                .append(lineBreak)
                .append("* Localized Message: **")
                .append(richCrashModel.localizedMessage)
                .append("**")
                .append(lineBreak)
                .append(lineBreak)

        if (crashConfig.logLevel === LogLevel.STACKTRACE) {
            builder.append("#### Stack Trace")
                    .append(lineBreak)
                    .append("````")
                    .append(lineBreak)
                    .append(richCrashModel.stackTrace)
                    .append("````")
                    .append(lineBreak)
                    .append(lineBreak)
        }

        return builder.toString()
    }

    companion object {
        private var instance: CrashHandler? = null

        fun getInstance(config: CrashConfig): CrashHandler {
            if (instance == null)
                instance = CrashHandler(config)

            return instance as CrashHandler
        }

        private val timeForPrint: String
            get() = System.currentTimeMillis().asDateString("yyyyMMddHHmmss")
    }
}