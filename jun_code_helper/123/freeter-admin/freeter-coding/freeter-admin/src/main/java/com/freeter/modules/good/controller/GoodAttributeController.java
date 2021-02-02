package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.Map;

import com.freeter.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.freeter.modules.good.entity.GoodAttributeEntity;
import com.freeter.modules.good.entity.view.GoodAttributeView;

import com.freeter.modules.good.service.GoodAttributeService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.MPUtil;



/**
 * 商品属性表
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-30 17:28:16
 */
@RestController
@RequestMapping("good/goodattribute")
public class GoodAttributeController {
    @Autowired
    private GoodAttributeService goodAttributeService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("good:goodattribute:list")
    public R page(@RequestParam Map<String, Object> params,GoodAttributeEntity goodAttribute){
 
        EntityWrapper< GoodAttributeEntity> ew = new EntityWrapper< GoodAttributeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goodAttribute, "goodAttribute")); 
    	PageUtils page = goodAttributeService.queryPage(params, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("good:goodattribute:list")
    public R list( GoodAttributeEntity goodAttribute){
       	EntityWrapper<  GoodAttributeEntity> ew = new EntityWrapper<  GoodAttributeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goodAttribute, "goodAttribute")); 
        return R.ok().put("data",  goodAttributeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("good:goodattribute:info")
    public R query(GoodAttributeEntity goodAttribute){
        EntityWrapper< GoodAttributeEntity> ew = new EntityWrapper< GoodAttributeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( goodAttribute, "goodAttribute")); 
		GoodAttributeView  goodAttributeView =  goodAttributeService.selectView(ew);
		return R.ok("查询商品属性表成功").put("data",  goodAttributeView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{attributeId}")
    @RequiresPermissions("good:goodattribute:info")
    public R info(@PathVariable("attributeId") Long attributeId){
        GoodAttributeEntity goodAttribute = goodAttributeService.selectById(attributeId);

        return R.ok().put("goodAttribute", goodAttribute);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("good:goodattribute:save")
    public R save(@RequestBody GoodAttributeEntity goodAttribute){
    	ValidatorUtils.validateEntity(goodAttribute);
        goodAttributeService.insert(goodAttribute);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("good:goodattribute:update")
    public R update(@RequestBody GoodAttributeEntity goodAttribute){
        ValidatorUtils.validateEntity(goodAttribute);
        goodAttributeService.updateAllColumnById(goodAttribute);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("good:goodattribute:delete")
    public R delete(@RequestBody Long[] attributeIds){
        goodAttributeService.deleteBatchIds(Arrays.asList(attributeIds));

        return R.ok();
    }

}
