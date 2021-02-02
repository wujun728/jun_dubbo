package com.freeter.modules.good.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.GoodSpecPriceEntity;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
 

/**
 * 规格价格表
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-24 14:04:18
 */
@TableName("cn_good_spec_price")
@ApiModel(value = "GoodSpecPrice")
public class GoodSpecPriceView  extends GoodSpecPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodSpecPriceView(){
	}
 
 	public GoodSpecPriceView(GoodSpecPriceEntity goodSpecPriceEntity){
 	
 		BeanUtils.copyProperties(this, goodSpecPriceEntity);
	}
}
