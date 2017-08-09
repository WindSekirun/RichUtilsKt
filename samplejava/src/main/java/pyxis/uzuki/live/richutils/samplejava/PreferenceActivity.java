package pyxis.uzuki.live.richutils.samplejava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import pyxis.uzuki.live.richutilskt.utils.RPreference;
import pyxis.uzuki.live.richutilskt.utils.RichUtils;

public class PreferenceActivity extends BaseActivity {
    @BindView(R.id.editPref) EditText editPref;
    @BindView(R.id.btnSave) Button btnSave;
    @BindView(R.id.btnLoad) Button btnLoad;
    @BindView(R.id.btnClear) Button btnClear;
    private String value;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        RPreference pref = RPreference.getInstance(this);
        String key = "preferenceActivity";
        value = pref.getString(key);

        editPref.setText(value);
        editPref.setSelection(editPref.length());

        btnSave.setOnClickListener(v -> {
            RichUtils.hideKeyboard(this);
            pref.put(key, editPref.getText().toString());
        });

        btnLoad.setOnClickListener(v -> {
            RichUtils.hideKeyboard(this);
            value = pref.getString(key);

            editPref.setText(value);
            editPref.setSelection(editPref.length());
        });

        btnClear.setOnClickListener(v -> {
            RichUtils.hideKeyboard(this);
            pref.clear();

            editPref.setText("");
        });
    }
}
