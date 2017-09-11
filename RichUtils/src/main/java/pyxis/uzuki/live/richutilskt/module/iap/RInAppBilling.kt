package pyxis.uzuki.live.richutilskt.module.iap

import android.app.Activity
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.text.TextUtils
import android.util.Base64
import android.util.Log
import com.android.vending.billing.IInAppBillingService
import org.json.JSONObject
import pyxis.uzuki.live.richutilskt.utils.getJSONInt
import pyxis.uzuki.live.richutilskt.utils.getJSONLong
import pyxis.uzuki.live.richutilskt.utils.getJSONString
import pyxis.uzuki.live.richutilskt.utils.runAsync
import java.security.*
import java.security.spec.InvalidKeySpecException
import java.security.spec.X509EncodedKeySpec
import java.util.*

data class Transaction(var autoRenewing: String, var orderId: String, var packageName: String, var productId: String,
                       var purchaseTime: Long = 0, var purchaseState: Int = 0, var developerPayload: String, var purchaseToken: String,
                       var purchaseInfo: String, var dataSignature: String) {

    override fun toString(): String {
        return "Transaction(autoRenewing='$autoRenewing', orderId='$orderId', packageName='$packageName', productId='$productId', " +
                "purchaseTime=$purchaseTime, purchaseState=$purchaseState, developerPayload='$developerPayload', purchaseToken='$purchaseToken', " +
                "  `purchaseInfo='$purchaseInfo', dataSignature='$dataSignature')"
    }
}


data class Sku(var productId: String = "", var type: String = "", var price: String = "", var priceAmountMicros: String = "",
               var priceCurrencyCode: String = "", var title: String = "", var description: String = "") {

    override fun toString(): String {
        return "Sku(productId='$productId', type='$type', price='$price', priceAmountMicros='$priceAmountMicros', " +
                "priceCurrencyCode='$priceCurrencyCode', title='$title', description='$description')"
    }
}

class RInAppBilling(private val activity: Activity, private val signatureBase64: String) {
    private lateinit var billingCallback: OnInAppBillingCallback
    private var consumeCallback: OnInAppConsumeCallback? = null
    private var developerPayload = ""

    private lateinit var mService: IInAppBillingService
    private var isBoundService = false

