package pyxis.uzuki.live.richutilskt.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import pyxis.uzuki.live.richutilskt.utils.RichUtils;

/**
 * RichUtilsKt
 * Class: DummyClass
 * Created by Pyxis on 2017-11-09.
 * <p>
 * Description:
 */

public class DummyClass extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String jsonStr = RichUtils.fileAsString(getAssets(), "json", "customer_array.json");
        JSONArray jsonArray = RichUtils.createJSONArray(jsonStr);

        RichUtils.forObjectEach(jsonArray, object -> {
            RichUtils.toast(DummyClass.this, RichUtils.getJSONString(object, "type"));
        });

        List<JSONObject> objectList = RichUtils.toObjectList(jsonArray);
    }
}
