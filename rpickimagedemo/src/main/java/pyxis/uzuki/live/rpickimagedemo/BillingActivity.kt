package pyxis.uzuki.live.rpickimagedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pyxis.uzuki.live.richutilskt.module.iap.RInAppBilling
import pyxis.uzuki.live.richutilskt.utils.toast


/**
 * RichUtilsKt
 * Class: BIllingActivity
 * Created by pyxis on 18. 5. 2.
 *
 *
 * Description:
 */

// keystore for demo: !!demo
class BillingActivity : AppCompatActivity() {
    private lateinit var mInAppBilling: RInAppBilling

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_billing)

        mInAppBilling = RInAppBilling(this, "")
        mInAppBilling.bindInAppBilling()

        mInAppBilling.setOnInAppBillingCallback { code, transaction ->
            when (code) {
                RInAppBilling.PURCHASE_SUCCESS -> toast("success to purchase")
                RInAppBilling.PURCHASE_FAILED_INVALID, RInAppBilling.PURCHASE_FAILED_UNKNOWN -> toast("fail to purchase")
            }
        }

        mInAppBilling.setOnInAppConsumeCallback { code, transaction ->
            when (code) {
                RInAppBilling.PURCHASE_SUCCESS -> toast("success to consume")
                RInAppBilling.PURCHASE_FAILED_INVALID, RInAppBilling.PURCHASE_FAILED_UNKNOWN -> toast("fail to purchase")
            }
        }
    }
}