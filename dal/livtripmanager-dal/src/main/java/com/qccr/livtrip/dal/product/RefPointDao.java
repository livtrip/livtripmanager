package com.qccr.livtrip.dal.product;

import com.qccr.livtrip.model.product.RefPoint;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:RefPointDao.java v 0.1 2016年12月21日 13:50 xierongli
 */
public interface RefPointDao {

    int insert(RefPoint refPoint);

    List<RefPoint> queryForList(@Param("productId") Integer productId);

    int delete(@Param("id") Integer id);

    int update(RefPoint refPoint);

    RefPoint queryForObject(@Param("id") Integer id);

    Integer deleteByPid(@Param("productId") String productId);
}
