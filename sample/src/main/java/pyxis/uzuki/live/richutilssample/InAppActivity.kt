package pyxis.uzuki.live.richutilssample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_inapp.*

import java.util.ArrayList
import pyxis.uzuki.live.richutilskt.module.iap.RInAppBilling
import pyxis.uzuki.live.richutilskt.module.iap.Sku
import pyxis.uzuki.live.richutilskt.module.iap.Transaction

class InAppActivity : AppCompatActivity() {
    private var utils: RInAppBilling? = null
    private val item1Sku = "item_1"
    private val item2Sku = "item_2"
    private val item3Sku = "item_3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inapp)

        utils = RInAppBilling(this, "")

        utils?.setOnInAppBillingCallback { responseCode, transaction ->
            if (responseCode == RInAppBilling.PURCHASE_SUCCESS) {
                Log.d("Purchase", "Success!!")
                Log.d("Purchase", transaction?.purchaseInfo)
                Log.d("Purchase", transaction?.dataSignature)
                Log.d("Purchase", transaction?.purchaseToken)
            } else {
                Log.d("Purchase", "Failed!!")
            }
        }

        utils?.setOnInAppConsumeCallback { responseCode, transaction ->
            if (responseCode == RInAppBilling.PURCHASE_SUCCESS) {
                Log.d("Consume", "Consume success!!")
                Log.d("Consume", transaction?.purchaseInfo)
                Log.d("Consume", transaction?.dataSignature)
                Log.d("Consume", transaction?.purchaseToken)
            } else {
                Log.d("Consume", "Failed!!")
            }
        }

        utils?.bindInAppBilling()

        val items = arrayListOf(item1Sku, item2Sku, item3Sku)
        val availablePackage = utils?.getAvailableInappPackage(items)

        if (availablePackage != null) {
            for ((productId, type, price, _, _, title) in availablePackage) {
                Log.d(productId, "$price: $title : $type")
            }
        }

        button.setOnClickListener { utils?.purchase(item1Sku) }
        button2.setOnClickListener { utils?.purchase(item2Sku) }
        button3.setOnClickListener { utils?.purchase(item3Sku) }
    }

    override fun onDestroy() {
        super.onDestroy()
        utils!!.unBindInAppBilling()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (utils != null) {
            utils!!.onActivityResult(requestCode, resultCode, data)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
