package com.qccr.livtrip.biz.service.task;

import com.qccr.livtrip.dal.task.JobTaskLogDao;
import com.qccr.livtrip.model.task.JobTaskLog;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service("jobTaskLogService")
public class JobTaskLogService{

    @Resource
    private JobTaskLogDao jobTaskLogDao;

    public int insert(JobTaskLog pojo){
        return jobTaskLogDao.insert(pojo);
    }

    public int insertSelective(JobTaskLog pojo){
        return jobTaskLogDao.insertSelective(pojo);
    }

    public int insertList(List<JobTaskLog> pojos){
        return jobTaskLogDao.insertList(pojos);
    }

    public int update(JobTaskLog pojo){
        return jobTaskLogDao.update(pojo);
    }
}
