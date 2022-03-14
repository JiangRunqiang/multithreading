package com.kuang.gaoji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/14  15:39
 */
// 测试线程池
public class TestPool {
    public static void main(String[] args) {
        // 1.创建服务，创建线程池
        // newFixedThreadPool:参数为 线程池的大小
        ExecutorService service= Executors.newFixedThreadPool(10);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        // 2 关闭连接
        service.shutdown();


    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName());

    }
}
