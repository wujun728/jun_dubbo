package com.freeter.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.modules.good.entity.GoodDetailEntity;
import com.freeter.modules.good.entity.vo.GoodDetailVO;

import org.apache.ibatis.annotations.Param;

/**
 * 商品描述表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
public interface GoodDetailDao extends BaseMapper<GoodDetailEntity> {
	
	List<GoodDetailVO> selectListVO(@Param("ew") Wrapper<GoodDetailEntity> wrapper);
	
	GoodDetailVO selectVO(@Param("ew") Wrapper<GoodDetailEntity> wrapper);
}
