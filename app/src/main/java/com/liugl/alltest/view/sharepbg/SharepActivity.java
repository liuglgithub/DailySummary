package com.liugl.alltest.view.sharepbg;

import android.graphics.Outline;
import android.graphics.Path;
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





//        outlineProImg.setElevation(5);

        ViewOutlineProvider viewOutlineProvider  = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //x，y轴表示位置，后两个参数表示长，宽
                outline.setOval(0,0,outlineProImg.getWidth(),outlineProImg.getHeight());
                //你可以用 Path 指定任何的形状，前提是凸多边形
                //这里设置投影的位置从右下角开始，投影形状是矩形
//                Path path = new Path();
//                path.moveTo(view.getWidth(), view.getHeight());
//                path.lineTo(view.getWidth(), view.getHeight() * 2);
//                path.lineTo(view.getWidth() * 2, view.getHeight() * 2);
//                path.lineTo(view.getWidth() * 2, view.getHeight());
//                path.close();
//                outline.setConvexPath(path);
            }
        };
//        outlineProImg.setOutlineProvider(viewOutlineProvider);
//        outlineProImg.setOutlineProvider(viewOutlineProvider);
//        outlineProImg.setClipToOutline( true);

    }
}
