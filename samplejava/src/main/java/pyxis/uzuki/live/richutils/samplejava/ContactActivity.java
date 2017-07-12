package pyxis.uzuki.live.richutils.samplejava;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import kotlin.Unit;
import pyxis.uzuki.live.richutilskt.utils.ContactItem;
import pyxis.uzuki.live.richutilskt.utils.RPermission;
import pyxis.uzuki.live.richutilskt.utils.Utils;

public class ContactActivity extends BaseActivity {
    @BindView(R.id.txtResult) TextView txtResult;
    String text = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        String[] arrays = new String[]{Manifest.permission.READ_CONTACTS};

        boolean isGranted = RPermission.Companion.getInstance(this).checkPermission(arrays, (integer, strings) -> {
            init();
            return Unit.INSTANCE;
        });

        if (isGranted)
            init();
    }

    private void init() {
        Utils.runAsync(() -> {
            ArrayList<ContactItem> list = Utils.getContactsList(ContactActivity.this);
            for (ContactItem item : list) {
                text += "\n" + item;
            }

            runOnUiThread(() -> {
                txtResult.setText(text);
            });

            return Unit.INSTANCE;
        });
    }
}
