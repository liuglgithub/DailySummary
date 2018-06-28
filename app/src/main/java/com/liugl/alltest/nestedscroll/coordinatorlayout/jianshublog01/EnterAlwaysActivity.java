package com.liugl.alltest.nestedscroll.coordinatorlayout.jianshublog01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.liugl.alltest.R;

/**
 * 向下滑动的时候，先把标题栏显示出来，之后再滑动下面的可滑动scv控件
 */
public class EnterAlwaysActivity extends AppCompatActivity {

    private TextView scroll_flag_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_always);
        scroll_flag_tv = this.findViewById(R.id.scroll_flag_tv);
        String text = "1" +
                "\n"+"2"+
                "\n"+"3"+
                "\n"+"4"+
                "\n"+"5"+
                "\n"+"6"+
                "\n"+"7"+
                "\n"+"8"+
                "\n"+"9"+
                "\n"+"10"+
                "\n"+"11"+
                "\n"+"12"+
                "\n"+"13"+
                "\n"+"14"
                + "\n"+"15"
                + "\n"+"17"
                + "\n"+"18"
                + "\n"+"19"
                + "\n"+"20"
                + "\n"+"21"



                ;
        scroll_flag_tv.setText(text);
    }
}
