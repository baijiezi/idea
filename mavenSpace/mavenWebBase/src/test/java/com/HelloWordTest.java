package com;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 15-8-27
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
public class HelloWordTest extends TestCase {

    //测试方法的名称必须以 test 开头
    public void testSay1(){
        HelloWord helloWord = new HelloWord();
        helloWord.sayHello();
    }


    public void testSay2(){
        HelloWord helloWord = new HelloWord();
        helloWord.sayHello2();
    }


}
