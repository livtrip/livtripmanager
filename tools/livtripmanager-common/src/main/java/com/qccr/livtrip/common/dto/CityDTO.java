package com.qccr.livtrip.common.dto;

import java.util.List;

/**
 *城市数据模型
 * @author xierongli
 * @version $Id:City.java v 0.1 2017年01月11日 18:07 xierongli
 */
public class CityDTO {

    /**城市名称*/
    private String name;
    private Integer elementType;
    private Integer destinationId;
    private String provider;
    /**状态*/
    private String status;
    /**destinationCode*/
    private String destinationCode;
    private String cityDestinationId;
    private String location;
    /**经度*/
    private String cityLatitude;
    /**纬度*/
    private String cityLongitude;
//    /**城市地理位置*/
//    private List<CityLocationDTO> CityLocation;



    public String getCityLatitude() {
        return cityLatitude;
    }

    public void setCityLatitude(String cityLatitude) {
        this.cityLatitude = cityLatitude;
    }

    public String getCityLongitude() {
        return cityLongitude;
    }

    public void setCityLongitude(String cityLongitude) {
        this.cityLongitude = cityLongitude;
    }


    public String getCityDestinationId() {
        return cityDestinationId;
    }

    public void setCityDestinationId(String cityDestinationId) {
        this.cityDestinationId = cityDestinationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }
}
