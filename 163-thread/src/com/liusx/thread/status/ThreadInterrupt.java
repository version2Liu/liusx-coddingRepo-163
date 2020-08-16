package com.liusx.thread.status;

/**
 * description: ThreadInterrupt 线程终止的方式<br>
 * date: 2020/8/16 0016 11:27 <br>
 * version: 1.0 <br>
 * @author Administrator
 */
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();
        thread.start();
        // 休眠1秒，确保i变量自增成功
        Thread.sleep(1000);
        // 暂停线程
        //  thread.stop(); // 错误的终止
        thread.interrupt(); // 正确终止
        while (thread.isAlive()) {
        // 确保线程已经终止
        } // 输出结果
        thread.print();
    }

}
