package com.freeter.modules.sys.api.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.sys.entity.MobileEntity;
import com.freeter.modules.sys.service.MobileService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-02 16:54:42
 */
@RestController
@RequestMapping("mobile/api")
@Api(tags="接口")
public class Mobile2ApiController {
    @Autowired
    private MobileService mobileService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("获取多个")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = mobileService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取相应的")
    public R info(@PathVariable("id") Long id){
        MobileEntity mobile = mobileService.selectById(id);

        return R.ok().put("mobile", mobile);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @RequiresPermissions("sys:mobile:save")
    @ApiOperation("添加数据")
    public R saveJson(@RequestBody MobileEntity mobile){
    	ValidatorUtils.validateEntity(mobile);
        mobileService.insert(mobile);

        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @RequiresPermissions("sys:mobile:save")
    @ApiOperation("添加数据")
    public R saveForm(MobileEntity mobile){
    	ValidatorUtils.validateEntity(mobile);
        mobileService.insert(mobile);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改数据（参数：json格式）")
    public R updateJson(@RequestBody MobileEntity mobile){
        ValidatorUtils.validateEntity(mobile);
        mobileService.updateAllColumnById(mobile);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改数据（参数表单格式）")
    public R updateForm(MobileEntity mobile){
        ValidatorUtils.validateEntity(mobile);
        mobileService.updateAllColumnById(mobile);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ApiOperation("删除数据")
    public R delete(@RequestBody Long[] ids){
        mobileService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
