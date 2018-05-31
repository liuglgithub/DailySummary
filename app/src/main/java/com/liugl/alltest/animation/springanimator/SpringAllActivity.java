package com.liugl.alltest.animation.springanimator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

public class SpringAllActivity extends AppCompatActivity implements View.OnClickListener {


    Button spring_01;
    Button spring_02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_all);
        spring_01 = (Button) this.findViewById(R.id.spring_01);
        spring_02 = (Button) this.findViewById(R.id.spring_02);

        spring_01.setOnClickListener(this);
        spring_02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.spring_01:
                Intent springIntent = new Intent(this,SpringOneActivity.class);
                this.startActivity(springIntent);
                break;
            case R.id.spring_02:
                Intent qspringIntent = new Intent(this,QSpringActivity.class);
                this.startActivity(qspringIntent);
                break;
        }
    }
}
