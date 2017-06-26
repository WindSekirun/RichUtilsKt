@file:JvmName("RPermission")

package pyxis.uzuki.live.richutilskt

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Fragment
import android.app.FragmentManager
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat

class RPermission private constructor(private var context: Context) {

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
     * check and request Permission which given.
     *
     * @param[array] array of Permission to check
     * @param[callback] callback object
     * @return check result
     */
    fun checkPermission(array: Array<String>, callback: (Int, ArrayList<String>) -> Unit): Boolean {
        val permissionList: ArrayList<String> = ArrayList()
        array.forEach { permissionList.add(it) }

        return checkPermission(permissionList, callback)
    }

    /**
     * check and request Permission which given.
     *
     * @param[list] list of Permission to check
     * @param[callback] callback object
     * @return check result
     */
    fun checkPermission(list: ArrayList<String>, callback: (Int, ArrayList<String>) -> Unit): Boolean {
        if (Build.VERSION.SDK_INT < 23) {
            callback(PERMISSION_ALREADY, list)
            return true
        }

        val notGranted: ArrayList<String> = ArrayList()
        list.forEach({
            val result = ContextCompat.checkSelfPermission(context, it)
            if (result != PackageManager.PERMISSION_GRANTED)
                notGranted.add(it)
        })

        if (notGranted.isNotEmpty()) {
            requestPermission(notGranted, callback)
            return false
        } else {
            callback(PERMISSION_ALREADY, list)
            return true
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestPermission(list: ArrayList<String>, callback: (Int, ArrayList<String>) -> Unit) {
        val fm = getActivity(context)!!.fragmentManager
        val f = RequestFragment(fm, callback)

        fm.beginTransaction().add(f, "FRAGMENT_TAG").commit()
        fm.executePendingTransactions()

        f.requestPermissions(list.toTypedArray(), 72)
    }

    @SuppressLint("ValidFragment")
    private inner class RequestFragment(private val fm: FragmentManager, private val callback: (Int, ArrayList<String>) -> Unit) : Fragment() {

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)

            val permissionList: ArrayList<String> = ArrayList()
            permissions.forEach { permissionList.add(it) }

            val returnCode = if (verifyPermissions(grantResults)) PERMISSION_GRANTED else PERMISSION_FAILED
            callback(returnCode, permissionList)
            fm.beginTransaction().remove(this).commit()
        }

    }

    private fun verifyPermissions(grantResults: IntArray): Boolean {
        if (grantResults.isEmpty()) {
            return false
        }

        return grantResults.none { it != PackageManager.PERMISSION_GRANTED }
    }

    companion object {
        private var instance: RPermission? = null

        fun getInstance(c: Context): RPermission {

            if (instance == null) {
                instance = RPermission(c)
            }

            return instance as RPermission
        }

        val PERMISSION_GRANTED = 1
        val PERMISSION_FAILED = 2
        val PERMISSION_ALREADY = 3
    }
}