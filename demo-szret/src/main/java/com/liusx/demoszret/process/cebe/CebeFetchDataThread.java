package com.liusx.demoszret.process.cebe;

import com.liusx.demoszret.process.cebi.CebiMessageCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * description: CebeFetchDataThread <br>
 * date: 2020/8/29 0029 11:43 <br>
 *
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class CebeFetchDataThread extends Thread{

    private Integer beanId;

    public CebeFetchDataThread(Integer beanId) {
        this.beanId = beanId;
    }

    @Override
    public void run() {
        while(true){
            List<String> data = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                data.add("这是出口bean对象："+beanId+"的第-->"+i +"  条数据");
            }
            CebeMessageCenter.cebeMessageMap.get(beanId).addAll(data);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
