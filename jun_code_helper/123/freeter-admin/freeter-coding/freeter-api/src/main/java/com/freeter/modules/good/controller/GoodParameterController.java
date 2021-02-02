package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodParameterEntity;
import com.freeter.modules.good.entity.model.GoodParameterModel;
import com.freeter.modules.good.entity.view.GoodParameterView;
import com.freeter.modules.good.service.GoodParameterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 商品参数表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@RestController
@RequestMapping("goodparameter")
@Api(tags="商品参数表接口")
public class GoodParameterController {
    @Autowired
    private GoodParameterService goodParameterService;
 
	
    /**
     * 查询
     */
    @GetMapping("/Model")
    @ApiOperation("查询商品参数表")
    public R Model(GoodParameterModel goodParameterModel){
		ValidatorUtils.validateEntity(goodParameterModel);
        EntityWrapper< GoodParameterEntity> ew = new EntityWrapper< GoodParameterEntity>();
		GoodParameterEntity goodParameter = new  GoodParameterEntity( goodParameterModel);
		ew.setEntity(goodParameter);
		goodParameterService.selectList(ew);
		return R.ok("查询商品参数表成功").put("data",goodParameterService.selectList(ew));
    }

	

    /**
     * 信息
     */
    @GetMapping("/info/{goodParameterId}")
    @ApiOperation("获取相应的商品参数表")
    public R info(@PathVariable("goodParameterId") Long goodParameterId){
        GoodParameterEntity goodParameter = goodParameterService.selectById(goodParameterId);

        return R.ok().put("goodParameter", goodParameter);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加商品参数表数据")
    public R saveJson(@RequestBody GoodParameterEntity goodParameter){
    	ValidatorUtils.validateEntity(goodParameter);
        goodParameterService.insert(goodParameter);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加商品参数表数据 （参数：表单格式）")
    public R saveForm(GoodParameterEntity goodParameter){
    	ValidatorUtils.validateEntity(goodParameter);
        goodParameterService.insert(goodParameter);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改商品参数表数据（参数：json格式）")
    public R updateJson(@RequestBody GoodParameterEntity goodParameter){
        ValidatorUtils.validateEntity(goodParameter);
        goodParameterService.updateAllColumnById(goodParameter);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改商品参数表数据（参数：表单格式）")
    public R updateForm(GoodParameterEntity goodParameter){
        ValidatorUtils.validateEntity(goodParameter);
        goodParameterService.updateAllColumnById(goodParameter);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除商品参数表数据")
    public R delete(@RequestBody Long[] goodParameterIds){
        goodParameterService.deleteBatchIds(Arrays.asList(goodParameterIds));
        return R.ok();
    }

}
