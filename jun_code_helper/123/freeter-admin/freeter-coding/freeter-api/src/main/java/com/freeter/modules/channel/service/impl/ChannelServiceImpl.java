package com.freeter.modules.channel.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.channel.dao.ChannelDao;
import com.freeter.modules.channel.entity.ChannelEntity;
import com.freeter.modules.channel.service.ChannelService;


@Service("channelService")
public class ChannelServiceImpl extends ServiceImpl<ChannelDao, ChannelEntity> implements ChannelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChannelEntity> page = this.selectPage(
                new Query<ChannelEntity>(params).getPage(),
                new EntityWrapper<ChannelEntity>()
        );

        return new PageUtils(page);
    }

}
