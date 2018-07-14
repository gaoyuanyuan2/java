package com.study.java.gof23.singleton;

public class SingletonVolatile {
    private  volatile static SingletonVolatile singletonVolatile;

    public SingletonVolatile() {
        System.out.println("构造方法："+Thread.currentThread().getName());
    }

    public static  SingletonVolatile getInstance(){
        if(singletonVolatile == null){
            synchronized (SingletonVolatile.class){
                if(singletonVolatile == null) {
                    singletonVolatile = new SingletonVolatile();
                }
            }
        }
        return  singletonVolatile;
    }

    public static void main(String[] args) {
        new Thread(() -> SingletonVolatile.getInstance(),"线程A").start();
        new Thread(() -> SingletonVolatile.getInstance(),"线程B").start();
        new Thread(() -> SingletonVolatile.getInstance(),"线程C").start();
        new Thread(() -> SingletonVolatile.getInstance(),"线程D").start();
        new Thread(() -> SingletonVolatile.getInstance(),"线程E").start();

    }
}
