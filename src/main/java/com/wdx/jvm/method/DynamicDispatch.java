package com.wdx.jvm.method;

/**
 * @author wangdongxing
 * @since 2019-07-08 13:09
 */
public class DynamicDispatch {
    static abstract class Human {
        abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        void sayHello() {
            System.out.println("man say hello!");
        }
    }

    static class Woman extends Human {
        @Override
        void sayHello() {
            System.out.println("woman say hello");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}
