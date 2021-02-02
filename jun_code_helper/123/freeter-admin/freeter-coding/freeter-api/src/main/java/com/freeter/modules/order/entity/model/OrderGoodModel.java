package com.freeter.modules.order.entity.model;


import java.util.List;
import java.util.Map;

public class OrderGoodModel {
    private Integer goodId;//商品id
    private String goodImg;//商品图片
    private String goodTitle; //商品标题
    private List<Map> goodSpec; //商品规格
    private Integer goodCount; //商品数量

    public String getGoodImg() {
        return goodImg;
    }
    public String getGoodTitle() {
        return goodTitle;
    }
    public void setGoodImg(String googImg) {
        this.goodImg = googImg;
    }

    public void setGoodTitle(String goodTitle) {
        this.goodTitle = goodTitle;
    }



    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public List<Map> getGoodSpec() {
        return goodSpec;
    }

    public void setGoodSpec(List<Map> goodSpec) {
        this.goodSpec = goodSpec;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
}
