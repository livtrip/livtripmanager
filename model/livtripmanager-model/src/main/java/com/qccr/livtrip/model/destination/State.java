package com.qccr.livtrip.model.destination;

import com.qccr.livtrip.model.common.BaseDO;

/**
 * 州
 * @author xierongli
 * @version : livtripmanager-parent, v 0.1 2017/4/3 12:51 Exp $$
 */
public class State extends BaseDO{
    private Integer id;
    /**州名*/
    private String name;
    private String stateName;
    private Integer type;
    private String status;
    private Integer destinationId;
    private String provider;
    /**州名简称*/
    private String stateShort;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getStateShort() {
        return stateShort;
    }

    public void setStateShort(String stateShort) {
        this.stateShort = stateShort;
    }
}
