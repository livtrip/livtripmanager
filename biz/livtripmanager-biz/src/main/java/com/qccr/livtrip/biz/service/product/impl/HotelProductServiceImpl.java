package com.qccr.livtrip.biz.service.product.impl;

import com.google.common.eventbus.Subscribe;
import com.qccr.livtrip.biz.event.DataEvent;
import com.qccr.livtrip.biz.service.product.HotelProductService;
import com.qccr.livtrip.common.webservice.hotel.TWSHotelDetailsV3;
import com.qccr.livtrip.dal.product.HotelProductDao;
import com.qccr.livtrip.model.product.HotelProduct;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xierongli
 * @version $Id:HotelProductServiceImpl.java v 0.1 2016年12月17日 11:21 xierongli
 */
@Service("hotelProductService")
public class HotelProductServiceImpl implements HotelProductService {

    protected static final Logger logger	= LoggerFactory.getLogger(HotelProductServiceImpl.class);

    @Autowired
    private HotelProductDao hotelProductDao;

    @Override
    public int insert(HotelProduct hotelProduct) {
        return hotelProductDao.insert(hotelProduct);
    }

    @Override
    public int updateFlagByHotelIds(List<Integer> hotelIds) {
        return hotelProductDao.updateFlagByHotelIds(hotelIds);
    }

    /**
     * @return
     * @name 查询flag 未采集 前100条数据
     * @author xierongli
     * @date 2016/12/27 18:41
     */
    @Override
    public List<HotelProduct> queryFiftyHotelProductList() {
        return hotelProductDao.queryFiftyHotelProductList();
    }

    @Override
    public HotelProduct queryByHoteId(Integer hotelId) {
        return hotelProductDao.queryByHoteId(hotelId);
    }

    /**
     * 
     * @name  采集酒店产品数据
     * @param dataEvent
     * @return  
     * @author xierongli
     * @date 2016/12/20 9:37
     */
    @Subscribe
    public void fetchHotelProduct(DataEvent dataEvent){
        try{
            //去重
            if(dataEvent.getProductId() != null){
                Integer count = hotelProductDao.queryHotelByProductId(dataEvent.getProductId());
                if(count >= 1){
                    return;
                }
            }
            TWSHotelDetailsV3.Hotel hotelDetail = dataEvent.getHotelDetail();
            HotelProduct hotelProduct = new HotelProduct();
            hotelProduct.setProductId(dataEvent.getProductId());
            hotelProduct.setStartLevel(hotelDetail.getStarLevel());
            hotelProduct.setHotelId(hotelDetail.getHotelID());
            hotelProduct.setProvider(hotelDetail.getProvider()==null?"":hotelDetail.getProvider());
            hotelProduct.setCheckInTime(hotelDetail.getCheckInTime()==null?"":hotelDetail.getCheckInTime().toString());
            hotelProduct.setCheckOutTime(hotelDetail.getCheckOutTime()==null?"":hotelDetail.getCheckOutTime().toString());
            hotelProduct.setHotelFax(hotelDetail.getHotelFax()==null?"":hotelDetail.getHotelFax());
            hotelProduct.setHotelPhone(hotelDetail.getHotelPhone()==null?"":hotelDetail.getHotelPhone());
            hotelProduct.setRanking(hotelDetail.getRanking()==null?"":hotelDetail.getRanking().toString());
            hotelProduct.setRooms(hotelDetail.getRooms()==null?0:hotelDetail.getRooms());
            String description = hotelDetail.getDescriptions().get(0).getLongDescription().get(0).getFreeTextLongDescription();
            hotelProduct.setDescription(StringUtils.isNoneBlank(description)?description: "");
            insert(hotelProduct);
        }catch (Exception e){
            logger.error("HotelProduct酒店采集异常",e.getMessage());
        }

    }

}
