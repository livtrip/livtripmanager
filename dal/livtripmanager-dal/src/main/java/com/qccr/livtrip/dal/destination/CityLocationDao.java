package com.qccr.livtrip.dal.destination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.qccr.livtrip.model.destination.CityLocation;

@Mapper
public interface CityLocationDao {
    int insert(@Param("pojo") CityLocation pojo);

    int insertSelective(@Param("pojo") CityLocation pojo);

    int insertList(@Param("pojos") List<CityLocation> pojo);

    int update(@Param("pojo") CityLocation pojo);
}
