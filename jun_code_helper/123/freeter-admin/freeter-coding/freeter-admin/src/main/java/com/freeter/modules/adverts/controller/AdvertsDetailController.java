package com.freeter.modules.adverts.controller;

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
import com.freeter.common.utils.JQPageInfo;
import com.freeter.common.mpextend.parser.ParseWrapper;
import com.freeter.common.utils.PageInfo;


import com.freeter.modules.adverts.entity.AdvertsDetailEntity;
import com.freeter.modules.adverts.entity.view.AdvertsDetailView;
import com.freeter.modules.adverts.entity.model.AdvertsDetailModel;

import com.freeter.modules.adverts.service.AdvertsDetailService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.MPUtil;



/**
 * 广告位详情
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 12:36:59
 */
@RestController
@RequestMapping("adverts/advertsdetail")
public class AdvertsDetailController {
    @Autowired
    private AdvertsDetailService advertsDetailService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("adverts:advertsdetail:list")
    public R page(JQPageInfo jqPageInfo,AdvertsDetailModel advertsDetail){
        EntityWrapper< AdvertsDetailEntity> ew = ParseWrapper.parseWrapper(advertsDetail);
     	PageInfo pageInfo = new PageInfo(jqPageInfo);
     	PageUtils page = advertsDetailService.queryPage(pageInfo, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("adverts:advertsdetail:list")
    public R list( AdvertsDetailModel advertsDetail){
       	EntityWrapper< AdvertsDetailEntity> ew = ParseWrapper.parseWrapper(advertsDetail);
        return R.ok().put("data",  advertsDetailService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("adverts:advertsdetail:info")
    public R query(AdvertsDetailEntity advertsDetail){
        EntityWrapper< AdvertsDetailEntity> ew = new EntityWrapper< AdvertsDetailEntity>();
 		ew.allEq(MPUtil.allEQMapPre( advertsDetail, "advertsDetail")); 
		AdvertsDetailView  advertsDetailView =  advertsDetailService.selectView(ew);
		return R.ok("查询广告位详情成功").put("data",  advertsDetailView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{advertsDetailId}")
    @RequiresPermissions("adverts:advertsdetail:info")
    public R info(@PathVariable("advertsDetailId") Long advertsDetailId){
        AdvertsDetailEntity advertsDetail = advertsDetailService.selectById(advertsDetailId);

        return R.ok().put("advertsDetail", advertsDetail);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("adverts:advertsdetail:save")
    public R save(@RequestBody AdvertsDetailEntity advertsDetail){
    	ValidatorUtils.validateEntity(advertsDetail);
        advertsDetailService.insert(advertsDetail);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("adverts:advertsdetail:update")
    public R update(@RequestBody AdvertsDetailEntity advertsDetail){
        ValidatorUtils.validateEntity(advertsDetail);
        advertsDetailService.updateAllColumnById(advertsDetail);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("adverts:advertsdetail:delete")
    public R delete(@RequestBody Long[] advertsDetailIds){
        advertsDetailService.deleteBatchIds(Arrays.asList(advertsDetailIds));

        return R.ok();
    }

}
