package pyxis.uzuki.live.richutils.samplejava;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import pyxis.uzuki.live.richutilskt.utils.RPickMedia;
import pyxis.uzuki.live.richutilskt.utils.RichUtils;

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

        gallery.setOnClickListener(v -> RPickMedia.instance.pickFromGallery(this, this::resultMessage));

        camera.setOnClickListener(v -> RPickMedia.instance.pickFromCamera(this, this::resultMessage));

        video.setOnClickListener(v -> RPickMedia.instance.pickFromVideo(this, this::resultMessage));

        videoc.setOnClickListener(v -> RPickMedia.instance.pickFromVideoCamera(this, this::resultMessage));
    }

    private void resultMessage(int resultCode, String path) {
        if (resultCode == RPickMedia.PICK_FAILED) {
            throw new SecurityException("not granted permission to pick media files");
        }

        String realPath = RichUtils.getRealPath(Uri.parse(path), this);
        int width = RichUtils.getPhotoWidth(realPath);
        int height = RichUtils.getPhotoHeight(realPath);
        int degree = RichUtils.getPhotoOrientationDegree(realPath);

        txtUrl.setText("url -> " + realPath + ", width -> " + width + ", height ->" + height + ", degree -> " + degree);

        Bitmap bitmap = RichUtils.getBitmap(realPath);
        imgView.setImageBitmap(bitmap);

        RichUtils.requestMediaScanner(this, realPath);
    }
}
