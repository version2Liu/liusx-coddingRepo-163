package com.liusx.demoszret.process.cebi;

/**
 * description: CebiRetProcessBean <br>
 * date: 2020/8/29 0029 11:38 <br>
 *
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class CebiRetProcessBean {
    private void doOperationI() {
        System.out.println("-----------------------进口回执报文处理对象注入成功v-----------------------"+this.hashCode());
        inti();
    }

    private void inti() {
        System.out.println("---------------进口再次调用hashCode"+this.hashCode());
    }

}
