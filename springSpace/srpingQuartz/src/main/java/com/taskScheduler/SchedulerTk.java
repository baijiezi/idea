package com.taskScheduler;

import com.taskScheduler.component.DeptTask;
import com.taskScheduler.component.DoctorTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

/**
 * Created with IntelliJ IDEA.
 * User: BaiJiezi
 * Date: 15-10-10
 * Time: 下午4:42
 * To change this template use File | Settings | File Templates.
 */

public class SchedulerTk {

    @Autowired
    private TaskScheduler scheduler;

    private void init(){
        DeptTask deptTask = new DeptTask();
        System.out.println("scheduler:" + scheduler);
        scheduler.schedule(deptTask, new CronTrigger("0 * * * * ?"));


        DoctorTask doctorTask = new DoctorTask();
        scheduler.schedule(doctorTask, new CronTrigger("30 * * * * ?"));
    }






}
