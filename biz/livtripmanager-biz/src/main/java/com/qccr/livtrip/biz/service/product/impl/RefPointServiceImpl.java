package com.qccr.livtrip.biz.service.product.impl;

import com.google.common.eventbus.Subscribe;
import com.qccr.livtrip.biz.event.DataEvent;
import com.qccr.livtrip.biz.service.product.RefPointService;
import com.qccr.livtrip.common.webservice.hotel.TWSHotelDetailsV3;
import com.qccr.livtrip.dal.product.RefPointDao;
import com.qccr.livtrip.model.product.RefPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 *
 * @author xierongli
 * @version $Id:RefPointServiceImpl.java v 0.1 2016年12月21日 14:00 xierongli
 */
@Service("refPointService")
public class RefPointServiceImpl implements RefPointService {

    @Autowired
    RefPointDao refPointDao;

    @Override
    public int insert(RefPoint refPoint) {
        return refPointDao.insert(refPoint);
    }

    @Override
    public List<RefPoint> queryForList(Integer productId) {
        return refPointDao.queryForList(productId);
    }

    @Override
    public int delete(Integer id) {
        return refPointDao.delete(id);
    }

    @Override
    public int update(RefPoint refPoint) {
        return refPointDao.update(refPoint);
    }

    @Override
    public RefPoint queryForObject(Integer id) {
        return refPointDao.queryForObject(id);
    }

    @Subscribe
    public void fetchRefPoint(DataEvent dataEvent){
        System.out.print("========refPoint======");
        TWSHotelDetailsV3.Hotel hotelDetail = dataEvent.getHotelDetail();
        Integer hotelId = hotelDetail.getHotelID();
        Integer productId = dataEvent.getProductId();

        List<TWSHotelDetailsV3.Hotel.RefPoints> refPointses =  hotelDetail.getRefPoints();
        if(!CollectionUtils.isEmpty(refPointses)){
            for(TWSHotelDetailsV3.Hotel.RefPoints refPoints : refPointses){
                RefPoint refPoint = new RefPoint();
                refPoint.setName(refPoints.getName());
                refPoint.setType(refPoints.getType());
                refPoint.setTypeId(refPoints.getTypeId());
                refPoint.setAirportCode(refPoints.getAirportCode());
                refPoint.setDirection(refPoints.getDirection());
                refPoint.setUnit(refPoints.getUnit());
                refPoint.setHotelId(hotelId);
                refPoint.setProductId(productId);
                refPoint.setDistance(refPoints.getDistance().toString());
                insert(refPoint);
            }
        }

    }
}
