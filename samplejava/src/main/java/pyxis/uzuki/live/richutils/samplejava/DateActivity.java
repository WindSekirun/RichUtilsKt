package pyxis.uzuki.live.richutils.samplejava;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import pyxis.uzuki.live.richutilskt.Utils;

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

        Date date = Utils.parseDate("2016-11-23 11:11:11");
    }
}
