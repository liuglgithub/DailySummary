package com.liugl.alltest.animation.defualtinterpolator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;

public class AccelerateInterpolatorActivity extends InterpolatorBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void addBaseInterpolator() {
        this.baseInterpolator = new AccelerateInterpolator();
    }

}
