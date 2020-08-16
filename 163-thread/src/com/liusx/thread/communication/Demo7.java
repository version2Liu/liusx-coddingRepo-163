package com.liusx.thread.communication;

/**
 * description: Demo7 <br>
 * date: 2020/8/16 0016 17:17 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 */
public class Demo7 {

    /**
     * 下面的代码模拟的是，多个线程去买包子，只有一个生产者去生产包子。最终实现的效果是
     * 每次有一个消费者消费成功。
     * 最开始我疑惑的点是，从日志记录来看，为什么每次剩下的线程都能全部抢到锁，而不是每次只有一个人抢到锁
     * 疑惑的点在于：我忘记了wait这个方法是会自动释放锁的。即每次执行完wait之后他的锁就释放掉的。
     * 然后实际计算机的运行速度又很快，三五个线程去争抢锁然后再释放掉的过程是非常快的，所以从日志打印来看
     * 我们感觉好像是一次性五个线程都拿到了锁，其实不是的，是一个一个挨着拿到的，每次都只有一个线程拿到了锁。不是多个。
     *
     * 这个类和之前课程中的例子的区别在于两点：
     * 1、课程中举得例子是一个消费者，我这里是多个
     * 2、课程中的消费者真正消费包子的代码没有在同步代码块中，我这里把消费包子的代码放在了同步代码块中。
     *
     * 如果我们不把消费包子的代码baozidian--放在同步代码快之内，那么就会出现，线程1拿到锁之后。进入while循环，发现baozidian>0.
     * 然后跳出循环。注意跳出循环这个时候，同步代码快就结束了；就意味着锁已经释放了。
     * 那么当线程1继续去下面执行消费代码的同时，会有其他的线程在这个时候拿到这把锁
     * 在线程1还没有真正执行count--这代码之前的这个时间差里面，另外的一个线程进入到了while循环中，
     * 这个时候另外的这个线程一看baozidian>0也成立了，就也结束循环跳出同步代码快，去真正消费了
     *
     * 上面的这部分描述就是我们最开始的时候会出现说一次性有五个线程都消费到了包子。而且消费到的baozidian这个变量还都是1。
     * 打印出来都是 1是因为打印语句在baozidian--之前执行，所以会出现打印的是1
     *
     * */
    public static Integer baozidian = 0;

    public void waitNotifyTest() throws Exception {
        // 启动线程
        for (int i = 0; i <5; i++) {
            new Thread(() -> {
                synchronized (this) {
                    while (baozidian <= 0) { // 如果没包子，则进入等待
                        try {
                            System.out.println(Thread.currentThread().getName()+"  进入等待");
                            Thread.sleep(2000);
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                //消费包子的代码必须放在同步代码块之内    具体解释看上边
                System.out.println(Thread.currentThread().getName()+"买到"+baozidian+"个包子，回家");
                baozidian--;
                }
            }).start();
        }

        // 3秒之后，生产一个包子
        while(true){
            Thread.sleep(15000L);
            baozidian ++;
            synchronized (this) {
                System.out.println("生产者生产了一个包子，notify准备通知消费者");
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new Demo7().waitNotifyTest();
    }
}
