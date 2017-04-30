package com.qccr.livtrip.web.vo.product;

/**
 * 酒店房型数据列表
 * Created by mark1xie on 17/4/30.
 */
public class HotelRoomTypeVO {

    /**房型名称*/
    private String name;
    /**每晚均价(原价)*/
    private Double originalPrice;
    /**每晚均价(销售价)*/
    private Double salePrice;
    /**几晚*/
    private Integer nights;
    /**手续费*/
    private Integer commission;
    /**总原价*/
    private Double totalOrginalPrice;
    /**销售总价*/
    private Double totalSalePrice;
    /**利润*/
    private Double profit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Double getTotalOrginalPrice() {
        return totalOrginalPrice;
    }

    public void setTotalOrginalPrice(Double totalOrginalPrice) {
        this.totalOrginalPrice = totalOrginalPrice;
    }

    public Double getTotalSalePrice() {
        return totalSalePrice;
    }

    public void setTotalSalePrice(Double totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
}
