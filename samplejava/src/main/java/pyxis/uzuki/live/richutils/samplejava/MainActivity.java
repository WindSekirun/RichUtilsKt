package pyxis.uzuki.live.richutils.samplejava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import butterknife.BindView;
import kotlin.Unit;
import pyxis.uzuki.live.richutilskt.utils.ContactItem;
import pyxis.uzuki.live.richutilskt.utils.RichUtils;

public class MainActivity extends BaseActivity {
    @BindView(R.id.logo) ImageView logo;
    @BindView(R.id.txtVersion) TextView txtVersion;
    @BindView(R.id.alert) Button alert;
    @BindView(R.id.bitmap) Button bitmap;
    @BindView(R.id.date) Button date;
    @BindView(R.id.json) Button json;
    @BindView(R.id.permission) Button permission;
    @BindView(R.id.preference) Button preference;
    @BindView(R.id.media) Button media;
    @BindView(R.id.btnReboot) Button btnReboot;
    @BindView(R.id.contact) Button contact;
    @BindView(R.id.location) Button location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(RichUtils.setTypeface(this, R.layout.activity_main));
        RichUtils.setStatusNavBarColor(this, Color.parseColor("#303F9F"));


        RichUtils.runAsync(() -> {
            getLatestReleaseFromGitHub();
            return Unit.INSTANCE;
        }, 5);

        logo.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/WindSekirun/RichUtilsKt"));
            startActivity(intent);
        });

        btnReboot.setOnClickListener(view -> RichUtils.reboot(this));
        alert.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, AlertActivity.class)));
        bitmap.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, BitmapActivity.class)));
        date.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DateActivity.class)));
        json.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, JSONActivity.class)));
        permission.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PermissionActivity.class)));
        preference.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PreferenceActivity.class)));
        media.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PickMediaActivity.class)));
        contact.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ContactActivity.class)));
        location.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LocationActivity.class)));
    }

    private void getLatestReleaseFromGitHub() {
        String apiPath = "https://api.github.com/repos/windsekirun/richutilskt/releases/latest";
        try {
            URL url = new URL(apiPath);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setConnectTimeout(10000);
            connection.setRequestMethod("GET");

            int resCode = connection.getResponseCode();
            if (resCode == HttpsURLConnection.HTTP_OK) {
                InputStream stream = connection.getInputStream();
                String response = RichUtils.getString(stream);
                runOnUiThread(() -> parsingReleaseData(response));
                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    private void parsingReleaseData(String response) {
        if (TextUtils.isEmpty(response))
            return;

        JSONObject jsonObject = RichUtils.createJSONObject(response);
        if (jsonObject != null) {
            String version = RichUtils.getJSONString(jsonObject, "tag_name", "");
            txtVersion.setText("Latest version -> " + version);
        }
    }
}
