package com.qccr.livtrip.web.task;

import java.util.Map;

/**
 * 产品采集任务
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/16 15:07 Exp $$
 */
public class ProductCollectionTask extends Task{


    @Override
    public void execute(Map map) {
        System.out.println("产品采集任务开始");
        //分页获取destinationIds

        //根据destinationId, checkIn, checkOut 查询最新的酒店数据

        //排除已经存在的productId

        //不在排除范围之内, 将数据落库

    }
}
