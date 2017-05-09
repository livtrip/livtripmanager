package com.qccr.livtrip.biz.service.test;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.qccr.livtrip.model.test.RepayPlan;
import com.qccr.livtrip.dal.test.RepayPlanDao;

@Service
public class RepayPlanService{

    @Resource
    private RepayPlanDao repayPlanDao;

    public int insert(RepayPlan pojo){
        return repayPlanDao.insert(pojo);
    }

    public int insertSelective(RepayPlan pojo){
        return repayPlanDao.insertSelective(pojo);
    }

    public int insertList(List<RepayPlan> pojos){
        return repayPlanDao.insertList(pojos);
    }

    public int update(RepayPlan pojo){
        return repayPlanDao.update(pojo);
    }

    public List<RepayPlan> queryForList(Integer repayInfoId){
        return  repayPlanDao.queryForList(repayInfoId);
    }

    public RepayPlan getByRepayInfoIdAndPeriodNum(Integer repayInfoId, Integer periodNumber){
        return  repayPlanDao.getByRepayInfoIdAndPeriodNum(repayInfoId,periodNumber);
    }
}
