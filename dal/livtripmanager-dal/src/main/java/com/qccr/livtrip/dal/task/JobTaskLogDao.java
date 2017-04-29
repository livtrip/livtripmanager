package com.qccr.livtrip.dal.task;

import com.qccr.livtrip.model.dto.task.JobTaskLogDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.qccr.livtrip.model.task.JobTaskLog;

@Mapper
public interface JobTaskLogDao {
    int insert(@Param("pojo") JobTaskLog pojo);

    int insertSelective(@Param("pojo") JobTaskLog pojo);

    int insertList(@Param("pojos") List<JobTaskLog> pojo);

    int update(@Param("pojo") JobTaskLog pojo);

    List<JobTaskLog> queryForList();

    List<JobTaskLogDTO> queryForJobTaskLogDTOList(@Param("taskId") Integer taskId, @Param("state") String state);
}