    private val mServiceConn = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName) {
            isBoundService = false
        }

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            isBoundService = true
            mService = IInAppBillingService.Stub.asInterface(service)
        }
    }

    /**
     * Should be initialized in onCreate
     */
    fun bindInAppBilling() {
        val serviceIntent = Intent("com.android.vending.billing.InAppBillingService.BIND")
        serviceIntent.`package` = "com.android.vending"
        activity.bindService(serviceIntent, mServiceConn, Context.BIND_AUTO_CREATE)
    }

    /**
     * Should be initialized in onDestroy
     */
    fun unBindInAppBilling() {
        if (isBoundService) {
            activity.unbindService(mServiceConn)
        }
    }

    /**
     * Using when try to purchase un-consumable item
     *
     * @param[callback] callback lambda parameter
     */
    fun setOnInAppBillingCallback(callback: (Int, Transaction?) -> Unit) {
        this.billingCallback = object : OnInAppBillingCallback {
            override fun purchaseResult(responseCode: Int, transaction: Transaction?) {
                callback.invoke(responseCode, transaction)
            }
        }
    }

    /**
     * Using when try to purchase consumable item, within using AppBillingUtils.setOnInAppBillingCallback(OnInAppBillingCallback)
     *
     * @param[callback] callback lambda parameter
     */
    fun setOnInAppConsumeCallback(callback: (Int, Transaction?) -> Unit) {
        this.consumeCallback = object : OnInAppConsumeCallback {
            override fun consumeResult(responseCode: Int, transaction: Transaction?) {
                callback.invoke(responseCode, transaction)
            }
        }
    }

    /**
     * Purchase specific item
     *
     * @param productId to purchase
     * @param type inapp or sub
     * @param developerPayload for secure working.
     */
    @JvmOverloads
    fun purchase(productId: String, type: String = "inapp", developerPayload: String = generateDeveloperPayload(productId, type)) {
        var buyIntentBundle: Bundle? = null

        try {
            buyIntentBundle = mService.getBuyIntent(3, activity.packageName, productId, type, developerPayload)
        } catch (e: RemoteException) {
            billingCallback.purchaseResult(PURCHASE_FAILED_UNKNOWN, null)
        }

        this.developerPayload = developerPayload
        if (buyIntentBundle == null)
            billingCallback.purchaseResult(PURCHASE_FAILED_UNKNOWN, null)

        val pendingIntent = buyIntentBundle?.getParcelable<PendingIntent>("BUY_INTENT")
        if (pendingIntent != null) {
            try {
                activity.startIntentSenderForResult(pendingIntent.intentSender, 1001, Intent(), 0, 0, 0)
            } catch (e: Exception) {
                billingCallback.purchaseResult(PURCHASE_FAILED_UNKNOWN, null)
            }
        } else {
            billingCallback.purchaseResult(PURCHASE_FAILED_UNKNOWN, null)
        }
    }

    /**
     * Consume specific item which consumable item
     *
     * @param transaction transaction object
     */
    fun consumePurchase(transaction: Transaction?) {
        if (transaction != null) {
            runAsync {
                val response = mService.consumePurchase(3, activity.packageName, transaction.purchaseToken)
                if (response == 0 && consumeCallback != null) {
                    consumeCallback?.consumeResult(PURCHASE_SUCCESS, transaction)
                } else if (consumeCallback != null) {
                    consumeCallback?.consumeResult(response, transaction)
                }
            }
        }
    }

    /**
     * Purchase Result billingCallback, just pass Activity's onActivityResult.
     *
     * @param requestCode requestcode
     * @param resultCode resultCode
     * @param data intent
     */
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != 1001 || resultCode != Activity.RESULT_OK || data == null) {
            return
        }

        val jsonStr = data.getStringExtra("INAPP_PURCHASE_DATA")
        val dataSignature = data.getStringExtra("INAPP_DATA_SIGNATURE")
        val jsonObject = JSONObject(jsonStr)

        if (jsonObject.getJSONString("developerPayload") != developerPayload) {
            billingCallback.purchaseResult(PURCHASE_FAILED_INVALID, null)
            return
        }

        val transaction = Transaction("", jsonObject.getJSONString("orderId"),
                jsonObject.getJSONString("packageName"), jsonObject.getJSONString("productId"),
                jsonObject.getJSONLong("purchaseTime"), jsonObject.getJSONInt("purchaseState"),
                jsonObject.getJSONString("developerPayload"), jsonObject.getJSONString("purcahseToken"),
                jsonObject.toString(), dataSignature)

        if (isValidTransaction(transaction)) {
            billingCallback.purchaseResult(PURCHASE_SUCCESS, transaction)
        } else {
            billingCallback.purchaseResult(PURCHASE_FAILED_INVALID, null)
        }
    }

    /**
     * get Available 'inapp' package of own package name.
     *
     * @param items Strings of item's id
     * @return ArrayList of [sku][Sku]
     */
    fun getAvailableInappPackage(items: ArrayList<String>): ArrayList<Sku> {
        val skuArrayList = ArrayList<Sku>()
        val querySkus = Bundle()
        querySkus.putStringArrayList("ITEM_ID_LIST", items)

        val skuDetails = mService.getSkuDetails(3, activity.packageName, "inapp", querySkus)
        val response = skuDetails.getInt("RESPONSE_CODE")

        if (response != 0)
            return skuArrayList

        val responseList = skuDetails.getStringArrayList("DETAILS_LIST") ?: return skuArrayList

        for (thisResponse in responseList) {
            val sku = Sku()
            val jsonObject = JSONObject(thisResponse)
            sku.description = jsonObject.getJSONString("description")
            sku.title = jsonObject.getJSONString("title")
            sku.price = jsonObject.getJSONString("price")
            sku.priceAmountMicros = jsonObject.getJSONString("price_amount_micros")
            sku.priceCurrencyCode = jsonObject.getJSONString("price_currency_code")
            sku.type = jsonObject.getJSONString("type")
            sku.productId = jsonObject.getJSONString("productId")
        }

        return skuArrayList
    }

    /**
     * generate developerPayload using nonce(UUID)
     *
     * @param productId productId of product
     * @param type inapp or sub
     * @return random generated developerPayload
     */
    fun generateDeveloperPayload(productId: String, type: String): String =
            "$productId:$type:${UUID.randomUUID().toString().replace("-".toRegex(), "")}"

    /**
     * Checking transaction is valid.
     *
     * @param transaction transaction object
     * @return true - valid, false - invalid
     */
    fun isValidTransaction(transaction: Transaction): Boolean =
            verifyPurchaseSignature(transaction.productId, transaction.purchaseInfo, transaction.dataSignature)

    /**
     * verify signature using BASE64
     *
     * @param productId productId
     * @param purchaseData purchaseData (full-jsonStr)
     * @param dataSignature signature key
     * @return value, true - valid, false - invalid
     */
    private fun verifyPurchaseSignature(productId: String, purchaseData: String, dataSignature: String): Boolean {
        try {
            return TextUtils.isEmpty(signatureBase64) || Security.verifyPurchase(productId, signatureBase64, purchaseData, dataSignature)
        } catch (e: Exception) {
            return false
        }
    }

    interface OnInAppBillingCallback {
        fun purchaseResult(responseCode: Int, transaction: Transaction?)
    }

    interface OnInAppConsumeCallback {
        fun consumeResult(responseCode: Int, transaction: Transaction?)
    }

    companion object {
        @JvmField
        val PURCHASE_SUCCESS = 0
        @JvmField
        val PURCHASE_FAILED_UNKNOWN = -1
        @JvmField
        val PURCHASE_FAILED_INVALID = -2
    }

    /* Copyright (c) 2012 Google Inc.
     *
     * Licensed under the Apache License, Version 2.0 (the "License");
     * you may not use this file except in compliance with the License.
     * You may obtain a copy of the License at
     *
     *     http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */

    /**
     * Security-related methods. For a secure implementation, all of this code
     * should be implemented on a server that communicates with the
     * application on the device. For the sake of simplicity and clarity of this
     * example, this code is included here and is executed on the device. If you
     * must verify the purchases on the phone, you should obfuscate this code to
     * make it harder for an attacker to replace the code with stubs that treat all
     * purchases as verified.
     */
    object Security {
        private val TAG = "IABUtil/Security"

        private val KEY_FACTORY_ALGORITHM = "RSA"
        private val SIGNATURE_ALGORITHM = "SHA1withRSA"

        /**
         * Verifies that the data was signed with the given signature, and returns
         * the verified purchase. The data is in JSON format and signed
         * with a private key. The data also contains the purchaseState
         * and product ID of the purchase.
         * @param productId the product Id used for debug validation.
         * @param base64PublicKey the base64-encoded public key to use for verifying.
         * @param signedData the signed JSON string (signed, not encrypted)
         * @param signature the signature for the data, signed with the private key
         */
        fun verifyPurchase(productId: String, base64PublicKey: String, signedData: String, signature: String): Boolean {
            if (TextUtils.isEmpty(signedData) || TextUtils.isEmpty(base64PublicKey) || TextUtils.isEmpty(signature)) {

                if (productId == "android.test.purchased" || productId == "android.test.canceled" ||
                        productId == "android.test.refunded" || productId == "android.test.item_unavailable")
                    return true


                Log.e(TAG, "Purchase verification failed: missing data.")
                return false
            }

            val key = Security.generatePublicKey(base64PublicKey)
            return Security.verify(key, signedData, signature)
        }

        /**
         * Generates a PublicKey instance from a string containing the
         * Base64-encoded public key.

         * @param encodedPublicKey Base64-encoded public key
         * @throws IllegalArgumentException if encodedPublicKey is invalid
         */
        fun generatePublicKey(encodedPublicKey: String): PublicKey {
            try {
                val decodedKey = Base64.decode(encodedPublicKey, Base64.DEFAULT)
                val keyFactory = KeyFactory.getInstance(KEY_FACTORY_ALGORITHM)
                return keyFactory.generatePublic(X509EncodedKeySpec(decodedKey))
            } catch (e: NoSuchAlgorithmException) {
                throw RuntimeException(e)
            } catch (e: InvalidKeySpecException) {
                Log.e(TAG, "Invalid key specification.")
                throw IllegalArgumentException(e)
            } catch (e: IllegalArgumentException) {
                Log.e(TAG, "Base64 decoding failed.")
                throw e
            }
        }

        /**
         * Verifies that the signature from the server matches the computed
         * signature on the data.  Returns true if the data is correctly signed.
         * @param publicKey public key associated with the developer account
         * @param signedData signed data from server
         * @param signature server signature
         * @return true if the data and signature match
         */
        fun verify(publicKey: PublicKey, signedData: String, signature: String): Boolean {
            val sig: Signature
            try {
                sig = Signature.getInstance(SIGNATURE_ALGORITHM)
                sig.initVerify(publicKey)
                sig.update(signedData.toByteArray())
                if (!sig.verify(Base64.decode(signature, Base64.DEFAULT))) {
                    Log.e(TAG, "Signature verification failed.")
                    return false
                }
                return true
            } catch (e: NoSuchAlgorithmException) {
                Log.e(TAG, "NoSuchAlgorithmException.")
            } catch (e: InvalidKeyException) {
                Log.e(TAG, "Invalid key specification.")
            } catch (e: SignatureException) {
                Log.e(TAG, "Signature exception.")
            } catch (e: IllegalArgumentException) {
                Log.e(TAG, "Base64 decoding failed.")
            }

            return false
        }
    }
}