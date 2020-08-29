package com.liusx.demoszret.process.cebi;

import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description: CebiMessageCenter <br>
 * date: 2020/8/29 0029 11:34 <br>
 *
 * @author: Administrator <br>
 * version: 1.0 <br>
 */
public class CebiMessageCenter {
    public static Map<Integer, ArrayBlockingQueue<Object>> cebeMessageMap = new ConcurrentHashMap<Integer, ArrayBlockingQueue<Object>>();

}
