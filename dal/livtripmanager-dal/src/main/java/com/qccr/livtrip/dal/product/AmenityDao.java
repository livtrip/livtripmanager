package com.qccr.livtrip.dal.product;

import com.qccr.livtrip.model.product.Amenity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:AmenityDao.java v 0.1 2016年12月20日 19:35 xierongli
 */
public interface AmenityDao {

    int insert(Amenity amenity);

    List<Amenity> queryForList(@Param("productId") Integer productId);

    int delete(@Param("id") Integer id);

    int update(Amenity amenity);

    Amenity queryForObject(@Param("id") Integer id);

    Integer deleteByPid(@Param("productId") String productId);

}
