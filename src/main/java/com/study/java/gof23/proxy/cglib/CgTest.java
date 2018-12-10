package com.study.java.gof23.proxy.cglib;

/**
 * Created by yan on  10/12/2018.
 */
public class CgTest {
    public static void main(String[] args) {
        CgMan xiaoming = new CgMan();
        CgMan  cgmeipo  = (CgMan) new CgMeiPo().getInstance(xiaoming.getClass());
        cgmeipo.findLove();
    }
}
