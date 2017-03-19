package com.qccr.livtrip.common.cache;

/**
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2017/2/25 16:05 user Exp $$
 * @name 缓存枚举值
 */
public enum  CacheEnums {


    HOTEL_SEARCH("hotel_search");

    private String description;
    private CacheEnums(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
