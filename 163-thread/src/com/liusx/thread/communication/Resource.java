package com.liusx.thread.communication;

/**
 * description: Resource <br>
 * date: 2020/8/16 0016 16:34 <br>
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class Resource {
    private int count = 1;


    public synchronized void set(String name){

            count++;
            System.out.println(Thread.currentThread().getName()+"...生产者生产一个包子...");

    }

    public synchronized void out(){
        while(count <= 0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName()+"...消费者取走一个包子...");
    }

}
