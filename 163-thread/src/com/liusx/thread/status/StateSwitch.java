package com.liusx.thread.status;

/**
 * description: Demo1  线程状态的切换<br>
 * date: 2020/8/16 0016 10:37 <br>
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class StateSwitch {

    public static void main(String[] args) throws Exception {
        // 第一种状态切换 - 新建 -> 运行 -> 终止
        System.out.println("#######第一种状态切换  - 新建 -> 运行 -> 终止################################");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 执行了");
                System.out.println("thread1当前状态：" + Thread.currentThread().getState().toString());
            }
        });
        System.out.println("没调用start方法，thread1当前状态：" + thread1.getState().toString());
        thread1.start();
        // 等待thread1执行结束，再看状态
        Thread.sleep(2000L);
        System.out.println("等待两秒，再看thread1当前状态：" + thread1.getState().toString());
        // thread1.start(); TODO 注意，线程终止之后，再进行调用，会抛出IllegalThreadStateException异常


        System.out.println();
        System.out.println("############第二种：新建 -> 运行 -> 等待 -> 运行 -> 终止(sleep方式)###########################");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {// 将线程2移动到等待状态，1500后自动唤醒
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 执行了");
                System.out.println("thread2当前状态：" + Thread.currentThread().getState().toString());
            }
        });
        System.out.println("没调用start方法，thread2当前状态：" + thread2.getState().toString());
        thread2.start();
        System.out.println("调用start方法，thread2当前状态：" + thread2.getState().toString());
        // 注意此处等待时间不能大于上面thread2的休眠时间，如果大于的话，上面的线程就会自动执行并且进入到terminated状态我们就看不到TIME WATTING状态了。
        Thread.sleep(200L);
        System.out.println("等待200毫秒，再看thread2当前状态：" + thread2.getState().toString());
        // 再等待3秒，让thread2执行完毕，再看状态
        Thread.sleep(3000L);
        System.out.println("等待3秒，再看thread2当前状态：" + thread2.getState().toString());



        System.out.println();
        System.out.println("############第三种：新建 -> 运行 -> 阻塞 -> 运行 -> 终止###########################");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (StateSwitch.class) {
                    System.out.println("thread3 拿到锁。开始执行");
                    System.out.println("thread3当前状态：" + Thread.currentThread().getState().toString());
                }
            }
        });
        //在没有执行start方法之前，主线程就先抢到了这把锁。
        synchronized (StateSwitch.class) {
            System.out.println("没调用start方法，thread3当前状态：" + thread3.getState().toString());
            thread3.start();
            System.out.println("调用start方法，thread3当前状态：" + thread3.getState().toString());
            // 等待200毫秒，再看状态。
            Thread.sleep(200L);
            //这个时候，thread3已经start了。但是因为主线程还没有释放锁，所以这个时候他的状态还是blockd
            System.out.println("等待200毫秒，再看thread3当前状态：" + thread3.getState().toString());
            System.out.println("主线程即将释放锁------");
        }

        // 再等待3秒，让thread3执行完毕，再看状态
        Thread.sleep(3000L);
        System.out.println("等待3秒，让thread3抢到锁运行之后，再看thread3当前状态：" + thread3.getState().toString());

    }
}
