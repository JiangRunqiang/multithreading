package com.kuang.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/13  0:40
 */
// 测试JUC安全类型的集合
public class TestJUC {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
