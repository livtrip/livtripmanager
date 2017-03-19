package com.qccr.livtrip.model.product;

import com.qccr.livtrip.model.common.BaseDO;

/**
 * 酒店图片(liv_hotel_images)
 * @author xierongli
 * @version $Id:HotelImages.java v 0.1 2016年12月18日 11:02 xierongli
 */
public class HotelImages extends BaseDO{

    private Integer id;
    private Integer hotelId;
    private Integer productId;
    private Integer type;

    private String path;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
