package com.qccr.livtrip.biz.service.product;

import com.qccr.livtrip.model.product.Localtion;

/**
 * 地理信息业务层
 * @author xierongli
 * @version $Id:LocationService.java v 0.1 2016年12月18日 10:27 xierongli
 */
public interface LocationService {

    int insert(Localtion localtion);

    int delete(Integer id);

    int update(Localtion localtion);

    Localtion queryForObject(Integer productId);
}
