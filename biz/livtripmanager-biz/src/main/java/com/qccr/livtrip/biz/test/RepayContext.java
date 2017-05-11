package com.qccr.livtrip.biz.test;



import com.qccr.livtrip.model.test.RepayInfo;
import com.qccr.livtrip.model.test.RepayPlan;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xierongli on 17/5/8.
 */
public class RepayContext {

    /**冲账金额*/
    private BigDecimal amount;
    /** 还款日期*/
    private Date repayDate;
    /**还款计划*/
    private RepayPlan repayPlan;
    /**还款详情总览*/
    private RepayInfo repayInfo;
    /**0: 不忽略罚息  1:忽略罚息*/
    private Integer ignorePenalty;

    public Integer getIgnorePenalty() {
        return ignorePenalty;
    }

    public void setIgnorePenalty(Integer ignorePenalty) {
        if (ignorePenalty == null){
            this.ignorePenalty = 0;
        }else{
            this.ignorePenalty = ignorePenalty;
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public RepayPlan getRepayPlan() {
        return repayPlan;
    }

    public void setRepayPlan(RepayPlan repayPlan) {
        this.repayPlan = repayPlan;
    }

    public RepayInfo getRepayInfo() {
        return repayInfo;
    }

    public void setRepayInfo(RepayInfo repayInfo) {
        this.repayInfo = repayInfo;
    }
}
