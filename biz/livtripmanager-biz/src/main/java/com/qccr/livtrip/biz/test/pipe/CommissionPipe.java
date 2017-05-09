package com.qccr.livtrip.biz.test.pipe;

import com.qccr.livtrip.biz.test.RepayContext;
import com.qccr.livtrip.model.test.RepayInfo;
import com.qccr.livtrip.model.test.RepayPlan;

import java.math.BigDecimal;

/**
 * Created by xierongli on 17/5/8.
 */
public class CommissionPipe implements StrikeBlancePipe{

    @Override
    public RepayContext doWork(RepayContext repayContext) {
        System.out.println("冲账项：手续费");
        RepayPlan repayPlan = repayContext.getRepayPlan();
        RepayInfo repayInfo = repayContext.getRepayInfo();
        BigDecimal amount = repayContext.getAmount();

        if(amount.compareTo(ZERO) > 0 && repayPlan.getRestCommissionCharge().compareTo(ZERO) > 0){
            BigDecimal reduceCommission = amount.subtract(repayPlan.getCommissionCharge());
            if(reduceCommission.doubleValue() >= 0){
              //手续费冲满
              //1.还款计划：剩余手续费置0，已还手续费增加
              repayPlan.setRestCommissionCharge(new BigDecimal(0));
              repayPlan.setRepayedCommissionCharge(repayPlan.getCommissionCharge());
              //2.还款详情
              repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(repayPlan.getCommissionCharge()));
              repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(repayPlan.getCommissionCharge()));
              repayInfo.setRepayedAmount(repayInfo.getRepayedAmount()==null?repayPlan.getCommissionCharge():repayInfo.getRepayedAmount().add(repayPlan.getCommissionCharge()));

              //剩余冲账金额
              amount = amount.subtract(repayPlan.getCommissionCharge());

            }
            if(reduceCommission.doubleValue() < 0){
              //手续费未充满
              //1.还款计划：剩余手续费置0，已还手续费增加
              repayPlan.setRestCommissionCharge(repayPlan.getCommissionCharge().subtract(amount));
              repayPlan.setRepayedCommissionCharge(repayPlan.getRepayedCommissionCharge() == null?amount:repayPlan.getRepayedCommissionCharge().add(amount));

              //2.还款详情
              repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(amount));
              repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(amount));
              repayInfo.setRepayedAmount(repayInfo.getRepayedAmount()==null?amount : repayInfo.getRepayedAmount().add(amount));

              // 剩余冲账金额
              amount = new BigDecimal(0);
            }

            repayContext.setAmount(amount);
            repayContext.setRepayPlan(repayPlan);
            repayContext.setRepayInfo(repayInfo);
        }

        return repayContext;
    }
}
