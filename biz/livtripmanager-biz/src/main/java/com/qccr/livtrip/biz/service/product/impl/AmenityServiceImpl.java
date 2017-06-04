package com.qccr.livtrip.biz.service.product.impl;

import com.google.common.eventbus.Subscribe;
import com.qccr.livtrip.biz.event.DataEvent;
import com.qccr.livtrip.biz.service.product.AmenityService;
import com.qccr.livtrip.common.webservice.hotel.TWSHotelDetailsV3;
import com.qccr.livtrip.dal.product.AmenityDao;
import com.qccr.livtrip.model.product.Amenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:AmenityServiceImpl.java v 0.1 2016年12月20日 19:38 xierongli
 */
@Service("amenityService")
public class AmenityServiceImpl implements AmenityService {

    @Autowired
    private AmenityDao amenityDao;
    @Override
    public int insert(Amenity amenity) {
        return amenityDao.insert(amenity);
    }

    @Override
    public List<Amenity> queryForList(Integer productId) {
        if(productId == null){return null;}
        return amenityDao.queryForList(productId);
    }

    @Override
    public int update(Amenity amenity) {
        if(amenity == null){return 0;}

        return amenityDao.update(amenity);
    }

    @Override
    public Amenity queryForObject(Integer id) {
        if(id == null){ return null;}
        return amenityDao.queryForObject(id);
    }

    @Subscribe
    public void fetchAmenity(DataEvent dataEvent){
        System.out.print("========Amenity======");
        TWSHotelDetailsV3.Hotel hotelDetail = dataEvent.getHotelDetail();
        List<TWSHotelDetailsV3.Hotel.Amenities.Amenity> amenities =  hotelDetail.getAmenities().get(0).getAmenity();
        Integer hotelId = hotelDetail.getHotelID();
        Integer productId = dataEvent.getProductId();

        if(!CollectionUtils.isEmpty(amenities)){
            for(TWSHotelDetailsV3.Hotel.Amenities.Amenity amenity : amenities){
                Amenity amenityModel = new Amenity();
                amenityModel.setHotelId(hotelId);
                amenityModel.setProductId(productId);
                amenityModel.setAmenityId(amenity.getAmenityID());
                amenityModel.setName(amenity.getName());
                insert(amenityModel);
            }
        }
    }


}
