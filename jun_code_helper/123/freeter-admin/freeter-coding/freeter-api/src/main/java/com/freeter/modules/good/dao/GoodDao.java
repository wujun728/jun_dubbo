package com.freeter.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.vo.GoodVO;

import org.apache.ibatis.annotations.Param;

/**
 * 商品表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:00
 */
public interface GoodDao extends BaseMapper<GoodEntity> {
	
	List<GoodVO> selectListVO(@Param("ew") Wrapper<GoodEntity> wrapper);
	
	GoodVO selectVO(@Param("ew") Wrapper<GoodEntity> wrapper);
	
	List<GoodVO> selectGoodAndGoodAttr(@Param("ew") Wrapper<GoodEntity> wrapper);
}
