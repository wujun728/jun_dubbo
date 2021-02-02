package com.freeter.modules.order.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.order.entity.OrderEntity;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
 

/**
 * 订单主表
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 15:57:37
 */
@TableName("cn_order")
@ApiModel(value = "Order")
public class OrderView  extends OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrderView(){
	}
 
 	public OrderView(OrderEntity orderEntity){
 	
 		BeanUtils.copyProperties(this, orderEntity);

	}
}
