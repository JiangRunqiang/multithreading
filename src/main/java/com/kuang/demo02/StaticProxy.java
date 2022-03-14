package com.kuang.demo02;
/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/11  0:08
 */
//静态代理模式总结：
// 真实对象和代理对象都要实现同一个接口
// 代理对象要代理真实角色

/**
 * 好处：
 * 代理对象，可以做很多真实对象做不了的事情
 * 真实对象专注于做自己的事情
 */
public class StaticProxy {
    public static void main(String[] args) {
        new Thread(()->System.out.println("我爱你")).start();
        new WeddingCompany(new You()).happymarry();

    }
}


interface Marry{
    void happymarry();
}

// 真实角色，你去结婚
class You implements Marry{

    @Override
    public void happymarry() {
        System.out.println("秦老师要结婚了,超级开心");
    }
}
// 代理角色,帮助你结婚
class WeddingCompany implements Marry{

    // 代理谁==》真实目标角色
    private Marry target;


    public WeddingCompany(Marry target){
            this.target=target;
    }
    @Override
    public void happymarry() {
        before();
        this.target.happymarry();//这就是真实对象
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置现场");
    }
}