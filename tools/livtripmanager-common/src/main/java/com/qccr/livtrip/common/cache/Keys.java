package com.qccr.livtrip.common.cache;

/**
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2017/2/25 15:57 user Exp $$
 * @name
 */

public class Keys {

    private final static String prefix="LIVTRIP";

    public static String getHotelSearchCacheKey(String destinationId){
        return prefix + "_" +  CacheEnums.HOTEL_SEARCH.getDescription() + "_" + destinationId;
    }

}
