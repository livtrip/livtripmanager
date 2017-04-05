package com.qccr.livtrip.dal.destination;

import com.qccr.livtrip.model.dto.CityQueryDTO;
import com.qccr.livtrip.model.request.CityQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.qccr.livtrip.model.destination.City;

@Mapper
public interface CityDao {
    int insert(@Param("pojo") City pojo);

    int insertSelective(@Param("pojo") City pojo);

    int insertList(@Param("pojos") List<City> pojo);

    int update(@Param("pojo") City pojo);

    List<CityQueryDTO> queryCityList(CityQuery cityQuery);
}
