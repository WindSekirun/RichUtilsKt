@file:JvmName("RPickMedia")

package pyxis.uzuki.live.richutilskt.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.content.ContentValues
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import pyxis.uzuki.live.richutilskt.impl.F2
import java.text.SimpleDateFormat
import java.util.*

class RPickMedia private constructor() {
    private var IMAGE_CONTENT_URL = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    private var VIDEO_CONTENT_URL = MediaStore.Video.Media.EXTERNAL_CONTENT_URI

    private fun getActivity(context: Context): Activity? {
        var c = context

        while (c is ContextWrapper) {
            if (c is Activity) {
                return c
            }
            c = c.baseContext
        }
        return null
    }

    /**
     * enable internal storage mode
     *
     * @param [isInternal] capture Image/Video in internal storage
     */
    fun setInternalStorage(isInternal: Boolean) {
        if (isInternal) {
            IMAGE_CONTENT_URL = MediaStore.Images.Media.INTERNAL_CONTENT_URI
            VIDEO_CONTENT_URL = MediaStore.Video.Media.INTERNAL_CONTENT_URI
        } else {
            IMAGE_CONTENT_URL = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            VIDEO_CONTENT_URL = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        }
    }

    /**
     * pick image from Camera
     *
     * @param[callback] callback
     */
    fun pickFromCamera(context: Context, callback: (Int, String) -> Unit) = requestPhotoPick(context, PICK_FROM_CAMERA, callback)

    /**
     * pick image from Camera
     *
     * @param[callback] callback
     */
    fun pickFromCamera(context: Context, callback: F2<Int, String>?) = requestPhotoPick(context, PICK_FROM_CAMERA, { code, uri -> callback?.invoke(code, uri) })

    /**
     * pick image from Gallery
     *
     * @param[callback] callback
     */
    fun pickFromGallery(context: Context, callback: (Int, String) -> Unit) = requestPhotoPick(context, PICK_FROM_GALLERY, callback)

    /**
     * pick image from Gallery
     *
     * @param[callback] callback
     */
    fun pickFromGallery(context: Context, callback: F2<Int, String>?) = requestPhotoPick(context, PICK_FROM_GALLERY, {code, uri -> callback?.invoke(code, uri)})

    /**
     * pick image from Video
     *
     * @param[callback] callback
     */
    fun pickFromVideo(context: Context, callback: (Int, String) -> Unit) = requestPhotoPick(context, PICK_FROM_VIDEO, callback)

    /**
     * pick image from Video
     *
     * @param[callback] callback
     */
    fun pickFromVideo(context: Context, callback: F2<Int, String>?) = requestPhotoPick(context, PICK_FROM_VIDEO, {code, uri -> callback?.invoke(code, uri)})

    /**
     * pick image from Camera (Video Mode)
     *
     * @param[callback] callback
     */
    fun pickFromVideoCamera(context: Context, callback: (Int, String) -> Unit) = requestPhotoPick(context, PICK_FROM_CAMERA_VIDEO, callback)

    /**
     * pick image from Camera (Video Mode)
     *
     * @param[callback] callback
     */
    fun pickFromVideoCamera(context: Context, callback: F2<Int, String>?) = requestPhotoPick(context, PICK_FROM_CAMERA_VIDEO, {code, uri -> callback?.invoke(code, uri)})

    private var currentPhotoPath: String? = null
    private var currentVideoPath: String? = null

