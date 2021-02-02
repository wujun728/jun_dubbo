package com.freeter.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freeter.modules.order.entity.view.OrderView;

import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;



/**
 * 订单主表
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 15:57:37
 */
@TableName("cn_order")
@ApiModel(value = "Order")
public class OrderEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public OrderEntity() {
		
	}
	
	public OrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * 主键id
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "订单编号",hidden = true)
	private Integer id;

	/**
	 * 订单编号
	 */

	@NotNull (message = "订单编号不能为空")
	@ApiModelProperty(value = "订单编号")
	private String orderNo;

	
	/**
	 * 订单总额
	 */
			
	@NotNull (message = "订单总额不能为空") 			 
	@ApiModelProperty(value = "订单总额")
	private BigDecimal totalMoney;
	
	/**
	 * 订单状态 0:待支付 1:待支付关闭 2:已付款，待发货  3:待收货 4:已收货 5:待评价 6:申请退款 7:退款完成 8:已完成订单
	 */
			
	@NotNull (message = "订单状态 0:待支付 1:待支付关闭 2:已付款，待发货  3:待收货 4:已收货 5:待评价 6:申请退款 7:退款完成 8:已完成订单不能为空") 			 
	@ApiModelProperty(value = "订单状态 0:待支付 1:待支付关闭 2:已付款，待发货  3:待收货 4:已收货 5:待评价 6:申请退款 7:退款完成 8:已完成订单")
	private Integer orderStatus;
	
	/**
	 * 用户id
	 */
			
	@NotNull (message = "用户id不能为空") 			 
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	
	/**
	 * 订单提交时间
	 */
			
	@NotNull (message = "订单提交时间不能为空") 			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "订单提交时间")
	private Date createdTime;
	
	/**
	 * 发货时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "发货时间")
	private Date deliveryTime;
	
	/**
	 * 收货时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "收货时间")
	private Date receivingTime;
	
	/**
	 * 申请退款时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "申请退款时间")
	private Date refundPeriod;
	
	/**
	 * 退款完成时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 	 
	@ApiModelProperty(value = "退款完成时间")
	private Date refundCompletePeriod;
	
	/**
	 * 收货地址
	 */
				
	@NotBlank (message = "收货地址不能为空") 		 
	@ApiModelProperty(value = "收货地址")
	private String address;
	
	/**
	 * 收货人
	 */
				
	@NotBlank (message = "收货人不能为空") 		 
	@ApiModelProperty(value = "收货人")
	private String consignee;
	
	/**
	 * 邮编
	 */
				
	@NotBlank (message = "邮编不能为空") 		 
	@ApiModelProperty(value = "邮编")
	private String postcode;
	
	/**
	 * 收货人手机号
	 */
				
	@NotBlank (message = "收货人手机号不能为空") 		 
	@ApiModelProperty(value = "收货人手机号")
	private String tel;
	
	/**
	 * 快递单号
	 */
				
	@NotBlank (message = "快递单号不能为空") 		 
	@ApiModelProperty(value = "快递单号")
	private String expressNumber;
	
	/**
	 * 快递公司编号
	 */
				
	@NotBlank (message = "快递公司编号不能为空") 		 
	@ApiModelProperty(value = "快递公司编号")
	private String expressCompanyNo;


	/**
	 * 备注
	 */
	@ApiModelProperty(value="备注")
	private String note;

	/**
	 * 运费
	 */
	@ApiModelProperty(value="运费")
	private Double 	freight;

	/**
	 * 虚拟删除
	 */
	@ApiModelProperty(value="虚拟删除")
	private String virDel;


	/**
	 * 设置：订单id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：订单主键id
	 */
	public Integer  getId() {
		return id;
	}

	/**
	 * 设置订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * 设置：订单总额
	 */
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	/**
	 * 获取：订单总额
	 */
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	/**
	 * 设置：订单状态 0:待支付 1:待支付关闭 2:已付款，待发货  3:待收货 4:已收货 5:待评价 6:申请退款 7:退款完成 8:已完成订单
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态 0:待支付 1:待支付关闭 2:已付款，待发货  3:待收货 4:已收货 5:待评价 6:申请退款 7:退款完成 8:已完成订单
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：订单提交时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：订单提交时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * 设置：发货时间
	 */
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	/**
	 * 获取：发货时间
	 */
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	/**
	 * 设置：收货时间
	 */
	public void setReceivingTime(Date receivingTime) {
		this.receivingTime = receivingTime;
	}
	/**
	 * 获取：收货时间
	 */
	public Date getReceivingTime() {
		return receivingTime;
	}
	/**
	 * 设置：申请退款时间
	 */
	public void setRefundPeriod(Date refundPeriod) {
		this.refundPeriod = refundPeriod;
	}
	/**
	 * 获取：申请退款时间
	 */
	public Date getRefundPeriod() {
		return refundPeriod;
	}
	/**
	 * 设置：退款完成时间
	 */
	public void setRefundCompletePeriod(Date refundCompletePeriod) {
		this.refundCompletePeriod = refundCompletePeriod;
	}
	/**
	 * 获取：退款完成时间
	 */
	public Date getRefundCompletePeriod() {
		return refundCompletePeriod;
	}
	/**
	 * 设置：收货地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：收货地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：收货人
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	/**
	 * 获取：收货人
	 */
	public String getConsignee() {
		return consignee;
	}
	/**
	 * 设置：邮编
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * 获取：邮编
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * 设置：收货人手机号
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：收货人手机号
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：快递单号
	 */
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
	/**
	 * 获取：快递单号
	 */
	public String getExpressNumber() {
		return expressNumber;
	}
	/**
	 * 设置：快递公司编号
	 */
	public void setExpressCompanyNo(String expressCompanyNo) {
		this.expressCompanyNo = expressCompanyNo;
	}
	/**
	 * 获取：快递公司编号
	 */
	public String getExpressCompanyNo() {
		return expressCompanyNo;
	}

	public String getNote() {
		return note;
	}

	public Double getFreight() {
		return freight;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public String getVirDel() {
		return virDel;
	}

	public void setVirDel(String virDel) {
		this.virDel = virDel;
	}
}
