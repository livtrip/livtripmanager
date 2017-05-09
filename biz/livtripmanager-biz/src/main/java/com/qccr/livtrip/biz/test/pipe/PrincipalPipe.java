package com.qccr.livtrip.biz.test.pipe;

import com.qccr.livtrip.biz.test.RepayContext;
import com.qccr.livtrip.model.test.RepayInfo;
import com.qccr.livtrip.model.test.RepayPlan;


import java.math.BigDecimal;

/**
 * Created by xierongli on 17/5/8.
 */
public class PrincipalPipe implements StrikeBlancePipe{
    @Override
    public RepayContext doWork(RepayContext repayContext) {
        System.out.println("冲账项：本金");
        RepayPlan repayPlan = repayContext.getRepayPlan();
        RepayInfo repayInfo = repayContext.getRepayInfo();
        BigDecimal amount = repayContext.getAmount();

        if(amount.doubleValue() > 0){
            BigDecimal reducePrincipal = amount.subtract(repayPlan.getPrincipal());
            if(reducePrincipal.doubleValue() >= 0){
                //本金冲满
                repayPlan.setRestPrincipal(new BigDecimal(0));
                repayPlan.setRepayedPrincipal(repayPlan.getPrincipal());
                //还款详情
                repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(repayPlan.getPrincipal()));
                repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(repayPlan.getPrincipal()));
                repayInfo.setRepayedAmount(repayInfo.getRepayedAmount()==null?repayPlan.getPrincipal():repayInfo.getRepayedAmount().add(repayPlan.getPrincipal()));

                //剩余冲账金额
                amount = amount.subtract(repayPlan.getPrincipal());
            }
            if(reducePrincipal.doubleValue() < 0){
                //本金冲不满
                //1.还款计划：剩余本金，已还本金增加
                repayPlan.setRestPrincipal(repayPlan.getPrincipal().subtract(amount));
                repayPlan.setRepayedPrincipal(repayPlan.getPrincipal() == null?amount:repayPlan.getPrincipal().add(amount));

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
