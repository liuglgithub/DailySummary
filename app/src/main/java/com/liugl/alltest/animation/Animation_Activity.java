package com.liugl.alltest.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import com.liugl.alltest.R;
import com.liugl.alltest.animation.defualtinterpolator.TweenDefaultInterpolatorActivity;

public class Animation_Activity extends AppCompatActivity implements View.OnClickListener {

    BounceInterpolator bounceInterpolator;

    Button tweenDefaultInterpolator;
    Button propertyAnimationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_);
        tweenDefaultInterpolator = (Button) this.findViewById(R.id.tweenDefaultInterpolator);
        propertyAnimationBtn = (Button) this.findViewById(R.id.propertyAnimationBtn);
        tweenDefaultInterpolator.setOnClickListener(this);
        propertyAnimationBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tweenDefaultInterpolator:
                Intent tweenDefaultInterpolatorIntent = new Intent(this,TweenDefaultInterpolatorActivity.class);
                this.startActivity(tweenDefaultInterpolatorIntent);
                break;
            case R.id.propertyAnimationBtn:

                break;
        }
    }
}
