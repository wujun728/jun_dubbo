package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.Map;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.CategoryGoodEntity;
import com.freeter.modules.good.service.CategoryGoodService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;



/**
 * 分类表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-01 16:28:07
 */
@RestController
@RequestMapping("good/categorygood")
public class CategoryGoodController {
    @Autowired
    private CategoryGoodService categoryGoodService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("good:categorygood:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryGoodService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{categoryId}")
    @RequiresPermissions("good:categorygood:info")
    public R info(@PathVariable("categoryId") Long categoryId){
        CategoryGoodEntity categoryGood = categoryGoodService.selectById(categoryId);

        return R.ok().put("categoryGood", categoryGood);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("good:categorygood:save")
    public R save(@RequestBody CategoryGoodEntity categoryGood){
    	ValidatorUtils.validateEntity(categoryGood);
        categoryGoodService.insert(categoryGood);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("good:categorygood:update")
    public R update(@RequestBody CategoryGoodEntity categoryGood){
        ValidatorUtils.validateEntity(categoryGood);
        categoryGoodService.updateAllColumnById(categoryGood);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("good:categorygood:delete")
    public R delete(@RequestBody Long[] categoryIds){
        categoryGoodService.deleteBatchIds(Arrays.asList(categoryIds));

        return R.ok();
    }

}
