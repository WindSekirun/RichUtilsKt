package pyxis.uzuki.live.richutils.samplejava;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import pyxis.uzuki.live.richutilskt.utils.ContactItem;
import pyxis.uzuki.live.richutilskt.utils.RPermission;
import pyxis.uzuki.live.richutilskt.utils.RichUtils;

public class ContactActivity extends BaseActivity {
    @BindView(R.id.txtResult) TextView txtResult;
    String text = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        String[] arrays = new String[]{Manifest.permission.READ_CONTACTS};

        RPermission.getInstance(this).checkPermission(arrays, (integer, strings) -> {
            init();
        });
    }

    private void init() {
        RichUtils.runAsync(() -> {
            List<ContactItem> list = RichUtils.getContactsList(ContactActivity.this);
            for (ContactItem item : list) {
                text += "\n" + item;
            }

            runOnUiThread(() -> txtResult.setText(text));
        });
    }
}
