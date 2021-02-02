package com.freeter.modules.order.entity.model;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderModel {
    private Integer orderId;//订单id
    private String  userName; //用户名称
    private Integer userId;//用户id
    private String orderNo;//订单编号
    private BigDecimal totalAmount;//订单金额
    private String strCreatedTime;//订单提交时间
    private String address;//订单收货地址
    private String consignee;//收货人
    private String postCode;//邮编
    private String tel;//收货人电话
    private String expressNumber;//快递单号
    private String expressCompanyNo;//快递公司编号
    private String expressCompanyName;//快递公司名称
    private String orderGood;//订单商品
    private String orderStatus;  //订单状态
    private String deliveryPersonTel;//配送人电话
    private String expressType;//快递类型
    private String expressMsg;//快递信息


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStrCreatedTime() {
        return strCreatedTime;
    }

    public void setStrCreatedTime(String strCreatedTime) {
        this.strCreatedTime = strCreatedTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }

    public String getExpressCompanyNo() {
        return expressCompanyNo;
    }

    public void setExpressCompanyNo(String expressCompanyNo) {
        this.expressCompanyNo = expressCompanyNo;
    }

    public String getOrderGood() {
        return orderGood;
    }

    public void setOrderGood(String orderGood) {
        this.orderGood = orderGood;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getExpressCompanyName() {
        return expressCompanyName;
    }

    public void setExpressCompanyName(String expressCompanyName) {
        this.expressCompanyName = expressCompanyName;
    }

    public String getDeliveryPersonTel() {
        return deliveryPersonTel;
    }

    public void setDeliveryPersonTel(String deliveryPersonTel) {
        this.deliveryPersonTel = deliveryPersonTel;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public String getExpressMsg() {
        return expressMsg;
    }

    public void setExpressMsg(String expressMsg) {
        this.expressMsg = expressMsg;
    }
}
