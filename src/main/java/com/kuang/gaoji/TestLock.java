package com.kuang.gaoji;

import java.util.concurrent.locks.ReentrantLock;

/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/14  8:57
 */
// 测试Lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2=new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();

    }
}

class TestLock2 implements Runnable{
    int ticketNums=10;
    // 定义loc锁
   private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try{
                lock.lock();//加锁
                if(ticketNums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }
            finally {
               // 解锁
               lock.unlock();
            }

        }

    }
}
