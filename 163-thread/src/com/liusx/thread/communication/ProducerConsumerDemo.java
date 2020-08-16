package com.liusx.thread.communication;

/**
 * description: ProducerConsumerDemo <br>
 * date: 2020/8/16 0016 16:46 <br>
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Resource r = new Resource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);

        Thread pro1 = new Thread(pro);
        Thread pro2 = new Thread(pro);
        Thread consumer1 = new Thread(con);
        pro1.start();
        pro2.start();
        consumer1.start();


    }
}
