package com.stock.task;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 16-2-1
 * Time: 下午4:32
 * To change this template use File | Settings | File Templates.
 */
public class Task {

    public void execute(){
        System.out.println(new Date() + "  Task  execute");
    }


    public String Hi(){
        return "hi";
    }

}
