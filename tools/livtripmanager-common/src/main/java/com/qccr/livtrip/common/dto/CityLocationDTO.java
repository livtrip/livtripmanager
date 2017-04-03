package com.qccr.livtrip.common.dto;

/**
 * 城市地点
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/2 20:38 Exp $$
 */
public class CityLocationDTO {

    private Integer elementType;
    private Integer destinationId;
    private String provider;
    private String status;
    private String location;
    private String destinationCode;
    private String city;
    private Integer cityDestinationId;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityDestinationId() {
        return cityDestinationId;
    }

    public void setCityDestinationId(Integer cityDestinationId) {
        this.cityDestinationId = cityDestinationId;
    }
}
