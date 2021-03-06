package com.liugl.alltest.nestedscroll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;
import com.liugl.alltest.nestedscroll.coordinatorlayout.csdn.CSDN01Activity;
import com.liugl.alltest.nestedscroll.coordinatorlayout.all01.CoordinatorLayoutAllActivity;
import com.liugl.alltest.nestedscroll.coordinatorlayout.demo01.MyBehaviroTowTextviewActivity;
import com.liugl.alltest.nestedscroll.coordinatorlayout.demo2.EaseyBehaviorActivity;
import com.liugl.alltest.nestedscroll.coordinatorlayout.jianshublog01.JianshuBlog_one_Activity;
import com.liugl.alltest.nestedscroll.coordinatorlayout.jianshublog01.weibo.WeiboFindActivity;
import com.liugl.alltest.nestedscroll.coordinatorlayout.uc.UCBehavieMain3Activity;
import com.liugl.alltest.nestedscroll.defapi.DefApiActivity;
import com.liugl.alltest.nestedscroll.nestedapi.NestedApiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NestedScrollHomeActivity extends BaseActivity {

    @BindView(R.id.def)
    Button defBtn;

    @BindView(R.id.nestedscrool)
    Button nestedBtn;

    @BindView(R.id.behavior_01)
    Button behavior_01;
    @BindView(R.id.btn_txt)
    Button btnTxt;
    @BindView(R.id.activity_nested_scroll_home)
    RelativeLayout activityNestedScrollHome;
    @BindView(R.id.ucbtn_txt)
    Button ucbtnTxt;

    @BindView(R.id.allCoordinatorLayout)
    Button allCoordinatorLayout;

    @BindView(R.id.cblog_01)
    Button cblog_01;

    @BindView(R.id.weiboblog_01)
    Button weiboblog_01;

    @BindView(R.id.csdnblog_01)
    Button csdnblog_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_scroll_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.csdnblog_01,R.id.weiboblog_01, R.id.cblog_01, R.id.allCoordinatorLayout, R.id.ucbtn_txt, R.id.btn_txt, R.id.behavior_01, R.id.def, R.id.nestedscrool})
    public void onViewClick(View view) {
        switch (view.getId()) {
            case R.id.def:
                Intent qiantaohuadong = new Intent(this, DefApiActivity.class);
                startActivity(qiantaohuadong);
                break;
            case R.id.nestedscrool:
                Intent nestedscrool = new Intent(this, NestedApiActivity.class);
                startActivity(nestedscrool);
                break;
            case R.id.behavior_01:
                Intent behavior_01 = new Intent(this, MyBehaviroTowTextviewActivity.class);
                startActivity(behavior_01);
                break;
            case R.id.btn_txt:
                Intent behavior_btn = new Intent(this, EaseyBehaviorActivity.class);
                startActivity(behavior_btn);
                break;
            case R.id.ucbtn_txt:
                Intent uc = new Intent(this, UCBehavieMain3Activity.class);
                startActivity(uc);
                break;
            case R.id.allCoordinatorLayout:

                Intent allCoordinatorLayoutIntent = new Intent(this, CoordinatorLayoutAllActivity.class);
                startActivity(allCoordinatorLayoutIntent);

                break;
            case R.id.cblog_01:

                Intent cblog_01 = new Intent(this, JianshuBlog_one_Activity.class);
                startActivity(cblog_01);

                break;
            case R.id.weiboblog_01:
                Intent weiboblog_01 = new Intent(this, WeiboFindActivity.class);
                startActivity(weiboblog_01);
                break;
            case R.id.csdnblog_01:
                Intent csdnblog_01 = new Intent(this, CSDN01Activity.class);
                startActivity(csdnblog_01);
                break;
        }
    }
}
