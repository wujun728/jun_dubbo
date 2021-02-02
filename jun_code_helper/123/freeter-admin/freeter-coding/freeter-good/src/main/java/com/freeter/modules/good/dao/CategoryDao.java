package com.freeter.modules.good.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.modules.good.entity.CategoryEntity;
import com.freeter.modules.good.entity.view.CategoryView;
import com.freeter.modules.good.entity.vo.CategoryVO;

import org.apache.ibatis.annotations.Param;


/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-15 14:33:44
 */
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
	List<CategoryVO> selectListVO(@Param("ew") Wrapper<CategoryEntity> wrapper);
	
	CategoryVO selectVO(@Param("ew") Wrapper<CategoryEntity> wrapper);
	
	
	List<CategoryView> selectListView(@Param("ew") Wrapper<CategoryEntity> wrapper);

	CategoryView selectView(@Param("ew") Wrapper<CategoryEntity> wrapper);
}
