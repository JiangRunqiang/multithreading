package com.kuang.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/10  22:28
 */
// 练习Thread:实现多线程同时下载图片
public class TestThread2 implements Runnable {
    private String url;// 网络图片地址
    private String name;// 保存的文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }
    // 下载图片线程的执行体
    @Override
    public void run() {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url,name);
        System.out.println("下载了文件名为："+name);

    }

    public static void main(String[] args) {
        TestThread2 t1=new TestThread2("https://t7.baidu.com/it/u=1362366007,2277133945&fm=193&f=GIF","1.jpg");
        TestThread2 t2=new TestThread2("https://t7.baidu.com/it/u=1362366007,2277133945&fm=193&f=GIF","2.jpg");
        TestThread2 t3=new TestThread2("https://t7.baidu.com/it/u=1362366007,2277133945&fm=193&f=GIF","3.jpg");
        // 先下载t1
        new Thread(t1).start();
        // 然后是t2
        new Thread(t2).start();
        // 最后是t3
        new Thread(t3).start();



    }
}

// 下载器
class WebDownload {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现异常");
        }

    }
}