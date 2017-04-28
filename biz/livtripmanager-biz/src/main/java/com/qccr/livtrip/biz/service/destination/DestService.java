package com.qccr.livtrip.biz.service.destination;

import com.qccr.livtrip.dal.destination.DestDao;
import com.qccr.livtrip.model.destination.Dest;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
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
}
