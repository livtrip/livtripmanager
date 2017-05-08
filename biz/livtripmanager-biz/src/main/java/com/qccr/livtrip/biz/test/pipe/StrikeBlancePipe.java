package com.qccr.livtrip.biz.test.pipe;

import com.qccr.livtrip.biz.test.RepayContext;

/**
 *  冲账接口
 * Created by xierongli on 17/5/8.
 */
public interface StrikeBlancePipe {

     RepayContext doWork(RepayContext repayPlanContext);
}
