package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.good.entity.CategoryEntity;
import com.freeter.modules.good.entity.CategorySpecEntity;
import com.freeter.modules.good.entity.view.CategorySpecView;
import com.freeter.modules.good.entity.vo.CategorySpecVO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


/**
 * 分类规格表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 18:32:07
 */
public interface CategorySpecService extends IService<CategorySpecEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CategorySpecVO> selectListVO(Wrapper<CategorySpecEntity> wrapper);
   	
   	CategorySpecVO selectVO(@Param("ew") Wrapper<CategorySpecEntity> wrapper);
   	
   	List<CategorySpecView> selectListView(Wrapper<CategorySpecEntity> wrapper);
   	
   	CategorySpecView selectView(@Param("ew") Wrapper<CategorySpecEntity> wrapper);

	//Page<CategorySpecView> queryPageCategorySpecView(Page<CategorySpecView> page, Wrapper<CategorySpecEntity> wrapper);

	Page<CategorySpecView> queryPageCategorySpecView(Map<String, Object> params, Wrapper<CategorySpecEntity> wrapper);
}

