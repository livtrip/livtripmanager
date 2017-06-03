package com.qccr.livtrip.web.controller.web;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.qccr.livtrip.common.converters.ObjectConvert;
import com.qccr.livtrip.common.processor.HotelProcessor;
import com.qccr.livtrip.common.util.date.DateStyle;
import com.qccr.livtrip.common.util.date.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

   @RequestMapping("main")
   public String main(){
        return "main";
   }


}
