package com.stock.task;

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
        Task task = new Task();
        String result = task.Hi();
        System.out.println(result);



    }
}
