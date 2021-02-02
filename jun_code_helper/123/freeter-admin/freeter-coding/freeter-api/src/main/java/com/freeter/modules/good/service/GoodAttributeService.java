package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.good.entity.GoodAttributeEntity;
import com.freeter.modules.good.entity.vo.GoodAttributeVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 商品属性表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
public interface GoodAttributeService extends IService<GoodAttributeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodAttributeVO> selectListVO(Wrapper<GoodAttributeEntity> wrapper);
   	
   	GoodAttributeVO selectVO(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
}

