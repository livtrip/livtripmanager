package com.qccr.livtrip.dal.product;

import com.qccr.livtrip.model.product.HotelProductRo;
import com.qccr.livtrip.model.product.Product;
import com.qccr.livtrip.model.request.HotelProductQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:ProductDao.java v 0.1 2016年12月16日 17:17 xierongli
 */
public interface ProductDao {
    /**
     * 
     * @name  新增产品
     * @param product
     * @return  
     * @author xierongli
     * @date 2016/12/16 17:35
     */
    int insertAndGetId(Product product);
    /**
     *
     * @name  查询产品
     * @param
     * @return
     * @author xierongli
     * @date 2016/12/17 12:48
     */
    List<Product> queryProduct();

    /**
     *
     * @name  查询酒店产品
     * @return
     * @author xierongli
     * @date 2016/12/28 16:28
     */
    List<HotelProductRo> queryHotelProduct();

    /**
     * 
     * @name  根据productId 查询产品详情数据
     * @param productId
     * @return HotelProduct
     * @author xierongli
     * @date 2017/2/18 17:22 
     * 
     */
    
    HotelProductRo getHotelProductById(Integer productId);

    /**
     * 
     * @name 根据酒店Ids查询酒店数据
     * @param  hotelIds 酒店Ids 集合
     * @return 酒店组合数据集合
     * @author xierongli
     * @date 2017/2/22 14:11 
     */
    List<HotelProductRo> queryProductByHotelIds(@Param("hotelIds") List<Integer> hotelIds);

    /**
     *
     * @name  根据产品查询产品数量
     * @param  id 产品主键Id
     * @return
     * @author xierongli
     * @date 2017/2/24 15:36
     */
    Integer queryProductCount(Integer id);

    /**
     * 根据参数查询酒店信息
     * @param  hotelProductQuery
     * @return  
     * @author xierongli
     * @date 2017/3/26 10:04 
     */
    List<HotelProductRo> queryHotelProductByReq(HotelProductQuery hotelProductQuery);

    int deleteProduct(@Param("productId") String productId);
}
