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
import java.text.SimpleDateFormat
import java.util.*

class RPickMedia private constructor(private var context: Context) {

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
     * pick image from Camera
     *
     * @param[callback] callback, should make class PickMediaCallback : PickMediaCallback
     * @since 1.0.1
     */
    fun pickFromCamera(callback: (Int, String) -> Unit) = requestPhotoPick(context, PICK_FROM_CAMERA, callback)

    /**
     * pick image from Gallery
     *
     * @param[callback] callback, should make class PickMediaCallback : PickMediaCallback
     * @since 1.0.1
     */
    fun pickFromGallery(callback: (Int, String) -> Unit) = requestPhotoPick(context, PICK_FROM_GALLERY, callback)

    /**
     * pick image from Video
     *
     * @param[callback] callback, should make class PickMediaCallback : PickMediaCallback
     * @since 1.0.1
     */
    fun pickFromVideo(callback: (Int, String) -> Unit) = requestPhotoPick(context, PICK_FROM_VIDEO, callback)

    /**
     * pick image from Camera (Video Mode)
     *
     * @param[callback] callback, should make class PickMediaCallback : PickMediaCallback
     * @since 1.0.1
     */
    fun pickFromVideoCamera(callback: (Int, String) -> Unit) = requestPhotoPick(context, PICK_FROM_CAMERA_VIDEO, callback)

    private var currentPhotoPath: String? = null
    private var currentVideoPath: String? = null

    @SuppressLint("ValidFragment")
    private fun requestPhotoPick(context: Context, pickType: Int, callback: (Int, String) -> Unit) {

        val fm = getActivity(context)!!.fragmentManager
        val f = ResultFragment(fm, callback)

        fm.beginTransaction().add(f, "FRAGMENT_TAG").commit()
        fm.executePendingTransactions()


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                        ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
            f.requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), pickType)
            return
        }

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

        f.startActivityForResult(intent, pickType)
    }

    private fun createImageUri(context: Context): Uri {
        val contentResolver = context.contentResolver
        val cv = ContentValues()
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        cv.put(MediaStore.Images.Media.TITLE, timeStamp)
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cv)
    }

    private fun createVideoUri(context: Context): Uri {
        val contentResolver = context.contentResolver
        val cv = ContentValues()
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        cv.put(MediaStore.Images.Media.TITLE, timeStamp)
        return contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, cv)
    }

    @SuppressLint("ValidFragment")
    inner class ResultFragment(private val fm: FragmentManager, private val callback: (Int, String) -> Unit) : Fragment() {

        fun ResultFragment() {
        }

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)

            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                requestPhotoPick(activity, requestCode, callback)
            } else {
                callback(PICK_FAILED, "")
            }

            fm.beginTransaction().remove(this).commit()

        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
            super.onActivityResult(requestCode, resultCode, data)
            when (requestCode) {
                PICK_FROM_CAMERA ->

                    if (resultCode == Activity.RESULT_OK) {
                        currentPhotoPath?.let { callback(PICK_SUCCESS, it) }
                    }

                PICK_FROM_GALLERY ->

                    if (resultCode == Activity.RESULT_OK) {
                        val cursor = activity.contentResolver.query(data.data, null, null, null, null)
                        if (cursor!!.moveToNext()) {

                            val path = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA))
                            cursor.close()

                            callback(PICK_SUCCESS, path)
                        }

                    }

                PICK_FROM_VIDEO ->

                    if (resultCode == Activity.RESULT_OK) {
                        val cursor = activity.contentResolver.query(data.data, null, null, null, null)
                        if (cursor!!.moveToNext()) {

                            val path = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA))
                            cursor.close()

                            callback(PICK_SUCCESS, path)
                        }

                    }

                PICK_FROM_CAMERA_VIDEO -> if (resultCode == Activity.RESULT_OK) {

                    if (resultCode == Activity.RESULT_OK) {
                        var path = data.data.getRealPath(activity)
                        if (path.isEmpty()) {
                            path = currentVideoPath as String
                        }

                        path.let {
                            callback(PICK_SUCCESS, path)
                        }
                    }

                }
            }

            fm.beginTransaction().remove(this).commit()

        }

    }

    companion object {


        private var instance: RPickMedia? = null

        @JvmStatic fun getInstance(c: Context): RPickMedia {

            if (instance == null) {
                instance = RPickMedia(c)
            }

            return instance as RPickMedia
        }

        val PICK_FROM_CAMERA = 0
        val PICK_FROM_GALLERY = 1
        val PICK_FROM_VIDEO = 2
        val PICK_FROM_CAMERA_VIDEO = 3

        val PICK_SUCCESS = 1
        val PICK_FAILED = 0
    }

}