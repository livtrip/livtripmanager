package com.qccr.livtrip.common.dto;

import java.util.List;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/21 19:51 Exp $$
 */
public class DestinationCityDTO {
    List<CityNewDTO> city;
    String s_name;

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public List<CityNewDTO> getCity() {
        return city;
    }

    public void setCity(List<CityNewDTO> city) {
        this.city = city;
    }
}
