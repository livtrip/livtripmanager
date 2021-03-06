package com.qccr.livtrip.biz.event;


import com.google.common.eventbus.EventBus;
import com.qccr.livtrip.biz.service.destination.DestService;
import com.qccr.livtrip.biz.service.product.*;
import com.qccr.livtrip.common.processor.HotelProcessor;
import com.qccr.livtrip.common.util.Money;
import com.qccr.livtrip.common.webservice.hotel.Hotel;
import com.qccr.livtrip.common.webservice.hotel.TWSHotelDetailsV3;
import com.qccr.livtrip.model.product.HotelProduct;
import com.qccr.livtrip.model.product.Product;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.collections.Lists;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by xierongli on 17/5/11.
 */
@Component
public class HotelEventBus {
    private final static Logger logger = LoggerFactory.getLogger(HotelEventBus.class);
    public EventBus eventBus = EventBusFactory.getIstance();


    @Autowired
    private ProductService productService;
    @Autowired
    private HotelProductService hotelProductService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private AmenityService amenityService;

    @Autowired
    private HotelImagesService hotelImagesService;

    @Autowired
    private RefPointService refPointService;

    @Autowired
    private DescriptionService descriptionService;

    private DestService destService;


   /**
    *  产品采集任务
    * @param  destinationId 城市ID
    * @return
    * @author xierongli
    * @date 17/5/13 下午3:25
    */
    public void productFetchTask(Integer destinationId){
        if(destinationId == null){return;}
        List<Integer> destinationIds = Lists.newArrayList();
        destinationIds.add(destinationId);

        List<Hotel> hotels = HotelProcessor.SearchHotelsByDestinationIds(destinationIds);
        if(CollectionUtils.isNotEmpty(hotels)) {
            for(Hotel hotel : hotels){
                //排除已经存在的productId
                HotelProduct hotelProduct = hotelProductService.queryByHoteId(hotel.getHotelId());
                if(hotelProduct == null){
                    //产品product 数据落地
                    Product product = productService.queryByHotelId(hotel.getHotelId());
                    if(product == null){
                        //hotel,location数据落地
                        List<Integer> hotelIds = Lists.newArrayList();
                        hotelIds.add(hotel.getHotelId());
                        List<TWSHotelDetailsV3.Hotel> hotelList = HotelProcessor.getHotelDetailsV3(hotelIds);
                        final TWSHotelDetailsV3.Hotel hotelDetail =hotelList.get(0);
                        if(hotelDetail!= null){
                            logger.info("产品去重，HotelId[{}]",hotel.getHotelId());
                            Integer primaryKey = productService.insertAndGetId(buildProduct(hotel));
                            logger.info("hotel pick up begin,productId[{}]", primaryKey);
                            eventBus.register(hotelProductService);
                            eventBus.register(locationService);
                            eventBus.post(new DataEvent(primaryKey,hotelDetail,hotel));
                            fetchProductExt(primaryKey, hotelDetail,hotel);
                        }
                    }

                }
            }
        }


    }

    public void fetchProductExt(Integer productId, TWSHotelDetailsV3.Hotel hotelDetail, Hotel hotel){

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                eventBus.register(hotelImagesService);
                eventBus.register(amenityService);
                eventBus.register(refPointService);
                eventBus.register(descriptionService);
                eventBus.post(new DataEvent(productId, hotelDetail, hotel));
            }
        });
        executorService.shutdown();
    }

    public Product buildProduct(Hotel hotel){
        Product product = new Product();
        product.setName(hotel.getName());
        product.setCurrency(hotel.getCurrency());
        product.setBrandName(hotel.getBrandName());
        product.setType(1);
        product.setHotelId(hotel.getHotelId());
        product.setIsBest(hotel.isBestValue()?1:0);

        product.setClearPrice(Money.convertYuanToCent(hotel.getMinAverPrice().doubleValue()).intValue());
        product.setIsBest(hotel.isBestValue()? 1:0);
        product.setKeywords(hotel.getDesc());
        product.setThumb(hotel.getThumb());
        product.setSalePrice(Money.convertYuanToCent(hotel.getMinAverPrice().doubleValue()).intValue());
        product.setVendor("tourico");
        product.setLabel(hotel.getCategory());
        return product;
    }








}
