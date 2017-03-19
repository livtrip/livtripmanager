package com.qccr.livtrip.model.product;

import com.qccr.livtrip.model.common.BaseDO;

/**
 * 酒店产品(liv_hotel)
 * @author xierongli
 * @version $Id:HotelProduct.java v 0.1 2016年12月16日 17:13 xierongli
 */
public class HotelProduct extends BaseDO {

    private Integer id;
    private Integer hotelId;
    /**外健 product 主键*/
    private Integer productId;
    /**星级*/
    private Double startLevel;
    /**酒店描述*/
    private String description;

    /**房间数*/
    private Integer rooms;
    /**供应商*/
    private String provider;
    /**入住时间*/
    private String checkInTime;
    /**退房时间*/
    private String checkOutTime;

    /**酒店电话*/
    private String hotelPhone;
    /**传真*/
    private String hotelFax;
    /**排名*/
    private String ranking;
    /**0 未采集 1 已采集*/
    private Integer flag;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(Double startLevel) {
        this.startLevel = startLevel;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelFax() {
        return hotelFax;
    }

    public void setHotelFax(String hotelFax) {
        this.hotelFax = hotelFax;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
