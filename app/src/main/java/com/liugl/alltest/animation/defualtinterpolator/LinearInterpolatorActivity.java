package com.liugl.alltest.animation.defualtinterpolator;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;

public class LinearInterpolatorActivity extends InterpolatorBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void addBaseInterpolator() {
        this.baseInterpolator = new LinearInterpolator();
    }
}
