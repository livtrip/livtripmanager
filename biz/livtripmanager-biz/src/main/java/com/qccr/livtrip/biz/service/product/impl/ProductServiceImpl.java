package com.qccr.livtrip.biz.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.enums.StartLevelTypeEnum;
import com.qccr.livtrip.biz.service.product.ProductService;
import com.qccr.livtrip.dal.product.*;
import com.qccr.livtrip.model.product.HotelProductRo;
import com.qccr.livtrip.model.product.Product;
import com.qccr.livtrip.model.request.HotelProductQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品业务层
 * @author xierongli
 * @version $Id:ProductServiceImpl.java v 0.1 2016年12月16日 17:37 xierongli
 */
@Service("productServcie")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private AmenityDao amenityDao;
    @Autowired
    private DescriptionDao descriptionDao;
    @Autowired
    private HotelImagesDao hotelImagesDao;
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private RefPointDao refPointDao;


    @Override
    public Integer insertAndGetId(Product product) {
        productDao.insertAndGetId(product);
        return product.getId();
    }

    /**
     * @name 分页查询产品
     * @param pageNum
     * @param pageSize @return
     * @author xierongli
     * @date 2016/12/17 12:47
     */
    @Override
    public PageInfo<Product> pageQueryProduct(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<Product> productList = productDao.queryProduct();
        for(Product product : productList){
            product.setThumb(product.getThumb().replace("100x100", "200x200"));
        }
        return new PageInfo<>(productList);
    }

    /**
     * @param pageNum
     * @param pageSize @return
     * @name
     * @author xierongli
     * @date 2016/12/28 16:28
     */
    @Override
    public PageInfo<HotelProductRo> pageQueryHotelProduct(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<HotelProductRo> hotelProductRos = productDao.queryHotelProduct();
        for(HotelProductRo product : hotelProductRos){
            product.setThumb(product.getThumb().replace("100x100", "200x200"));
        }
        return new PageInfo<>(hotelProductRos);
    }

    /**
     * @param starLevel 星级
     * @return
     * @name 获取产品星级
     * @author xierongli
     * @date 2017/1/9 19:50
     */
    @Override
    public String getProductStarLevel(String starLevel) {
        if(StringUtils.isEmpty(starLevel)){ return "";}
        StringBuilder sb  = new StringBuilder();
        if(starLevel.contains(".")){
            Integer num = Integer.parseInt(starLevel.split("\\.")[0]);
            for(int i=0;i<num; i++){
                sb.append(StartLevelTypeEnum.FULL_STAR.getValue());
            }
            sb.append(StartLevelTypeEnum.HALF_STAR.getValue());
        }else{
            Integer num = Integer.parseInt(starLevel);
            for(int i=0;i<num; i++){
                sb.append(StartLevelTypeEnum.FULL_STAR.getValue());
            }
        }
        return sb.toString();
    }

    @Override
    public HotelProductRo getHotelProductById(Integer productId) {
        if(productId != null){
            HotelProductRo hotelProduct = productDao.getHotelProductById(productId);
            hotelProduct.setThumb(hotelProduct.getThumb().replace("100x100", "200x200"));
            return hotelProduct;
        }
        return null;
    }

    @Override
    public PageInfo<HotelProductRo> pageQueryHotelProduct(Integer pageNum, Integer pageSize, List<Integer> hotelIds) {
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<HotelProductRo> hotelProductRos = productDao.queryProductByHotelIds(hotelIds);
        for(HotelProductRo product : hotelProductRos){
            product.setThumb(product.getThumb().replace("100x100", "200x200"));
        }
        return new PageInfo<>(hotelProductRos);
    }

    @Override
    public PageInfo<HotelProductRo> pageQueryHotelProductForAdmin(Integer pageNum, Integer pageSize, HotelProductQuery hotelProductQuery) {
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<HotelProductRo> hotelProductRos = productDao.queryHotelProductByReq(hotelProductQuery);
        for(HotelProductRo product : hotelProductRos){
            product.setThumb(product.getThumb().replace("100x100", "200x200"));
        }
        return new PageInfo<>(hotelProductRos);
    }

    public void deleteProduct(String productId) {
        productDao.deleteProduct(productId);
        amenityDao.deleteByPid(productId);
        descriptionDao.deleteByPid(productId);
        hotelImagesDao.deleteByPid(productId);
        locationDao.deleteByPid(productId);
        refPointDao.deleteByPid(productId);
    }

}
