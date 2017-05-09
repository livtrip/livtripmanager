package com.qccr.livtrip.model.test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xierongli on 17/5/8.
 */
public class RepayPlan {

    private Integer id;
    private Integer uid;
    private Integer repayInfoId;
    private Integer periodNumber;


    //本金＋利息＋手续费＋罚金
    /**应还金额*/
    private BigDecimal amount;//本＋息＋罚＋手续费
    /**已还金额*/
    private BigDecimal repayedAmount; //已本＋已息＋已罚＋已手续费
    /**剩余金额*/
    private BigDecimal restAmount;//剩本＋剩息＋剩罚＋剩手续费

    /**还款日期*/
    private Date repayDate;
    /**实际还款日*/
    private Date actualRepayDate;
    /**0未开始 1 部分还款 2 还款成功 3 还款失败*/
    private  Integer status;
    /**逾期天数*/
    private  Integer delayDays;


    /**应还本金*/
    private BigDecimal principal;
    /**应还利息*/
    private BigDecimal interest;
    /**应还罚金*/
    private BigDecimal penaltyInterestAmount;
    /**应还手续费*/
    private BigDecimal commissionCharge;

    /**已还本金*/
    private BigDecimal repayedPrincipal;
    /**已还利息*/
    private BigDecimal repayedInterest;
    /**已还罚金*/
    private BigDecimal repayedPenaltyInterestAmount;
    /**已还手续费*/
    private BigDecimal repayedCommissionCharge;

    /**剩余本金*/
    private BigDecimal restPrincipal;
    /**剩余利息*/
    private BigDecimal restInterest;
    /**剩余手续费*/
    private BigDecimal restCommissionCharge;
    /**剩余罚金*/
    private BigDecimal restPenaltyInterestAmount;


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

    public Integer getRepayInfoId() {
        return repayInfoId;
    }

    public void setRepayInfoId(Integer repayInfoId) {
        this.repayInfoId = repayInfoId;
    }

    public Integer getPeriodNumber() {
        return periodNumber;
    }

    public void setPeriodNumber(Integer periodNumber) {
        this.periodNumber = periodNumber;
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

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public Date getActualRepayDate() {
        return actualRepayDate;
    }

    public void setActualRepayDate(Date actualRepayDate) {
        this.actualRepayDate = actualRepayDate;
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

    public BigDecimal getPenaltyInterestAmount() {
        return penaltyInterestAmount;
    }

    public void setPenaltyInterestAmount(BigDecimal penaltyInterestAmount) {
        this.penaltyInterestAmount = penaltyInterestAmount;
    }

    public BigDecimal getCommissionCharge() {
        return commissionCharge;
    }

    public void setCommissionCharge(BigDecimal commissionCharge) {
        this.commissionCharge = commissionCharge;
    }

    public BigDecimal getRepayedPrincipal() {
        return repayedPrincipal;
    }

    public void setRepayedPrincipal(BigDecimal repayedPrincipal) {
        this.repayedPrincipal = repayedPrincipal;
    }

    public BigDecimal getRepayedInterest() {
        return repayedInterest;
    }

    public void setRepayedInterest(BigDecimal repayedInterest) {
        this.repayedInterest = repayedInterest;
    }

    public BigDecimal getRepayedPenaltyInterestAmount() {
        return repayedPenaltyInterestAmount;
    }

    public void setRepayedPenaltyInterestAmount(BigDecimal repayedPenaltyInterestAmount) {
        this.repayedPenaltyInterestAmount = repayedPenaltyInterestAmount;
    }

    public BigDecimal getRepayedCommissionCharge() {
        return repayedCommissionCharge;
    }

    public void setRepayedCommissionCharge(BigDecimal repayedCommissionCharge) {
        this.repayedCommissionCharge = repayedCommissionCharge;
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

    public BigDecimal getRestCommissionCharge() {
        return restCommissionCharge;
    }

    public void setRestCommissionCharge(BigDecimal restCommissionCharge) {
        this.restCommissionCharge = restCommissionCharge;
    }

    public BigDecimal getRestPenaltyInterestAmount() {
        return restPenaltyInterestAmount;
    }

    public void setRestPenaltyInterestAmount(BigDecimal restPenaltyInterestAmount) {
        this.restPenaltyInterestAmount = restPenaltyInterestAmount;
    }
}
