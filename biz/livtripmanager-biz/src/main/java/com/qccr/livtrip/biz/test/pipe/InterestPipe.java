package com.qccr.livtrip.biz.test.pipe;

import com.qccr.livtrip.biz.test.RepayContext;
import com.qccr.livtrip.biz.test.model.RepayInfo;
import com.qccr.livtrip.biz.test.model.RepayPlan;

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

        if(amount.doubleValue() > 0){
            BigDecimal reduceInterest = amount.subtract(repayPlan.getInterest());
            if(reduceInterest.doubleValue() >=0){
             //利息冲满,还款计划
             repayPlan.setRestInterest(new BigDecimal(0));
             repayPlan.setRepayInterest(repayPlan.getCommission());
             //还款详情
             repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(repayPlan.getInterest()));
             repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(repayPlan.getInterest()));
             repayInfo.setRepayedAmount(repayInfo.getRepayedAmount().add(repayPlan.getInterest()));

             //剩余冲账金额
             amount = amount.subtract(repayPlan.getInterest());
            }
            if(reduceInterest.doubleValue() < 0){
             //利息冲不满
            //1.还款计划：剩余利息，已还利息增加
            repayPlan.setRestCommission(repayPlan.getInterest().subtract(amount));
            repayPlan.setRepayCommission(repayPlan.getRepayInterest() == null?amount:repayPlan.getRepayInterest().add(amount));

            //2.还款详情
            repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(amount));
            repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(amount));
            repayInfo.setRepayedAmount(repayInfo.getRepayedAmount()==null?amount : repayInfo.getRepayedAmount().add(amount));

            // 剩余冲账金额
            amount = new BigDecimal(0);
            }
        }
        System.out.println("剩余冲账金额："+ amount.doubleValue());
        repayContext.setAmount(amount);
        repayContext.setRepayPlan(repayPlan);
        repayContext.setRepayInfo(repayInfo);
        return repayContext;
    }
}
