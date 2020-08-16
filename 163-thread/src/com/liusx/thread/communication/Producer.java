package com.liusx.thread.communication;

/**
 * description: Producer <br>
 * date: 2020/8/16 0016 16:42 <br>
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class Producer implements Runnable{

    private Resource r;
    Producer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        for (int i = 0; i <10; i++) {

            r.set("包子");
        }

    }
}
