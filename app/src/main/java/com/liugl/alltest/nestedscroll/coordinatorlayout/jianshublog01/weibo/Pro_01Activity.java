package com.liugl.alltest.nestedscroll.coordinatorlayout.jianshublog01.weibo;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.liugl.alltest.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * 两种实现tablayout悬停的方式
 * 第一种，
 * AppBarLayout里面嵌套一层layout。
 * 之后再嵌套两个layout
 * 第二种
 * AppBarLayout里面嵌套两个layout
 * 这时候发现只有第一个能处理参与滑动的操作，不清是否是因为behavior引起的
 * 但是第一种实现后，header下拉的动画没有了，，，，
 */
public class Pro_01Activity extends AppCompatActivity {


    //fragment的适配器
    private MainTabFragmentAdapter mainTabFragmentAdapter;

    //viewpager
    private ViewPager mViewPager;

    //AppBarLayout
    private AppBarLayout mAppBarLayout;

    //顶部HeaderLayout
    private LinearLayout headerLayout;

    private SmartTabLayout mTabs;

    //是否隐藏了头部
    private boolean isHideHeaderLayout = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_01);
        init();
    }

    //初始化方法
    private void init() {
        mTabs = (SmartTabLayout) findViewById(R.id.tabs);
        mainTabFragmentAdapter = new MainTabFragmentAdapter(getSupportFragmentManager(), this);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mainTabFragmentAdapter);
        mTabs.setViewPager(mViewPager);

        mViewPager.setOffscreenPageLimit(mainTabFragmentAdapter.getCount());
//        headerLayout = (LinearLayout) findViewById(R.id.ll_header_layout);
        headerLayout = (LinearLayout) findViewById(R.id.parent_ll_header_layout);
        initAppBarLayout();
    }

    // 初始化AppBarLayout
    private void initAppBarLayout() {
        LayoutTransition mTransition = new LayoutTransition();
        /**
         * 添加View时过渡动画效果
         */
        ObjectAnimator addAnimator = ObjectAnimator.ofFloat(null, "translationY", 0, 1.f).
                setDuration(mTransition.getDuration(LayoutTransition.APPEARING));
        mTransition.setAnimator(LayoutTransition.APPEARING, addAnimator);

        //header layout height
        final int headerHeight = getResources().getDimensionPixelOffset(R.dimen.header_height);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mAppBarLayout.setLayoutTransition(mTransition);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                verticalOffset = Math.abs(verticalOffset);
                if (verticalOffset >= headerHeight) {
                    isHideHeaderLayout = true;
                    //当偏移量超过顶部layout的高度时，我们认为他已经完全移动出屏幕了
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            AppBarLayout.LayoutParams mParams = (AppBarLayout.LayoutParams) headerLayout.getLayoutParams();
                            mParams.setScrollFlags(0);
//                            headerLayout.setLayoutParams(mParams);
//                            headerLayout.setVisibility(View.GONE);
                        }
                    }, 100);
                }
            }
        });


        mTabs.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {
            @Override
            public void onTabClicked(int position) {
                mAppBarLayout.setExpanded(false, true);
            }
        });

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //监听返回键
            if (isHideHeaderLayout) {
                isHideHeaderLayout = false;
                ((MainTabFragment) mainTabFragmentAdapter.getFragments().get(0)).getRvList().scrollToPosition(0);
                headerLayout.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        AppBarLayout.LayoutParams mParams = (AppBarLayout.LayoutParams) headerLayout.getLayoutParams();
                        mParams.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL |
                                AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
                        headerLayout.setLayoutParams(mParams);
                    }
                }, 300);
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
