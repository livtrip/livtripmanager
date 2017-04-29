package com.qccr.livtrip.biz.service.task.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.service.task.JobTaskService;
import com.qccr.livtrip.dal.task.JobTaskDao;
import com.qccr.livtrip.model.task.JobTask;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/15 16:36 Exp $$
 */
@Service("jobTaskService")
public class JobTaskServiceImpl implements JobTaskService {

    @Resource
    private JobTaskDao jobTaskDao;


    public int insert(JobTask pojo){
        return jobTaskDao.insert(pojo);
    }

    public int insertSelective(JobTask pojo){
        return jobTaskDao.insertSelective(pojo);
    }

    public int insertList(List<JobTask> pojos){
        return jobTaskDao.insertList(pojos);
    }

    public int update(JobTask pojo){
        return jobTaskDao.update(pojo);
    }

    @Override
    public List<JobTask> queryJobTask(String state) {
        return jobTaskDao.queryJobTask(state);
    }

    @Override
    public PageInfo<JobTask> pageQueryJobTask(String taskCode, String state, Integer pageNum, Integer pageSize) {
        if(pageNum == null || pageSize == null){pageNum = 1; pageSize=20;}
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<JobTask> jobTasks = jobTaskDao.queryJobTaskByParam(taskCode,state);
        return new PageInfo<>(jobTasks);
    }
}
