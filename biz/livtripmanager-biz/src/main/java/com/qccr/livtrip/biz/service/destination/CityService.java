package com.qccr.livtrip.biz.service.destination;

import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.model.destination.City;
import com.qccr.livtrip.model.dto.CityQueryDTO;
import com.qccr.livtrip.model.request.CityQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/4 12:36 Exp $$
 */
public interface CityService {
    int insert(City city);
    int insertList(List<City> cities);
    PageInfo<CityQueryDTO> pageQueryCity(CityQuery cityQuery);
    City queryByDestinationId(Integer destinationId);


}
