@file:JvmName("RAsync")

package pyxis.uzuki.live.richutilskt.utils

import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Internal Use for RThread.runNaraeAsync
 * port and optimize for kotlin version of NaraeAsynchronous
 * Url: https://github.com/PyxisDev/NaraeAsynchronous
 */
internal class RAsync {
    internal var settingPoolSize = DEFAULT_POOL_SIZE
    internal var settingTaskType = DEFAULT_TASK_TYPE
    internal var bte = BackgroundThreadExecutor()

    @JvmOverloads fun execute( executeProcess: () -> Unit, poolSize: Int = settingPoolSize, taskType: String = settingTaskType) {
        bte = BackgroundThreadExecutor()
        bte.setTaskType(taskType)
        bte.setThreadPoolSize(poolSize)
        bte.execute({ executeProcess.invoke() })
    }

    companion object {
        private val DEFAULT_POOL_SIZE = Attributes.coresCount + 1
        private val DEFAULT_TASK_TYPE = "NaraeAsync_" + Attributes.randomTaskType
        @JvmStatic var instance: RAsync = RAsync()
    }

    interface BackgroundExecutor : Executor {
        fun setTaskType(taskType: String): BackgroundExecutor
        fun setThreadPoolSize(poolSize: Int): BackgroundExecutor
    }

    class BackgroundThreadExecutor : BackgroundExecutor {
        internal var settingTaskType: String = ""
        internal var settingPoolSize: Int = 0

        override fun setTaskType(taskType: String): BackgroundExecutor {
            settingTaskType = taskType
            return this
        }

        override fun setThreadPoolSize(poolSize: Int): BackgroundExecutor {
            settingPoolSize = poolSize
            return this
        }

        override fun execute(command: Runnable) {
            executor.execute(command)
        }

        private val executor: java.util.concurrent.Executor
            get() {
                val executorId = ExecutorId(settingPoolSize, settingTaskType)
                val lockObject = ""
                synchronized(lockObject) {
                    var executor: Executor? = BackgroundThreadExecutor.sCachedExecutors[executorId]

                    if (executor == null) {
                        executor = Executors.newFixedThreadPool(settingPoolSize)
                        BackgroundThreadExecutor.sCachedExecutors.put(executorId, executor)
                    }

                    return executor!!
                }
            }

        companion object {
            @JvmField val sCachedExecutors = java.util.HashMap<ExecutorId, Executor>()
        }
    }

    class ExecutorId(private val mThreadPoolSize: Int, private val mTaskType: String) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || javaClass != other.javaClass) return false
            val executorId = other as ExecutorId?
            return mThreadPoolSize == executorId!!.mThreadPoolSize && mTaskType == executorId.mTaskType
        }

        override fun hashCode(): Int {
            return 31 * mThreadPoolSize + mTaskType.hashCode()
        }
    }

    object Attributes {
        val coresCount: Int
            get() {
                class CpuFilter : java.io.FileFilter {
                    override fun accept(pathname: java.io.File): Boolean {
                        return java.util.regex.Pattern.matches("cpu[0-9]+", pathname.name)
                    }
                }

                return try {
                    val dir = java.io.File("/sys/devices/system/cpu/")
                    val files = dir.listFiles(CpuFilter())
                    files.size
                } catch (e: Exception) {
                    Math.max(1, Runtime.getRuntime().availableProcessors())
                }

            }

        var random = Random()

        val randomTaskType: String
            get() {
                val buffer = StringBuilder()
                val chars = "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z".split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                for (i in 0..4)
                    buffer.append(chars[random.nextInt(chars.size)])

                return buffer.toString()
            }

        val randomPoolSize: Int
            get() = random.nextInt(20)
    }
}