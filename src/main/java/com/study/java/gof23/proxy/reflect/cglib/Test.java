package com.study.java.gof23.proxy.reflect.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class  Message{//直接做此类的代理
    public void  send(){
        System.out.println("Message:打游戏");
    }
}

class MyProxy implements MethodInterceptor{//定义一个拦截器

    private Object target;

    public MyProxy(Object target) {
        this.target = target;
    }

    public void  pre(){
        System.out.println("MethodInterceptor:准备");
    }
    public void  over(){
        System.out.println("MethodInterceptor:关机");
    }
    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        pre();
        Object obj = method.invoke(this.target,objects);
        over();
        return obj;
    }
}


public class Test {
    public static void main(String[] args) {
        Message message= new Message();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(message.getClass());
        enhancer.setCallback(new MyProxy(message));
        Message temp = (Message) enhancer.create();
        temp.send();
    }
}
