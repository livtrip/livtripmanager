package com.qccr.livtrip.web.task;

import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageInfo;
import com.google.common.eventbus.EventBus;
import com.qccr.livtrip.biz.event.DataEvent;
import com.qccr.livtrip.biz.service.destination.CityService;
import com.qccr.livtrip.biz.service.destination.DestService;
import com.qccr.livtrip.biz.service.product.*;
import com.qccr.livtrip.common.processor.HotelProcessor;
import com.qccr.livtrip.common.util.ApplicationUtil;
import com.qccr.livtrip.common.util.Money;
import com.qccr.livtrip.common.webservice.hotel.Hotel;
import com.qccr.livtrip.common.webservice.hotel.TWSHotelDetailsV3;
import com.qccr.livtrip.model.destination.Dest;
import com.qccr.livtrip.model.product.HotelProduct;
import com.qccr.livtrip.model.product.Product;
import com.qccr.livtrip.model.request.CityQuery;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 产品采集任务
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/16 15:07 Exp $$
 */
public class ProductCollectionTask extends Task{

    public EventBus eventBus = new EventBus();
    private CityService cityService;
    private HotelProductService hotelProductService;
    private ProductService productService;
    private LocationService locationService;
    private AmenityService amenityService;
    private HotelImagesService hotelImagesService;
    private RefPointService refPointService;
    private DescriptionService descriptionService;

    private DestService destService;

    public void init(){
        cityService = (CityService) ApplicationUtil.getBean("cityService");
        hotelProductService = (HotelProductService)ApplicationUtil.getBean("hotelProductService");
        productService = (ProductService) ApplicationUtil.getBean("productService");
        locationService = (LocationService)ApplicationUtil.getBean("locationService");
        destService = (DestService)ApplicationUtil.getBean("destService");
        amenityService = (AmenityService)ApplicationUtil.getBean("amenityService");
        hotelImagesService = (HotelImagesService)ApplicationUtil.getBean("hotelImagesService");
        refPointService = (RefPointService)ApplicationUtil.getBean("refPointService");
        descriptionService = (DescriptionService)ApplicationUtil.getBean("descriptionService");
    }

    @Override
    public void execute(Map map) {
        System.out.println("产品采集任务开始");
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
                List<Integer> destinationIds = Lists.newArrayList();
                destinationIds.add(destination.getDestinationId());
                List<Hotel> hotels = HotelProcessor.SearchHotelsByDestinationIds(destinationIds);
                if(CollectionUtils.isNotEmpty(hotels)) {
                    for(Hotel hotel : hotels){
                        //排除已经存在的productId
                        HotelProduct  hotelProduct = hotelProductService.queryByHoteId(hotel.getHotelId());
                        if(hotelProduct == null){
                            //产品product 数据落地
                            Integer primaryKey = productService.insertAndGetId(buildProduct(hotel));
                            //hotel,location数据落地
                            List<Integer> hotelIds = com.google.common.collect.Lists.newArrayList();
                            hotelIds.add(hotel.getHotelId());
                            List<TWSHotelDetailsV3.Hotel> hotelList = HotelProcessor.getHotelDetailsV3(hotelIds);
                            final TWSHotelDetailsV3.Hotel hotelDetail =hotelList.get(0);
                            if(hotelDetail!= null && primaryKey != null){
                                System.out.println("hotel date begin....");
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
    }

    public Product buildProduct(Hotel hotel){
        Product product = new Product();
        product.setName(hotel.getName());
        product.setCurrency(hotel.getCurrency());
        product.setBrandName(hotel.getBrandName());
        product.setType(1);

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
