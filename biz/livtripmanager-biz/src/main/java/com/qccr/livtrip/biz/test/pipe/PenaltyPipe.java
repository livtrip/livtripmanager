package com.qccr.livtrip.biz.test.pipe;

import com.qccr.livtrip.biz.test.RepayContext;

import com.qccr.livtrip.biz.test.util.RepayUtil;
import com.qccr.livtrip.common.util.date.DateUtil;
import com.qccr.livtrip.model.test.RepayInfo;
import com.qccr.livtrip.model.test.RepayPlan;

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
        if(inputRepayDate.compareTo(repayDate) == 1 && repayPlan.getRestPenaltyInterestAmount().compareTo(BigDecimal.ZERO) > 0){
            //1.根据输入还款日期,计算罚息
            int delayDays = DateUtil.getIntervalDays(repayDate,inputRepayDate);
            if(delayDays == 0){return repayContext;}

            BigDecimal realTimePenaltyInterest = RepayUtil.calculatePenaltyInterest(repayInfo.getPrincipal(),repayInfo.getYearRate(),delayDays);
            System.out.println("实时计算的罚息："+realTimePenaltyInterest.doubleValue());
            //修复真实的罚息
            repayPlan.setPenaltyInterestAmount(realTimePenaltyInterest);
            repayPlan.setRestPenaltyInterestAmount(realTimePenaltyInterest);

            Boolean isEqualsOrMore = amount.compareTo(realTimePenaltyInterest) >=0;
            BigDecimal operationMoney = null;
            if(isEqualsOrMore){
                operationMoney = realTimePenaltyInterest;
                amount = amount.subtract(realTimePenaltyInterest);
            }else{
                operationMoney = amount;
                amount = new BigDecimal(0);
            }
            repayPlan.setRepayedPenaltyInterestAmount(repayPlan.getRepayedPenaltyInterestAmount()==null?operationMoney:repayPlan.getRepayedPenaltyInterestAmount().add(operationMoney));
            repayPlan.setRestPenaltyInterestAmount(repayPlan.getRestPenaltyInterestAmount().subtract(operationMoney));

            repayPlan.setRestAmount(repayPlan.getRestAmount().subtract(operationMoney));
            repayPlan.setRepayedAmount(repayPlan.getRepayedAmount()==null?operationMoney:repayPlan.getRepayedAmount().add(operationMoney));
            //2.还款详情
            repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(operationMoney));
            repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(operationMoney));
            repayInfo.setRepayedAmount(repayInfo.getRepayedAmount()==null?operationMoney:repayInfo.getRepayedAmount().add(operationMoney));

            repayContext.setRepayPlan(repayPlan);
            repayContext.setRepayInfo(repayInfo);
            repayContext.setAmount(amount);
        }

        return repayContext;
    }



}
