package com.liugl.alltest.cach;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;
import com.liugl.alltest.cach.acache.ACache;
import com.liugl.alltest.cach.acache.AcacheBean;

public class CachMain2Activity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "CachMain2Activity";
    Button acacheBtn;
    Button gettacache_btn;
    Button setBoolean;
    Button getBoolean;

    AcacheBean mAcacheBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cach_main2);
        initView();
        initBean();
    }

    private void initView(){

        acacheBtn = (Button) this.findViewById(R.id.acache_btn);
        gettacache_btn = (Button) this.findViewById(R.id.gettacache_btn);
        setBoolean = (Button) this.findViewById(R.id.setBoolean);
        getBoolean = (Button) this.findViewById(R.id.getBoolean);
        acacheBtn.setOnClickListener(this);
        gettacache_btn.setOnClickListener(this);
        setBoolean.setOnClickListener(this);
        getBoolean.setOnClickListener(this);
    }

    private void initBean(){
        mAcacheBean = new AcacheBean();
        mAcacheBean.setPwd("pwd");
        mAcacheBean.setUserName("testname");
        mAcacheBean.setAge(18);
    }

    //LRU缓存
    private LruCache<String, Bitmap> mCache;

    private void initLruCach() {

        //返回Java虚拟机将尝试使用的最大内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        //指定缓存大小
        int cacheSize = maxMemory / 4;

        mCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //Bitmap的实际大小 注意单位与maxMemory一致
                return value.getByteCount();
            }
        };
    }

    @Override
    public void onClick(View v) {
        if (v == acacheBtn){
            ACache.get(this).put("testbean",mAcacheBean);
        }else if (v == gettacache_btn){
//            setBoolean.setOnClickListener(this);
//            getBoolean.setOnClickListener(this);
            AcacheBean tmpBean = null;
            tmpBean = (AcacheBean) ACache.get(this).getAsObject("testbean");
            Log.e(TAG,tmpBean.getUserName());
            Log.e(TAG,tmpBean.getAge()+"");
        }else if (v==setBoolean ){
            ACache.get(this).put("testbeanBool",true);
        }else if(v==getBoolean){
            boolean tb = ACache.get(this).getAsBoolean("testbeanBool",false);
            Log.e(TAG,"tb = "+ tb);
        }


    }
}
