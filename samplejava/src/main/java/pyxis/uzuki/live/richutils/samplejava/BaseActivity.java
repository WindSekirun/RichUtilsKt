package pyxis.uzuki.live.richutils.samplejava;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pyxis on 2017. 6. 12..
 */

public class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
