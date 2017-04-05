package com.qccr.livtrip.dal.destination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.qccr.livtrip.model.destination.State;

@Mapper
public interface StateDao {
    int insert(@Param("pojo") State pojo);

    int insertSelective(@Param("pojo") State pojo);

    int insertList(@Param("pojos") List<State> pojo);

    int update(@Param("pojo") State pojo);
}
