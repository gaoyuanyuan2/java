package com.study.java.multi.volatiles;

public class RunThread implements Runnable {

    /**
     *
     在虚拟机的Client模式下，由于JIT并没有做足够的优化，在主线程修改ready变量的状态后，ReaderThread 可以发现这个改动，
     并退出程序。但是在Server 模式下，由于系统优化的结果，ReaderThread 线程无法“看到”主线程中的修改，
     导致ReaderThread永远无法退出( 因为代码第7行判断永远不会成立)，这显然不是我们想看到的结果。这个问题就是一个典型的可见性问题。

     注意:可以使用Java虚拟机参数server切换到Server模式。

     *
     **/

    private boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void run() {
        System.out.println("into..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isRunning = false;
    }

    public static void main(String[] args) throws InterruptedException {
        RunThread rt = new RunThread();
        new Thread(rt).start();

        while (true) {
            if (rt.isRunning()) {
                System.out.println("run");
            } else {
                System.out.println("stop");
                return;
            }
        }
    }


}
