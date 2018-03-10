package com.liugl.alltest.nestedscroll.coordinatorlayout.all01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

public class CoordinatorLayoutAllActivity extends AppCompatActivity implements View.OnClickListener {

    private Button systemDefaultScroll;
    private Button selfDefaultScroll;
    private Button tabLayoutToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_all);
//        ButterKnife.bind(this);
        initViews();
    }

    private void initViews(){
        systemDefaultScroll = (Button) this.findViewById(R.id.systemDefaultScroll);
        selfDefaultScroll = (Button) this.findViewById(R.id.selfDefaultScroll);
        tabLayoutToolbar = (Button) this.findViewById(R.id.tabLayoutToolbar);
        systemDefaultScroll.setOnClickListener(this);
        selfDefaultScroll.setOnClickListener(this);
        tabLayoutToolbar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.systemDefaultScroll:
                Intent systemDefaultScrollIntent = new Intent(this,SystemDefaultScrollActivity.class);
                startActivity(systemDefaultScrollIntent);
                break;
            case R.id.selfDefaultScroll:
                Intent selfDefaultScrollIntent = new Intent(this,SlefDefindScrollActivity.class);
                startActivity(selfDefaultScrollIntent);
                break;
            case R.id.tabLayoutToolbar:

                Intent tabLayoutToolbarIntent = new Intent(this,TableLayoutScrollActivity.class);
                startActivity(tabLayoutToolbarIntent);

                break;
        }
    }
}
