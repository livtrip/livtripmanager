package com.qccr.livtrip.model.destination;

import com.qccr.livtrip.model.common.BaseDO;

/**
 * 城市区域
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/9 16:43 Exp $$
 */
public class CityLocation extends BaseDO{
    private Integer id;
    private String location;
    private String destinationCode;
    private Integer destinationId;
    private Integer type;
    private Integer cityId;
    private Integer cityDestinationId;
    private String city;
    private String status;
    private String provider;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCityDestinationId() {
        return cityDestinationId;
    }

    public void setCityDestinationId(Integer cityDestinationId) {
        this.cityDestinationId = cityDestinationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
