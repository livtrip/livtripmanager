package com.qccr.livtrip.biz.test.model;

import java.math.BigDecimal;

/**
 * Created by xierongli on 17/5/8.
 */
public class RepayInfo {

    /**应还金额*/
    private BigDecimal amount;//本＋息＋罚＋手续费
    /**已还金额*/
    private BigDecimal repayedAmount; //已本＋已息＋已罚＋已手续费
    /**剩余金额*/
    private BigDecimal restAmount;//剩本＋剩息＋剩罚＋剩手续费

    /**本*/
    private BigDecimal principal;
    /**利息*/
    private BigDecimal interest;
    /**手续费*/
    private BigDecimal commission;
    /**罚金*/
    private BigDecimal penaltyInterest;

    /**本期应还金额*/
    private BigDecimal thisPeriodAmount;
    /**逾期应还总额*/
    private BigDecimal overdueAmount;
    /**逾期期数*/
    private Integer overduePeriods;
    /**年化利率*/
    private BigDecimal yearRate;



    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public BigDecimal getRepayedAmount() {
        return repayedAmount;
    }

    public void setRepayedAmount(BigDecimal repayedAmount) {
        this.repayedAmount = repayedAmount;
    }

    public BigDecimal getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(BigDecimal restAmount) {
        this.restAmount = restAmount;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getPenaltyInterest() {
        return penaltyInterest;
    }

    public void setPenaltyInterest(BigDecimal penaltyInterest) {
        this.penaltyInterest = penaltyInterest;
    }

    public BigDecimal getThisPeriodAmount() {
        return thisPeriodAmount;
    }

    public void setThisPeriodAmount(BigDecimal thisPeriodAmount) {
        this.thisPeriodAmount = thisPeriodAmount;
    }

    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public Integer getOverduePeriods() {
        return overduePeriods;
    }

    public void setOverduePeriods(Integer overduePeriods) {
        this.overduePeriods = overduePeriods;
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }
}
