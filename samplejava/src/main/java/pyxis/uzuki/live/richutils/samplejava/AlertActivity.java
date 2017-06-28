package pyxis.uzuki.live.richutils.samplejava;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import kotlin.Unit;
import pyxis.uzuki.live.richutilskt.utils.Utils;

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
            Utils.alert(this, "Hello, World!");
        });

        selector.setOnClickListener(view -> {
            ArrayList<String> items = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                items.add(String.valueOf(i));
            }

            Utils.selector(this, items, (dialogInterface, integer) -> {
                Utils.toast(AlertActivity.this, "click item -> " + String.valueOf(integer), Toast.LENGTH_SHORT);
                return Unit.INSTANCE;
            });
        });

        confirm.setOnClickListener(view -> {
            Utils.confirm(this,  "Hello, world!", dialogInterface -> {
                Utils.toast(AlertActivity.this, "click confirm button", Toast.LENGTH_SHORT);
                return Unit.INSTANCE;
            });
        });

        progress.setOnClickListener(view -> {
            ProgressDialog dialog = (ProgressDialog) Utils.progress(this, "", "Loading...");

            Utils.runDelayed(10000, () -> {
                dialog.dismiss();
                return Unit.INSTANCE;
            });
        });
    }
}
