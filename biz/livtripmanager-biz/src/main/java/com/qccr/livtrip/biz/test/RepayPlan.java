package com.qccr.livtrip.biz.test;

/**
 * Created by xierongli on 17/5/5.
 */
public class RepayPlan {

    //本金＋利息＋手续费＋罚金


    /**应还金额*/
    private Double amount;//本＋息＋罚＋手续费
    /**已还金额*/
    private Double repayAmount; //已本＋已息＋已罚＋已手续费
    /**期数*/
    private Integer period;



    /**本金*/
    private Double principal;
    /**利息*/
    private Double interest;
    /**罚金*/
    private Double penalty;
    /**手续费*/
    private Double commission;


    /**已还本金*/
    private Double repayPrincipal;
    /**已还利息*/
    private Double repayInterest;
    /**已还罚金*/
    private Double repayPenalty;
    /**已还手续费*/
    private Double repayCommission;


    /**剩余本金*/
    private Double restPrincipal;
    /**剩余利息*/
    private Double restInterest;
    /**剩余罚金*/
    private Double restPenalty;
    /**剩余手续费*/
    private Double restCommission;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(Double repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getRepayPrincipal() {
        return repayPrincipal;
    }

    public void setRepayPrincipal(Double repayPrincipal) {
        this.repayPrincipal = repayPrincipal;
    }

    public Double getRepayInterest() {
        return repayInterest;
    }

    public void setRepayInterest(Double repayInterest) {
        this.repayInterest = repayInterest;
    }

    public Double getRepayPenalty() {
        return repayPenalty;
    }

    public void setRepayPenalty(Double repayPenalty) {
        this.repayPenalty = repayPenalty;
    }

    public Double getRepayCommission() {
        return repayCommission;
    }

    public void setRepayCommission(Double repayCommission) {
        this.repayCommission = repayCommission;
    }

    public Double getRestPrincipal() {
        return restPrincipal;
    }

    public void setRestPrincipal(Double restPrincipal) {
        this.restPrincipal = restPrincipal;
    }

    public Double getRestInterest() {
        return restInterest;
    }

    public void setRestInterest(Double restInterest) {
        this.restInterest = restInterest;
    }

    public Double getRestPenalty() {
        return restPenalty;
    }

    public void setRestPenalty(Double restPenalty) {
        this.restPenalty = restPenalty;
    }

    public Double getRestCommission() {
        return restCommission;
    }

    public void setRestCommission(Double restCommission) {
        this.restCommission = restCommission;
    }
}
