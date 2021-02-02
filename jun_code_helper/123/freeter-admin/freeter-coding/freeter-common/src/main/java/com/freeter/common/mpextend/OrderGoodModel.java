package com.freeter.common.mpextend;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.freeter.common.annotation.ConditionType;
import com.freeter.common.annotation.MpBetween;
import com.freeter.common.annotation.MpEQ;
import com.freeter.common.annotation.MpIn;
import com.freeter.common.annotation.MpLike;
import com.freeter.common.annotation.OuterTable;
import com.freeter.common.annotation.OwnerTable;

import io.swagger.annotations.ApiModelProperty;

@OuterTable(value = { OrderGoodModel.class })
@OwnerTable(OrderGoodModel.class)
public class OrderGoodModel {
	@MpBetween(type = ConditionType.$gte,value="test")
	//@MpLike("goodName")
	@OuterTable(OrderGoodModel.class)
	private Integer goodId;// 商品id

	@MpEQ("orderBo")
	private String orderNo;
	
	@MpLike
	private String goodImg;// 商品图片

	@MpEQ("orderBo")
	@OuterTable(value = { OrderGoodModel.class })
	private String goodName; // 商品名称

	@OuterTable({ OrderGoodModel.class, OrderGoodModel.class })
	@MpEQ({ "goodDname", "dfDsdf" })
	private String goodSpec; // 商品规格

	@MpLike({ "column1", "column12" })
	@OuterTable({ OrderGoodModel.class, OrderGoodModel.class })
	private Integer goodCount; // 商品数量
	
	//@MpBetween(type = ConditionType.$gte)
	private BigDecimal unitPrice;// 商品单价
	@NotNull(message = "用户id不能为空")
	@ApiModelProperty(value = "用户id")
	@OuterTable(OrderGoodModel.class)
	private Integer userId;

	@MpIn
	private Integer[] ids;
	
	@MpIn
	private String idstr;
	
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getIdstr() {
		return idstr;
	}

	public void setIdstr(String idstr) {
		this.idstr = idstr;
	}

	
}
