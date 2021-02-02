package com.freeter.modules.user.controller;

import java.util.Arrays;

import com.freeter.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.JQPageInfo;
import com.freeter.common.mpextend.parser.ParseWrapper;
import com.freeter.common.utils.PageInfo;


import com.freeter.modules.user.entity.UserEntity;
import com.freeter.modules.user.entity.view.UserView;
import com.freeter.modules.user.entity.model.UserModel;

import com.freeter.modules.user.service.UserService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.MPUtil;



/**
 * 用户表
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 14:03:28
 */
@RestController
@RequestMapping("user/user")
@SuppressWarnings({"unchecked","rawtypes"})
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("user:user:list")
    public R page(JQPageInfo jqPageInfo,UserModel user){
        EntityWrapper< UserEntity> ew = ParseWrapper.parseWrapper(user);
     	PageInfo pageInfo = new PageInfo(jqPageInfo);
     	PageUtils page = userService.queryPage(pageInfo, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("user:user:list")
    public R list( UserModel user){
       	EntityWrapper< UserEntity> ew = ParseWrapper.parseWrapper(user);
        return R.ok().put("data",  userService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("user:user:info")
    public R query(UserEntity user){
        EntityWrapper< UserEntity> ew = new EntityWrapper< UserEntity>();
 		ew.allEq(MPUtil.allEQMapPre( user, "user")); 
		UserView  userView =  userService.selectView(ew);
		return R.ok("查询用户表成功").put("data",  userView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("user:user:info")
    public R info(@PathVariable("userId") Long userId){
        UserEntity user = userService.selectById(userId);

        return R.ok().put("user", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("user:user:save")
    public R save(@RequestBody UserEntity user){
    	ValidatorUtils.validateEntity(user);
        userService.insert(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("user:user:update")
    public R update(@RequestBody UserEntity user){
        ValidatorUtils.validateEntity(user);
        userService.updateAllColumnById(user);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("user:user:delete")
    public R delete(@RequestBody Long[] userIds){
        userService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }

}
