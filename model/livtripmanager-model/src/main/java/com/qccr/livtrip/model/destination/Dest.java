package com.qccr.livtrip.model.destination;

import com.qccr.livtrip.model.common.BaseDO;

/**
 *
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/28 18:45 Exp $$
 */
public class Dest extends BaseDO {
    private Integer id;
    private Integer destinationId;
    private String cityName;
    private String state;
    private  Integer sort;

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
