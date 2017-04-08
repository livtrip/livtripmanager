package com.qccr.livtrip.web.controller;

import com.alibaba.fastjson.JSON;
import com.qccr.livtrip.common.constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/8 16:12 Exp $$
 */
public class BaseController {

    public String getSuccessJsonResult(Object data){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", data);
        resultMap.put("success", true);
        resultMap.put("message", Constant.SUCCESS);
        return JSON.toJSONString(resultMap);
    }

    public String getFailedJsonResult(String errorMsg){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", false);
        resultMap.put("message", errorMsg);
        return JSON.toJSONString(resultMap);
    }



}
