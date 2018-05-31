package com.liugl.alltest.animation.propertyanima;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.liugl.alltest.R;

public class PropertyAnimationActivity extends AppCompatActivity implements View.OnClickListener {


    Button obje_01;
    Button obje_02;
    Button propertyValuesHolderBtn;
    Button ValueAnimatorBtn;
    Button AnimatorSetBtn;
    Button Evaluators;
    TextView text_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        obje_01 = (Button) this.findViewById(R.id.obje_01);
        obje_02 = (Button) this.findViewById(R.id.obje_02);
        ValueAnimatorBtn = (Button) this.findViewById(R.id.ValueAnimatorBtn);
        AnimatorSetBtn = (Button) this.findViewById(R.id.AnimatorSetBtn);
        Evaluators = (Button) this.findViewById(R.id.Evaluators);
        propertyValuesHolderBtn = (Button) this.findViewById(R.id.propertyValuesHolderBtn);
        text_01 = (TextView) this.findViewById(R.id.text_01);

        text_01.setOnClickListener(this);
        obje_01.setOnClickListener(this);
        obje_02.setOnClickListener(this);
        propertyValuesHolderBtn.setOnClickListener(this);
        ValueAnimatorBtn.setOnClickListener(this);
        AnimatorSetBtn.setOnClickListener(this);
        Evaluators.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_01:
                Toast.makeText(PropertyAnimationActivity.this,"看看我哦哦哦",Toast.LENGTH_LONG).show();
                break;
            case R.id.obje_01:
                String a = null;
//                a.length();
                ObjectAnimator.ofFloat(text_01, "rotationY", 0.0f, 360.0f).setDuration(1000).start();

                 break;

            case R.id.obje_02:
                ObjectAnimator mObjectAnimator= ObjectAnimator.ofFloat(text_01, "rotationY", 1,  360).setDuration(2000);
                mObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation)
                    {
                        float value = (float) animation.getAnimatedValue();  //可以获取当前属性值
                        Log.e("value_tag","value= " + value);
                        text_01.postInvalidate();  //可以主动刷新
                        text_01.setX(value);
                        text_01.setY(value);
                        //......可以批量修改属性
                    }
                });
                mObjectAnimator.start();
                break;
            case R.id.propertyValuesHolderBtn:
                PropertyValuesHolder a1 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
                PropertyValuesHolder a2 = PropertyValuesHolder.ofFloat("translationY", 0, 720);
                ObjectAnimator.ofPropertyValuesHolder(text_01, a1, a2).setDuration(3000).start();
//                ObjectAnimator.ofPropertyValuesHolder(text_01,  a2).setDuration(3000).start();
                break;
            case R.id.ValueAnimatorBtn:

                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,800);
                valueAnimator.setTarget(text_01);
                valueAnimator.setDuration(2000).start();
                valueAnimator.setInterpolator(new BounceInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float value = (float) animation.getAnimatedValue();
                        text_01.setTranslationX(value);
//                        text_01.setX(value);

//                        text_01.setXXX(value);  //必须通过这里设置属性值才有效
//                        view.mXXX = value;  //不需要setXXX属性方法
                    }
                });

                break;
            case R.id.AnimatorSetBtn:

                ObjectAnimator obj1 = ObjectAnimator.ofFloat(text_01,"alpha",1,0);
                ObjectAnimator obj2 = ObjectAnimator.ofFloat(text_01,"translationY",0f,700);


//                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
//                ScaleAnimation scaleAnimation = new ScaleAnimation(4.0f, 1.0f,
//                        4.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f,
//                        Animation.RELATIVE_TO_SELF, 0.5f);
//                AnimationSet set = new AnimationSet(true);
//                set.setInterpolator(new AccelerateDecelerateInterpolator());
//
//                set.addAnimation(alphaAnimation);
//                set.addAnimation(scaleAnimation);
//                set.setDuration(3000);
//
//                set.start();


                /**
                 * 简介: AnimatorSet 和 AnimationSet 都是动画集合。这里简单介绍下他们的异同，了解这些后在设计动画实现时才能得心应手。
                 AnimationSet 我们最常用的是调用其 addAnimation 将一个个不一样的动画组织到一起来，然后调用view 的 startAnimation 方法触发这些动画执行。功能较弱不能做到把集合中的动画按一定顺序进行组织然后在执行的定制。

                 AnimatorSet 我们最常用的是调用其play、before、with、after 等方法设置动画的执行顺序，然后调用其start 触发动画执行。

                 AnimationSet 与 AnimatorSet 最大的不同在于，AnimationSet 使用的是 Animation 子类、AnimatorSet 使用的是 Animator 的子类。

                 Animation 是针对视图外观的动画实现，动画被应用时外观改变但视图的触发点不会发生变化，还是在原来定义的位置。

                 Animator  是针对视图属性的动画实现，动画被应用时对象属性产生变化，最终导致视图外观变化。

                 Animator详解参考：
                 */
                AnimatorSet animSet = new AnimatorSet();
                animSet.setDuration(2000);
                animSet.setInterpolator(new LinearInterpolator());
//                animSet.play(obj1).after(obj2);//先后执行
                animSet.playTogether(obj1,obj2);//两个动画同时执行
                animSet.start();


                break;

            case R.id.Evaluators:

                Evaluator();

                break;


        }
    }


    private void Evaluator(){
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(5000);
        valueAnimator.setObjectValues(new float[2]); //设置属性值类型
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<float[]>()
        {
            @Override
            public float[] evaluate(float fraction, float[] startValue,
                                    float[] endValue)
            {
                //实现自定义规则计算的float[]类型的属性值
                Log.e("fraction","fraction= " + fraction);
                float[] temp = new float[2];
                temp[0] = fraction * 2;
                temp[1] = (float)Math.random() * 10 * fraction;
                return temp;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                float[] xyPos = (float[]) animation.getAnimatedValue();
                Log.e("fraction","xyPos[0]= " + xyPos[0] + "     " + "xyPos[1]= " + xyPos[1]);
//                text_01.setHeight(Integer.parseInt("" + xyPos[0]));   //通过属性值设置View属性动画
//                text_01.setWidth(Integer.parseInt("" + xyPos[1]));    //通过属性值设置View属性动画
            }
        });
    }


}
