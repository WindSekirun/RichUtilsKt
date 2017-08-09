package pyxis.uzuki.live.richutils.samplejava;

import android.os.Bundle;
import android.support.annotation.Nullable;

import pyxis.uzuki.live.richutilskt.utils.RichUtils;

public class MiscActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int versionCode = RichUtils.versionCode(this);
        String versionName = RichUtils.versionName(this);

        int dip15 = RichUtils.dip2px(this, 15);
        int sp12 = RichUtils.sp2px(this, 12);
        int dip15f = RichUtils.dip2px(this, 15f);
        int sp12f = RichUtils.sp2px(this, 12f);

        float px2dip15 = RichUtils.px2dip(this, 15);
        float px2sp12 = RichUtils.px2sp(this, 12);

        int networkState = RichUtils.checkNetwork(this);
        String hash = RichUtils.getKeyHash(this);
    }
}
