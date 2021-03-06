package com.qccr.livtrip.dal.destination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.qccr.livtrip.model.destination.Dest;

@Mapper
public interface DestDao {
    int insert(@Param("pojo") Dest pojo);

    int insertSelective(@Param("pojo") Dest pojo);

    int insertList(@Param("pojos") List<Dest> pojo);

    int update(@Param("pojo") Dest pojo);

    List<Dest> queryForList(@Param("query") String query);

    int increaseSort(@Param("destinationId") Integer destinationId);

    Integer getDestinationIdByCityName(@Param("cityName") String cityName);

    List<Dest> queryForListByCondition(@Param("cityName") String cityName,@Param("state") String state,@Param("destinationId") Integer destinationId);

    Dest getByDestinationId(@Param("destinationId") Integer destinationId);
}
