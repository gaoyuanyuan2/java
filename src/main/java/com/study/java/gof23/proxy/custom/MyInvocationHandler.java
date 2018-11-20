package com.study.java.gof23.proxy.custom;

import java.lang.reflect.Method;

/**
 * Created by yan on  20/11/2018.
 */
public interface MyInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
