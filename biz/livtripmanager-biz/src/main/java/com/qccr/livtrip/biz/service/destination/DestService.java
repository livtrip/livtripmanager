package com.qccr.livtrip.biz.service.destination;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.dal.destination.DestDao;
import com.qccr.livtrip.model.destination.Dest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service("destService")
public class DestService{

    @Resource
    private DestDao destDao;

    public int insert(Dest pojo){
        return destDao.insert(pojo);
    }

    public int insertSelective(Dest pojo){
        return destDao.insertSelective(pojo);
    }

    public int insertList(List<Dest> pojos){
        return destDao.insertList(pojos);
    }

    public int update(Dest pojo){
        return destDao.update(pojo);
    }

    public PageInfo<Dest> pageQueryList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<Dest> dests = destDao.queryForList(null);
        return new PageInfo<>(dests);
    }

    public PageInfo<Dest> pageQueryListByCondition(String cityName, String state, Integer destinationId,
                                                   Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<Dest> dests = destDao.queryForListByCondition(cityName,state,destinationId);
        return new PageInfo<>(dests);
    }



    public List<Dest> queryForList(String query){
        return  destDao.queryForList(query);
    }

    public int increaseSort(Integer destinationId){
        return  destDao.increaseSort(destinationId);
    }

    public Integer getDestinationIdByCityName(String cityName){
        return destDao.getDestinationIdByCityName(cityName);
    }


}
