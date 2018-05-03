package com.liugl.alltest.animation.defualtinterpolator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.liugl.alltest.R;

/**
 * AccelerateDecelerateInterpolator
 @android:anim/accelerate_decelerate_interpolator
 在动画开始与介绍的地方速率改变比较慢，在中间的时候加速

 AccelerateInterpolator
 @android:anim/accelerate_interpolator
 在动画开始的地方速率改变比较慢，然后开始加速

 AnticipateInterpolator
 @android:anim/anticipate_interpolator
 开始的时候向后然后向前甩

 AnticipateOvershootInterpolator
 @android:anim/anticipate_overshoot_interpolator
 开始的时候向后然后向前甩一定值后返回最后的值

 BounceInterpolator
 @android:anim/bounce_interpolator
 动画结束的时候弹起

 CycleInterpolator
 @android:anim/cycle_interpolator
 动画循环播放特定的次数，速率改变沿着正弦曲线

 DecelerateInterpolator
 @android:anim/decelerate_interpolator
 在动画开始的地方快然后慢

 LinearInterpolator
 @android:anim/linear_interpolator
 以常量速率改变

 OvershootInterpolator
 @android:anim/overshoot_interpolator
 向前甩一定值后再回到原来位置
 */
public class TweenDefaultInterpolatorActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_default_interpolator);
    }


    public void AccelerateDecelerateInterpolator(View view) {
        startActivity(AccelerateDecelerateInterpolatorActivity.class);
    }

    public void AccelerateInterpolator(View view) {
        startActivity(AccelerateInterpolatorActivity.class);
    }

    public void AnticipateInterpolator(View view) {
        startActivity(AnticipateInterpolatorActivity.class);
    }

    public void AnticipateOvershootInterpolator(View view) {
        startActivity(AnticipateOvershootInterpolatorActivity.class);
    }

    public void BounceInterpolator(View view) {
        startActivity(BounceInterpolatorActivity.class);
    }

    public void CycleInterpolator(View view) {
        startActivity(CycleInterpolatorActivity.class);
    }

    public void DecelerateInterpolator(View view) {
        startActivity(DecelerateInterpolatorActivity.class);
    }

    public void LinearInterpolator(View view) {
        startActivity(LinearInterpolatorActivity.class);
    }

    public void OvershootInterpolator(View view) {
        startActivity(OvershootInterpolatorActivity.class);
    }


    private void startActivity(Class mClass) {
        startActivity(new Intent(this, mClass));
    }

}
