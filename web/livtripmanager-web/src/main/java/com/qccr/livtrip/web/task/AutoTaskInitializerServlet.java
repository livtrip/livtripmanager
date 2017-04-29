package com.qccr.livtrip.web.task;

import com.qccr.livtrip.biz.service.task.JobTaskService;
import com.qccr.livtrip.biz.enums.task.JobStateEnum;
import com.qccr.livtrip.model.task.JobTask;
import org.apache.commons.collections.CollectionUtils;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务启动器
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/12 16:50 Exp $$
 */
@Component
public class AutoTaskInitializerServlet {

    public final static  String TASK_ID_KEY = "TASK_ID_KEY";

    @Resource
    private JobTaskService jobTaskService;

    @PostConstruct
    public  void initTask() throws Exception {
        System.out.println("---init task---");
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        JobDetail job = null;
        CronTrigger trigger =null;
        JobDataMap map=null;

        //获取正在使用中的任务
        List<JobTask> jobTaskList = jobTaskService.queryJobTask(JobStateEnum.USE.getState());
        if(CollectionUtils.isNotEmpty(jobTaskList)){
            for(JobTask jobTask : jobTaskList){
                sched.deleteJob(jobTask.getTaskCode(), jobTask.getTaskType().toString());
                map = new JobDataMap();
                map.put(TASK_ID_KEY, jobTask.getId());
                job = new JobDetail(jobTask.getTaskCode(),jobTask.getTaskType().toString(), Class.forName(jobTask.getTaskImplClass()));
                job.setJobDataMap(map);
                trigger = new CronTrigger(
                        jobTask.getTaskCode(),
                        jobTask.getTaskType().toString(),
                        jobTask.getTaskExpress());

                sched.scheduleJob(job,trigger);
            }
            sched.start();
        }
    }

}
