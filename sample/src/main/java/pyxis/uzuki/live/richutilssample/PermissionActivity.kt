package pyxis.uzuki.live.richutilssample

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_permission.*
import pyxis.uzuki.live.richutilskt.RPermission
import pyxis.uzuki.live.richutilskt.alert
import pyxis.uzuki.live.richutilskt.getIMEI

class PermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        class Callback : RPermission.PermissionRequestCallback {
            override fun onPermissionResult(resultCode: Int, list: ArrayList<String>) {
                alert(message = "Permission result -> $resultCode / Requested Permission: ${TextUtils.join(",", list)}")

                if (list.contains(Manifest.permission.READ_PHONE_STATE)) {
                    alert(message = "Your device IMEI -> ${getIMEI()}")
                }
            }
        }

        btnCall.setOnClickListener {
            val arrays : Array<String> = arrayOf(Manifest.permission.CALL_PHONE)
            RPermission.getInstance(this).checkPermission(arrays, Callback())
        }

        btnSMS.setOnClickListener {
            val arrays : Array<String> = arrayOf(Manifest.permission.SEND_SMS)
            RPermission.getInstance(this).checkPermission(arrays, Callback())
        }

        btnStorage.setOnClickListener {
            val arrays : Array<String> = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            RPermission.getInstance(this).checkPermission(arrays, Callback())
        }

        btnLocation.setOnClickListener {
            val arrays : Array<String> = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
            RPermission.getInstance(this).checkPermission(arrays, Callback())
        }

        btnState.setOnClickListener {
            val arrays : Array<String> = arrayOf(Manifest.permission.READ_PHONE_STATE)
            RPermission.getInstance(this).checkPermission(arrays, Callback())
        }
    }
}
