package com.freeter.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.modules.good.entity.CategoryGoodEntity;
import com.freeter.modules.good.entity.view.CategoryGoodView;
import com.freeter.modules.good.entity.vo.CategoryGoodVO;

import org.apache.ibatis.annotations.Param;


/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-01 16:28:07
 */
public interface CategoryGoodDao extends BaseMapper<CategoryGoodEntity> {
	
	List<CategoryGoodVO> selectListVO(@Param("ew") Wrapper<CategoryGoodEntity> wrapper);
	
	CategoryGoodVO selectVO(@Param("ew") Wrapper<CategoryGoodEntity> wrapper);
	
	
	List<CategoryGoodView> selectListView(@Param("ew") Wrapper<CategoryGoodEntity> wrapper);

	CategoryGoodView selectView(@Param("ew") Wrapper<CategoryGoodEntity> wrapper);
}
