package com.liugl.alltest.view.sharepbg;

import android.graphics.Outline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import com.liugl.alltest.R;

public class SharepActivity extends AppCompatActivity {
private ImageView  paddingImg;
private ImageView  outlineProImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharep);
        paddingImg = (ImageView) this.findViewById(R.id.paddingImg);
        outlineProImg = (ImageView) this.findViewById(R.id.outlineProImg);
        paddingImg.setPadding(15,15,15,15);






        ViewOutlineProvider viewOutlineProvider  = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //x，y轴表示位置，后两个参数表示长，宽
                outline.setOval(0,0,outlineProImg.getWidth(),outlineProImg.getHeight());
            }
        };
        outlineProImg.setOutlineProvider(viewOutlineProvider);
    }
}
