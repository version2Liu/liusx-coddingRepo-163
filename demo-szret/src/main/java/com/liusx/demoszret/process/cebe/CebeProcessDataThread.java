package com.liusx.demoszret.process.cebe;

import com.liusx.demoszret.process.cebi.CebiMessageCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * description: CebeProcessDataThread <br>
 * date: 2020/8/29 0029 11:43 <br>
 *
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class CebeProcessDataThread extends Thread {
    private Integer beanId;

    public CebeProcessDataThread(Integer beanId) {
        this.beanId = beanId;
    }
    @Override
    public void run() {
        while(true){
            try {
                String s = (String) CebeMessageCenter.cebeMessageMap.get(beanId).take();
                System.out.println("对象"+beanId+"取出来数据为---->" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
