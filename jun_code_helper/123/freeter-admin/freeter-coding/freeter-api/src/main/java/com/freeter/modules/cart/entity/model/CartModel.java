package com.freeter.modules.cart.entity.model;


import java.util.List;
import java.util.Map;

public class CartModel {
    private Integer goodId;//商品id
    private Integer merchantsId;//商户id
    private Integer cartId;//购物车id
    private String goodImg;//商品图片
    private String goodTitle; //商品标题
    private List<Map> goodSpec; //商品规格
    private Integer goodCount; //商品数量
    private Double goodUnitPrice;//商品单价
    private Double  totalAmount;//商品总价





    public String getGoodTitle() {
        return goodTitle;
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

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public Integer getMerchantsId() {
        return merchantsId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public void setMerchantsId(Integer merchantsId) {
        this.merchantsId = merchantsId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    public Double getGoodUnitPrice() {
        return goodUnitPrice;
    }

    public void setGoodUnitPrice(Double goodUnitPrice) {
        this.goodUnitPrice = goodUnitPrice;
    }
}
