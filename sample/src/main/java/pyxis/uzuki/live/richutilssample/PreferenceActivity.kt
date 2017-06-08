package pyxis.uzuki.live.richutilssample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preference.*
import pyxis.uzuki.live.richutilskt.RPerference

class PreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        var pref:RPerference = RPerference.getInstance(this)
        val key = "preferenceActivity"
        var value = pref.getValue(key = key, def = "")

        editPref.setText(value)
        editPref.setSelection(editPref.length())

        btnSave.setOnClickListener {
            pref.put(key, editPref.text.toString())
        }

        btnLoad.setOnClickListener {
            value = pref.getValue(key = key, def = "")

            editPref.setText(value)
            editPref.setSelection(editPref.length())
        }

        btnClear.setOnClickListener {
            pref.clear()

            editPref.setText("")
        }
    }
}