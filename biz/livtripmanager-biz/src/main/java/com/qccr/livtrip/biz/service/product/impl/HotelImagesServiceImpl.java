package com.qccr.livtrip.biz.service.product.impl;

import com.google.common.eventbus.Subscribe;
import com.qccr.livtrip.biz.event.DataEvent;
import com.qccr.livtrip.biz.service.product.HotelImagesService;
import com.qccr.livtrip.common.webservice.hotel.TWSHotelDetailsV3;
import com.qccr.livtrip.dal.product.HotelImagesDao;
import com.qccr.livtrip.model.product.HotelImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:HotelImagesServiceImpl.java v 0.1 2016年12月18日 11:06 xierongli
 */
@Service("hotelImagesService")
public class HotelImagesServiceImpl implements HotelImagesService {

    @Autowired
    private HotelImagesDao hotelImagesDao;
    @Override
    public int insert(HotelImages hotelImages) {
        return hotelImagesDao.insert(hotelImages);
    }

    @Override
    public int update(Integer id) {
        if(id == null){return 0;}
        return hotelImagesDao.update(id);
    }


    @Override
    public HotelImages queryForObject(Integer id) {
        if(id == null){ return null;}
        return hotelImagesDao.queryForObject(id);
    }

    @Override
    public List<HotelImages> queryForList(Integer productId) {
        if(productId == null){return null;}
        return hotelImagesDao.queryForList(productId);
    }

    /**
     * 
     * @name  采集图片
     * @param
     * @return  
     * @author xierongli
     * @date 2016/12/20 9:41
     */
    @Subscribe
    public void fetchHotelImages(DataEvent dataEvent){
        TWSHotelDetailsV3.Hotel hotelDetail = dataEvent.getHotelDetail();
        Integer productId = dataEvent.getProductId();
        List<TWSHotelDetailsV3.Hotel.Media.Images.Image> images = hotelDetail.getMedia().get(0).getImages().get(0).getImage();
        for(TWSHotelDetailsV3.Hotel.Media.Images.Image image : images){
            HotelImages hotelImages = new HotelImages();
            hotelImages.setHotelId(hotelDetail.getHotelID());
            hotelImages.setProductId(productId);
            hotelImages.setType(image.getType());
            hotelImages.setPath(image.getPath());
            insert(hotelImages);
        }
    }
}
