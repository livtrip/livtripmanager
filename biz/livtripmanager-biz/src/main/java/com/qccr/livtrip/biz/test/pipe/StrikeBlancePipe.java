package com.qccr.livtrip.biz.test.pipe;

import com.qccr.livtrip.biz.test.RepayContext;

import java.math.BigDecimal;

/**
 *  冲账接口
 * Created by xierongli on 17/5/8.
 */
public interface StrikeBlancePipe {
     public static final BigDecimal ZERO = new BigDecimal(0);
;
     RepayContext doWork(RepayContext repayPlanContext);
}
