package com.qccr.livtrip.web.controller.backend;

import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.event.HotelEventBus;
import com.qccr.livtrip.biz.service.destination.DestService;
import com.qccr.livtrip.common.constant.Constant;
import com.qccr.livtrip.model.destination.Dest;
import com.qccr.livtrip.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xierongli on 17/5/14.
 */
@Controller
@RequestMapping("/backend/dest")
public class DestController extends BaseController{

    @Autowired
    private DestService destService;
    @Autowired
    private HotelEventBus hotelEventBus;


    @RequestMapping("list")
    public String list(String cityName,String state,Integer destinationId,
                       Integer pageNum, Integer pageSize,ModelMap modelMap){
        if(pageNum == null){pageNum =1;}
        if(pageSize == null){pageSize =20;}
        PageInfo<Dest> destPageInfo = destService.pageQueryListByCondition(cityName,state,destinationId,pageNum,pageSize);
        modelMap.put("page", destPageInfo);
        modelMap.put("cityName", cityName);
        modelMap.put("state",state);
        modelMap.put("destiantionId", destinationId);
        return "/backend/dest/list";
    }

    @RequestMapping("fetch")
    @ResponseBody
    public String fetch(Integer destinationId){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                hotelEventBus.productFetchTask(destinationId);
            }
        });
        return getSuccessJsonResult(Constant.SUCCESS);
    }
}
