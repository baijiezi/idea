package com.stocks.task;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-2-1
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public class TaskTest extends TestCase {

    public void testHi(){
        Task2 task2 = new Task2();
        String result = task2.hi();
        System.out.println(result);



    }
}
