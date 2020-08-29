package com.liusx.thread.safe;

import java.util.concurrent.TimeUnit;

/**
 * description: VolatileDemo <br>
 * date: 2020/8/18 0018 21:18 <br>
 * 线程安全之  可见性问题探讨
 * 让一个线程对共享变量的修改，能够及时的被其他线程看到
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class VolatileDemo {

    private boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(demo.flag){
                    i++;
                }
                System.out.println(i);
            }
        });
        thread1.start();
        TimeUnit.SECONDS.sleep(2);
        demo.flag = false;
        System.out.println("被设置为false了");
    }
}
