package com.study.java.gof23.proxy.reflect.basic;

import java.lang.reflect.Constructor;

interface ISubject {
    public void eat();
}

class RealSubject implements ISubject {

    @Override
    public void eat() {
        System.out.println("RealSubject:c吃");
    }
}



class Factroy {
    private Factroy() {
    }

    public static <T> T getInstanc(String className) {
        T t = null;
        try {
            t = (T) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T getInstanc(String className,String realName) {
        T t = null;
        try {
            T  object =  getInstanc(realName);
            Constructor<?> constructor = Class.forName(className).getConstructor(object.getClass());
            t = (T)constructor.newInstance(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

}

class ProxySubject implements ISubject {

    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public void pre() {
        System.out.println("ProxySubject：准备");
    }

    public void clear() {
        System.out.println("ProxySubject：洗碗");
    }

    @Override
    public void eat() {
        pre();
        realSubject.eat();
        clear();
    }
}

public class Test {
    public static void main(String[] args) {
        ISubject iSubject = Factroy.getInstanc("com.study.java.gof23.proxy.reflect.basic.ProxySubject","com.study.java.gof23.proxy.reflect.basic.RealSubject");
        iSubject.eat();
    }

}
