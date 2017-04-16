package com.qccr.livtrip.web.task;

import com.beust.jcommander.internal.Maps;
import com.qccr.livtrip.biz.service.task.JobTaskLogService;
import com.qccr.livtrip.biz.service.task.enums.JobTaskLogStateEnum;
import com.qccr.livtrip.common.util.ApplicationUtil;
import com.qccr.livtrip.model.task.JobTaskLog;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Iterator;
import java.util.Map;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/16 14:58 Exp $$
 */
public abstract class Task  implements ITask,Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobTaskLog jobTaskLog = new JobTaskLog();
        JobTaskLogService jobTaskLogService = (JobTaskLogService)ApplicationUtil.getBean("jobTaskLogService");
        try{
            Map map = Maps.newHashMap();
            JobDataMap qzMap = jobExecutionContext.getJobDetail().getJobDataMap();
            Iterator i = qzMap.keySet().iterator();
            while (i.hasNext()){
                Object key = i.next();
                map.put( key, qzMap.get( key ) );
            }

            //任务执行前
            jobTaskLog.setTaskId((Integer)map.get(AutoTaskInitializerServlet.TASK_ID_KEY));
            jobTaskLog.setState(JobTaskLogStateEnum.RUN.getState());
            jobTaskLog.setRemark(JobTaskLogStateEnum.RUN.getDescripton());
            jobTaskLogService.insert(jobTaskLog);
            execute(map);
            //任务执行后
            jobTaskLog.setState(JobTaskLogStateEnum.OVER.getState());
            jobTaskLog.setRemark(JobTaskLogStateEnum.OVER.getDescripton());
            jobTaskLogService.update(jobTaskLog);

        }catch (Exception e){
            jobTaskLog.setState(JobTaskLogStateEnum.EXCEPTION.getState());
            jobTaskLog.setRemark(e.getMessage());
            jobTaskLogService.update(jobTaskLog);
        }
    }
}
