package com.liugl.alltest.animation.springanimator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.liugl.alltest.R;
import com.liugl.alltest.animation.springanimator.bezierinterpolator.EaseCubicInterpolator;
import com.liugl.alltest.animation.springanimator.interpolator.SpringScaleInterpolator;

public class BezierInterploatorActivity extends AppCompatActivity implements View.OnClickListener {



    ImageView animation_image;
    Button normal_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier_interploator);
        animation_image = this.findViewById(R.id.animation_image);
        normal_animation = this.findViewById(R.id.normal_animation);
        normal_animation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == normal_animation){
//            ObjectAnimator obj011 = ObjectAnimator.ofFloat(animation_image,"scaleX",1f,1.8f);
//            ObjectAnimator obj022 = ObjectAnimator.ofFloat(animation_image,"scaleY",1f,1.8f);
//            AnimatorSet set1 = new AnimatorSet();
//            set1.setDuration(2000);
//            set1.setInterpolator(new SpringScaleInterpolator(0.4f));
//            set1.playTogether(obj011,obj022);
//            set1.start();

            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,800);
            valueAnimator.setTarget(animation_image);
            valueAnimator.setDuration(2000).start();
//            valueAnimator.setInterpolator(new EaseCubicInterpolator(0.22f,1.18f,0.87f,1.04f));
//            valueAnimator.setInterpolator(new EaseCubicInterpolator(0.94f,0.37f,0.11f,1.07f));
            valueAnimator.setInterpolator(new EaseCubicInterpolator(0.3f,1.63f,0.28f,0.69f));
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value = (float) animation.getAnimatedValue();
                    animation_image.setTranslationX(value);
//                        text_01.setX(value);

//                        text_01.setXXX(value);  //必须通过这里设置属性值才有效
//                        view.mXXX = value;  //不需要setXXX属性方法
                }
            });
            valueAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });


        }
    }
}
