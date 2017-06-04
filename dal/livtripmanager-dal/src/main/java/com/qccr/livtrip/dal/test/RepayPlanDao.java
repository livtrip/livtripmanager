package com.qccr.livtrip.dal.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.qccr.livtrip.model.test.RepayPlan;

@Mapper
public interface RepayPlanDao {
    int insert(@Param("pojo") RepayPlan pojo);

    int insertSelective(@Param("pojo") RepayPlan pojo);

    int insertList(@Param("pojos") List<RepayPlan> pojo);

    int update(@Param("pojo") RepayPlan pojo);

    List<RepayPlan> queryForList(@Param("repayInfoId") Integer repayInfoId);

    RepayPlan getByRepayInfoIdAndPeriodNum(@Param("repayInfoId") Integer repayInfoId, @Param("periodNumber") Integer periodNumber);
}
