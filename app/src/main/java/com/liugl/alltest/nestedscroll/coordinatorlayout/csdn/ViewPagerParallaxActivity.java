package com.liugl.alltest.nestedscroll.coordinatorlayout.csdn;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.liugl.alltest.R;
import com.liugl.alltest.nestedscroll.coordinatorlayout.csdn.adapter.BaseFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 要实现视差效果，appbarlayot内需要嵌套CollapsingToolbarLayout
 */
public class ViewPagerParallaxActivity extends AppCompatActivity {

    ViewPager mViewPager;
    List<Fragment> mFragments;
    Toolbar mToolbar;

    String[]  mTitles=new String[]{
            "主页","微博","相册"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_parallax);


        mToolbar= (Toolbar) findViewById(R.id.toolbar);

        mToolbar.setTitle("唐嫣");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setupViewPager();

    }
    private void setupViewPager() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        mFragments=new ArrayList<>();
        for(int i=0;i<mTitles.length;i++){
            ListFragment listFragment = ListFragment.newInstance(mTitles[i]);
            mFragments.add(listFragment);
        }
        BaseFragmentAdapter adapter =
                new BaseFragmentAdapter(getSupportFragmentManager(),mFragments,mTitles);



        viewPager.setAdapter(adapter);
    }
}
