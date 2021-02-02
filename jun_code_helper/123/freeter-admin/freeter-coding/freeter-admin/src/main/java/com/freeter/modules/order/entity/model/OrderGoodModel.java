package com.freeter.modules.order.entity.model;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class OrderGoodModel {
    private Integer goodId;//商品id
    private String goodImg;//商品图片
    private String goodName; //商品名称
    private String goodSpec; //商品规格
    private Integer goodCount; //商品数量
    private BigDecimal unitPrice;//商品单价

    public String getGoodImg() {
        return goodImg;
    }
    public String getGoodName() {
        return goodName;
    }
    public void setGoodImg(String googImg) {
        this.goodImg = googImg;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }


    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getGoodSpec() {
        return goodSpec;
    }

    public void setGoodSpec(String goodSpec) {
        this.goodSpec = goodSpec;
    }
}
