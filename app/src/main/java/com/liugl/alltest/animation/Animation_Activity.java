package com.liugl.alltest.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import com.liugl.alltest.R;
import com.liugl.alltest.animation.defualtinterpolator.TweenDefaultInterpolatorActivity;
import com.liugl.alltest.animation.propertyanima.PropertyAnimationActivity;
import com.liugl.alltest.animation.springanimator.BezierInterploatorActivity;
import com.liugl.alltest.animation.springanimator.SpringAllActivity;

public class Animation_Activity extends AppCompatActivity implements View.OnClickListener {

    BounceInterpolator bounceInterpolator;

    Button tweenDefaultInterpolator;
    Button propertyAnimationBtn;
    Button springAnimator;
    Button beziSpringAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_);
        tweenDefaultInterpolator = (Button) this.findViewById(R.id.tweenDefaultInterpolator);
        propertyAnimationBtn = (Button) this.findViewById(R.id.propertyAnimationBtn);
        springAnimator = (Button) this.findViewById(R.id.springAnimator);
        beziSpringAnimator = (Button) this.findViewById(R.id.beziSpringAnimator);

        tweenDefaultInterpolator.setOnClickListener(this);
        propertyAnimationBtn.setOnClickListener(this);
        springAnimator.setOnClickListener(this);
        beziSpringAnimator.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tweenDefaultInterpolator:
                Intent tweenDefaultInterpolatorIntent = new Intent(this,TweenDefaultInterpolatorActivity.class);
                this.startActivity(tweenDefaultInterpolatorIntent);
                break;
            case R.id.propertyAnimationBtn:
                Intent propertyAnimationBtnIntent = new Intent(this,PropertyAnimationActivity.class);
                this.startActivity(propertyAnimationBtnIntent);
                break;
            case R.id.springAnimator:

                Intent springIntent = new Intent(this,SpringAllActivity.class);
                this.startActivity(springIntent);

                break;
            case R.id.beziSpringAnimator:

                Intent bspringIntent = new Intent(this,BezierInterploatorActivity.class);
                this.startActivity(bspringIntent);
                break;
        }
    }
}
