package pyxis.uzuki.live.richutils.samplejava;

import android.os.Bundle;
import android.support.annotation.Nullable;

import pyxis.uzuki.live.richutilskt.utils.Utils;

public class MiscActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int versionCode = Utils.versionCode(this);
        String versionName = Utils.versionName(this);

        int dip15 = Utils.dip2px(this, 15);
        int sp12 = Utils.sp2px(this, 12);
        int dip15f = Utils.dip2px(this, 15f);
        int sp12f = Utils.sp2px(this, 12f);

        float px2dip15 = Utils.px2dip(this, 15);
        float px2sp12 = Utils.px2sp(this, 12);

        int networkState = Utils.checkNetwork(this);
        String hash = Utils.getKeyHash(this);
    }
}
