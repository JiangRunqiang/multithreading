package com.kuang.lambda;
/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/11  9:58
 */

public class TestLambda2 {
    // 2 静态内部类
   static class Love2 implements Ilove{

        @Override
        public void love(int a) {
            System.out.println("I love you-->"+a);
        }
    }

    public static void main(String[] args) {
       // 1 实现接口进行调用
       Ilove love=new Love();
        love.love(1);
        // 2 静态内部类
        love=new Love2();
        love.love(2);
        // 3 局部内部类
        class Love3 implements Ilove{

            @Override
            public void love(int a) {
                System.out.println("I love you-->"+a);
            }
        }
        love=new Love3();
        love.love(3);
        // 4 匿名内部类,没有类的名称，必须借助接口或者父类
        love=new Ilove(){

            @Override
            public void love(int a) {
                System.out.println("I love you-->"+a);
            }
        };
        love.love(4);
        // 5 lambda表达式方法
        love=(int a)->{
            System.out.println("I love you-->"+a);
        };
        love.love(5);
        // 简化1：去掉参数类型
        // 注意：这里的love变量的定义，应该是Ilove love=null;
        // 指代的是接口
        love=(a)->{
            System.out.println("I love you-->"+a);
        };
        love.love(6);
        // 简化2：去掉括号
        love=a->{
            System.out.println("I love you-->"+a);
        };
        love.love(7);
        // 简化3：去掉花括号
        love=a->
            System.out.println("I love you-->"+a);
        love.love(521);
        /**
         * lambda表达式只能有一行代码的情况下才能简化成为一行，
         * 如果有多行就需要使用代码块。
         * 前提是接口为函数式接口
         * 多个参数也可以去掉参数类型，要去掉就都去掉，必须带上花括号
         */



    }
}


interface Ilove{
    void love(int a);
}

class Love implements Ilove{

    @Override
    public void love(int a) {
        System.out.println("I love you-->"+a);
    }
}