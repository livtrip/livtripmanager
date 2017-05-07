package com.qccr.livtrip.biz.test;

import org.apache.commons.collections.CollectionUtils;
import org.testng.collections.Lists;

import java.util.List;

/**
 * Created by xierongli on 17/5/5.
 */
public class Test2 {

    public static void main(String[] args) {
        //冲账逻辑：手续费－>罚－>利息 ->本金

        List<RepayPlan> repayPlans = Lists.newArrayList();

        //第一期(逾期)
        RepayPlan repayPlan = new RepayPlan();
        repayPlan.setPeriod(1);
        repayPlan.setAmount(10276.44);
        repayPlan.setPrincipal(9999.78);
        repayPlan.setInterest(167.34);
        repayPlan.setCommission(100.00);
        repayPlan.setPenalty(9.32);

        repayPlan.setRestPrincipal(9999.78);
        repayPlan.setInterest(167.34);
        repayPlan.setCommission(100.00);
        repayPlan.setRestPenalty(9.32);


    }

    /**
     * 冲账
     * @param   amount     输入金额
     * @param   repayPlans 还款期数
     * @return  处理之后的还款计划
     * @author xierongli
     * @date 17/5/5 下午5:36
     */
     public List<RepayPlan> strikeBlance(Double amount, List<RepayPlan> repayPlans){
         if(CollectionUtils.isNotEmpty(repayPlans) && amount != null){
             if(repayPlans.size() >1 && amount.compareTo(repayPlans.get(0).getAmount()) < 0){
                 System.out.println("输入的金额满足不了账期,可以减少还款期数");
             }




         }

        return repayPlans;
     }

}
