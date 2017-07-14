package pyxis.uzuki.live.richutilssample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preference.*
import pyxis.uzuki.live.richutilskt.utils.RPreference
import pyxis.uzuki.live.richutilskt.utils.hideKeyboard

class PreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        var pref: RPreference = RPreference.getInstance(this)
        val key = "preferenceActivity"
        var value = pref.getString(key = key)

        editPref.setText(value)
        editPref.setSelection(editPref.length())

        btnSave.setOnClickListener {
            hideKeyboard()
            pref.put(key, editPref.text.toString())
        }

        btnLoad.setOnClickListener {
            hideKeyboard()
            value = pref.getString(key = key)

            editPref.setText(value)
            editPref.setSelection(editPref.length())
        }

        btnClear.setOnClickListener {
            hideKeyboard()
            pref.clear()

            editPref.setText("")
        }
    }
}