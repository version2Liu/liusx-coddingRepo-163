package com.liusx.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * description: FutureCook <br>
 * date: 2020/8/30 0030 11:40 <br>
 *
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class FutureCook {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        // 第一步 网购厨具
        Callable<Chuju> onlineShopping = new Callable<Chuju>() {

            @Override
            public Chuju call() throws Exception {
                System.out.println("第一步：下单");
                System.out.println("第一步：等待送货");
                Thread.sleep(5000);  // 模拟送货时间
                System.out.println("第一步：快递送到");
                return new Chuju();
            }

        };
        FutureTask<Chuju> task = new FutureTask<Chuju>(onlineShopping);
        new Thread(task).start();
        // 第二步 去超市购买食材 sleep模拟购买食材时间
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步：食材到位");
        // 第三步 用厨具烹饪食材
        if (!task.isDone()) {
            // 联系快递员，询问是否到货
            System.out.println("第三步：厨具还没到，心情好就等着（心情不好就调用cancel方法取消订单）");
        }
        Chuju chuju = task.get();
        System.out.println("第三步：厨具到位，开始展现厨艺");
        cook(chuju, shicai);

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * description: cook 用厨具烹饪食材<br>
     * version: 1.0 <br>
     * date: 2020/8/30 0030 11:42 <br>
     * author: liusx <br> 
     * @param: chuju
     * @param: shicai
     * @return void
    */ 
    static void cook(Chuju chuju, Shicai shicai) {}

    /**
     * description:Chuju  厨具类<br>
     * version: 1.0 <br>
     * date: 2020/8/30 0030 11:42 <br>
     * author: liusx <br> 
     * @param: null
     * @return 
    */ 
    static class Chuju {}

    /**
     * description: Shicai 食材类 <br>
     * version: 1.0 <br>
     * date: 2020/8/30 0030 11:43 <br>
     * author: liusx <br> 
     * @param: null
     * @return 
    */ 
    static class Shicai {}


}
