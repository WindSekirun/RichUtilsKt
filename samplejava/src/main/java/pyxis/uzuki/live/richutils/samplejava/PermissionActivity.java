package pyxis.uzuki.live.richutils.samplejava;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;

import butterknife.BindView;
import pyxis.uzuki.live.richutilskt.utils.RPermission;
import pyxis.uzuki.live.richutilskt.utils.RichUtils;

/**
 * Created by pyxis on 2017. 6. 12..
 */

public class PermissionActivity extends BaseActivity {
    @BindView(R.id.btnCall) Button btnCall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        btnCall.setOnClickListener(view -> {
            String[] arrays = new String[]{Manifest.permission.CALL_PHONE};

            RPermission.getInstance(this).checkPermission(arrays, (integer, strings) -> {
                RichUtils.alert(PermissionActivity.this,
                        "Permission result ->" + integer + " / Requested Permission: " + TextUtils.join(",", strings));
            });
        });
    }
}
