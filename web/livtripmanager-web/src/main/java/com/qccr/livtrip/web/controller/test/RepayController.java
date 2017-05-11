package com.qccr.livtrip.web.controller.test;

import com.qccr.livtrip.biz.service.test.RepayInfoService;
import com.qccr.livtrip.biz.service.test.RepayPlanService;
import com.qccr.livtrip.biz.test.RepayContext;
import com.qccr.livtrip.biz.test.RepayPlanPipeManager;
import com.qccr.livtrip.biz.test.util.RepayUtil;
import com.qccr.livtrip.common.util.date.DateUtil;
import com.qccr.livtrip.model.test.RepayInfo;
import com.qccr.livtrip.model.test.RepayPlan;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by xierongli on 17/5/9.
 */
@Controller
@RequestMapping("/repay")
public class RepayController {

    @Resource
    private RepayInfoService repayInfoService;
    @Autowired
    private RepayPlanService repayPlanService;

    @RequestMapping("gotoRepayInfo")
    public String gotoRepayInfo(ModelMap modelMap){
        System.out.println("goto repayInfo...");
        List<RepayInfo> repayInfoList = repayInfoService.queryForList();
        for(RepayInfo repayInfo : repayInfoList){
            repayInfo.setYearRate(repayInfo.getYearRate().divide(new BigDecimal(10)));
        }

        modelMap.put("repayInfoList", repayInfoList);
        return "/test/repay_info";
    }

    @RequestMapping("addRepayPlan")
    public String  addRepayPlan(String amount, String yearRate,Integer term,String commissionCharge){
        System.out.println(amount + yearRate + term);
        if(StringUtils.isNoneBlank(amount) && StringUtils.isNoneBlank(yearRate)){
            Double invest = Double.parseDouble(amount);
            term = term == null?12:term;
            //生成还款计划
            repayInfoService.buildRepayPlanTest(invest,yearRate,term,new BigDecimal(commissionCharge));
        }
        return "redirect:gotoRepayInfo";
    }

    @RequestMapping("gotoRepayPlan")
    public String gotoRepayPlan(@RequestParam  Integer repayInfoId, ModelMap modelMap){
        System.out.println("还款计划"+repayInfoId);
        List<RepayPlan> repayPlans = repayPlanService.queryForList(repayInfoId);
        modelMap.put("repayPlans",repayPlans);
        modelMap.put("repayInfoId",repayInfoId);
        return "/test/repay_plan";
    }

    @RequestMapping("stripe")
    public String stripeBlance(@RequestParam Integer repayInfoId, @RequestParam Double amount,
                               @RequestParam String periodsNum,String repayDate,Integer ignorePenalty){
        RepayInfo repayInfo = repayInfoService.getById(repayInfoId);
        if(repayInfo != null && StringUtils.isNoneBlank(periodsNum)){
            String[] periodsNumbers = periodsNum.split(",");
            for(String periodNumber : periodsNumbers){
                RepayPlan repayPlan = repayPlanService.getByRepayInfoIdAndPeriodNum(repayInfoId,Integer.parseInt(periodNumber));
                RepayContext repayContext = new RepayContext();
                repayContext.setAmount(new BigDecimal(amount));
                repayContext.setRepayDate(DateUtil.StringToDate(repayDate));
                repayContext.setRepayInfo(repayInfo);
                repayContext.setRepayPlan(repayPlan);
                repayContext.setIgnorePenalty(ignorePenalty);
                RepayPlanPipeManager.doPipe(repayContext);
                //判断剩余本金
                if(repayContext.getRepayInfo().getRestAmount().equals(new BigDecimal(0))){
                    repayContext.getRepayInfo().setStatus(2);
                }else{
                    repayContext.getRepayInfo().setStatus(1);
                }
                System.out.println("本期剩余金额："+repayContext.getRepayPlan().getRestAmount().doubleValue());
                if(repayContext.getRepayPlan().getRestAmount().compareTo(BigDecimal.ZERO) == 0){
                    repayContext.getRepayPlan().setStatus(2);
                }else if(repayContext.getRepayPlan().getRestAmount().compareTo(BigDecimal.ZERO) >0){
                    repayContext.getRepayPlan().setStatus(1);
                }
                repayInfoService.updateRepayPlan(repayContext.getRepayInfo(), repayContext.getRepayPlan());

            }
        }

        return "redirect:gotoRepayPlan.do?repayInfoId="+repayInfoId;
    }

    @RequestMapping("generatePenalty")
    public String generateReplayPlanPenaltyInterest(@RequestParam Integer repayInfoId, @RequestParam Integer period, @RequestParam Integer delayDays){
        RepayInfo repayInfo = repayInfoService.getById(repayInfoId);
        RepayPlan repayPlan = repayPlanService.getByRepayInfoIdAndPeriodNum(repayInfoId,period);
        if(repayPlan != null && repayInfo != null){
            //还款计划表更新
            BigDecimal penaltyInterest = RepayUtil.calculatePenaltyInterest(repayPlan.getPrincipal(),repayInfo.getYearRate(),delayDays);
            repayPlan.setAmount(repayPlan.getAmount().add(penaltyInterest));
            repayPlan.setPenaltyInterestAmount(repayPlan.getPenaltyInterestAmount()==null?penaltyInterest:repayPlan.getPenaltyInterestAmount().add(penaltyInterest));
            repayPlan.setRestAmount(repayPlan.getRestAmount().add(penaltyInterest));
            repayPlan.setRestPenaltyInterestAmount(penaltyInterest);
            //还款详情表更新
            repayInfo.setOverdueAmount(repayInfo.getOverdueAmount()==null?penaltyInterest:repayInfo.getOverdueAmount().add(penaltyInterest));
            repayInfo.setOverduePeriods(repayInfo.getOverduePeriods()==null?period.toString():repayInfo.getOverduePeriods()+","+period);
            repayInfoService.updateRepayPlan(repayInfo,repayPlan);
        }

        return "redirect:gotoRepayPlan.do?repayInfoId="+repayInfoId;
    }





}
