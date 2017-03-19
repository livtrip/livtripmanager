package com.qccr.livtrip.biz.service.product;

import com.qccr.livtrip.model.product.HotelProduct;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:HotelProductService.java v 0.1 2016年12月17日 11:21 xierongli
 */
public interface HotelProductService {

    int insert(HotelProduct hotelProduct);

    int updateFlagByHotelIds(List<Integer> hotelIds);

    /**
     *
     * @name 查询flag 未采集 前50条数据
     * @return
     * @author xierongli
     * @date 2016/12/27 18:41
     */
    List<HotelProduct> queryFiftyHotelProductList();

}
