package com.liugl.alltest.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;
import com.liugl.alltest.view.datapick.DatePickActivity;
import com.liugl.alltest.view.gaussian.GaussianBlurActivity;
import com.liugl.alltest.view.progress.Progress01Activity;
import com.liugl.alltest.view.recyclerviewmulitlayout.RecycleViewMulitLayoutActivity;
import com.liugl.alltest.view.relatvie.Relativelayout_Activity;
import com.liugl.alltest.view.shijianzhou.ShiJianZhouActivity;
import com.liugl.alltest.view.viewpagernetsgridview.ViewPagerNestGridViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UIMain3Activity extends BaseActivity {

    @BindView(R.id.datapic)
    Button datapic;
    @BindView(R.id.activity_uimain3)
    RelativeLayout activityUimain3;
    @BindView(R.id.vpgridview)
    Button vpgridview;
    @BindView(R.id.rvmulit)
    Button rvmulit;
    @BindView(R.id.timezhou)
    Button timezhou;
    @BindView(R.id.progressJvhua)
    Button progressJvhua;
    @BindView(R.id.relativeAverage)
    Button relativeAverage;
    @BindView(R.id.gaussianBlurBtn)
    Button gaussianBlurBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uimain3);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.gaussianBlurBtn,R.id.relativeAverage,R.id.progressJvhua,R.id.timezhou,R.id.vpgridview, R.id.datapic,R.id.rvmulit})
    public void onBtnClick(View view) {

        switch (view.getId()) {
            case R.id.datapic:
                Intent datapickItent = new Intent(this, DatePickActivity.class);
                startActivity(datapickItent);
                break;
            case R.id.vpgridview:
                Intent vpIntent = new Intent(this, ViewPagerNestGridViewActivity.class);
                startActivity(vpIntent);
                break;
            case R.id.rvmulit:
                Intent rvmltyoautIntent = new Intent(this, RecycleViewMulitLayoutActivity.class);
                startActivity(rvmltyoautIntent);
                break;
            case R.id.timezhou:
                Intent timezhouIntent = new Intent(this, ShiJianZhouActivity.class);
                startActivity(timezhouIntent);
                break;
            case R.id.progressJvhua:
                Intent progressJvhuaIntent = new Intent(this, Progress01Activity.class);
                startActivity(progressJvhuaIntent);
                break;
            case R.id.relativeAverage:

                Intent relativeAverageIntent = new Intent(this, Relativelayout_Activity.class);
                startActivity(relativeAverageIntent);

                break;

            case R.id.gaussianBlurBtn:

                Intent gaussianBlurIntent = new Intent(this, GaussianBlurActivity.class);
                startActivity(gaussianBlurIntent);

                break;
        }

    }

}
