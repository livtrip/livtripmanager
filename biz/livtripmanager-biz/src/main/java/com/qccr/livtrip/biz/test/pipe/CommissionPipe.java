package com.qccr.livtrip.biz.test.pipe;

import com.qccr.livtrip.biz.test.RepayContext;
import com.qccr.livtrip.biz.test.model.RepayInfo;
import com.qccr.livtrip.biz.test.model.RepayPlan;
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

        if(amount.doubleValue() > 0){
            BigDecimal reduceCommission = amount.subtract(repayPlan.getCommission());
            if(reduceCommission.doubleValue() >= 0){
              //手续费冲满
              //1.还款计划：剩余手续费置0，已还手续费增加
              repayPlan.setRestCommission(new BigDecimal(0));
              repayPlan.setRepayCommission(repayPlan.getCommission());
              //2.还款详情
              repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(repayPlan.getCommission()));
              repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(repayPlan.getCommission()));
              repayInfo.setRepayedAmount(repayInfo.getRepayedAmount().add(repayPlan.getCommission()));

              //剩余冲账金额
              amount = amount.subtract(repayPlan.getCommission());

            }
            if(reduceCommission.doubleValue() < 0){
              //手续费未充满
              //1.还款计划：剩余手续费置0，已还手续费增加
              repayPlan.setRestCommission(repayPlan.getCommission().subtract(amount));
              repayPlan.setRepayCommission(repayPlan.getRepayCommission() == null?amount:repayPlan.getRepayCommission().add(amount));

              //2.还款详情
              repayInfo.setThisPeriodAmount(repayInfo.getThisPeriodAmount().subtract(amount));
              repayInfo.setRestAmount(repayInfo.getRestAmount().subtract(amount));
              repayInfo.setRepayedAmount(repayInfo.getRepayedAmount()==null?amount : repayInfo.getRepayedAmount().add(amount));

              // 剩余冲账金额
              amount = new BigDecimal(0);
            }

        }
        repayContext.setAmount(amount);
        repayContext.setRepayPlan(repayPlan);
        repayContext.setRepayInfo(repayInfo);
        return repayContext;
    }
}
