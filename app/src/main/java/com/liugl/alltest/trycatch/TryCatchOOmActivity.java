package com.liugl.alltest.trycatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.liugl.alltest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TryCatchOOmActivity extends AppCompatActivity {

    @BindView(R.id.button8)
    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_catch_oom);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.button8})
    public void btnOnclick(View view) {
        switch (view.getId()) {

            case R.id.button8:

                main();

                break;
        }
    }

    public static void main() {
        int size = Integer.MAX_VALUE;
        int factor = 10;

        while (true) {
            try {
                System.out.println("Trying to allocate " + size + " bytes");
                byte[] bytes = new byte[size * 1000];
                System.out.println("Succeed!");
                break;
            } catch (OutOfMemoryError e) {
                System.out.println("OOME .. Trying again with 10x less");
                size /= factor;
            }
        }
    }

//    private static final int MEGABYTE = (1024*1024);
//    public static void runOutOfMemory() {
//        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
//        for (int i=1; i <= 100; i++) {
//            try {
//                byte[] bytes = new byte[MEGABYTE*500];
//            } catch (Exception e) {
//                e.printStackTrace();
//            } catch (OutOfMemoryError e) {
//                MemoryUsage heapUsage = memoryBean.getHeapMemoryUsage();
//                long maxMemory = heapUsage.getMax() / MEGABYTE;
//                long usedMemory = heapUsage.getUsed() / MEGABYTE;
//                System.out.println(i+ " : Memory Use :" + usedMemory + "M/" + maxMemory + "M");
//            }
//        }
//    }

}
