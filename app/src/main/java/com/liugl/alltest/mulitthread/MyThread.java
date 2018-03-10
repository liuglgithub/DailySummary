package com.liugl.alltest.mulitthread;

import android.util.Log;

import java.util.List;

/**
 * Created by liugl on 2017/10/19.
 */

public class MyThread implements Runnable{
    private final List<Long> list = MultiThread.list;

    @Override
    public void run() {
        for (int i = 0; i < list.size(); i++) {
// 同步list，打印数据并删除该数据
            synchronized (list) {
                try {
//当前线程睡眠，让其它线程获得执行机会
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + list.get(i));
                Log.e("MyThread_all",Thread.currentThread().getName() + ":" + list.get(i));
//                list.remove(i);
            }
        }
    }
}
