package pyxis.uzuki.live.richutils.samplejava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import pyxis.uzuki.live.richutilskt.utils.RichUtils;

/**
 * Created by pyxis on 2017. 6. 12..
 */

public class DateActivity extends BaseActivity {
    @BindView(R.id.btnCopy) Button btnCopy;
    @BindView(R.id.btnLoad) Button btnLoad;
    @BindView(R.id.txtResult) TextView txtResult;
    @BindView(R.id.editCopy) EditText editCopy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        Date date = RichUtils.parseDate("2016-11-23 11:11:11");
        String asString = "";
        if (date != null) {
            asString = RichUtils.asString(date);
        }

        String formatted = RichUtils.toDateString("2016-11-23 11:11:11", "yyyy-Mm-dd HH:mm:ss", "yyyy.MM.dd");
        long timestamp = 149648887L;
        String tsStr = RichUtils.asDateString(timestamp, true);

        btnCopy.setOnClickListener(view -> RichUtils.copyText(this, editCopy.getText().toString()));

        btnLoad.setOnClickListener(view -> {
            String value = (String) RichUtils.getTextFromClipboard(this);
            editCopy.setText(value);
            editCopy.setSelection(editCopy.length());
        });

        StringBuilder builder = new StringBuilder();
        builder.append("parseDate ->")
                .append(date)
                .append("\n")
                .append("asString ->")
                .append(asString)
                .append("\n")
                .append("toDateString ->")
                .append(formatted)
                .append("\n")
                .append("timestamp ->")
                .append(timestamp)
                .append("\n")
                .append("asDateString ->")
                .append(tsStr);

        txtResult.setText(builder.toString());
    }
}
