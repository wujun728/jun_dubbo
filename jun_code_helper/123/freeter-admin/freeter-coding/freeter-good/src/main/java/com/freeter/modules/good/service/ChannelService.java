package com.freeter.modules.good.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageInfo;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.good.entity.ChannelEntity;
import com.freeter.modules.good.entity.vo.ChannelVO;


/**
 * 频道
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
public interface ChannelService extends IService<ChannelEntity> {

    PageUtils queryPage(PageInfo pageInfo);
    
   	List<ChannelVO> selectListVO(Wrapper<ChannelEntity> wrapper);
   	
   	ChannelVO selectVO(@Param("ew") Wrapper<ChannelEntity> wrapper);
}

