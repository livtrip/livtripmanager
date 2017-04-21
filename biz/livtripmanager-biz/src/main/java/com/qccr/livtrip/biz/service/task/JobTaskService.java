package com.qccr.livtrip.biz.service.task;

import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.model.task.JobTask;

import java.util.List;

/**
 * 定时任务
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/15 16:33 Exp $$
 */
public interface JobTaskService {

     int insert(JobTask pojo);
     int insertSelective(JobTask pojo);
     int insertList(List<JobTask> pojos);
     int update(JobTask pojo);
     List<JobTask> queryJobTask(String state);
     PageInfo<JobTask> pageQueryJobTask(String taskCode, String state, Integer pageNum, Integer pageSize);
}
