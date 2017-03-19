package com.qccr.livtrip.biz.service.product.impl;

import com.google.common.eventbus.Subscribe;
import com.qccr.livtrip.biz.event.DataEvent;
import com.qccr.livtrip.biz.service.product.LocationService;
import com.qccr.livtrip.common.webservice.hotel.TWSHotelDetailsV3;
import com.qccr.livtrip.dal.product.LocationDao;
import com.qccr.livtrip.model.product.Localtion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xierongli
 * @version $Id:LocationServiceImpl.java v 0.1 2016年12月18日 10:27 xierongli
 */
@Service("locationService")
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDao locationDao;

    @Override
    public int insert(Localtion localtion) {
        return locationDao.insert(localtion);
    }

    @Override
    public int delete(Integer id) {
        if(id == null){ return 0;}
        return locationDao.delete(id);
    }

    @Override
    public int update(Localtion localtion) {
        if(localtion == null){return 0;}
        return locationDao.update(localtion);
    }

    @Override
    public Localtion queryForObject(Integer productId) {
        if(productId == null){return null;}
        return locationDao.queryForObject(productId);
    }

    /**
     * 
     * @name  采集地理信息
     * @param dataEvent
     * @return  
     * @author xierongli
     * @date 2016/12/20 9:39
     */
    @Subscribe
    public void fetchLocation(DataEvent dataEvent){
        System.out.println("==========location==========");
        TWSHotelDetailsV3.Hotel hotelDetail = dataEvent.getHotelDetail();
        Integer productId = dataEvent.getProductId();
        Localtion localtion = new Localtion();
        localtion.setHotelId(hotelDetail.getHotelID());
        localtion.setProductId(productId);

        localtion.setCountry(hotelDetail.getLocation().get(0).getCountry());
        localtion.setState(hotelDetail.getLocation().get(0).getState());
        localtion.setCity(hotelDetail.getLocation().get(0).getCity());
        localtion.setDestinationCode(hotelDetail.getLocation().get(0).getDestinationCode());
        localtion.setDestinationId(hotelDetail.getLocation().get(0).getDestinationId());
        localtion.setAddress(hotelDetail.getLocation().get(0).getAddress());
        localtion.setLatitude(hotelDetail.getLocation().get(0).getLatitude().toString());
        localtion.setLongitude(hotelDetail.getLocation().get(0).getLongitude().toString());

        System.out.println("latitude:" + localtion.getLatitude() +" longitude:" + localtion.getLongitude());
        localtion.setSearchCity(hotelDetail.getLocation().get(0).getSearchingCity());
        localtion.setZip(hotelDetail.getLocation().get(0).getZip());
        insert(localtion);
    }
}
