package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.mpextend.parser.ParseWrapper;
import com.freeter.common.utils.JQPageInfo;
import com.freeter.common.utils.PageInfo;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.ChannelEntity;
import com.freeter.modules.good.service.ChannelService;



/**
 * 频道
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
@RestController
@RequestMapping("good/channel")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("good:channel:list")
    public R list( JQPageInfo jqPageInfo){
        PageUtils page = channelService.queryPage(new PageInfo(jqPageInfo));
        //ParseWrapper.parseWrapper(t);
         return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/getChannelList")
    @RequiresPermissions("good:channel:list")
    public R getChannelList(){
    	ChannelEntity channelEntity = new ChannelEntity();
    	EntityWrapper< ChannelEntity> ew = new EntityWrapper< ChannelEntity>();
    	ew.orderBy("sort", true);
        List page = channelService.selectList(ew);

        return R.ok().put("data", page);
    }

    

    /**
     * 信息
     */
    @RequestMapping("/info/{channelId}")
    @RequiresPermissions("good:channel:info")
    public R info(@PathVariable("channelId") Long channelId){
        ChannelEntity channel = channelService.selectById(channelId);

        return R.ok().put("channel", channel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("good:channel:save")
    public R save(@RequestBody ChannelEntity channel){
    	ValidatorUtils.validateEntity(channel);
        channelService.insert(channel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("good:channel:update")
    public R update(@RequestBody ChannelEntity channel){
        ValidatorUtils.validateEntity(channel);
        channelService.updateAllColumnById(channel);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("good:channel:delete")
    public R delete(@RequestBody Long[] channelIds){
        channelService.deleteBatchIds(Arrays.asList(channelIds));

        return R.ok();
    }

}
