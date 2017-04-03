package com.qccr.livtrip.common.dto;

import java.util.List;

/**
 *州数据模型
 * @author xierongli
 * @version $Id:.java v 0.1 2017年01月11日 18:03 xierongli
 */
public class StateDTO {
    /**州名称*/
    private String name;
    private Integer elementType;
    private Integer destinationId;
    private String provider;
    /**状态*/
    private String status;
    /***简称*/
    private String StateShort;
    /**城市集合*/
    private List<CityDTO> City;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getElementType() {
        return elementType;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public List<CityDTO> getCity() {
        return City;
    }

    public void setCity(List<CityDTO> city) {
        City = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStateShort() {
        return StateShort;
    }

    public void setStateShort(String stateShort) {
        StateShort = stateShort;
    }
}
