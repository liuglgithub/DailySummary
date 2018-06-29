package com.liugl.alltest.nestedscroll.coordinatorlayout.csdn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

/**
 * https://blog.csdn.net/gdutxiaoxu/article/details/52858598
 */
public class CSDN01Activity extends AppCompatActivity implements View.OnClickListener {

    Button vp01;
    Button vp02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csdn01);
        vp01 = this.findViewById(R.id.vp01);
        vp02 = this.findViewById(R.id.vp02);

        vp01.setOnClickListener(this);
        vp02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vp01:

                Intent csdnblog_01 = new Intent(this, ViewPager01Activity.class);
                startActivity(csdnblog_01);

                break;
            case R.id.vp02:

                Intent csdnblog_02 = new Intent(this, ViewPagerParallaxActivity.class);
                startActivity(csdnblog_02);

                break;
        }
    }
}
