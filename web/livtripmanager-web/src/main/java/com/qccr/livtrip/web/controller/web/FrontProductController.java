package com.qccr.livtrip.web.controller.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.google.common.cache.Cache;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qccr.livtrip.biz.service.product.DescriptionService;
import com.qccr.livtrip.biz.service.product.HotelImagesService;
import com.qccr.livtrip.biz.service.product.ProductService;
import com.qccr.livtrip.common.cache.Keys;
import com.qccr.livtrip.common.cache.LoadingCache;
import com.qccr.livtrip.common.converters.ObjectConvert;
import com.qccr.livtrip.common.processor.HotelProcessor;
import com.qccr.livtrip.common.util.date.DateStyle;
import com.qccr.livtrip.common.util.date.DateUtil;
import com.qccr.livtrip.common.webservice.hotel.*;
import com.qccr.livtrip.model.product.Description;
import com.qccr.livtrip.model.product.HotelImages;
import com.qccr.livtrip.model.product.HotelProduct;
import com.qccr.livtrip.model.product.HotelProductRo;
import com.qccr.livtrip.web.model.ProductQuery;
import com.qccr.livtrip.web.vo.product.HotelDescriptionVO;
import com.qccr.livtrip.web.vo.product.HotelDetailVO;
import com.qccr.livtrip.web.vo.product.HotelImageVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 前台产品
 * @author xierongli
 * @version $Id:ProductController.java v 0.1 2016年12月16日 17:43 xierongli
 */
