package com.qccr.livtrip.web.controller.backend;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.qccr.livtrip.biz.handler.HotelHandler;
import com.qccr.livtrip.biz.service.product.ProductService;
import com.qccr.livtrip.model.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String list(ModelMap modelMap){
        PageInfo<HotelProductRo> pageInfo = productService.pageQueryHotelProduct(1,20);
        modelMap.put("page", pageInfo);
        System.out.println(JSON.toJSONString(pageInfo));
        return "/backend/product/list";
    }
     

}
