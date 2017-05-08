package com.qccr.livtrip.biz.test.pipe;

import com.qccr.livtrip.biz.test.RepayContext;
import com.qccr.livtrip.biz.test.model.RepayInfo;
import com.qccr.livtrip.biz.test.model.RepayPlan;
import com.qccr.livtrip.common.util.date.DateUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;


/**
 * Created by xierongli on 17/5/8.
 */
public class PenaltyPipe implements StrikeBlancePipe{

    @Override
    public RepayContext doWork(RepayContext repayContext) {
        System.out.println("冲账项：罚金");
        RepayPlan repayPlan = repayContext.getRepayPlan();
        RepayInfo repayInfo = repayContext.getRepayInfo();
        BigDecimal amount = repayContext.getAmount();
        Date inputRepayDate =  repayContext.getRepayDate();

        Date repayDate = repayPlan.getRepayDate();
        //发生逾期，进行罚金冲账
        if(inputRepayDate.compareTo(repayDate) == 1){
            //1.根据输入还款日期,计算罚息
            int delayDays = DateUtil.getIntervalDays(repayDate,inputRepayDate);
            BigDecimal penaltyInterest = calculatePenaltyInterest(repayInfo.getPrincipal(),repayInfo.getYearRate(),delayDays);
            System.out.println("罚息："+penaltyInterest.doubleValue());
            //2.计算输入金额与罚息的关系
            BigDecimal reducePenaltyInterest = amount.subtract(penaltyInterest);
            if(reducePenaltyInterest.doubleValue() >= 0){
                //罚息可以冲满
                //1. 还款计划：剩余罚息置0，已还罚息增加，更新罚息
                repayPlan.setRestPenalty(new BigDecimal("0.00"));
                repayPlan.setRepayPenalty(penaltyInterest);
                repayPlan.setPenalty(penaltyInterest);
                //2. 还款详情：restAmount 减少，repayAmount 增加， 当前应还(this_period_amount)减少
                repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(reducePenaltyInterest));
                repayInfo.setRepayedAmount(repayInfo.getRepayedAmount().add(reducePenaltyInterest));
                repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(reducePenaltyInterest));
                 //剩余冲账金额
                amount = amount.subtract(penaltyInterest);
                System.out.println("剩余冲账金额："+ amount.doubleValue());
            }
            if(reducePenaltyInterest.doubleValue() < 0){
                //罚息没有冲满
                //1. 还款计划：剩余罚息置0，已还罚息增加，更新罚息
                repayPlan.setRestPenalty(penaltyInterest.subtract(amount));
                repayPlan.setRepayPenalty(repayPlan.getPenalty()==null?amount:repayPlan.getPenalty().add(amount));
                repayInfo.setPenaltyInterest(penaltyInterest);

                //2. 还款详情：restAmount 减少，repayAmount 增加， 当前应还(this_period_amount)减少
                repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(amount));
                repayInfo.setRepayedAmount(repayInfo.getRepayedAmount().add(amount));
                repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(amount));

                //剩余冲账金额
                amount = new BigDecimal("0");
            }
        }
        repayContext.setRepayPlan(repayPlan);
        repayContext.setRepayInfo(repayInfo);
        repayContext.setAmount(amount);

        return repayContext;
    }

    public BigDecimal calculatePenaltyInterest(BigDecimal principal, BigDecimal yearRate, int delayDays){
        return principal.multiply(new BigDecimal(delayDays)).multiply(yearRate).divide(new BigDecimal(1000)).divide(new BigDecimal(365),2, RoundingMode.HALF_UP).multiply(new BigDecimal(2));
    }

}
