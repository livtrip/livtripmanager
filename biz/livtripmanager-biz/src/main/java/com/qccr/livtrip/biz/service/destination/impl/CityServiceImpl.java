package com.qccr.livtrip.biz.service.destination.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.service.destination.CityService;
import com.qccr.livtrip.dal.destination.CityDao;
import com.qccr.livtrip.model.destination.City;
import com.qccr.livtrip.model.dto.CityQueryDTO;
import com.qccr.livtrip.model.request.CityQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/4 12:36 Exp $$
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public int insert(City city) {
        return cityDao.insert(city);
    }

    @Override
    public int insertList(List<City> cities) {
        return cityDao.insertList(cities);
    }

    @Override
    public PageInfo<CityQueryDTO> pageQueryCity(CityQuery cityQuery) {
        PageHelper.startPage(cityQuery.getPageNumber(),cityQuery.getPageSize(),true,false);
        List<CityQueryDTO> cities = cityDao.queryCityList(cityQuery);
        return new PageInfo<>(cities);
    }

    @Override
    public City queryByDestinationId(Integer destinationId) {
        return cityDao.queryByDestinationId(destinationId);
    }
}
