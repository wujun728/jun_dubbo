package com.freeter.modules.adverts.controller;

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


import com.freeter.modules.adverts.entity.AdvertsEntity;
import com.freeter.modules.adverts.entity.view.AdvertsView;
import com.freeter.modules.adverts.entity.model.AdvertsModel;

import com.freeter.modules.adverts.service.AdvertsService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.MPUtil;



/**
 * 广告位表
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
@RestController
@RequestMapping("adverts/adverts")
@SuppressWarnings({"unchecked","rawtypes"})
public class AdvertsController {
    @Autowired
    private AdvertsService advertsService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("adverts:adverts:list")
    public R page(JQPageInfo jqPageInfo,AdvertsModel adverts){
		EntityWrapper< AdvertsEntity> ew = ParseWrapper.parseWrapper(adverts);
     	PageInfo pageInfo = new PageInfo(jqPageInfo);
     	PageUtils page = advertsService.queryPage(pageInfo, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("adverts:adverts:list")
    public R list( AdvertsModel adverts){
		EntityWrapper< AdvertsEntity> ew = ParseWrapper.parseWrapper(adverts);
        return R.ok().put("data",  advertsService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("adverts:adverts:info")
    public R query(AdvertsEntity adverts){
        EntityWrapper< AdvertsEntity> ew = new EntityWrapper< AdvertsEntity>();
 		ew.allEq(MPUtil.allEQMapPre( adverts, "adverts")); 
		AdvertsView  advertsView =  advertsService.selectView(ew);
		return R.ok("查询广告位表成功").put("data",  advertsView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{advertsId}")
    @RequiresPermissions("adverts:adverts:info")
    public R info(@PathVariable("advertsId") Long advertsId){
        AdvertsEntity adverts = advertsService.selectById(advertsId);

        return R.ok().put("adverts", adverts);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("adverts:adverts:save")
    public R save(@RequestBody AdvertsEntity adverts){
    	ValidatorUtils.validateEntity(adverts);
        advertsService.insert(adverts);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("adverts:adverts:update")
    public R update(@RequestBody AdvertsEntity adverts){
        ValidatorUtils.validateEntity(adverts);
        advertsService.updateAllColumnById(adverts);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("adverts:adverts:delete")
    public R delete(@RequestBody Long[] advertsIds){
        advertsService.deleteBatchIds(Arrays.asList(advertsIds));

        return R.ok();
    }

}
