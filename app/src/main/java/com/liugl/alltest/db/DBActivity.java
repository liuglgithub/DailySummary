package com.liugl.alltest.db;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DBActivity extends AppCompatActivity {

    @BindView(R.id.button10)
    Button button10;
    SQLiteDatabase db;
    openHelper3 helper3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.button10})
    public void viewOnClick(View view){

        switch (view.getId()){
            case R.id.button10:
                  helper3 = new openHelper3(this);
                  db = helper3.getWritableDatabase();
                break;
        }

    }
}
