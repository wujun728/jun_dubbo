package com.freeter.modules.good.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
 

/**
 * 
 * 
 * @author xuchen
 * @email 363236211@qq.com
 * @date 2018-05-23 10:29:33
 */
@ApiModel(value = "goodSpecSearch")
public class CategorySpecSearch  implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品分类id（商品规格和商品分类关联）")
	private Integer goodId;




}
