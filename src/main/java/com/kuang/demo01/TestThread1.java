package com.kuang.demo01;
/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/10  22:16
 */

// 创建线程的方式一：集成Thread类，重写run()方法,调用start开启线程
// 总结：注意，线程开启不一定立即执行，由CPU调度执行
public class TestThread1 extends Thread{
    @Override
    public void run() {
        // run方法线程体
        for(int i=0;i<20;i++){
            System.out.println("我在看代码---"+i);
        }
    }

    public static void main(String[] args) {
        //main线程,主线程

        // 创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
        // 调用start()方法开启线程
        testThread1.start();


        for(int i=0;i<200;i++){
            System.out.println("我在学习多线程---"+i);
        }
    }
}
