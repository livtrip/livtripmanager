package com.qccr.livtrip.dal.destination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.qccr.livtrip.model.destination.Destination;

@Mapper
public interface DestinationDao {
    int insert(@Param("pojo") Destination pojo);

    int insertSelective(@Param("pojo") Destination pojo);

    int insertList(@Param("pojos") List<Destination> pojo);

    int update(@Param("pojo") Destination pojo);

    List<Destination> queryObject();
}
