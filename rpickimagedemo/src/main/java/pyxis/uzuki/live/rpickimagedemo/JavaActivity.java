package pyxis.uzuki.live.rpickimagedemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import pyxis.uzuki.live.richutilskt.utils.RichUtils;

/**
 * RichUtilsKt
 * Class: JavaActivity
 * Created by Pyxis on 5/2/18.
 * <p>
 * Description:
 */

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 26) {
            PrintMethodList.writeMethods(this, RichUtils.class.getMethods());
        }
    }
}
