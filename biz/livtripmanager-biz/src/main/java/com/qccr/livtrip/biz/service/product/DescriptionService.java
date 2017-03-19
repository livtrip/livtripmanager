package com.qccr.livtrip.biz.service.product;

import com.qccr.livtrip.model.product.Description;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:DescriptionService.java v 0.1 2016年12月21日 17:07 xierongli
 */
public interface DescriptionService {

    int insert(Description description);

    int update(Integer id);

    int delete(Integer id);

    Description queryForObject(Integer id);

    List<Description> queryForList(Integer productId);
}
