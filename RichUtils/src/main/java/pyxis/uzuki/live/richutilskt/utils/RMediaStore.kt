@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import java.io.ByteArrayOutputStream

/**
 * RichUtilsKt
 * Class: RMediaStore
 * Created by pyxis on 18. 5. 14.
 *
 * Description:
 */

/**
 * create empty Uri in MediaStore
 *
 * @param context Context object
 * @param videoUri flag on kind of class. true - MediaStore.Video false - MediaStore.Images
 * @param internalStorage flag on saved at internal storage
 */
fun createUri(context: Context, videoUri: Boolean = false, internalStorage: Boolean = false): Uri {
    val uri = if (videoUri && internalStorage) MediaStore.Video.Media.INTERNAL_CONTENT_URI
    else if (videoUri) MediaStore.Video.Media.EXTERNAL_CONTENT_URI
    else if (!videoUri && internalStorage) MediaStore.Images.Media.INTERNAL_CONTENT_URI
    else MediaStore.Images.Media.EXTERNAL_CONTENT_URI

    return createUri(context, uri)
}

/**
 * create empty Uri in MediaStore
 *
 * @param context Context object
 * @param uri MediaStore Uri
 */
fun createUri(context: Context, uri: Uri): Uri {
    val cv = ContentValues()
    cv.put(MediaStore.Images.Media.TITLE, nowDateString())
    return context.contentResolver.insert(uri, cv)
}

/**
 * Insert Bitmap into MediaStore
 */
fun insertImage(context: Context, bitmap: Bitmap): Uri {
    val bytes = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
    val path = MediaStore.Images.Media.insertImage(context.contentResolver, bitmap, nowDateString(), null)
    return Uri.parse(path)
}