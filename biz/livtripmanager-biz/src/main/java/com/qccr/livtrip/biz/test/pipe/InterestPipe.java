package com.qccr.livtrip.biz.test.pipe;

import com.qccr.livtrip.biz.test.RepayContext;
import com.qccr.livtrip.model.test.RepayInfo;
import com.qccr.livtrip.model.test.RepayPlan;


import java.math.BigDecimal;

/**
 * Created by xierongli on 17/5/8.
 */
public class InterestPipe implements StrikeBlancePipe{
    @Override
    public RepayContext doWork(RepayContext repayContext) {
        System.out.println("冲账项：利息");
        RepayPlan repayPlan = repayContext.getRepayPlan();
        RepayInfo repayInfo = repayContext.getRepayInfo();
        BigDecimal amount = repayContext.getAmount();
        System.out.println("利息处还剩冲账金额验证结果"+(amount.compareTo(ZERO)>0 && repayPlan.getRestInterest().compareTo(ZERO) > 0));
        System.out.println(amount.doubleValue() > 0);

        if(amount.compareTo(ZERO)>0 && repayPlan.getRestInterest().compareTo(ZERO) > 0){
            BigDecimal reduceInterest = amount.subtract(repayPlan.getRestInterest());
            if(reduceInterest.doubleValue() >=0){
             //利息冲满,还款计划
             repayPlan.setRestInterest(new BigDecimal(0));
             repayPlan.setRepayedInterest(repayPlan.getInterest());
             //还款详情
             repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(repayPlan.getInterest()));
             repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(repayPlan.getInterest()));
             repayInfo.setRepayedAmount(repayInfo.getRepayedAmount()==null?repayPlan.getInterest():repayInfo.getRepayedAmount().add(repayPlan.getInterest()));

             //剩余冲账金额
             amount = amount.subtract(repayPlan.getInterest());
            }
            if(reduceInterest.doubleValue() < 0){
             //利息冲不满
            //1.还款计划：剩余利息，已还利息增加
            repayPlan.setRestInterest(repayPlan.getRestInterest().subtract(amount));
            repayPlan.setRepayedInterest(repayPlan.getRepayedInterest() == null?amount:repayPlan.getRepayedInterest().add(amount));

            //2.还款详情
            repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(amount));
            repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(amount));
            repayInfo.setRepayedAmount(repayInfo.getRepayedAmount()==null?amount : repayInfo.getRepayedAmount().add(amount));

            // 剩余冲账金额
            amount = new BigDecimal(0);
            }
            System.out.println("利息处剩余冲账金额"+amount.doubleValue());
            repayContext.setAmount(amount);
            repayContext.setRepayPlan(repayPlan);
            repayContext.setRepayInfo(repayInfo);
        }

        return repayContext;
    }
}
