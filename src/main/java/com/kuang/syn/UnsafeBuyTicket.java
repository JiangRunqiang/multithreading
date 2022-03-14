package com.kuang.syn;

import jdk.management.resource.internal.inst.ThreadRMHooks;

/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/11  16:41
 */
// 不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket=new BuyTicket();
        new Thread(buyTicket,"小明").start();
        new Thread(buyTicket,"老师").start();
        new Thread(buyTicket,"黄牛").start();
    }

}

class BuyTicket implements Runnable{
    //票
    private int ticketNums=10;
    boolean  flag=true; // 外部停止方式
    @Override
    public void run() {
        // 买票
        while (flag){
            buy();
        }


    }
    //synchronized 同步方法，锁的是this
    private synchronized void  buy()  {
        //判断是否有票
        if(ticketNums<=0){
            flag=false;
            return;
        }
        // 模拟延时，放大问题的发生性
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 买票
        System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--);
    }
}
