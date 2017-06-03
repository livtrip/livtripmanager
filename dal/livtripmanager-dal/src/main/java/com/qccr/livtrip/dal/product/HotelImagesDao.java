package com.qccr.livtrip.dal.product;

import com.qccr.livtrip.model.product.HotelImages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:HotelImagesDao.java v 0.1 2016年12月18日 11:03 xierongli
 */
public interface HotelImagesDao {

    /**
     *
     * @name  插入酒店图片
     * @param  hotelImages
     * @return
     * @author xierongli
     * @date 2016/12/18 11:06
     */
    int insert(HotelImages hotelImages);

    int update(@Param("id") Integer id);

    List<HotelImages> queryForList(@Param("productId") Integer productId);

    HotelImages queryForObject(@Param("id") Integer id);

    Integer deleteByPid(@Param("productId") String productId);
}
