package com.liugl.alltest.mulitthread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liugl on 2017/10/19.
 */

public class MultiThread {


    // 用Collections.synchronizedList让list线程安全
    public final static List<Long> list = Collections.synchronizedList(new ArrayList<Long>());

    public static void main() {
// 为List添加100个数据
        for (int i = 1; i <= 20; i++) {
            list.add(Long.valueOf(i));
        }

        MyThread myThread = new MyThread();
// 开启四个线程处理list数据
        Thread t1 = new Thread(myThread);
        t1.setName("线程1");
        t1.start();

        Thread t2 = new Thread(myThread);
        t2.setName("线程2");
        t2.start();

        Thread t3 = new Thread(myThread);
        t3.setName("线程3");
        t3.start();

        Thread t4 = new Thread(myThread);
        t4.setName("线程4");
        t4.start();
    }


}
