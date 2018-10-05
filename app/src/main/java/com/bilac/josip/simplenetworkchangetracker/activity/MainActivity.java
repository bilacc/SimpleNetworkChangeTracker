package com.bilac.josip.simplenetworkchangetracker.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bilac.josip.simplenetworkchangetracker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.bilac.josip.simplenetworkchangetracker.R;

public class MainActivity extends BaseActivity {

    @BindView(R.id.llRoot)
    LinearLayout llRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    public void connWentOffline() {
        super.connWentOffline(); // call method in BaseActivity too
        llRoot.setBackgroundColor(Color.parseColor("#9db3b6"));
    }

    @Override
    public void connWentOnline() {
        super.connWentOnline(); // call method in BaseActivity too
        llRoot.setBackgroundColor(Color.parseColor("#88EFEFEF"));

    }
}

