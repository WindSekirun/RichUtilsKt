@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.content.Context
import android.database.Cursor
import android.media.MediaMetadataRetriever
import android.provider.MediaStore

/**
 * get Width of Video which given String
 *
 * @return Width of Video
 */
fun String.getVideoWidth(): Int {
    val retriever = MediaMetadataRetriever()
    retriever.setDataSource(this)
    val width = Integer.valueOf(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH))
    retriever.release()
    return width
}

/**
 * get Height of Video which given String
 *
 * @return Height of Video
 */
fun String.getVideoHeight(): Int {
    val retriever = MediaMetadataRetriever()
    retriever.setDataSource(this)
    val height = Integer.valueOf(retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT))
    retriever.release()
    return height
}

/**
 * get id from MediaStore.Video with given [videoPath]
 */
fun Context.getVideoFileId(videoPath: String): String {
    val projection = arrayOf(MediaStore.Video.Media._ID)
    val where = MediaStore.Video.Media.DATA + "=?"
    val cursor = queryVideo(videoPath, projection, where)

    return cursor?.use { it.getString(0) } ?: ""
}

/**
 * get Path of Thumbnail from MediaStore.Video with given [videoId]
 *
 * you can get videoId from Context.getVideoFileId()
 *
 * @param context Context object
 * @param videoId Video ID
 */
fun Context.getVideoThumbsPath(videoId: String): String {
    MediaStore.Video.Thumbnails.getThumbnail(contentResolver, videoId.toLong(),
            MediaStore.Video.Thumbnails.MINI_KIND, null)
    val projection = arrayOf(MediaStore.Video.Thumbnails.DATA)
    val where = MediaStore.Video.Thumbnails.VIDEO_ID + "=?"
    val cursor = queryVideo(videoId, projection, where)

    return cursor?.use { it.getString(0) } ?: ""
}

/**
 * get Duration of Video from MediaStore.Video with given [videoId]
 *
 * you can get videoId from Context.getVideoFileId()
 *
 * @param context Context object
 * @param videoId Video ID
 */
fun Context.getVideoDuration(videoId: String): Long {
    val projection = arrayOf(MediaStore.Video.VideoColumns.DURATION)
    val where = MediaStore.Video.VideoColumns._ID + "=?"
    val cursor = queryVideo(videoId, projection, where)

    return cursor?.use { it.getLong(0) } ?: 0
}

private fun Context.queryVideo(args: String, projection: Array<String>, where: String): Cursor? {
    val uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
    val whereArgs = arrayOf(args)
    val cursor = contentResolver.query(uri, projection, where, whereArgs, null)

    if (cursor == null || !cursor.moveToFirst()) {
        return null
    }

    return cursor
}