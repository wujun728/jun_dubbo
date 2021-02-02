package com.freeter.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.modules.good.entity.GoodAttributeEntity;
import com.freeter.modules.good.entity.vo.GoodAttributeVO;

import org.apache.ibatis.annotations.Param;

/**
 * 商品属性表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
public interface GoodAttributeDao extends BaseMapper<GoodAttributeEntity> {
	
	List<GoodAttributeVO> selectListVO(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
	
	GoodAttributeVO selectVO(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
}
