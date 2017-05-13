package com.qccr.livtrip.web.task;


import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.event.HotelEventBus;
import com.qccr.livtrip.biz.service.destination.DestService;
import com.qccr.livtrip.common.util.ApplicationUtil;
import com.qccr.livtrip.model.destination.Dest;
import com.qccr.livtrip.model.request.CityQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 产品采集任务
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/16 15:07 Exp $$
 */
public class ProductCollectionTask extends Task{

    private final static Logger logger = LoggerFactory.getLogger(ProductCollectionTask.class);


    private HotelEventBus hotelEventBus;


    private DestService destService;

    public void init(){
        hotelEventBus = (HotelEventBus) ApplicationUtil.getBean("hotelEventBus");
        destService = (DestService) ApplicationUtil.getBean("destService");
       }

    @Override
    public void execute(Map map) {
        logger.info("产品采集任务开始");
        init();
       //分页获取destinationIds
        CityQuery cityQuery = new CityQuery();
        cityQuery.setPageNumber(1);
        cityQuery.setPageSize(20);
        PageInfo<Dest> destinationPageInfoPage = destService.pageQueryList(1,20);
        Integer totalPage = destinationPageInfoPage.getPages();
        for(int i=1; i<totalPage+1; i++){
            PageInfo<Dest> destinationPageInfo = destService.pageQueryList(i,20);
            //根据destinationId, checkIn, checkOut 查询最新的酒店数据
            for(Dest destination : destinationPageInfo.getList()){
                logger.info("开始采集［{}］的酒店",destination.getCityName());
                hotelEventBus.productFetchTask(destination.getDestinationId());
            }
        }
    }


}
