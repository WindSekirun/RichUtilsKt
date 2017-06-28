package pyxis.uzuki.live.richutilssample

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.startActivity
import org.json.JSONObject
import pyxis.uzuki.live.richutilskt.utils.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runAsync { getLatestReleaseFromGitHub() }

        alert.setOnClickListener { startActivity<AlertActivity>() }
        bitmap.setOnClickListener { startActivity<BitmapActivity>() }
        date.setOnClickListener { startActivity<DateActivity>() }
        media.setOnClickListener { startActivity<PickMediaActivity>() }
        btnReboot.setOnClickListener { this.reboot() }
        logo.setOnClickListener { browse("https://github.com/WindSekirun/RichUtilsKt") }
        json.setOnClickListener { startActivity<JSONActivity>() }
        permission.setOnClickListener { startActivity<PermissionActivity>() }
        preference.setOnClickListener { startActivity<PreferenceActivity>() }
        contact.setOnClickListener { startActivity<ContactActivity>() }
        btnRecycler.setOnClickListener { startActivity<RefreshRecyclerActivity>() }
    }

    private fun getLatestReleaseFromGitHub() {
        val apiPath = "https://api.github.com/repos/windsekirun/richutilskt/releases/latest"

        val url = URL(apiPath)
        val conn = url.openConnection() as HttpURLConnection
        conn.connectTimeout = 10000
        conn.requestMethod = "GET"

        val resCode = conn.responseCode
        if (resCode == HttpURLConnection.HTTP_OK) {
            val inputStream = conn.inputStream
            val response: String = inputStream.getString()
            runOnUiThread { parsingReleaseData(response) }
            conn.disconnect()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun parsingReleaseData(response: String) {
        if (TextUtils.isEmpty(response))
            return

        val jsonObject: JSONObject? = response.createJSONObject()
        val version = jsonObject?.getJSONString(name = "tag_name")

        txtVersion.text = "Latest version -> $version"
    }
}

