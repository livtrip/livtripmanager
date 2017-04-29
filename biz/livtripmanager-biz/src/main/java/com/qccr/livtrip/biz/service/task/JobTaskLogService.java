package com.qccr.livtrip.biz.service.task;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.enums.task.JobStateEnum;
import com.qccr.livtrip.biz.enums.task.JobTaskLogStateEnum;
import com.qccr.livtrip.model.dto.task.JobTaskLogDTO;
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

    public PageInfo<JobTaskLog> pageQuery(Integer pageNum, Integer pageSize){
        if(pageNum == null || pageSize == null){pageNum = 1; pageSize= 20;}
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<JobTaskLog> jobTaskLogs = jobTaskLogDao.queryForList();
        return new PageInfo<>(jobTaskLogs);
    }

    public PageInfo<JobTaskLogDTO> pageQueryJobTaskLogDTO(Integer taskId, String state,Integer pageNum, Integer pageSize){
        if(pageNum == null || pageSize == null){pageNum = 1; pageSize= 20;}
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<JobTaskLogDTO> jobTaskLogDTOS = jobTaskLogDao.queryForJobTaskLogDTOList(taskId, state);
        for(JobTaskLogDTO jobTaskLogDTO : jobTaskLogDTOS){
            jobTaskLogDTO.setState(JobTaskLogStateEnum.getNameByCode(jobTaskLogDTO.getState()));
        }
        return new PageInfo<>(jobTaskLogDTOS);

    }
}
