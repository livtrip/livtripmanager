package com.qccr.livtrip.common.dto;

import java.util.List;

/**
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/21 19:50 Exp $$
 */
public class DestinationStateDTO {

    List<DestinationCityDTO> state;



    public List<DestinationCityDTO> getState() {
        return state;
    }

    public void setState(List<DestinationCityDTO> state) {
        this.state = state;
    }
}
