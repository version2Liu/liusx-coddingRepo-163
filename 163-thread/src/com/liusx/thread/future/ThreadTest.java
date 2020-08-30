package com.liusx.thread.future;

/**
 * description: ThreadTest <br>
 * date: 2020/8/30 0030 11:49 <br>
 *
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class ThreadTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Thread thread1 = new myThread1();
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始购买食材。");
        try {
            Thread.sleep(5000);
            System.out.println("购买食材结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread2 = new myThread2();
        thread2.start();
        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }





    static class myThread1 extends Thread{
        @Override
        public void run(){
            System.out.println("线程1启动成功，将要耗时10s");
            try {
                Thread.sleep(10000);
                System.out.println("线程1执行结束。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class myThread2 extends Thread{
        @Override
        public void run(){
            System.out.println("线程2启动成功，将要耗时5s");
            try {
                Thread.sleep(5000);
                System.out.println("线程2执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
