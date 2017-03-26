package com.qccr.livtrip.dal.product;

import com.qccr.livtrip.model.product.Localtion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地理位置
 * @author xierongli
 * @version $Id:LocationDao.java v 0.1 2016年12月22日 14:21 xierongli
 */
public interface LocationDao {

    int insert(Localtion localtion);

    int delete(@Param("id") Integer id);

    int update(Localtion localtion);

    Localtion queryForObject(@Param("productId") Integer productId);

    Integer deleteByPid(@Param("productId") String productId);
}
