package com.qccr.livtrip.biz.service.product;

import com.qccr.livtrip.model.product.Amenity;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:AmenityService.java v 0.1 2016年12月20日 19:38 xierongli
 */
public interface AmenityService {

    int insert(Amenity amenity);

    List<Amenity> queryForList(Integer productId);

    int update(Amenity amenity);

    Amenity queryForObject(Integer id);

}
