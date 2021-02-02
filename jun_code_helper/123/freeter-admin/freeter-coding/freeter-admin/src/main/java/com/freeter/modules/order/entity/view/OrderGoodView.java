package com.freeter.modules.order.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.order.entity.OrderGoodEntity;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
 

/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 17:20:46
 */
@TableName("cn_order_good")
@ApiModel(value = "OrderGood")
public class OrderGoodView  extends OrderGoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrderGoodView(){
	}
 
 	public OrderGoodView(OrderGoodEntity orderGoodEntity){
 	
 		BeanUtils.copyProperties(this, orderGoodEntity);
	}
}
