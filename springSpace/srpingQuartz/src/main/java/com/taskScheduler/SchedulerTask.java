package com.taskScheduler;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 15-10-10
 * Time: 下午5:01
 * To change this template use File | Settings | File Templates.
 */
public class SchedulerTask implements TaskScheduler {


    @Override
    public ScheduledFuture schedule(Runnable runnable, Trigger trigger) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ScheduledFuture schedule(Runnable runnable, Date date) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, Date date, long l) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, Date date, long l) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
