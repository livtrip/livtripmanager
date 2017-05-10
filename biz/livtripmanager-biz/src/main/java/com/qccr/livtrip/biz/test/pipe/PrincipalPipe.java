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
        System.out.println("本金处还剩冲账金额验证结果"+(amount.compareTo(BigDecimal.ZERO) > 0 && repayPlan.getRestPrincipal().compareTo(BigDecimal.ZERO)> 0));
        System.out.println(amount.doubleValue() > 0);

        if(amount.compareTo(BigDecimal.ZERO) > 0 && repayPlan.getRestPrincipal().compareTo(BigDecimal.ZERO)> 0){
            Boolean isEqualsOrMore = amount.compareTo(repayPlan.getRestPrincipal())>=0;
            BigDecimal operationMoney = null;
            if(isEqualsOrMore){
                operationMoney = repayPlan.getRestPrincipal();
                //剩余冲账金额
                amount = amount.subtract(repayPlan.getRestPrincipal());
            }else{
                operationMoney = amount;
                //剩余冲账金额
                amount = new BigDecimal(0);
            }

            //1.还款计划
            repayPlan.setRepayedPrincipal(repayPlan.getRepayedPrincipal()==null?operationMoney:repayPlan.getRepayedPrincipal().add(operationMoney));
            repayPlan.setRestPrincipal(repayPlan.getRestPrincipal().subtract(operationMoney));
            repayPlan.setRestAmount(repayPlan.getRestAmount().subtract(operationMoney));
            repayPlan.setRepayedAmount(repayPlan.getRepayedAmount()==null?operationMoney:repayPlan.getRepayedAmount().add(operationMoney));
            //2.还款详情
            repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(operationMoney));
            repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(operationMoney));
            repayInfo.setRepayedAmount(repayInfo.getRepayedAmount()==null?operationMoney:repayInfo.getRepayedAmount().add(operationMoney));

            System.out.println("本金处剩余冲账金额"+amount.doubleValue());
            repayContext.setAmount(amount);
            repayContext.setRepayPlan(repayPlan);
            repayContext.setRepayInfo(repayInfo);
        }

        return repayContext;
    }

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.00");
        BigDecimal b = new BigDecimal("0");
        System.out.println(a.compareTo(b));
    }
}
