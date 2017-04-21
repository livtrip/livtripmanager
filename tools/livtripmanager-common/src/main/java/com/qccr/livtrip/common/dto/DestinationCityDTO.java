package com.qccr.livtrip.common.dto;

import java.util.List;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/21 19:51 Exp $$
 */
public class DestinationCityDTO {
  List<CityNewDTO> city;

    public List<CityNewDTO> getCity() {
        return city;
    }

    public void setCity(List<CityNewDTO> city) {
        this.city = city;
    }
}
