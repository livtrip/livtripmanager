package com.qccr.livtrip.model.test;

import java.math.BigDecimal;

/**
 * Created by xierongli on 17/5/8.
 */
public class RepayInfo {

    private Integer id;
    private Integer uid;
    private Integer currentPeriod;
    /**0 未开始 1 正常还款 2 还款结束 3 还款异常*/
    private Integer status;
    /**期限*/
    private Integer term;

    /**应还金额*/
    private BigDecimal amount;//本＋息＋罚＋手续费
    /**已还金额*/
    private BigDecimal repayedAmount; //已本＋已息＋已罚＋已手续费
    /**剩余金额*/
    private BigDecimal restAmount;//剩本＋剩息＋剩罚＋剩手续费
    /**还款日*/
    private Integer repayDay;

    /**本*/
    private BigDecimal principal;
    /**利息*/
    private BigDecimal interest;
    /**手续费*/
    private BigDecimal commissionCharge;
    /**罚金*/
    private BigDecimal penaltyInterestAmount;

    /**本期应还金额*/
    private BigDecimal thisPeriodAmount;
    /**逾期应还总额*/
    private BigDecimal overdueAmount;
    /**逾期期数*/
    private String overduePeriods;
    /**年化利率*/
    private BigDecimal yearRate;

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getRepayDay() {
        return repayDay;
    }

    public void setRepayDay(Integer repayDay) {
        this.repayDay = repayDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(Integer currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public BigDecimal getCommissionCharge() {
        return commissionCharge;
    }

    public void setCommissionCharge(BigDecimal commissionCharge) {
        this.commissionCharge = commissionCharge;
    }

    public BigDecimal getPenaltyInterestAmount() {
        return penaltyInterestAmount;
    }

    public void setPenaltyInterestAmount(BigDecimal penaltyInterestAmount) {
        this.penaltyInterestAmount = penaltyInterestAmount;
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

    public String getOverduePeriods() {
        return overduePeriods;
    }

    public void setOverduePeriods(String overduePeriods) {
        this.overduePeriods = overduePeriods;
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }
}
