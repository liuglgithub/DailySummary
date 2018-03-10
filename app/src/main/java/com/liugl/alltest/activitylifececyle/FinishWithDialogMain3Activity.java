package com.liugl.alltest.activitylifececyle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FinishWithDialogMain3Activity extends AppCompatActivity {

    @BindView(R.id.dialog_pop)
    Button dialogPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_with_dialog_main3);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.dialog_pop})
    public void viewOnclick(View v) {
        switch (v.getId()) {
            case R.id.dialog_pop:

                show();
                break;
        }
    }


    void show() {

        // TODO Auto-generated method stub

        new AlertDialog.Builder(FinishWithDialogMain3Activity.this).setTitle("系统提示")//设置对话框标题

                .setMessage("请确认所有数据都保存后再推出系统！")//设置显示的内容

                .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加确定按钮


                    @Override

                    public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                        // TODO Auto-generated method stub

                        finish();

                    }

                }).setNegativeButton("返回", new DialogInterface.OnClickListener() {//添加返回按钮


            @Override

            public void onClick(DialogInterface dialog, int which) {//响应事件

                // TODO Auto-generated method stub

                Log.i("alertdialog", " 请保存数据！");

            }

        }).show();//在按键响应事件中显示此对话框


    }


    public static String TAG = "lifecyel_dia";


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "2=onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "2=onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "2=onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "2=onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "2=onDestroy");
    }

}
