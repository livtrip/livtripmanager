package com.qccr.livtrip.biz.service.test;

import com.qccr.livtrip.common.test.AverageCapitalPlusInterestUtils;
import com.qccr.livtrip.common.util.date.DateUtil;
import com.qccr.livtrip.dal.test.RepayInfoDao;
import com.qccr.livtrip.dal.test.RepayPlanDao;
import com.qccr.livtrip.model.test.RepayInfo;
import com.qccr.livtrip.model.test.RepayPlan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.testng.collections.Lists;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("repayInfoService")
public class RepayInfoService{
    private final static BigDecimal COMMISSION_CHARGE = new BigDecimal(10);
    @Resource
    private RepayInfoDao repayInfoDao;
    @Resource
    private RepayPlanDao repayPlanDao;
    @Resource
    protected TransactionTemplate transactionTemplate;


    public int insert(RepayInfo pojo){
        return repayInfoDao.insert(pojo);
    }

    public int insertSelective(RepayInfo pojo){
        return repayInfoDao.insertSelective(pojo);
    }

    public int insertList(List<RepayInfo> pojos){
        return repayInfoDao.insertList(pojos);
    }

    public int update(RepayInfo pojo){
        return repayInfoDao.update(pojo);
    }

    public List<RepayInfo> queryForList(){
        return repayInfoDao.queryForList();
    }

    public RepayInfo getById(Integer id){
        return  repayInfoDao.getById(id);
    }

    public void updateRepayPlan(final RepayInfo repayInfo, RepayPlan repayPlan){
        transactionTemplate.execute(new TransactionCallback<Void>(){
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try{
                  update(repayInfo);
                    repayPlanDao.update(repayPlan);
                }catch (Exception e){
                    System.out.println("insert talbe error" +e);
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });
    }

    public void buildRepayPlanTest(Double invest,String yearRate,Integer term){
        transactionTemplate.execute(new TransactionCallback<Void>(){
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try{
                    RepayInfo repayInfo = buildeRepayInfo(invest,yearRate,term);
                    repayInfoDao.insert(repayInfo);
                    List<RepayPlan> repayPlans = buildRepayPlan(repayInfo.getId(),invest,yearRate,term);
                    repayPlanDao.insertList(repayPlans);
                }catch (Exception e){
                    System.out.println("insert talbe error" +e);
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });

    }


    public RepayInfo buildeRepayInfo(Double invest,String yearRateStr,Integer term){

        RepayInfo repayInfo = new RepayInfo();
        repayInfo.setUid(666);
        repayInfo.setCurrentPeriod(1);
        repayInfo.setCommissionCharge(COMMISSION_CHARGE.multiply(new BigDecimal(term)));
        repayInfo.setOverdueAmount(new BigDecimal(0));
        repayInfo.setOverduePeriods(0);
        repayInfo.setStatus(0);
        repayInfo.setRepayDay(15);
        repayInfo.setTerm(term);

        repayInfo.setPrincipal(new BigDecimal(invest));
        repayInfo.setYearRate(new BigDecimal(yearRateStr).multiply(new BigDecimal(10)));
        double yearRate = new BigDecimal(yearRateStr).divide(new BigDecimal(100)).doubleValue();
        System.out.println("年化利率："+ yearRate);
        //计算利息
        BigDecimal totalInterest = new BigDecimal(AverageCapitalPlusInterestUtils.getInterestCount(invest,yearRate,term));
        repayInfo.setInterest(totalInterest);
        // 计算应还金额（本＋息 + 手续费）
        BigDecimal amount = new BigDecimal(invest).add(totalInterest).add(COMMISSION_CHARGE.multiply(new BigDecimal(term)));
        repayInfo.setAmount(amount);
        repayInfo.setRestAmount(amount);

        //计算本期应还(本＋利息＋手续费)
        //每月应还本金
        Map<Integer, BigDecimal> mapPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(invest, yearRate, term);
        //每月应还利息
        Map<Integer, BigDecimal> mapInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(invest, yearRate, term);
        BigDecimal thisPeriodAmount = mapPrincipal.get(1).add(mapInterest.get(1)).add(COMMISSION_CHARGE);
        repayInfo.setThisPeriodAmount(thisPeriodAmount);

        return repayInfo;
    }

    public List<RepayPlan> buildRepayPlan(Integer repayInfoId, Double invest,String yearRateStr,Integer term){
        double yearRate = new BigDecimal(yearRateStr).divide(new BigDecimal(100)).doubleValue();
        System.out.println("年化利率："+ yearRate);

        List<RepayPlan> repayPlans = Lists.newArrayList();
        //每月应还本金
        Map<Integer, BigDecimal> mapPrincipal = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(invest, yearRate, term);
        //每月应还利息
        Map<Integer, BigDecimal> mapInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(invest, yearRate, term);
        for(int i=1; i<term+1; i++){
            RepayPlan repayPlan = new RepayPlan();
            repayPlan.setRepayInfoId(repayInfoId);
            repayPlan.setUid(666);
            repayPlan.setPrincipal(mapPrincipal.get(i));
            repayPlan.setInterest(mapInterest.get(i));
            repayPlan.setRepayDate(getRepayDate(i));
            repayPlan.setPeriodNumber(i);

            repayPlan.setStatus(0);
            //手续费
            repayPlan.setCommissionCharge(COMMISSION_CHARGE);

            //应还金额
            BigDecimal amount = mapPrincipal.get(i).add(mapInterest.get(i)).add(COMMISSION_CHARGE);
            repayPlan.setAmount(amount);
            repayPlan.setRestAmount(amount);

            //剩余
            repayPlan.setRestPrincipal(mapPrincipal.get(i));
            repayPlan.setRestInterest(mapInterest.get(i));
            repayPlan.setRestCommissionCharge(COMMISSION_CHARGE);
            repayPlans.add(repayPlan);
        }

        return repayPlans;
    }

    public Date getRepayDate(int term){
        return term == 1? DateUtil.StringToDate("2017-05-15"):DateUtil.addDay(DateUtil.StringToDate("2017-05-15"), term *30);
    }
}
