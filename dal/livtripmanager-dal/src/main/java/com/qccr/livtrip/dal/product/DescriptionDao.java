package com.qccr.livtrip.dal.product;

import com.qccr.livtrip.model.product.Description;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述
 * @author xierongli
 * @version $Id:DescriptionDao.java v 0.1 2016年12月21日 17:03 xierongli
 */
public interface DescriptionDao {

  int insert(Description description);

  List<Description> queryForList(@Param("productId") Integer productId);

  int update(@Param("id") Integer id);

  int delete(@Param("id") Integer id);

  Description queryForObject(@Param("id") Integer id);

}
