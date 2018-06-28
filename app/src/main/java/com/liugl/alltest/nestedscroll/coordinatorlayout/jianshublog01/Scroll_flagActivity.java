package com.liugl.alltest.nestedscroll.coordinatorlayout.jianshublog01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.liugl.alltest.R;

/**
 * scroll： 隐藏的时候，先整体向上滚动，
 * 直到 AppBarLayout 完全隐藏，再开始滚动 Scrolling View；
 * 显示的时候，直到 Scrolling View 顶部完全出现后，再开始滚动 AppBarLayout 到完全显示。
 */
public class Scroll_flagActivity extends AppCompatActivity {

    TextView scroll_flag_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_flag);
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
