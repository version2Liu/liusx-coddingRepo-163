package com.liusx.thread.local;

/**
 * description: ThreadLocalTest 线程封闭示例 <br>
 * date: 2020/8/16 0016 19:02 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */
public class ThreadLocalTest {
    /** threadLocal变量，每个线程都有一个副本，互不干扰 */
    public static ThreadLocal<String> value = new ThreadLocal<>();

    /**
     * threadlocal测试
     *
     * @throws Exception
     */
    public void threadLocalTest() throws Exception {

        // 主线程设置值
        value.set("这是主线程设置的123");
        String v = value.get();
        System.out.println("线程1执行之前，主线程取到的值：" + v);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String v = value.get();
                System.out.println("线程1取到的值：" + v);
                // 线程1设置 threadLocal
                value.set("这是线程1设置的456");

                v = value.get();
                System.out.println("重新设置之后，线程1取到的值：" + v);
                System.out.println("线程1执行结束");
            }
        }).start();
        // 等待所有线程执行结束
        Thread.sleep(5000L);

        v = value.get();
        System.out.println("线程1执行之后，主线程取到的值：" + v);

    }

    public static void main(String[] args) throws Exception {
        new ThreadLocalTest().threadLocalTest();
    }
}
