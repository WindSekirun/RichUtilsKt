package pyxis.uzuki.live.richutils.samplejava;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import pyxis.uzuki.live.richutilskt.utils.RPickMedia;
import pyxis.uzuki.live.richutilskt.utils.Utils;

public class PickMediaActivity extends BaseActivity {
    @BindView(R.id.gallery) Button gallery;
    @BindView(R.id.camera) Button camera;
    @BindView(R.id.video) Button video;
    @BindView(R.id.videoc) Button videoc;
    @BindView(R.id.txtUrl) TextView txtUrl;
    @BindView(R.id.imgView) ImageView imgView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick);

        gallery.setOnClickListener(v -> RPickMedia.Companion.getInstance(this).pickFromGallery((integer, s) -> {
            resultMessage(integer, s);
            return Unit.INSTANCE;
        }));

        camera.setOnClickListener(v -> RPickMedia.Companion.getInstance(this).pickFromCamera((integer, s) -> {
            resultMessage(integer, s);
            return Unit.INSTANCE;
        }));

        video.setOnClickListener(v -> RPickMedia.Companion.getInstance(this).pickFromVideo((integer, s) -> {
            resultMessage(integer, s);
            return Unit.INSTANCE;
        }));

        videoc.setOnClickListener(v -> RPickMedia.Companion.getInstance(this).pickFromVideoCamera((integer, s) -> {
            resultMessage(integer, s);
            return Unit.INSTANCE;
        }));
    }

    private void resultMessage(int resultCode, String path) {
        if (resultCode == RPickMedia.Companion.getPICK_FAILED()) {
            throw new SecurityException("not granted permission to pick media files");
        }

        String realPath = Utils.getRealPath(Uri.parse(path), this);
        int width = Utils.getPhotoWidth(realPath);
        int height = Utils.getPhotoHeight(realPath);
        int degree = Utils.getPhotoOrientationDegree(realPath);

        txtUrl.setText("url -> " + realPath + ", width -> " + width + ", height ->" + height + ", degree -> "+ degree);

        Bitmap bitmap = Utils.getBitmap(realPath);
        imgView.setImageBitmap(bitmap);

        Utils.requestMediaScanner(this, realPath);
    }

}