@Controller
@RequestMapping("/front/product")
public class FrontProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private HotelImagesService hotelImagesService;
    @Autowired
    private DescriptionService descriptionService;

    private static Map<String, Integer> cityNameIdMap = null;
    private static Map<Integer, String> cityIdNameMap = null;
    static {
        cityNameIdMap = Maps.newHashMap();
        cityNameIdMap.put("New York,NY", 7263);
        cityNameIdMap.put("Washington,DC", 949);

        cityIdNameMap = Maps.newHashMap();
        cityIdNameMap.put(7263,"New York,NY");
        cityIdNameMap.put(949,"Washington,DC");
    }

    @RequestMapping("/list")
    public String list(ProductQuery productQuery, ModelMap modelMap){
        try{
            System.out.println(productQuery.getPageNumber()+ "destinationId:" +
                    productQuery.getDestination() + "num:" + productQuery.getPeopleNum());
            String checkIn = StringUtils.isBlank(productQuery.getCheckIn())? defaultCheckIn() : productQuery.getCheckIn();
            String checkOut = StringUtils.isBlank(productQuery.getCheckOut())? defaultCheckOut() : productQuery.getCheckOut();
            //TODO 城市名称转ID
            List<Integer> destinationIds = Lists.newArrayList();
            Integer destinationId =cityNameIdMap.get(productQuery.getDestination()) == null?7263:cityNameIdMap.get(productQuery.getDestination());
            destinationIds.add(destinationId);

            //赋值productQuery
            productQuery.setCheckIn(checkIn);
            productQuery.setCheckOut(checkOut);

            //实时获取酒店数据
            List<Hotel> hotelList = HotelProcessor.SearchHotelsByDestinationIds(destinationIds,checkIn,checkOut, getArrayOfRoomInfoByNum(Integer.parseInt(productQuery.getPeopleNum())));

            List<Integer> hotelIdList = Lists.newArrayList();
            Map<Integer, List<RoomType>> roomTypeMap = Maps.newHashMap();
            if(CollectionUtils.isNotEmpty(hotelList)){
                roomTypeMap = getRoomTypeMap(hotelList);
                for(Hotel hotel : hotelList){
                    hotelIdList.add(hotel.getHotelId());
                }
            }
            if(CollectionUtils.isEmpty(hotelIdList)){
                return "/front/product/no_product";
            }
            //查询酒店数据
            PageInfo<HotelProductRo> pageInfo = productService.pageQueryHotelProduct(productQuery.getPageNumber(),productQuery.getPageSize(), hotelIdList);
            if(pageInfo.getTotal() == 0){
                return "/front/product/no_product";
            }
            for(HotelProductRo  hotelProductRo : pageInfo.getList()){
                hotelProductRo.setRoomTypeList(roomTypeMap.get(hotelProductRo.getHotelId()));
                Collections.sort(hotelProductRo.getRoomTypeList(),(m1,m2)->m1.getOccupancies().getOccupancy().get(0).getAvrNightPrice().compareTo(m2.getOccupancies().getOccupancy().get(0).getAvrNightPrice()));
                hotelProductRo.setMinAvgNightPrice(hotelProductRo.getRoomTypeList().get(0).getOccupancies().getOccupancy().get(0).getAvrNightPrice());
            }

            modelMap.put("page", pageInfo);
            modelMap.put("destination", destinationId==null?7263:destinationId);
            modelMap.put("destinationName", StringUtils.isBlank(productQuery.getDestination())?"New York,NY":productQuery.getDestination());
            modelMap.put("checkIn", productQuery.getCheckIn());
            modelMap.put("checkOut", productQuery.getCheckOut());
            modelMap.put("peopleNum", productQuery.getPeopleNum());
            StringBuilder pids = new StringBuilder();
            for(HotelProductRo hotelProductRo : pageInfo.getList()){
                hotelProductRo.setStarLevelText(productService.getProductStarLevel(hotelProductRo.getStartLevel().toString()));
                pids.append(hotelProductRo.getId()).append(",");
            }
            modelMap.put("pids", pids.toString());
            System.out.println(JSON.toJSONString(pageInfo));
        }catch (Exception e){
            return "/front/product/no_product";
        }
        return "/front/product/list";
    }

    public Map<Integer, List<RoomType>> getRoomTypeMap(List<Hotel> hotels){
        Map<Integer, List<RoomType>> map = Maps.newHashMap();
        if(CollectionUtils.isNotEmpty(hotels)){
            for(Hotel hotel : hotels){
                map.put(hotel.getHotelId(), hotel.getRoomTypes().getRoomType());
            }
        }
        return map;
    }

    @RequestMapping("/detail")
    public String getHotelDetail(ProductQuery productQuery, ModelMap modelMap){
        HotelProductRo hotelProductRo = productService.getHotelProductById(productQuery.getProductId());
        if(hotelProductRo == null){
            return "/front/product/no_product";
        }
        //实时查询房型数据
        List<Integer> destinationIds = Lists.newArrayList();
        Integer destination = Integer.valueOf(productQuery.getDestination()==null?"7263":productQuery.getDestination());
        destinationIds.add(destination);
        List<Hotel> hotelList = HotelProcessor.SearchHotelsByDestinationIds(destinationIds,productQuery.getCheckIn(),productQuery.getCheckOut(),
                getArrayOfRoomInfoByNum(Integer.parseInt(productQuery.getPeopleNum())));
        List<RoomType> roomTypeList = null;

        if(CollectionUtils.isNotEmpty(hotelList)){
            Map<Integer, List<RoomType>> roomTypeMap = getRoomTypeMap(hotelList);
            roomTypeList = roomTypeMap.get(hotelProductRo.getHotelId());
        }
        Collections.sort(roomTypeList,(m1,m2)->m1.getOccupancies().getOccupancy().get(0).getAvrNightPrice().compareTo(m2.getOccupancies().getOccupancy().get(0).getAvrNightPrice()));

        HotelDetailVO hotelDetailVO = ObjectConvert.convertObject(hotelProductRo, HotelDetailVO.class);
        List<HotelImages> hotelImagesList = hotelImagesService.queryForList(productQuery.getProductId());
        hotelDetailVO.setHotelImageVOList(ObjectConvert.convertList(hotelImagesList, HotelImageVO.class));

        List<Description> descriptions = descriptionService.queryForList(productQuery.getProductId());
        hotelDetailVO.setHotelDescriptionVOList(ObjectConvert.convertList(descriptions, HotelDescriptionVO.class));
        hotelDetailVO.setRoomTypeList(roomTypeList);
        hotelDetailVO.setMinAvgNightPrice(roomTypeList.get(0).getOccupancies().getOccupancy().get(0).getAvrNightPrice());
        hotelDetailVO.setCityName(cityIdNameMap.get(destination));
        modelMap.put("hotelDetail", hotelDetailVO);
        return "/front/product/detail";
    }

    @RequestMapping("getCity")
    @ResponseBody
    public String getCity(){
        List<String> cityList = Lists.newArrayList();
        cityList.add("New York,NY");
        cityList.add("Washington,DC");
        Map map = Maps.newHashMap();
        map.put("suggestions", cityList);
        return JSON.toJSONString(map);
    }


    public String defaultCheckIn(){
        return DateUtil.DateToString(DateUtil.addDay(DateUtil.getCurrentDate(),1), DateStyle.YYYY_MM_DD);
    }

    public String defaultCheckOut(){
        return  DateUtil.DateToString(DateUtil.addDay(DateUtil.getCurrentDate(),2), DateStyle.YYYY_MM_DD);
    }
    public static ArrayOfRoomInfo getArrayOfRoomInfoByNum(Integer peopleNum){
        ArrayOfRoomInfo arrayOfRoomInfo = new ArrayOfRoomInfo();
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setAdultNum(peopleNum);
        roomInfo.setChildNum(0);
        ArrayOfChildAge age = new ArrayOfChildAge();
        roomInfo.setChildAges(age);
        arrayOfRoomInfo.getRoomInfo().add(roomInfo);
        return  arrayOfRoomInfo;
    }
}
