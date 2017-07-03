package pyxis.uzuki.live.richutils.samplejava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import org.json.JSONObject;

import butterknife.BindView;
import pyxis.uzuki.live.richutilskt.utils.Utils;

/**
 * Created by pyxis on 2017. 6. 12..
 */

public class JSONActivity extends BaseActivity {
    @BindView(R.id.txtResult) TextView txtResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        String jsonStr = Utils.fileAsString(this.getAssets(), "json", "customer.json");
        JSONObject jsonObject = Utils.createJSONObject(jsonStr);

        if (jsonObject == null) {
            txtResult.setText("Json file isn't given!");
            return;
        }


        String firstName = Utils.getJSONString(jsonObject, "firstName");
        String lastName = Utils.getJSONString(jsonObject, "lastName");
        int age = Utils.getJSONInt(jsonObject, "age");



    }
}
