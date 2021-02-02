package com.freeter.modules.good.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.freeter.modules.good.entity.CategoryEntity;
import com.freeter.modules.good.entity.CategorySpecEntity;
import com.freeter.modules.good.entity.view.CategorySpecView;
import com.freeter.modules.good.entity.vo.CategorySpecVO;


/**
 * 分类规格表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 18:32:07
 */
public interface CategorySpecDao extends BaseMapper<CategorySpecEntity> {
	
	List<CategorySpecVO> selectListVO(@Param("ew") Wrapper<CategorySpecEntity> wrapper);
	
	CategorySpecVO selectVO(@Param("ew") Wrapper<CategorySpecEntity> wrapper);
	
	
	List<CategorySpecView> selectListView(@Param("ew") Wrapper<CategorySpecEntity> wrapper);

	CategorySpecView selectView(@Param("ew") Wrapper<CategorySpecEntity> wrapper);
	
	List<CategorySpecView> selectListView(Pagination page, @Param("ew") Wrapper<CategorySpecEntity> wrapper);
}
