package com.freeter.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.sys.entity.AddressEntity;
import com.freeter.modules.sys.service.AddressService;

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
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-18 13:41:16
 */
@RestController
@RequestMapping("sys/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:address:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = addressService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:address:info")
    public R info(@PathVariable("id") Integer id){
        AddressEntity address = addressService.selectById(id);

        return R.ok().put("address", address);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:address:save")
    public R save(@RequestBody AddressEntity address){
    	ValidatorUtils.validateEntity(address);
        addressService.insert(address);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:address:update")
    public R update(@RequestBody AddressEntity address){
        ValidatorUtils.validateEntity(address);
        addressService.updateAllColumnById(address);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:address:delete")
    public R delete(@RequestBody Integer[] ids){
        addressService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
