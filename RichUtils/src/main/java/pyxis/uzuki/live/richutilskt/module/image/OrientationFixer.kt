package pyxis.uzuki.live.richutilskt.module.image

import android.content.Context
import android.graphics.BitmapFactory
import pyxis.uzuki.live.richutilskt.utils.*
import java.io.File

/**
 * RichUtilsKt
 * Class: OrientationFixer
 * Created by pyxis on 18. 5. 14.
 *
 * Description:
 */
object OrientationFixer {
    @JvmStatic
    fun execute(path: String, context: Context) = execute(path.toFile(), context)

    /**
     * execute OrientationFixer to fix orientation with detection
     */
    @JvmStatic
    fun execute(file: File, context: Context): String {
        val orientation = getPhotoOrientationDegree(file.absolutePath)
        if (orientation == 0) {
            return file.absolutePath
        }

        var bitmap = BitmapFactory.decodeFile(file.absolutePath)
        bitmap = rotate(bitmap, orientation)
        val newFile: File = context.saveBitmapToFile(bitmap) ?: file
        context.requestMediaScanner(newFile.absolutePath)

        if (!bitmap.isRecycled) {
            bitmap.recycle()
        }

        return newFile.absolutePath
    }
}