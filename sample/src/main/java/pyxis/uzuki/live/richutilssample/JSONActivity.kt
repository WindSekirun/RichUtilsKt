package pyxis.uzuki.live.richutilssample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_json.*
import org.json.JSONObject
import pyxis.uzuki.live.richutilskt.*

class JSONActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)

        var jsonStr = this.assets.fileAsString(subdirectory = "json", filename = "customer.json")
        var jsonObject: JSONObject? = createJSONObject(jsonStr)

        var firstName = getJSONString(jsonObject = jsonObject, name = "firstName")
        var lastName = getJSONString(jsonObject = jsonObject, name = "lastName")
        var age = getJSONInt(jsonObject = jsonObject, name = "age")

        var address = getJSONObject(jsonObject = jsonObject, name = "address")
        var phoneNumber = getJSONArray(jsonObject, "phoneNumber")

        txtResult.text = "firstName -> $firstName\nlastName -> $lastName\nage -> $age"
    }
}
