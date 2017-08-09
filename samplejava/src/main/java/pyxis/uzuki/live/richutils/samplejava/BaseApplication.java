package pyxis.uzuki.live.richutils.samplejava;

import android.app.Application;

import pyxis.uzuki.live.richutilskt.utils.RichUtils;

/**
 * Created by pyxis on 2017. 7. 13..
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RichUtils.initializeFontEngine(this);
    }
}
