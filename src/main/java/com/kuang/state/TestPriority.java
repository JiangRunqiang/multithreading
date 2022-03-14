package com.kuang.state;
/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/11  14:46
 */

// 测试线程的优先级
public class TestPriority extends Thread{
    public static void main(String[] args) {
        // 主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"==>"+Thread.currentThread().getPriority());

        MyPriority myPriority=new MyPriority();
        Thread t1=new Thread(myPriority);
        Thread t2=new Thread(myPriority);
        Thread t3=new Thread(myPriority);
        Thread t4=new Thread(myPriority);
        Thread t5=new Thread(myPriority);
        Thread t6=new Thread(myPriority);
        // 先设置优先级再启动
        t1.start();
        t2.setPriority(1);
        t2.start();
        t3.setPriority(3);
        t3.start();
        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();
//        t5.setPriority(-1);
//        t5.start();
//        t6.setPriority(11);
//        t6.start();


    }
}


class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"==>"+Thread.currentThread().getPriority());
    }
}
