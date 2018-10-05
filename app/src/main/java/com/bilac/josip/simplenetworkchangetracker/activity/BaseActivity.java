package com.bilac.josip.simplenetworkchangetracker.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.bilac.josip.simplenetworkchangetracker.R;
import com.bilac.josip.simplenetworkchangetracker.utils.ConnectionListener;
import com.bilac.josip.simplenetworkchangetracker.utils.NetworkHelper;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

/**
 * BaseActivity class.
 * Holds screen always on and listens to internet connectivity changes.
 */
public abstract class BaseActivity extends AppCompatActivity implements ConnectionListener {

    public static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Check connection and set Ui when activity is started
        checkConnState();
        // Start listening for internet connection changes
        registerReceiver(connectivityBroadcastReceiver, new IntentFilter(CONNECTIVITY_ACTION));
        //added check connection state to manifest
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(connectivityBroadcastReceiver);
    }

    /**
     * If there is internet connection change alert the child fragments.
     */
    private final BroadcastReceiver connectivityBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(final Context context, final Intent intent) {
            if (NetworkHelper.getInstance().isNetworkAvailable(context)) {
                connWentOnline();
            } else {
                connWentOffline();
            }
        }
    };

    @Override
    public void checkConnState() {
        if (NetworkHelper.getInstance().isNetworkAvailable(this)) {
            connWentOnline();
        } else {
            connWentOffline();
        }
    }

    @Override
    public void connWentOnline() {
        Log.i(TAG, "connWentOnline");
    }

    @Override
    public void connWentOffline() {
        Log.w(TAG, "connWentOffline");
        Toast.makeText(this, getString(R.string.internet_down), Toast.LENGTH_SHORT).show();
    }
}

