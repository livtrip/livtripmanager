package com.qccr.livtrip.model.product;

import com.qccr.livtrip.model.common.BaseDO;

/**
 * 产品表(liv_product)
 * @author xierongli
 * @version $Id:Product.java v 0.1 2016年12月16日 17:12 xierongli
 */
public class Product extends BaseDO{

    private Integer id;
    /**产品名称*/
    private String name;
    /**产品封面图*/
    private String thumb;
    private String keywords;
    private String description;
    /**品牌名称*/
    private String brandName;

    /**USD, 美元  CNY 人民币 EUR 欧元*/
    private String currency;
    /**产品类型 1 hotel */
    private Integer type;
    /**销售价 分*/
    private Integer salePrice;
    /**结算价 分*/
    private Integer clearPrice;

    /**市场价 分*/
    private Integer marketPrice;
    /**供应商*/
    private String vendor;
    /**是否删除 0 否 1 是*/
    private Integer hotelId;
    /**是否最好 0 否 1 是*/
    private Integer isBest;
    /**产品标签: eg:海景房*/
    private String label;


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getClearPrice() {
        return clearPrice;
    }

    public void setClearPrice(Integer clearPrice) {
        this.clearPrice = clearPrice;
    }

    public Integer getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Integer marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getIsBest() {
        return isBest;
    }

    public void setIsBest(Integer isBest) {
        this.isBest = isBest;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
