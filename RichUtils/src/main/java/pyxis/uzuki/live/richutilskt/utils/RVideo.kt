@file:JvmName("RichUtils")
@file:JvmMultifileClass

package pyxis.uzuki.live.richutilskt.utils

import android.media.MediaMetadataRetriever

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
