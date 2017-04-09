package com.qccr.livtrip.biz.service.destination;

import com.qccr.livtrip.model.destination.CityLocation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/9 16:49 Exp $$
 */
public interface CityLocationService {

    int insertList(List<CityLocation> pojo);
}
