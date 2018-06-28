package com.liugl.alltest.nestedscroll.coordinatorlayout.jianshublog01.weibo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

public class WeiboFindActivity extends AppCompatActivity implements View.OnClickListener {

    Button pro_01;
    Button pro_02;
    Button pro_03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weibo_find);
        pro_01 = this.findViewById(R.id.pro_01);
        pro_02 = this.findViewById(R.id.pro_02);
        pro_03 = this.findViewById(R.id.pro_03);

        pro_01.setOnClickListener(this);
        pro_02.setOnClickListener(this);
        pro_03.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pro_01:
                Intent pro_01 = new Intent(this, Pro_01Activity.class);
                startActivity(pro_01);
                break;
            case R.id.pro_02:
                Intent pro_02 = new Intent(this, Pro_02Activity.class);
                startActivity(pro_02);
                break;
            case R.id.pro_03:
                break;
        }
    }
}
