package com.qccr.livtrip.dal.product;

import com.qccr.livtrip.model.product.HotelProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 酒店产品
 * @author xierongli
 * @version $Id:HotelProductDao.java v 0.1 2016年12月17日 10:54 xierongli
 */
public interface HotelProductDao {

    /**
     *
     * @name 新增酒店数据
     * @param hotelProduct
     * @return
     * @author xierongli
     * @date 2016/12/17 11:12
     */
    int insert(HotelProduct hotelProduct);

    /**
     * 
     * @name  更改酒店采集状态
     * @param  hotelIds
     * @return  成功 1 失败 0
     * @author xierongli
     * @date 2016/12/27 18:34
     */
    int updateFlagByHotelIds(@Param("hotelIds") List<Integer> hotelIds);

    /**
     * 
     * @name   查询flag 未采集 前50条数据
     * @param
     * @return  
     * @author xierongli
     * @date 2016/12/27 18:42
     */
    List<HotelProduct> queryFiftyHotelProductList();

    /**
     *
     * @name 根据产品Id 查询酒店
     * @param  productId
     * @return  数量
     * @author xierongli
     * @date 2017/2/24 15:42
     *
     */
    Integer queryHotelByProductId(@Param("productId") Integer productId);

    Integer deleteByPid(@Param("productId") String productId);
}
