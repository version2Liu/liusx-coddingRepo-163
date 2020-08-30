package com.liusx.thread.future;

/**
 * description: CommonCook <br>
 * date: 2020/8/30 0030 11:28 <br>
 *
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class CommonCook {

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        // 第一步 网购厨具
        OnlineShopping thread = new OnlineShopping();
        thread.start();
        // 保证厨具送到 join方法的作用是保证在子线程没执行完之前，主线程不结束。在这里就是保证购买厨具的线程可以正常执行
        thread.join();
        // 第二步 去超市购买食材  用sleep 来模拟超时购物耗时时间
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步：食材到位");
        // 第三步 用厨具烹饪食材
        System.out.println("第三步：开始展现厨艺");
        cook(thread.chuju, shicai);

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * description:    网购厨具线程 <br>
     * version: 1.0 <br>
     * date: 2020/8/30 0030 11:37 <br>
     * author: liusx <br>
     * @param: null
     * @return
    */
    static class OnlineShopping extends Thread {
        private Chuju chuju;
        @Override
        public void run() {
            System.out.println("第一步：下单");
            System.out.println("第二步：等待送货");
            try {
                // 模拟送货时间
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第三步：快递送到");
            chuju = new Chuju();
        }

    }

    /**
     * description: cook 用厨具烹饪食材<br>
     * version: 1.0 <br>
     * date: 2020/8/30 0030 11:38 <br>
     * author: liusx <br>
     * @param: chuju
     * @param: shicai
     * @return void
    */
    static void cook(Chuju chuju, Shicai shicai) {}

    /**
     * description: Chuju  厨具类<br>
     * version: 1.0 <br>
     * date: 2020/8/30 0030 11:41 <br>
     * author: liusx <br>
     * @param: null
     * @return
    */
    static class Chuju {}

    /**
     * description: Shicai 食材类<br>
     * version: 1.0 <br>
     * date: 2020/8/30 0030 11:41 <br>
     * author: liusx <br>
     * @param: null
     * @return
    */
    static class Shicai {}

}
