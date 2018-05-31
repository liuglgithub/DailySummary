package com.liugl.alltest.animation.springanimator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.liugl.alltest.R;
import com.liugl.alltest.animation.springanimator.interpolator.SpringScaleInterpolator;

public class SpringOneActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView animation_image;
    private Button normalAnimation;
    private Button springAnimationOne;
    private Button springAnimationTwo;
    private Button springAnimationThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_one);
        animation_image = (ImageView) findViewById(R.id.animation_image);
        normalAnimation = (Button) findViewById(R.id.normal_animation);
        springAnimationOne = (Button) findViewById(R.id.spring_animation_one);
        springAnimationTwo = (Button) findViewById(R.id.spring_animation_two);
        springAnimationThree = (Button) findViewById(R.id.spring_animation_three);

        normalAnimation.setOnClickListener(this);
        springAnimationOne.setOnClickListener(this);
        springAnimationTwo.setOnClickListener(this);
        springAnimationThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.normal_animation:
                ObjectAnimator obj01 = ObjectAnimator.ofFloat(animation_image,"scaleX",1f,1.8f);
                ObjectAnimator obj02 = ObjectAnimator.ofFloat(animation_image,"scaleY",1f,1.8f);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(2000);
                set.playTogether(obj01,obj02);
                set.start();
                break;
            case R.id.spring_animation_one:
                ObjectAnimator obj011 = ObjectAnimator.ofFloat(animation_image,"scaleX",1f,1.8f);
                ObjectAnimator obj022 = ObjectAnimator.ofFloat(animation_image,"scaleY",1f,1.8f);
                AnimatorSet set1 = new AnimatorSet();
                set1.setDuration(2000);
                set1.setInterpolator(new SpringScaleInterpolator(0.4f));
                set1.playTogether(obj011,obj022);
                set1.start();
                break;
            case R.id.spring_animation_two:

                /**
                 * 我们需要什么样的需求就重写对应方法就好。
                 上面的代码中有SpringConfig这个对象，通过看源码发现
                 他的构造函数接受两个变量：1.tension(拉力)、2.friction(摩擦力)。
                 作用是什么呢？很好理解tension拉力越大，弹性越大，friction
                 摩擦力越大，弹性效果越小
                 */


                SpringSystem springSystem = SpringSystem.create();
                Spring spring = springSystem.createSpring();
                spring.setCurrentValue(1.0f);
                spring.setSpringConfig(new SpringConfig(50,5));
                spring.addListener(new SimpleSpringListener(){
                    @Override
                    public void onSpringUpdate(Spring spring) {
                        super.onSpringUpdate(spring);
                        float currentValue = (float) spring.getCurrentValue();
                        animation_image.setScaleX(currentValue);
                        animation_image.setScaleY(currentValue);
                    }
                });
                spring.setEndValue(1.8f);


//                SpringSystem springSystem = SpringSystem.create();
//                Spring spring = springSystem.createSpring();
//                spring.setCurrentValue(1200.0f);
//                spring.setSpringConfig(new SpringConfig(50,5));
//                spring.addListener(new SimpleSpringListener(){
//                    @Override
//                    public void onSpringUpdate(Spring spring) {
//                        super.onSpringUpdate(spring);
//                        float currentValue = (float) spring.getCurrentValue();
////                        animation_image.setScaleX(currentValue);
////                        animation_image.setScaleY(currentValue);
//                        animation_image.setTranslationX(currentValue);
//                    }
//
//                });
//                spring.setEndValue(0f);

                break;
            case R.id.spring_animation_three:
                /**
                 * setStiffness()和setDampingRatio()方法来实现你想要的效果。
                 注意哦，stiffness的值越小，弹性效果越好，弹时间越长。
                 DampingRatio的值越大，弹性效果越差。
                 */

                SpringAnimation animationX = new SpringAnimation(animation_image, SpringAnimation.SCALE_X,1.8f);
                SpringAnimation animationY = new SpringAnimation(animation_image, SpringAnimation.SCALE_Y,1.8f);
                animationX.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
                animationX.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY);
                animationX.setStartValue(1.0f);

                animationY.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
                animationY.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY);
                animationY.setStartValue(1.0f);

                animationX.start();
                animationY.start();


//                SpringAnimation animationX = new SpringAnimation(animation_image, SpringAnimation.SCALE_X,1.8f);
//                SpringAnimation animationY = new SpringAnimation(animation_image, SpringAnimation.TRANSLATION_Y,122.8f);
//                animationX.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
//                animationX.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY);
//                animationX.setStartValue(1.0f);
//
//                animationY.getSpring().setStiffness(SpringForce.STIFFNESS_LOW);
//                animationY.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY);
//                animationY.setStartValue(1.0f);
//
//                animationX.start();
//                animationY.start();
                break;
        }

    }
}
