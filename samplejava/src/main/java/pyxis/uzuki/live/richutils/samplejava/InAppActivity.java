package pyxis.uzuki.live.richutils.samplejava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

import pyxis.uzuki.live.richutilskt.module.iap.RInAppBilling;
import pyxis.uzuki.live.richutilskt.module.iap.Sku;

public class InAppActivity extends AppCompatActivity {
    private RInAppBilling utils;
    private String item1Sku = "item_1";
    private String item2Sku = "item_2";
    private String item3Sku = "item_3";

    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);

        utils = new RInAppBilling(this, "");

        utils.setOnInAppBillingCallback((responseCode, transaction) -> {
            if (responseCode == RInAppBilling.PURCHASE_SUCCESS) {
                Log.d("Purchase", "Success!!");
                Log.d("Purchase", transaction.getPurchaseInfo());
                Log.d("Purchase", transaction.getDataSignature());
                Log.d("Purchase", transaction.getPurchaseToken());
            } else {
                Log.d("Purchase", "Failed!!");
            }
        });

        utils.setOnInAppConsumeCallback((responseCode, transaction) -> {
            if (responseCode == RInAppBilling.PURCHASE_SUCCESS) {
                Log.d("Consume", "Consume success!!");
                Log.d("Consume", transaction.getPurchaseInfo());
                Log.d("Consume", transaction.getDataSignature());
                Log.d("Consume", transaction.getPurchaseToken());
            } else {
                Log.d("Consume", "Failed!!");
            }
        });

        utils.bindInAppBilling();

        ArrayList<String> items = new ArrayList<>();
        items.add(item1Sku);
        items.add(item2Sku);
        items.add(item3Sku);

        ArrayList<Sku> availablePackage = utils.getAvailableInappPackage(items);
        for (Sku sku : availablePackage) {
            Log.d(sku.getProductId(), sku.getPrice() + ": " + sku.getTitle() + " : " + sku.getType());
        }

        btn1.setOnClickListener(v -> utils.purchase(item1Sku));

        btn2.setOnClickListener(v -> utils.purchase(item2Sku));

        btn3.setOnClickListener(v -> utils.purchase(item3Sku));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        utils.unBindInAppBilling();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (utils != null) {
            utils.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