    @SuppressLint("ValidFragment")
    private fun requestPhotoPick(context: Context, pickType: Int, callback: (Int, String) -> Unit) {

        val fm = getActivity(context)?.fragmentManager

        val intent = Intent()

        when (pickType) {
            PICK_FROM_CAMERA -> {
                intent.action = MediaStore.ACTION_IMAGE_CAPTURE
                val captureUri = createImageUri(context)
                currentPhotoPath = captureUri.toString()
                intent.putExtra(MediaStore.EXTRA_OUTPUT, captureUri)
            }

            PICK_FROM_GALLERY -> {
                intent.action = Intent.ACTION_PICK
                intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
            }

            PICK_FROM_VIDEO -> {
                intent.action = Intent.ACTION_PICK
                intent.type = android.provider.MediaStore.Video.Media.CONTENT_TYPE
            }

            PICK_FROM_CAMERA_VIDEO -> {
                intent.action = MediaStore.ACTION_VIDEO_CAPTURE
                val captureUri = createVideoUri(context)
                currentVideoPath = captureUri.toString()
                intent.putExtra(MediaStore.EXTRA_OUTPUT, captureUri)
            }
        }

        val fragment = ResultFragment(fm as FragmentManager, callback, currentPhotoPath ?: "", currentVideoPath ?: "")

        fm.beginTransaction().add(fragment, "FRAGMENT_TAG").commitAllowingStateLoss()
        fm.executePendingTransactions()

        fragment.startActivityForResult(intent, pickType)
    }

    private fun createImageUri(context: Context): Uri {
        val contentResolver = context.contentResolver
        val cv = ContentValues()
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        cv.put(MediaStore.Images.Media.TITLE, timeStamp)
        return contentResolver.insert(IMAGE_CONTENT_URL, cv)
    }

    private fun createVideoUri(context: Context): Uri {
        val contentResolver = context.contentResolver
        val cv = ContentValues()
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        cv.put(MediaStore.Images.Media.TITLE, timeStamp)
        return contentResolver.insert(VIDEO_CONTENT_URL, cv)
    }

    @SuppressLint("ValidFragment")
    class ResultFragment() : Fragment() {
        var fm: FragmentManager? = null
        var callback: ((Int, String) -> Unit)? = null
        var currentPhotoPath = ""
        var currentVideoPath = ""

        constructor(fm: FragmentManager, callback: (Int, String) -> Unit, currentPhotoPath: String, currentVideoPath: String) : this() {
            this.fm = fm
            this.callback = callback
            this.currentPhotoPath = currentPhotoPath
            this.currentVideoPath = currentVideoPath
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            when (requestCode) {
                PICK_FROM_CAMERA ->
                    if (resultCode == Activity.RESULT_OK) {
                        currentPhotoPath.let { callback?.invoke(PICK_SUCCESS, Uri.parse(it) getRealPath (activity)) }
                    } else {
                        callback?.invoke(PICK_FAILED, "")
                    }

                PICK_FROM_GALLERY ->
                    if (resultCode == Activity.RESULT_OK) {
                        callback?.invoke(PICK_SUCCESS, data?.data?.getRealPath((activity)) as String)
                    } else {
                        callback?.invoke(PICK_FAILED, "")
                    }

                PICK_FROM_VIDEO ->
                    if (resultCode == Activity.RESULT_OK) {
                        callback?.invoke(PICK_SUCCESS, data?.data?.getRealPath((activity)) as String)
                    } else {
                        callback?.invoke(PICK_FAILED, "")
                    }

                PICK_FROM_CAMERA_VIDEO ->
                    if (resultCode == Activity.RESULT_OK) {
                        var path = data?.data?.getRealPath(activity) as String
                        if (path.isEmpty()) {
                            path = currentVideoPath
                        }

                        path.let {
                            callback?.invoke(PICK_SUCCESS, path)
                        }
                    } else {
                        callback?.invoke(PICK_FAILED, "")
                    }
            }

            fm?.beginTransaction()?.remove(this)?.commit()
        }
    }

    companion object {
        @JvmField
        var instance: RPickMedia = RPickMedia()

        val PICK_FROM_CAMERA = 0
        val PICK_FROM_GALLERY = 1
        val PICK_FROM_VIDEO = 2
        val PICK_FROM_CAMERA_VIDEO = 3

        @JvmField
        val PICK_SUCCESS = 1
        @JvmField
        val PICK_FAILED = 0
    }

}