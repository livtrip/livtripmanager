package com.qccr.livtrip.web.controller.backend;


import com.alibaba.fastjson.JSON;
import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.event.HotelEventBus;
import com.qccr.livtrip.biz.handler.HotelHandler;
import com.qccr.livtrip.biz.service.destination.CityService;
import com.qccr.livtrip.biz.service.destination.DestService;
import com.qccr.livtrip.biz.service.destination.StateService;
import com.qccr.livtrip.common.dto.*;
import com.qccr.livtrip.common.processor.DestinationProcessor;
import com.qccr.livtrip.common.util.ApplicationUtil;
import com.qccr.livtrip.model.destination.City;
import com.qccr.livtrip.model.destination.Dest;
import com.qccr.livtrip.model.destination.State;
import com.qccr.livtrip.model.dto.CityQueryDTO;
import com.qccr.livtrip.model.request.CityQuery;
import com.qccr.livtrip.web.controller.BaseController;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qccr.livtrip.common.constant.Constant;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @name 地理位置控制器
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2017/2/18 15:07 user Exp $$
 */
@Controller
@RequestMapping("/backend/destination")
public class DestinationController extends BaseController{

    @Autowired
    private StateService stateService;
    @Autowired
    private CityService cityService;
    @Autowired
    private HotelHandler hotelHandler;
    @Autowired
    private DestService destService;
    @Autowired
    private HotelEventBus hotelEventBus;


    @RequestMapping("add")
    public void add(){
        List<String> files =DestinationProcessor.getDestinations();
        if(CollectionUtils.isNotEmpty(files)){
            for(String file : files){
                StateJSON stateJSON = DestinationProcessor.getStateModelByFileName("NewYork.json");
                if(stateJSON != null){
                    StateDTO stateDTO = stateJSON.getState();
                    if(stateDTO != null){
                        State state = new State();
                        state.setName(stateDTO.getName());
                        state.setStateName(stateDTO.getName());
                        state.setDestinationId(stateDTO.getDestinationId());
                        state.setProvider(stateDTO.getProvider());
                        state.setStateShort(stateDTO.getStateShort());
                        state.setType(stateDTO.getElementType());
                        state.setStatus(stateDTO.getStatus());
                        int num  = stateService.insert(state);
                        if(num > 0){
                            List<CityDTO> cityDTOList = stateDTO.getCity();
                            if(CollectionUtils.isNotEmpty(cityDTOList)){
                                List<City> cities = Lists.newArrayList();
                                for(CityDTO cityDTO : cityDTOList){
                                    City city = new City();
                                    city.setType(cityDTO.getElementType());
                                    city.setProvider(cityDTO.getProvider());
                                    city.setName(cityDTO.getName());
                                    city.setDestinationCode(cityDTO.getDestinationCode());
                                    city.setLatitude(cityDTO.getCityLatitude());
                                    city.setLongitude(cityDTO.getCityLongitude());
                                    city.setDestinationId(cityDTO.getDestinationId());
                                    city.setStatus(cityDTO.getStatus());
                                    city.setStateId(state.getId());
                                    cities.add(city);
                                }
                                cityService.insertList(cities);
                                System.out.println("城市数据落地成功");
                            }
                        }
                    }
                }
            }
        }
    }

    @RequestMapping("list")
    public String list(CityQuery cityQuery, ModelMap modelMap){
        PageInfo<CityQueryDTO> cityPageInfo = cityService.pageQueryCity(cityQuery);
        modelMap.put("page", cityPageInfo);
        modelMap.put("cityQuery",cityQuery);
        return "/backend/destination/list";
    }

    @RequestMapping("edit")
    public String list1(String destinationId, ModelMap modelMap){
        City city = cityService.queryByDestinationId(Integer.parseInt(destinationId));
        modelMap.put("city", city);
        return "/backend/destination/edit";
    }

    @RequestMapping("fetch")
    @ResponseBody
    public String fetch(Integer destinationId){
        System.out.println(destinationId);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                hotelEventBus.productFetchTask(destinationId);
            }
        });
        return getSuccessJsonResult(Constant.SUCCESS);
    }

    @RequestMapping("addDestination")
    public void addDestination(){
        System.out.println("addDestination");
        InputStream in = DestinationController.class.getResourceAsStream("destination.json");
        String json = DestinationProcessor.inputStream2String(in);
        DestinationDTO destinationDTO = JSON.parseObject(json, DestinationDTO.class);

        List<DestinationStateDTO> stateDTOs =destinationDTO.getRoot();
        if(CollectionUtils.isNotEmpty(stateDTOs)){
            for(DestinationStateDTO destinationStateDTO : stateDTOs) {
                List<DestinationCityDTO> cityDTOs = destinationStateDTO.getState();
                if (CollectionUtils.isNotEmpty(cityDTOs)) {

                    for(DestinationCityDTO destinationCityDTO :cityDTOs){
                        List<CityNewDTO> cityNewDTOs = destinationCityDTO.getCity();
                        String stateName = destinationCityDTO.getS_name();

                        if(CollectionUtils.isNotEmpty(cityNewDTOs)){
                            List<Dest> dests = Lists.newArrayList();
                            for(CityNewDTO cityNewDTO : cityNewDTOs){
                                Dest dest = new Dest();
                                dest.setCityName(cityNewDTO.getName());
                                dest.setDestinationId(cityNewDTO.getId());
                                dest.setState(stateName);
                                dest.setSort(1);
                                dest.setCreatePerson("system");
                                dest.setCreateTime(new Date());
                                dest.setUpdatePerson("system");
                                dest.setUpdateTime(new Date());
                                destService.insert(dest);
                                //dests.add(dest);
                            }
//                            if(CollectionUtils.isNotEmpty(dests)){
//                                System.out.println("come here...");
//                                destService.insertList(dests);
//                            }

                        }

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //DestService destService = (DestService) ApplicationUtil.getBean("destService");
        DestinationDTO destinationDTO = DestinationProcessor.getDestinationDTO("destination.json");
        System.out.println(JSON.toJSONString(destinationDTO));

    }



}
