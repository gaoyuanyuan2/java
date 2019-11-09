package com.study.java.gof23.proxy.jdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xm on 2018/1/20.
 */
public interface MyInvocationHandler {
	public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;
}
