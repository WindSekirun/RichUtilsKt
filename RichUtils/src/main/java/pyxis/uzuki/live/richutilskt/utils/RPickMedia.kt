@file:JvmName("RPickMedia")

package pyxis.uzuki.live.richutilskt.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import pyxis.uzuki.live.richutilskt.impl.F2
import java.io.File


class RPickMedia private constructor() {
    private var mInternalStorage: Boolean = false;
    private val PERMISSION_ARRAY = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)

    private fun getActivity(context: Context): FragmentActivity? {
        var c = context

        while (c is ContextWrapper) {
            if (c is FragmentActivity) {
                return c
            }
            c = c.baseContext
        }
        return null
    }

    private fun Context.requestPermission(listener: (Boolean) -> Unit) {
        RPermission.instance.checkPermission(this, PERMISSION_ARRAY, { code, _ ->
            listener.invoke(code == RPermission.PERMISSION_GRANTED)
        })
    }

    /**
     * enable internal storage mode
     *
     * @param [isInternal] capture Image/Video in internal storage
     */
    fun setInternalStorage(isInternal: Boolean) {
        mInternalStorage = isInternal
    }

    /**
     * pick image from Camera
     *
     * @param[callback] callback
     */
    fun pickFromCamera(context: Context, callback: (Int, String) -> Unit) {
        context.requestPermission {
            if (!it) {
                callback.invoke(PICK_FAILED, "")
                return@requestPermission
            }

            requestPhotoPick(context, PICK_FROM_CAMERA, callback)
        }

    }

    /**
     * pick image from Camera
     *
     * @param[callback] callback
     */
    fun pickFromCamera(context: Context, callback: F2<Int, String>?) {
        context.requestPermission {
            if (!it) {
                callback?.invoke(PICK_FAILED, "")
                return@requestPermission
            }

            requestPhotoPick(context, PICK_FROM_CAMERA, { code, uri -> callback?.invoke(code, uri) })
        }
    }

    /**
     * pick image from Gallery
     *
     * @param[callback] callback
     */
    fun pickFromGallery(context: Context, callback: (Int, String) -> Unit) {
        context.requestPermission {
            if (!it) {
                callback.invoke(PICK_FAILED, "")
                return@requestPermission
            }

            requestPhotoPick(context, PICK_FROM_GALLERY, callback)
        }
    }

    /**
     * pick image from Gallery
     *
     * @param[callback] callback
     */
    fun pickFromGallery(context: Context, callback: F2<Int, String>?) {
        context.requestPermission {
            if (!it) {
                callback?.invoke(PICK_FAILED, "")
                return@requestPermission
            }

            requestPhotoPick(context, PICK_FROM_GALLERY, { code, uri -> callback?.invoke(code, uri) })
        }
    }

    /**
     * pick image from Video
     *
     * @param[callback] callback
     */
    fun pickFromVideo(context: Context, callback: (Int, String) -> Unit) {
        context.requestPermission {
            if (!it) {
                callback.invoke(PICK_FAILED, "")
                return@requestPermission
            }

            requestPhotoPick(context, PICK_FROM_VIDEO, callback)
        }
    }

    /**
     * pick image from Video
     *
     * @param[callback] callback
     */
    fun pickFromVideo(context: Context, callback: F2<Int, String>?) {
        context.requestPermission {
            if (!it) {
                callback?.invoke(PICK_FAILED, "")
                return@requestPermission
            }

            requestPhotoPick(context, PICK_FROM_VIDEO, { code, uri -> callback?.invoke(code, uri) })
        }
    }

    /**
     * pick image from Camera (Video Mode)
     *
     * @param[callback] callback
     */
    fun pickFromVideoCamera(context: Context, callback: (Int, String) -> Unit) {
        context.requestPermission {
            if (!it) {
                callback.invoke(PICK_FAILED, "")
                return@requestPermission
            }

            requestPhotoPick(context, PICK_FROM_CAMERA_VIDEO, callback)
        }
    }

    /**
     * pick image from Camera (Video Mode)
     *
     * @param[callback] callback
     */
    fun pickFromVideoCamera(context: Context, callback: F2<Int, String>?) {
        context.requestPermission {
            if (!it) {
                callback?.invoke(PICK_FAILED, "")
                return@requestPermission
            }

            requestPhotoPick(context, PICK_FROM_CAMERA_VIDEO, { code, uri -> callback?.invoke(code, uri) })
        }
    }

    private var currentPhotoPath: String? = null
    private var currentVideoPath: String? = null

    @SuppressLint("ValidFragment")
    private fun requestPhotoPick(context: Context, pickType: Int, callback: (Int, String) -> Unit) {

        val fm = getActivity(context)?.supportFragmentManager

        val intent = Intent()

        when (pickType) {
            PICK_FROM_CAMERA -> {
                intent.action = MediaStore.ACTION_IMAGE_CAPTURE
                val captureUri = createUri(context, false, mInternalStorage)
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
                val captureUri = createUri(context, true, mInternalStorage)
                currentVideoPath = captureUri.toString()
                intent.putExtra(MediaStore.EXTRA_OUTPUT, captureUri)
            }
        }

        val fragment = ResultFragment(fm as FragmentManager, callback, currentPhotoPath
                ?: "", currentVideoPath ?: "")

        fm.beginTransaction().add(fragment, "FRAGMENT_TAG").commitAllowingStateLoss()
        fm.executePendingTransactions()

        fragment.startActivityForResult(intent, pickType)
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
            if (callback == null) {
                return
            }

            val callback = callback!! // implicit cast to non-null cause checking pre-processing

            if (resultCode != Activity.RESULT_OK || context == null) {
                callback.invoke(PICK_FAILED, "")
                return
            }

            val context = context!! // implicit cast to non-null cause checking pre-processing
            var realPath: String? = ""

            if (requestCode == PICK_FROM_CAMERA) {
                val uri = Uri.parse(currentPhotoPath)
                realPath = uri getRealPath context
            } else if (requestCode == PICK_FROM_CAMERA_VIDEO && data != null && data.data != null) {
                realPath = data.data.getRealPath(context)
                if (realPath.isEmpty()) {
                    realPath = Uri.parse(currentVideoPath) getRealPath context
                }
            } else if (requestCode == PICK_FROM_CAMERA_VIDEO) {
                realPath = Uri.parse(currentVideoPath) getRealPath context
            } else if (data != null && data.data != null) {
                realPath = data.data.getRealPath(context)
            }

            if (realPath?.isEmpty() != false) {
                callback.invoke(PICK_FAILED, "")
                return
            }

            callback.invoke(PICK_SUCCESS, realPath)
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