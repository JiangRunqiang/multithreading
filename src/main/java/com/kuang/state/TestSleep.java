package com.kuang.state;

import javafx.scene.chart.Axis;

/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/11  11:07
 */
// 模拟网络延时:放大问题的发生性
public class TestSleep implements Runnable {
    // 票数
    private int ticketNum = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNum-- + "票");
        }
    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();
        new Thread(ticket, "小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();

    }
}


