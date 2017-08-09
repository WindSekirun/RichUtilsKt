package pyxis.uzuki.live.richutils.samplejava;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import butterknife.BindView;
import kotlin.Unit;
import pyxis.uzuki.live.richutilskt.utils.RichUtils;

/**
 * Created by pyxis on 2017. 6. 12..
 */

public class BitmapActivity extends BaseActivity {
    Bitmap bitmap = null;
    @BindView(R.id.imgView) ImageView imgView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        RichUtils.runAsync(() -> {
            bitmap = RichUtils.downloadBitmap("http://images.goodsmile.info/cgm/images/product/20160606/5715/39417/large/f75b5722baec63a2922a81c3c3ca8743.jpg");
            runOnUiThread(this::init);
            return Unit.INSTANCE;
        });
    }

    private void init() {
        if (bitmap == null)
            return;

        Drawable drawable = RichUtils.bitmapToDrawable(this, bitmap);
        String file = RichUtils.saveBitmapToFile(this, bitmap);

        imgView.setImageBitmap(bitmap);
    }
}
