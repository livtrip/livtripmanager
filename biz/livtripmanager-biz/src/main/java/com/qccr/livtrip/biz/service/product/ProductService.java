package com.qccr.livtrip.biz.service.product;

import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.common.webservice.hotel.RoomType;
import com.qccr.livtrip.model.product.HotelProductRo;
import com.qccr.livtrip.model.product.Product;

import java.util.List;
import java.util.Map;

/**
 * 产品业务层
 * @author xierongli
 * @version $Id:ProductService.java v 0.1 2016年12月16日 17:37 xierongli
 */
public interface ProductService {

    Integer insertAndGetId(Product product);

    /**
     * 
     * @name  分页查询产品
     * @param
     * @return  
     * @author xierongli
     * @date 2016/12/17 12:47
     */
    PageInfo<Product> pageQueryProduct(Integer pageNum,Integer pageSize);

    /**
     * 
     * @name  分页查询酒店产品
     * @param pageNum 页码
     * @param pageSize 页数
     * @return  
     * @author xierongli
     * @date 2016/12/28 16:28
     */
    PageInfo<HotelProductRo> pageQueryHotelProduct(Integer pageNum,Integer pageSize);

    /**
     * 
     * @name  获取产品星级
     * @param  starLevel 星级
     * @return   返回星级的html 拼装数据
     * @author xierongli
     * @date 2017/1/9 19:50
     */
    String getProductStarLevel(String starLevel);

    /**
     * 
     * @name  根据productId 查询产品详情
     * @param productId
     * @return 酒店产品详情VO
     * @author xierongli
     * @date 2017/2/18 17:26 
     * 
     */
    
    HotelProductRo getHotelProductById(Integer productId);

    /**
     *
     * @name  分页查询酒店产品
     * @param pageNum 页码
     * @param pageSize 页数
     * @param hotelIds 酒店Ids
     * @return
     * @author xierongli
     * @date 2016/12/28 16:28
     */
    PageInfo<HotelProductRo> pageQueryHotelProduct(Integer pageNum,Integer pageSize, List<Integer> hotelIds);
}
