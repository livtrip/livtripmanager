package com.qccr.livtrip.biz.service.product.impl;

import com.google.common.eventbus.Subscribe;
import com.qccr.livtrip.biz.event.DataEvent;
import com.qccr.livtrip.biz.service.product.DescriptionService;
import com.qccr.livtrip.model.webservice.hotel.TWSHotelDetailsV3;
import com.qccr.livtrip.dal.product.DescriptionDao;
import com.qccr.livtrip.model.product.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:DescriptionServiceImpl.java v 0.1 2016年12月21日 17:07 xierongli
 */
@Service("descriptionService")
public class DescriptionServiceImpl implements DescriptionService {

    @Autowired
    private DescriptionDao descriptionDao;

    @Override
    public int insert(Description description) {
        return descriptionDao.insert(description);
    }

    @Override
    public int update(Integer id) {
        if(id == null){ return 0;}
        return descriptionDao.update(id);
    }

    @Override
    public int delete(Integer id) {
        if(id == null){return 0;}
        return descriptionDao.delete(id);
    }

    @Override
    public Description queryForObject(Integer id) {
        if(id == null){return null;}
        return descriptionDao.queryForObject(id);
    }

    @Override
    public List<Description> queryForList(Integer productId) {
        if(productId == null){ return null;}
        return descriptionDao.queryForList(productId);
    }

    @Subscribe
    public void fetchDescription(DataEvent dataEvent){
        System.out.print("========description======");
        TWSHotelDetailsV3.Hotel hotelDetail = dataEvent.getHotelDetail();
        Integer hotelId = hotelDetail.getHotelID();
        Integer productId = dataEvent.getProductId();
        List<TWSHotelDetailsV3.Hotel.Descriptions> descriptionses =  hotelDetail.getDescriptions();

        if(!CollectionUtils.isEmpty(descriptionses)){
            TWSHotelDetailsV3.Hotel.Descriptions descriptions = descriptionses.get(0);
            List<TWSHotelDetailsV3.Hotel.Descriptions.LongDescription> longDescriptions = descriptions.getLongDescription();
            if(!CollectionUtils.isEmpty(longDescriptions)){
                List<TWSHotelDetailsV3.Hotel.Descriptions.LongDescription.Description> descriptionList = longDescriptions.get(0).getDescription();

                for(TWSHotelDetailsV3.Hotel.Descriptions.LongDescription.Description description : descriptionList){
                    Description descriptionModel = new Description();
                    descriptionModel.setProductId(productId);
                    descriptionModel.setHotelId(hotelId);
                    descriptionModel.setCategory(description.getCategory());
                    descriptionModel.setValue(description.getValue());
                    insert(descriptionModel);
                }
            }



        }

    }


}
