package pyxis.uzuki.live.richutils.samplejava;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import pyxis.uzuki.live.richutilskt.utils.RichUtils;

/**
 * Created by pyxis on 2017. 6. 12..
 */

public class AlertActivity extends BaseActivity {
    @BindView(R.id.alert) Button alert;
    @BindView(R.id.confirm) Button confirm;
    @BindView(R.id.selector) Button selector;
    @BindView(R.id.progress) Button progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        alert.setOnClickListener(view -> {
            RichUtils.alert(this, "Hello, World!");
        });

        selector.setOnClickListener(view -> {
            ArrayList<String> items = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                items.add(String.valueOf(i));
            }

            RichUtils.selector(this, items, (dialogInterface, item, integer) ->  {
                RichUtils.toast(AlertActivity.this, "click item -> " + String.valueOf(integer), Toast.LENGTH_SHORT);
            });
        });

        confirm.setOnClickListener(view -> {
            RichUtils.confirm(this, "Hello, world!", dialogInterface -> {
                RichUtils.toast(AlertActivity.this, "clicked positive button!");
            });
        });

        progress.setOnClickListener(view -> {
            ProgressDialog dialog = (ProgressDialog) RichUtils.progress(this, "Loading...");
            RichUtils.runDelayed(10000, dialog::dismiss);
        });
    }
}
