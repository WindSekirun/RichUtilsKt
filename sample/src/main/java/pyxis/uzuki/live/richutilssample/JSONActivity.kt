package pyxis.uzuki.live.richutilssample

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_json.*
import org.json.JSONObject
import pyxis.uzuki.live.richutilskt.utils.*

class JSONActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)

        var jsonStr = this.assets.fileAsString("json", "customer.json")
        var jsonObject: JSONObject? = jsonStr.createJSONObject()

        var firstName = jsonObject?.getJSONString(name = "firstName")
        var lastName = jsonObject?.getJSONString(name = "lastName")
        var age = jsonObject?.getJSONInt(name = "age")

        var address = getJSONObject(jsonObject = jsonObject, name = "address")
        var phoneNumber = getJSONArray(jsonObject, "phoneNumber")

        txtResult.text = "firstName -> $firstName\nlastName -> $lastName\nage -> $age"
    }
}
