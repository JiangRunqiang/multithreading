package com.kuang.demo02;
/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/10  23:37
 */

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

// 线程创建方式三：实现callable接口

/**
 * callable的好处
 * 1 可以定义返回值
 * 2 可以抛出异常
 */
public class TestCallable implements Callable {

    private String url;// 网络图片地址
    private String name;// 保存的文件名
    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public Boolean call() {
        WebDownload webDownload=new WebDownload();
        webDownload.downloader(url,name);
        System.out.println("下载了文件名为："+name);

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1=new TestCallable("https://t7.baidu.com/it/u=1362366007,2277133945&fm=193&f=GIF","1.jpg");
        TestCallable t2=new TestCallable("https://t7.baidu.com/it/u=1362366007,2277133945&fm=193&f=GIF","2.jpg");
        TestCallable t3=new TestCallable("https://t7.baidu.com/it/u=1362366007,2277133945&fm=193&f=GIF","3.jpg");
        // 创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> r1=ser.submit(t1);
        Future<Boolean> r2=ser.submit(t2);
        Future<Boolean> r3=ser.submit(t3);
        // 获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();
        // 关闭服务
        ser.shutdown();


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