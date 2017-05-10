package com.qccr.livtrip.biz.test.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by xierongli on 17/5/10.
 */
public class RepayUtil {

    //计算罚息
    public static BigDecimal calculatePenaltyInterest(BigDecimal principal, BigDecimal yearRate, int delayDays){
        return principal.multiply(new BigDecimal(delayDays)).multiply(yearRate).divide(new BigDecimal(1000)).divide(new BigDecimal(365),2, RoundingMode.HALF_UP).multiply(new BigDecimal(2));
    }
}
