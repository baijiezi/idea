package com.taskScheduler.component;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 15-10-10
 * Time: 下午3:45
 * To change this template use File | Settings | File Templates.
 */
public class DoctorTask implements Runnable{

    @Override
    public void run() {
        System.out.println("run DoctorTask...");
    }
}
