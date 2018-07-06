package pyxis.uzuki.live.rpickimagedemo;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import pyxis.uzuki.live.richutilskt.impl.F2;
import pyxis.uzuki.live.richutilskt.utils.RPermission;
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
        setContentView(R.layout.activity_java);

        final TextView txtValue = findViewById(R.id.txtValue);

        RPermission.instance.checkPermission(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                new F2<Integer, List<String>>() {
                    @Override
                    public void invoke(Integer object, List<String> object1) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            String result = PrintMethodList.writeMethods(RichUtils.class.getMethods());
                            txtValue.setText(result);
                        }
                    }
                });
    }
}
