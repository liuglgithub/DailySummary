package com.liugl.alltest.animation.defualtinterpolator;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.CycleInterpolator;

public class CycleInterpolatorActivity extends InterpolatorBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void addBaseInterpolator() {
        this.baseInterpolator = new CycleInterpolator(3f);//如过对这个差值器 设置 android:fillAfter="true" 那么动画结束后,你看到的回事动画开始的第一幕(第一帧),如果不设置或者设置成 android:fillBefore="true",那么看到的回事控件本身的XML的状态
    }
}
