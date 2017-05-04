package com.qccr.livtrip.dal.task;

import com.qccr.livtrip.model.task.JobTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JobTaskDao {
    int insert(@Param("pojo") JobTask pojo);

    int insertSelective(@Param("pojo") JobTask pojo);

    int insertList(@Param("pojos") List<JobTask> pojo);

    int update(@Param("pojo") JobTask pojo);

    List<JobTask> queryJobTask(@Param("state") String state);

    List<JobTask> queryJobTaskByParam(@Param("taskCode") String taskCode, @Param("state") String state);

    JobTask getById(@Param("taskId") Integer taskId);
}
