package com.qccr.livtrip.common.test;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/27 17:33 Exp $$
 */
public class Test {

    public static void main(String[] args) {
        Double principal = 10000.0;
        Double yearRate  = 0.12;
        Integer month = 12;
        System.out.println(AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterest(principal,yearRate,month));
    }
}
