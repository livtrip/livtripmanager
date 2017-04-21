package com.qccr.livtrip.web.controller.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qccr.livtrip.biz.service.product.DescriptionService;
import com.qccr.livtrip.biz.service.product.HotelImagesService;
import com.qccr.livtrip.biz.service.product.ProductService;
import com.qccr.livtrip.common.converters.ObjectConvert;
import com.qccr.livtrip.common.processor.HotelProcessor;
import com.qccr.livtrip.common.util.date.DateStyle;
import com.qccr.livtrip.common.util.date.DateUtil;
import com.qccr.livtrip.common.webservice.hotel.*;
import com.qccr.livtrip.model.product.Description;
import com.qccr.livtrip.model.product.HotelImages;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 前台产品
 * @author xierongli
 * @version $Id:ProductController.java v 0.1 2016年12月16日 17:43 xierongli
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
      return "index";
   }


}
