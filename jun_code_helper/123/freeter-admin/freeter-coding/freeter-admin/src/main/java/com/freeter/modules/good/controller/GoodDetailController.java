package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.Map;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodDetailEntity;
import com.freeter.modules.good.entity.GoodSpecValueEntity;
import com.freeter.modules.good.service.GoodDetailService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;



/**
 * 商品描述表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-07 15:43:06
 */
@RestController
@RequestMapping("good/gooddetail")
public class GoodDetailController {
    @Autowired
    private GoodDetailService goodDetailService;

    /**
     * 列表
     */
    @RequestMapping("/list")
	@RequiresPermissions("good:good:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = goodDetailService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/goodDetail")
	@RequiresPermissions("good:good:list")
    public R goodDetail( Long goodId){
    	
    	EntityWrapper<GoodDetailEntity> ew = new EntityWrapper<GoodDetailEntity>();
    	ew.eq("good_id", goodId);
    	GoodDetailEntity goodDetail = goodDetailService.selectOne(ew);
    	 

        return R.ok().put("goodDetail", goodDetail);
    }
    

    /**
     * 信息
     */
    @RequestMapping("/info/{goodDetailId}")
	@RequiresPermissions("good:good:list")
    public R info(@PathVariable("goodDetailId") Long goodDetailId){
        GoodDetailEntity goodDetail = goodDetailService.selectById(goodDetailId);

        return R.ok().put("goodDetail", goodDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
	@RequiresPermissions("good:good:list")
    public R save(@RequestBody GoodDetailEntity goodDetail){
    	ValidatorUtils.validateEntity(goodDetail);
        goodDetailService.insert(goodDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
	@RequiresPermissions("good:good:list")
    public R update(@RequestBody GoodDetailEntity goodDetail){
        ValidatorUtils.validateEntity(goodDetail);
        goodDetailService.insertOrUpdateAllColumn(goodDetail);        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("good:gooddetail:delete")
    public R delete(@RequestBody Long[] goodDetailIds){
        goodDetailService.deleteBatchIds(Arrays.asList(goodDetailIds));

        return R.ok();
    }

}
