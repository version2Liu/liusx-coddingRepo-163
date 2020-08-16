package com.liusx.thread.communication;

/**
 * description: Consumer <br>
 * date: 2020/8/16 0016 16:44 <br>
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class Consumer implements Runnable{

    private Resource r;
    Consumer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            
            r.out();
        }

    }
}
