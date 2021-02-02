package com.freeter.modules.good.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodAttributeEntity;
import com.freeter.modules.good.entity.model.GoodAttributeModel;
import com.freeter.modules.good.entity.vo.GoodAttributeVO;
import com.freeter.modules.good.service.GoodAttributeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 商品属性表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@RestController
@RequestMapping("goodattribute")
@Api(tags="商品属性表接口")
public class GoodAttributeController {
    @Autowired
    private GoodAttributeService goodAttributeService;
 
	
    /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询商品属性表")
    public R Model(GoodAttributeModel goodAttributeModel){
		ValidatorUtils.validateEntity(goodAttributeModel);
        EntityWrapper< GoodAttributeEntity> ew = new EntityWrapper< GoodAttributeEntity>();
		GoodAttributeEntity goodAttribute = new  GoodAttributeEntity( goodAttributeModel);
		ew.setEntity(goodAttribute);
		GoodAttributeVO goodAttributeVO = goodAttributeService.selectVO(ew);
		return R.ok("查询商品属性表成功").put("data",goodAttributeVO);
    }

    /**
     * 信息
     */
    @GetMapping("/info/{attributeId}")
    @ApiOperation("获取相应的商品属性表")
    public R info(@PathVariable("attributeId") Long attributeId){
        GoodAttributeEntity goodAttribute = goodAttributeService.selectById(attributeId);

        return R.ok().put("goodAttribute", goodAttribute);
    }

    

}
