package com.kuang.state;
/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/11  13:59
 */
// 测试Join方法 想象为插队
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        TestJoin testJoin =new TestJoin();
        Thread thread=new Thread(testJoin);
        thread.start();
        //主线程
        for (int i = 0; i < 500; i++) {
            if(i==200){
                thread.join();// 插队
            }
            System.out.println("main"+i);
        }
        
    }
}
