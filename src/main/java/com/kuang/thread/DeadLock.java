package com.kuang.thread;
/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/13  0:46
 */

/**
 * 死锁：多个线程互相抱着对方需要的资源，然后形成僵持
 */
public class DeadLock {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0,"灰姑娘");
        MakeUp g2=new MakeUp(1,"白雪公主");
        g1.start();
        g2.start();


    }

}
//口红
class Lipstick{

}

// 镜子
class Mirror{

}

// 化妆
class MakeUp extends  Thread{
    // 需要的资源只有一份，用static保证只有一份资源
    static  Lipstick lipstick =new Lipstick();
    static  Mirror mirror=new Mirror();
    int choice;// 选择
    String girlName; // 使用化妆品的人

    public MakeUp(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }

    @Override
    public void run() {
        // 化妆
        makeup();
    }
    // 化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup(){
        if(choice==0){
            synchronized (lipstick){// 获得口红的锁
                System.out.println(this.girlName+"获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (mirror){// 一秒钟后获得镜子
                System.out.println(this.girlName+"获得镜子的锁");
            }
        }else {
            synchronized (mirror){// 获得镜子的锁
                System.out.println(this.girlName+"获得镜子的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (lipstick){// 二秒钟后获得镜子
                System.out.println(this.girlName+"获得口红的锁");
            }

        }
    }
}
