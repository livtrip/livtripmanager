package com.qccr.livtrip.model.product;

import com.qccr.livtrip.model.common.BaseDO;

/**
 * 酒店描述(liv_description)
 * @author xierongli
 * @version $Id:Description.java v 0.1 2016年12月21日 17:01 xierongli
 */
public class Description extends BaseDO {

    private Integer id;
    private Integer hotelId;
    private Integer productId;

    private String category;
    private String value;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
