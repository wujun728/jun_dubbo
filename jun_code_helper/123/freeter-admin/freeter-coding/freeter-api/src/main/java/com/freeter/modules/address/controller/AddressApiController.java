package com.freeter.modules.address.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.annotation.Login;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.address.entity.AddressEntity;
import com.freeter.modules.address.service.AddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-19 17:57:52
 */
@RestController
@RequestMapping("address/api")
@Api(tags="收货地址接口")
public class AddressApiController {
    @Autowired
    private AddressService addressService;

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取相应的")
    public R info(@PathVariable("id") Integer id){
        AddressEntity address = addressService.selectById(id);
        return R.ok().put("address", address);
    }


    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation("添加数据 （参数：表单格式）")
    @Login
    public R saveForm( AddressEntity address,@RequestAttribute("userId") long userId){
     	ValidatorUtils.validateEntity(address);
    	if("0".equals(address.getIsDefault())){
            addressService.insert(address);
        }else{
    	    EntityWrapper<AddressEntity> entityWrapper=new EntityWrapper<AddressEntity>();
    	    Wrapper wrapper=entityWrapper.eq("is_default",1);
    	    AddressEntity addressEntity=addressService.selectOne(wrapper);
    	    addressEntity.setIsDefault("0");
    	    addressService.updateAllColumnById(addressEntity);
    	    addressService.insert(address);
        }
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除数据")
    public R delete(@RequestBody Integer[] ids){
        addressService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 获取用户收货地址列表
     */
    @GetMapping("/getAddressesByUserId")
    @ApiOperation("获取用户收货地址列表")
    public R getAddressesByUserId(String userId) {
    	EntityWrapper<AddressEntity> entityWrapper=new EntityWrapper<AddressEntity>();
        Wrapper<AddressEntity> wrapper=entityWrapper.eq("user_id", "111");
        List<AddressEntity> addressList=addressService.selectList(wrapper);
    	return R.ok().put("data", addressList);
    }

    /**
     * 设置默认收货地址
     */
    @PostMapping("/setIsDefault")
    @ApiOperation("设置默认收货地址")
    public R setIsDefaultById(String addressId){
        EntityWrapper<AddressEntity> entityWrapper=new EntityWrapper<AddressEntity>();
        Wrapper<AddressEntity> wrapper=entityWrapper.eq("id",addressId);
        Wrapper<AddressEntity> defaultWrapper=entityWrapper.eq("is_default","1");
        AddressEntity addressEntity=addressService.selectOne(wrapper);
        AddressEntity defaultAddressEntity=addressService.selectOne(defaultWrapper);
        addressEntity.setIsDefault("1");
        defaultAddressEntity.setIsDefault("0");
        addressService.updateAllColumnById(addressEntity);
        addressService.updateAllColumnById(defaultAddressEntity);
        return R.ok("设置成功");
    }





}
