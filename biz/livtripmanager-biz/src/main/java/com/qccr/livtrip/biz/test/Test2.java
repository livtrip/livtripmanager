package com.qccr.livtrip.biz.test;

import com.alibaba.fastjson.JSON;
import com.qccr.livtrip.biz.test.model.RepayInfo;
import com.qccr.livtrip.biz.test.model.RepayPlan;
import com.qccr.livtrip.common.util.date.DateUtil;
import org.testng.collections.Lists;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Created by xierongli on 17/5/5.
 */
public class Test2 {

    public static void main(String[] args) {
        //冲账逻辑：罚->手续费－>利息 ->本金

        RepayInfo repayInfo = new RepayInfo();
        repayInfo.setYearRate(new BigDecimal("10"));
        repayInfo.setAmount(new BigDecimal("30801.40"));
        repayInfo.setRepayedAmount(new BigDecimal("0.0"));
        repayInfo.setRestAmount(new BigDecimal("30801.40"));
        repayInfo.setPrincipal(new BigDecimal("30000.00"));
        repayInfo.setInterest(new BigDecimal("501.40"));
        repayInfo.setCommission(new BigDecimal("300.00"));
        repayInfo.setPenaltyInterest(new BigDecimal("10.32"));
        repayInfo.setThisPeriodAmount(new BigDecimal("10276.44"));


        List<RepayPlan> repayPlans = Lists.newArrayList();

        //第一期(逾期)
        RepayPlan repayPlan = new RepayPlan();
        repayPlan.setPeriod(1);
        repayPlan.setRepayDate(DateUtil.StringToDate("2017-05-15"));
        repayPlan.setStatus(3);
        repayPlan.setDelayDays(17);

        repayPlan.setAmount(new BigDecimal("10276.44"));
        repayPlan.setPrincipal(new BigDecimal("9999.78"));
        repayPlan.setInterest(new BigDecimal("167.34"));
        repayPlan.setCommission(new BigDecimal("100.00"));
        repayPlan.setPenalty(new BigDecimal("9.32"));

        repayPlan.setRestPrincipal(new BigDecimal("9999.78"));
        repayPlan.setRestInterest(new BigDecimal("167.34"));
        repayPlan.setRestCommission(new BigDecimal("100.00"));
        repayPlan.setRestPenalty(new BigDecimal("9.32"));
        repayPlans.add(repayPlan);

        RepayContext repayPlanContext = new RepayContext();
        repayPlanContext.setAmount(new BigDecimal(8));
        repayPlanContext.setRepayDate(DateUtil.StringToDate("2017-05-18"));
        repayPlanContext.setRepayPlan(repayPlan);
        repayPlanContext.setRepayInfo(repayInfo);

        RepayPlanPipeManager.doPipe(repayPlanContext);
        System.out.println(repayPlanContext.getRepayPlan().getRepayPenalty());
        System.out.println(repayPlanContext.getAmount());
        System.out.println(JSON.toJSONString(repayPlanContext));




    }




     public BigDecimal calculatePenaltyInterest(BigDecimal principal, BigDecimal yearRate, int delayDays){
         return principal.multiply(new BigDecimal(delayDays)).multiply(yearRate).divide(new BigDecimal(1000)).divide(new BigDecimal(365),2,RoundingMode.HALF_UP).multiply(new BigDecimal(2));
     }


}
