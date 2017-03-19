package com.qccr.livtrip.biz.service.product;

import com.qccr.livtrip.model.product.RefPoint;

import java.util.List;

/**
 * 关联地理位置
 * @author xierongli
 * @version $Id:RefPointService.java v 0.1 2016年12月21日 14:00 xierongli
 */
public interface RefPointService {

    int insert(RefPoint refPoint);

    List<RefPoint> queryForList(Integer productId);

    int delete( Integer id);

    int update(RefPoint refPoint);

    RefPoint queryForObject( Integer id);
}
