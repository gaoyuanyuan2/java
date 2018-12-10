package com.study.java.gof23.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by yan on  10/12/2018.
 *
 * cglib��̬����   ý��
 * ��Ҫʵ�� MethodInterceptor�ӿ�
 */
public class CgMeiPo implements MethodInterceptor {

    public Object getInstance(Class clazz){
        Enhancer enhancer = new Enhancer();
        //cglib ��Ҫ���ݼ̳������ɴ���Ĺ�ϵ
        //���ø���
        enhancer.setSuperclass(clazz);
        //���ûص�  ���Ǵ�����ͨ��  MethodInterceptor �ҵ� intercept�������лص�
        enhancer.setCallback(this);
        //crate ����
        //��һ��������Դ����
        //�ڶ����������class�ļ�
        //�����������ص�JVM�У������ر��������
        return  enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("����ý�ţ�ͨ��cglib ��ʵ�ֵ�");
        //�����ͻ�ѭ����������
        //cglib�Ĵ���ʵ����ԭ�еĶ�������࣬ͨ���̳���ʵ�֣�����Ĭ�ϵ��ø���ķ���,obj Ϊcglib���������
        //�мǲ�Ҫд��        methodProxy.invoke(obj,args);  ������ͻ����ѭ�����õ����⣬��������cglib�����࣬Ȼ��ѭ������
        //���ø���
        methodProxy.invokeSuper(obj,args);
        System.out.println("���ڰ�����");
        return null;
    }
}
