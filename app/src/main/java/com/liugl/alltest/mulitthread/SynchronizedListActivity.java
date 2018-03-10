package com.liugl.alltest.mulitthread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SynchronizedListActivity extends AppCompatActivity {

    @BindView(R.id.button9)
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronized_list);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button9})
    public void btnOnclick(View v) {
        switch (v.getId()) {
            case R.id.button9:
                MultiThread.main();
                break;
        }
    }
}
