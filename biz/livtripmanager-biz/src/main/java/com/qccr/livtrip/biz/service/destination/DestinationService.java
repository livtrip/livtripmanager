package com.qccr.livtrip.biz.service.destination;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.dal.destination.DestinationDao;
import com.qccr.livtrip.model.destination.Destination;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.Des;

import javax.annotation.Resource;
import java.util.List;


@Service("destinationService")
public class DestinationService{

    @Resource
    private DestinationDao destinationDao;

    public int insert(Destination pojo){
        return destinationDao.insert(pojo);
    }

    public int insertSelective(Destination pojo){
        return destinationDao.insertSelective(pojo);
    }

    public int insertList(List<Destination> pojos){
        return destinationDao.insertList(pojos);
    }

    public int update(Destination pojo){
        return destinationDao.update(pojo);
    }

    public PageInfo<Destination> pageQueryList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<Destination> destinations = destinationDao.queryObject();
        return new PageInfo<>(destinations);
    }
}
