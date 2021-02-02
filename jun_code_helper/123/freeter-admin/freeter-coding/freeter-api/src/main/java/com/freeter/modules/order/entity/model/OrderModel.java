package com.freeter.modules.order.entity.model;


import java.math.BigDecimal;
import java.util.List;

public class OrderModel {
    private Integer userId; //用户id
    private String orderStatus;  //订单状态
    private List<OrderGoodModel> orderGoodModelList;  //订单商品模型列表
    private Integer goodCount; //商品总数量
    private BigDecimal totalAmount;//总金额

    public Integer getUserId() {
        return userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public List<OrderGoodModel> getOrderGoodModelList() {
        return orderGoodModelList;
    }

    public Integer getGoodCount() {
        return goodCount;
    }



    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderGoodModelList(List<OrderGoodModel> orderGoodModelList) {
        this.orderGoodModelList = orderGoodModelList;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
