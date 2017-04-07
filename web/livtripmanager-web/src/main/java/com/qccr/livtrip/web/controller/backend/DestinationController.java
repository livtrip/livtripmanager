package com.qccr.livtrip.web.controller.backend;

import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageInfo;
import com.qccr.livtrip.biz.service.destination.CityService;
import com.qccr.livtrip.biz.service.destination.StateService;
import com.qccr.livtrip.common.dto.CityDTO;
import com.qccr.livtrip.common.dto.StateDTO;
import com.qccr.livtrip.common.dto.StateJSON;
import com.qccr.livtrip.common.processor.DestinationProcessor;
import com.qccr.livtrip.model.destination.City;
import com.qccr.livtrip.model.destination.State;
import com.qccr.livtrip.model.dto.CityQueryDTO;
import com.qccr.livtrip.model.request.CityQuery;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @name 地理位置控制器
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2017/2/18 15:07 user Exp $$
 */
@Controller
@RequestMapping("/backend/destination")
public class DestinationController {

    @Autowired
    private StateService stateService;
    @Autowired
    private CityService cityService;

    @RequestMapping("add")
    public void add(){
        String name = "NewYork.json";

        StateJSON stateJSON = DestinationProcessor.getStateModelByFileName(name);
        if(stateJSON != null){
            StateDTO stateDTO = stateJSON.getState();
            if(stateDTO != null){
                State state = new State();
                state.setName(stateDTO.getName());
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

    @RequestMapping("list")
    public String list(CityQuery cityQuery, ModelMap modelMap){
        PageInfo<CityQueryDTO> cityPageInfo = cityService.pageQueryCity(cityQuery);
        modelMap.put("page", cityPageInfo);
        modelMap.put("cityQuery",cityQuery);
        return "/backend/destination/list";
    }
    
 @RequestMapping("test")
    public String test(ModelMap modelMap){
        List<Integer> nums = Lists.newArrayList();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(10);

        Integer sum =nums.stream().filter(num -> num != null).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum();
        System.out.println("sum is:"+sum);
        modelMap.put("test", sum);
        return "backend/destination/test";
    }

}
