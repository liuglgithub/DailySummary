package com.liugl.alltest.nestedscroll.coordinatorlayout.csdn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.liugl.alltest.R;
import com.liugl.alltest.nestedscroll.coordinatorlayout.csdn.adapter.ItemAdapter;
import com.liugl.alltest.nestedscroll.coordinatorlayout.csdn.divder.DividerItemDecoration;

import java.util.ArrayList;

public class ZhihuBottom01Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;
    private ItemAdapter mItemAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu_bottom01);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);



        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        mDatas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String s = String.format("我是第%d个item", i);
            mDatas.add(s);
        }
        mItemAdapter = new ItemAdapter(this, mDatas);
        mRecyclerView.setAdapter(mItemAdapter);
    }
}
