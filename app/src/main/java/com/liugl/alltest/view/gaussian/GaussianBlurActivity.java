package com.liugl.alltest.view.gaussian;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.widget.ImageView;

import com.liugl.alltest.R;

public class GaussianBlurActivity extends AppCompatActivity {


    private ImageView blurImg;
    private Bitmap sampleImg;
    private Bitmap gaussianBlurImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaussian_blur);
        blurImg = (ImageView) findViewById(R.id.blurImg);
        //获取当前时间戳
        long timeStamp = System.currentTimeMillis();
        Log.d("const", timeStamp + "");
        sampleImg = BitmapFactory.decodeResource(getResources(), R.drawable.mv); // 获取原图
        gaussianBlurImg = blur(sampleImg, 25f);
        blurImg.setImageBitmap(gaussianBlurImg);
        long timeStamp02 = System.currentTimeMillis();
        long all = timeStamp02 - timeStamp;
        Log.d("const", "all= " + all);
    }

    private Bitmap blur(Bitmap bitmap, float radius) {
        Bitmap output = Bitmap.createBitmap(bitmap); // 创建输出图片
        RenderScript rs = RenderScript.create(this); // 构建一个RenderScript对象
        ScriptIntrinsicBlur gaussianBlue = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs)); // 创建高斯模糊脚本
        Allocation allIn = Allocation.createFromBitmap(rs, bitmap); // 创建用于输入的脚本类型
        Allocation allOut = Allocation.createFromBitmap(rs, output); // 创建用于输出的脚本类型
        gaussianBlue.setRadius(radius); // 设置模糊半径，范围0f<radius<=25f
        gaussianBlue.setInput(allIn); // 设置输入脚本类型
        gaussianBlue.forEach(allOut); // 执行高斯模糊算法，并将结果填入输出脚本类型中
        allOut.copyTo(output); // 将输出内存编码为Bitmap，图片大小必须注意
        rs.destroy(); // 关闭RenderScript对象，API>=23则使用rs.releaseAllContexts()
        return output;
    }

}
