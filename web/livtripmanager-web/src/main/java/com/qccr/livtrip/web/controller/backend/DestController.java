package com.qccr.livtrip.web.controller.backend;

import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.event.HotelEventBus;
import com.qccr.livtrip.biz.service.destination.DestService;
import com.qccr.livtrip.common.constant.Constant;
import com.qccr.livtrip.model.destination.Dest;
import com.qccr.livtrip.model.request.DestQuery;
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
    public String list(DestQuery destQuery, ModelMap modelMap){
        PageInfo<Dest> destPageInfo = destService.pageQueryListByCondition(destQuery);
        modelMap.put("page", destPageInfo);
        modelMap.put("cityName", destQuery.getCityName());
        modelMap.put("state",destQuery.getState());
        modelMap.put("destinationId", destQuery.getDestinationId());
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
