package com.kuang.lambda;
/*
 *@author: Runqiang_Jiang@SAIC-GM.com
 *@Time: 2022/3/11  9:34
 */

/**
 * 函数式接口：可以使用lambda表达式
 * 如果一个接口只有一个抽象方法，我们可以使用lambda表达式的方法去实现这个接口
 * 推导lambda表达式
 */
public class TestLambda1 {
    // 3 静态内部类
    static class Like2 implements Ilike {
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        Ilike like = new Like();
        like.lambda();
        like = new Like2();
        like.lambda();
        // 4 局部内部类
        class Like3 implements Ilike {
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        like = new Like3();
        like.lambda();

        // 5 匿名内部类,没有类的名称，必须借助接口或者父类
        like=new Ilike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();
        // 6 用Lambda表达式进行简化
        like=()->{
            System.out.println("I like lambda5");
        };
        like.lambda();




    }
}
    // 1定义一个函数式接口
    interface Ilike {
        void lambda();
    }

    //2 实现类
    class Like implements Ilike {
        @Override
        public void lambda() {
            System.out.println("I like lambda");
        }
    }