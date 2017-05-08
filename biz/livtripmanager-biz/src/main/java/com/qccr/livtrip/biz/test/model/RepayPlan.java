package com.qccr.livtrip.biz.test.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xierongli on 17/5/5.
 */
public class RepayPlan {

    //本金＋利息＋手续费＋罚金


    /**应还金额*/
    private BigDecimal amount;//本＋息＋罚＋手续费
    /**已还金额*/
    private BigDecimal repayAmount; //已本＋已息＋已罚＋已手续费
    /**剩余金额*/
    private BigDecimal restAmount;//剩本＋剩息＋剩罚＋剩手续费
    /**期数*/
    private Integer period;
    /**还款日期*/
    private Date repayDate;
    /**0未开始 1 部分还款 2 还款成功 3 还款失败*/
    private  Integer status;
    /**逾期天数*/
    private  Integer delayDays;

    /**应还本金*/
    private BigDecimal principal;
    /**应还利息*/
    private BigDecimal interest;
    /**应还罚金*/
    private BigDecimal penalty;
    /**应还手续费*/
    private BigDecimal commission;

    /**已还本金*/
    private BigDecimal repayPrincipal;
    /**已还利息*/
    private BigDecimal repayInterest;
    /**已还罚金*/
    private BigDecimal repayPenalty;
    /**已还手续费*/
    private BigDecimal repayCommission;

    /**剩余本金*/
    private BigDecimal restPrincipal;
    /**剩余利息*/
    private BigDecimal restInterest;
    /**剩余手续费*/
    private BigDecimal restCommission;
    /**剩余罚金*/
    private BigDecimal restPenalty;


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public BigDecimal getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(BigDecimal restAmount) {
        this.restAmount = restAmount;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
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

    public BigDecimal getPenalty() {
        return penalty;
    }

    public void setPenalty(BigDecimal penalty) {
        this.penalty = penalty;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getRepayPrincipal() {
        return repayPrincipal;
    }

    public void setRepayPrincipal(BigDecimal repayPrincipal) {
        this.repayPrincipal = repayPrincipal;
    }

    public BigDecimal getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(BigDecimal repayInterest) {
        this.repayInterest = repayInterest;
    }

    public BigDecimal getRepayPenalty() {
        return repayPenalty;
    }

    public void setRepayPenalty(BigDecimal repayPenalty) {
        this.repayPenalty = repayPenalty;
    }

    public BigDecimal getRepayCommission() {
        return repayCommission;
    }

    public void setRepayCommission(BigDecimal repayCommission) {
        this.repayCommission = repayCommission;
    }

    public BigDecimal getRestPrincipal() {
        return restPrincipal;
    }

    public void setRestPrincipal(BigDecimal restPrincipal) {
        this.restPrincipal = restPrincipal;
    }

    public BigDecimal getRestInterest() {
        return restInterest;
    }

    public void setRestInterest(BigDecimal restInterest) {
        this.restInterest = restInterest;
    }

    public BigDecimal getRestCommission() {
        return restCommission;
    }

    public void setRestCommission(BigDecimal restCommission) {
        this.restCommission = restCommission;
    }

    public BigDecimal getRestPenalty() {
        return restPenalty;
    }

    public void setRestPenalty(BigDecimal restPenalty) {
        this.restPenalty = restPenalty;
    }
}
