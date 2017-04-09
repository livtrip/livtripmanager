package com.qccr.livtrip.biz.service.destination.impl;

import com.qccr.livtrip.biz.service.destination.CityLocationService;
import com.qccr.livtrip.dal.destination.CityLocationDao;
import com.qccr.livtrip.model.destination.CityLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/9 16:49 Exp $$
 */
@Service
public class CityLocationServiceImpl implements CityLocationService{
    @Autowired
    private CityLocationDao cityLocationDao;

    @Override
    public int insertList(List<CityLocation> pojo) {
        return cityLocationDao.insertList(pojo);
    }
}
