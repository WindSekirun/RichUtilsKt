package pyxis.uzuki.live.richutils.samplejava;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;

import butterknife.BindView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import pyxis.uzuki.live.richutilskt.service.RLocationService;
import pyxis.uzuki.live.richutilskt.utils.RPermission;
import pyxis.uzuki.live.richutilskt.utils.RichUtils;

@SuppressLint("SetTextI18n")
public class LocationActivity extends BaseActivity {
    @BindView(R.id.txtLocation) TextView txtLocation;
    private boolean mBound = false;
    private RLocationService locationService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        txtLocation.setText("Ready for fetch... \nnow time is " + RichUtils.asString(Calendar.getInstance().getTime()) + "\n=========================");

        String[] arrays = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

        boolean isGranted = RPermission.getInstance(this).checkPermission(arrays, (integer, strings) -> {
            start();
            return Unit.INSTANCE;
        });

        if (isGranted) {
            start();
        }
    }

    private void start() {
        Intent serviceIntent = new Intent(getApplicationContext(), RLocationService.class);
        startService(serviceIntent);
        bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE);
    }

    private void init() {
        locationService.setLocationCallback(location -> {
            txtLocation.setText(txtLocation.getText().toString() + "\n Location changed! -> \nlat: " + location.getLatitude() +
            "\nlng: " + location.getLongitude() + "\n provider: " + location.getProvider() + "\n time: " +  RichUtils.asString(Calendar.getInstance().getTime()));
            return Unit.INSTANCE;
        });

        if (locationService.getCurrentBestLocation() != null) {
            Location location = locationService.getCurrentBestLocation();
            txtLocation.setText(txtLocation.getText().toString() + "\n Location changed! -> \nlat: " + location.getLatitude() +
                    "\nlng: " + location.getLongitude() + "\n provider: " + location.getProvider() + "\n time: " +  RichUtils.asString(Calendar.getInstance().getTime()));
        } else {
            txtLocation.setText(txtLocation.getText().toString() + "\nNot fetched...");
            txtLocation.setText(txtLocation.getText().toString() + "\nNot fetched...");
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            RLocationService.LocalBinder binder = (RLocationService.LocalBinder) service;
            locationService = binder.getService();
            mBound = true;
            Log.d(LocationActivity.class.getSimpleName(), "service connected!");

            if (mBound && locationService != null) {
                init();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };
}
