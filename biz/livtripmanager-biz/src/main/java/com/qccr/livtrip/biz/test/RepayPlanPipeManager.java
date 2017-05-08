package com.qccr.livtrip.biz.test;

import com.qccr.livtrip.biz.test.pipe.*;
import org.apache.commons.collections.CollectionUtils;
import org.testng.collections.Lists;

import java.util.List;

/**
 * Created by xierongli on 17/5/8.
 */
public class RepayPlanPipeManager {

    private static StrikeBlancePipe commissionPipe;
    private static StrikeBlancePipe interestPipe;
    private static StrikeBlancePipe penaltyPipe;
    private static StrikeBlancePipe principalPipe;

    private static List<StrikeBlancePipe> strikeBlancePipeList = Lists.newArrayList();

    static {
        penaltyPipe = new PenaltyPipe();
        commissionPipe = new CommissionPipe();
        interestPipe = new InterestPipe();
        principalPipe = new PrincipalPipe();
        strikeBlancePipeList.add(penaltyPipe);
        strikeBlancePipeList.add(commissionPipe);
        strikeBlancePipeList.add(interestPipe);
        strikeBlancePipeList.add(principalPipe);
    }

    public static RepayContext doPipe(RepayContext repayPlanContext){

        if(CollectionUtils.isNotEmpty(strikeBlancePipeList)){
            for(StrikeBlancePipe strikeBlancePipe : strikeBlancePipeList){
                repayPlanContext = strikeBlancePipe.doWork(repayPlanContext);
            }
        }

        return repayPlanContext;
    }



}
