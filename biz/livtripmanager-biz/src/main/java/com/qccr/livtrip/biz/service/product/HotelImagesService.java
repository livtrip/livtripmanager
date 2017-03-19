package com.qccr.livtrip.biz.service.product;

import com.qccr.livtrip.model.product.HotelImages;

import java.util.List;

/**
 * 酒店图片
 * @author xierongli
 * @version $Id:HotelImagesService.java v 0.1 2016年12月18日 11:06 xierongli
 */
public interface HotelImagesService {

    int insert(HotelImages hotelImages);

    int update(Integer id);


    HotelImages queryForObject(Integer id);

    List<HotelImages> queryForList(Integer productId);

}
