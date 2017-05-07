package com.qccr.livtrip.web.controller.backend;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.qccr.livtrip.biz.handler.HotelHandler;
import com.qccr.livtrip.biz.service.destination.DestService;
import com.qccr.livtrip.biz.service.product.DescriptionService;
import com.qccr.livtrip.biz.service.product.HotelImagesService;
import com.qccr.livtrip.biz.service.product.ProductService;
import com.qccr.livtrip.common.constant.Constant;
import com.qccr.livtrip.common.converters.ObjectConvert;
import com.qccr.livtrip.common.processor.HotelProcessor;
import com.qccr.livtrip.common.util.Money;
import com.qccr.livtrip.common.webservice.hotel.Hotel;
import com.qccr.livtrip.common.webservice.hotel.RoomType;
import com.qccr.livtrip.model.product.*;
import com.qccr.livtrip.model.request.HotelProductQuery;
import com.qccr.livtrip.web.controller.BaseController;
import com.qccr.livtrip.web.vo.product.HotelDescriptionVO;
import com.qccr.livtrip.web.vo.product.HotelDetailVO;
import com.qccr.livtrip.web.vo.product.HotelImageVO;
import com.qccr.livtrip.web.vo.product.HotelRoomTypeVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author xierongli
 * @version $Id:ProductController.java v 0.1 2016年12月16日 17:42 xierongli
 */
@Controller
@RequestMapping("/backend/product")
public class ProductController extends BaseController{

    @Autowired
    private ProductService productService;

    @Autowired
    private HotelHandler hotelHandler;
    @Autowired
    private HotelImagesService hotelImagesService;
    @Autowired
    private DescriptionService descriptionService;
    @Autowired
    private DestService destService;

    @RequestMapping("/add")
    public String fetchProducts(@RequestParam  Integer destinationId){
        System.out.println("add product..." + destinationId);
        List<Integer> destinationIds = Lists.newArrayList();
        destinationIds.add(destinationId);//7263 new york 7693
        hotelHandler.fetchProductDateByDestinationId(destinationIds);
        hotelHandler.fetchHotelExtData();
        logger.info("酒店数据采集完成, 参数destinationId:[{}]", destinationId);
        return "/success";
    }

    @RequestMapping("/list")
    public String list(HotelProductQuery hotelProductQuery, ModelMap modelMap){
        System.out.println("params:" + JSON.toJSONString(hotelProductQuery));
        PageInfo<HotelProductRo> pageInfo = productService.pageQueryHotelProductForAdmin(hotelProductQuery.getPageNumber(),hotelProductQuery.getPageSize(),hotelProductQuery);
        modelMap.put("page", pageInfo);
        modelMap.put("name",hotelProductQuery.getName());
        modelMap.put("city",hotelProductQuery.getCity());
        modelMap.put("hotelId",hotelProductQuery.getHotelId());
        modelMap.put("isBest",hotelProductQuery.getIsBest());
        modelMap.put("starLevel",hotelProductQuery.getStarLevel());
        System.out.println(JSON.toJSONString(pageInfo));
        return "/backend/product/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String productId){
        System.out.println(productId);
        productService.deleteProduct(productId);
        return "redirect:list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam  String productId, ModelMap modelMap){
        //查询酒店基础信息
        HotelProductRo hotelProductRo = productService.getHotelProductById(Integer.parseInt(productId.trim()));
        HotelDetailVO hotelDetailVO = ObjectConvert.convertObject(hotelProductRo, HotelDetailVO.class);
        //酒店图片
        List<HotelImages> hotelImagesList = hotelImagesService.queryForList(Integer.parseInt(productId.trim()));
        hotelDetailVO.setHotelImageVOList(ObjectConvert.convertList(hotelImagesList, HotelImageVO.class));
        //酒店描述
        List<Description> descriptions = descriptionService.queryForList(Integer.parseInt(productId.trim()));
        hotelDetailVO.setHotelDescriptionVOList(ObjectConvert.convertList(descriptions, HotelDescriptionVO.class));

        //酒店房型数据
        List<Integer> hotelIds = Lists.newArrayList();
        hotelIds.add(hotelProductRo.getHotelId());

        List<Hotel> hotels = HotelProcessor.searchHotelsById(hotelIds);
        if(CollectionUtils.isNotEmpty(hotels)){

            List<RoomType> roomTypeList = hotels.get(0).getRoomTypes().getRoomType();
            //房型价格排序
            Collections.sort(roomTypeList,(m1, m2)->m1.getOccupancies().getOccupancy().get(0).getAvrNightPrice().compareTo(m2.getOccupancies().getOccupancy().get(0).getAvrNightPrice()));

            List<HotelRoomTypeVO> hotelRoomTypeVOS =Lists.newArrayList();
            for(RoomType roomType : roomTypeList){
                HotelRoomTypeVO hotelRoomTypeVO = new HotelRoomTypeVO();
                hotelRoomTypeVO.setName(roomType.getName());
                hotelRoomTypeVO.setCommission(Constant.COMMISSION);
                hotelRoomTypeVO.setNights(roomType.getNights());
                hotelRoomTypeVO.setCheckIn(HotelProcessor.defaultCheckIn());
                hotelRoomTypeVO.setCheckOut(HotelProcessor.defaultCheckOut());
                //每晚均价，总价（总价）
                Double avgNightPrice = roomType.getOccupancies().getOccupancy().get(0).getAvrNightPrice().doubleValue();
                hotelRoomTypeVO.setOriginalPrice(avgNightPrice);
                Money originalMoney = Money.ofYuan(avgNightPrice);
                Money totalPrice = originalMoney.multipliedBy(new Double(roomType.getNights()));
                hotelRoomTypeVO.setTotalOriginalPrice(totalPrice.getYuan());

                //每晚均价,总价（销售价）
                Money saleAvgNightPrice = originalMoney.multipliedBy(1+Constant.COMMISSION);
                Money totalSalePrice = saleAvgNightPrice.multipliedBy(new Double(roomType.getNights()));
                hotelRoomTypeVO.setSaleAvgPrice(saleAvgNightPrice.getYuan());
                hotelRoomTypeVO.setTotalSalePrice(totalSalePrice.getYuan());

                double profit = new BigDecimal(hotelRoomTypeVO.getTotalSalePrice()).subtract(new BigDecimal(hotelRoomTypeVO.getTotalOriginalPrice())).doubleValue();
                hotelRoomTypeVO.setProfit(profit);
                hotelRoomTypeVOS.add(hotelRoomTypeVO);
                hotelRoomTypeVO = null;

            }
            hotelDetailVO.setHotelRoomTypeVOS(hotelRoomTypeVOS);
        }
        System.out.println(JSON.toJSONString(hotelDetailVO));
        modelMap.put("product", hotelDetailVO);
        return "/backend/product/edit";
    }








     

}
