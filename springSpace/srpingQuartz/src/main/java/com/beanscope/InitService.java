package com.beanscope;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 15-10-10
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public class InitService implements Runnable{

    private void init(){
        System.out.println("-------------- InitService ---------------");
        Thread thread = new Thread(this,"InitService");
        thread.start();
    }

    @Override
    public void run() {
        while(true)
        {
            try
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("启动线程InitService  do something ...");
        }
    }
}
