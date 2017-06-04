package com.qccr.livtrip.biz.service.product.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.enums.StartLevelTypeEnum;
import com.qccr.livtrip.biz.service.product.ProductService;
import com.qccr.livtrip.dal.product.*;
import com.qccr.livtrip.model.dto.HotelProductDTO;
import com.qccr.livtrip.model.product.Product;
import com.qccr.livtrip.model.request.HotelProductQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品业务层
 * @author xierongli
 * @version $Id:ProductServiceImpl.java v 0.1 2016年12月16日 17:37 xierongli
 */
@Service("productService")
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
    public PageInfo<HotelProductDTO> pageQueryHotelProduct(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<HotelProductDTO> HotelProductDTOs = productDao.queryHotelProduct();
        for(HotelProductDTO product : HotelProductDTOs){
            product.setThumb(product.getThumb().replace("100x100", "200x200"));
        }
        return new PageInfo<>(HotelProductDTOs);
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
    public HotelProductDTO getHotelProductById(Integer productId) {
        if(productId != null){
            HotelProductDTO hotelProduct = productDao.getHotelProductById(productId);
            if(StringUtils.isNoneBlank(hotelProduct.getThumb())){
                hotelProduct.setThumb(hotelProduct.getThumb().replace("100x100", "200x200"));
            }
             return hotelProduct;
        }
        return null;
    }

    @Override
    public PageInfo<HotelProductDTO> pageQueryHotelProduct(Integer pageNum, Integer pageSize, List<Integer> hotelIds) {
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<HotelProductDTO> HotelProductDTOs = productDao.queryProductByHotelIds(hotelIds);
        for(HotelProductDTO product : HotelProductDTOs){
            product.setThumb(product.getThumb().replace("100x100", "200x200"));
        }
        return new PageInfo<>(HotelProductDTOs);
    }

    @Override
    public PageInfo<HotelProductDTO> pageQueryHotelProductForAdmin(Integer pageNum, Integer pageSize, HotelProductQuery hotelProductQuery) {
        PageHelper.startPage(pageNum,pageSize,true,false);
        List<HotelProductDTO> HotelProductDTOs = productDao.queryHotelProductByReq(hotelProductQuery);
        for(HotelProductDTO product : HotelProductDTOs){
            product.setThumb(product.getThumb().replace("100x100", "200x200"));
        }
        return new PageInfo<>(HotelProductDTOs);
    }

    public void deleteProduct(String productId) {
        productDao.deleteProduct(productId);
        amenityDao.deleteByPid(productId);
        descriptionDao.deleteByPid(productId);
        hotelImagesDao.deleteByPid(productId);
        locationDao.deleteByPid(productId);
        refPointDao.deleteByPid(productId);
    }

    @Override
    public Product queryByHotelId(Integer hotelId) {
        return productDao.queryByHotelId(hotelId);
    }

}
