package com.liusx.demoszret.process.cebe;

import com.liusx.demoszret.process.cebi.CebiFetchDataThread;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description: CebeRetProcessBean <br>
 * date: 2020/8/29 0029 11:39 <br>
 *
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class CebeRetProcessBean {


    private void doOperationE() {
        System.out.println("-----------------------出口回执报文处理对象注入成功v-----------------------"+this.hashCode());
        //初始化
        init();
        //拉取数据
        fetchData();
        //处理数据
        processData();

    }

    private void init() {
        CebeMessageCenter.cebeMessageMap.put(this.hashCode(),new ArrayBlockingQueue<Object>(1900));
        System.out.println("初始化队列成功");
    }

    private void fetchData() {
        CebeFetchDataThread cebeFetchDataThread = new CebeFetchDataThread(this.hashCode());
        cebeFetchDataThread.start();
        System.out.println("拉取数据成功");
    }

    private void processData() {
        for (int i = 0; i < 5; i++) {
            CebeProcessDataThread cebeProcessDataThread = new CebeProcessDataThread(this.hashCode());
            cebeProcessDataThread.start();
        }
        System.out.println("启动消费者线程成功");
    }


}
