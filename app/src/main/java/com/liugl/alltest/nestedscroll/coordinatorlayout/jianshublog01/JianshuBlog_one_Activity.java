package com.liugl.alltest.nestedscroll.coordinatorlayout.jianshublog01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

public class JianshuBlog_one_Activity extends AppCompatActivity implements View.OnClickListener {

    Button scroll_flag;
    Button enteralways_flag;
    Button collapsing_flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jianshu_blog_one_);
        scroll_flag = this.findViewById(R.id.scroll_flag);
        enteralways_flag = this.findViewById(R.id.enteralways_flag);
        collapsing_flag = this.findViewById(R.id.collapsing_flag);

        scroll_flag.setOnClickListener(this);
        enteralways_flag.setOnClickListener(this);
        collapsing_flag.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scroll_flag:
                Intent cblog_01 = new Intent(this, Scroll_flagActivity.class);
                startActivity(cblog_01);
                break;
            case R.id.enteralways_flag:
                Intent enteralways_flag = new Intent(this,
                        EnterAlwaysActivity.class);
                startActivity(enteralways_flag);
                break;
            case R.id.collapsing_flag:
                Intent collapsing_flag = new Intent(this,
                        CollapsingToolbarLayoutActivity.class);
                startActivity(collapsing_flag);
                break;
        }
    }
}
