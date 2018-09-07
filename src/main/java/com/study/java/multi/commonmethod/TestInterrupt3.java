package com.study.java.multi.commonmethod;

/**
 * Created by yan on  07/09/2018.
 */
public class TestInterrupt3  {

    //1 ) this.interrupted():测试当前线程是否已经是中断状态，执行后具有将状态标志置清除为false 的功能。
    //2 ) this.isInterruptedO :测试线程Thread对象是否已经是中断状态，但不清除状态标志。
    public static void main(String[] args){
        //当前线程是否停止
       Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
    }

}
