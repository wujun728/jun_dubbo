package com.freeter.modules.good.dao;

import com.freeter.modules.good.entity.GoodAttributeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.good.entity.vo.GoodAttributeVO;
import com.freeter.modules.good.entity.view.GoodAttributeView;


/**
 * 商品属性表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-30 17:28:16
 */
public interface GoodAttributeDao extends BaseMapper<GoodAttributeEntity> {
	
	List<GoodAttributeVO> selectListVO(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
	
	GoodAttributeVO selectVO(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
	
	
	List<GoodAttributeView> selectListView(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);

	List<GoodAttributeView> selectListView(Pagination page,@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
	
	GoodAttributeView selectView(@Param("ew") Wrapper<GoodAttributeEntity> wrapper);
}
