package com.qccr.livtrip.web.controller.backend;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.qccr.livtrip.biz.handler.HotelHandler;
import com.qccr.livtrip.biz.service.product.DescriptionService;
import com.qccr.livtrip.biz.service.product.HotelImagesService;
import com.qccr.livtrip.biz.service.product.ProductService;
import com.qccr.livtrip.common.converters.ObjectConvert;
import com.qccr.livtrip.model.product.*;
import com.qccr.livtrip.model.request.HotelProductQuery;
import com.qccr.livtrip.web.vo.product.HotelDescriptionVO;
import com.qccr.livtrip.web.vo.product.HotelDetailVO;
import com.qccr.livtrip.web.vo.product.HotelImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author xierongli
 * @version $Id:ProductController.java v 0.1 2016年12月16日 17:42 xierongli
 */
@Controller
@RequestMapping("/backend/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HotelHandler hotelHandler;
    @Autowired
    private HotelImagesService hotelImagesService;
    @Autowired
    private DescriptionService descriptionService;

    @RequestMapping("/add")
    public String fetchProducts(@RequestParam  Integer productId){
        System.out.println("add product..." + productId);
        List<Integer> destinationIds = Lists.newArrayList();
        destinationIds.add(productId);//7263 new york 7693
        hotelHandler.fetchProductDateByDestinationId(destinationIds);
        hotelHandler.fetchHotelExtData();
        return "/member/success";
    }

    @RequestMapping("/list")
    public String list(HotelProductQuery hotelProductQuery, ModelMap modelMap){
        PageInfo<HotelProductRo> pageInfo = productService.pageQueryHotelProductForAdmin(1,20,hotelProductQuery);
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
        System.out.println(JSON.toJSONString(hotelDetailVO));
        modelMap.put("product", hotelDetailVO);
        return "/backend/product/edit";
    }






     

}
