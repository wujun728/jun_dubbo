package com.freeter.modules.good.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageInfo;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.good.dao.CategoryDao;
import com.freeter.modules.good.entity.CategoryEntity;
import com.freeter.modules.good.entity.view.CategoryView;
import com.freeter.modules.good.entity.vo.CategoryVO;
import com.freeter.modules.good.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(PageInfo pageInfo) {
        Page<CategoryEntity> page = this.selectPage(
               pageInfo.getPage(),
                new EntityWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<CategoryVO> selectListVO( Wrapper<CategoryEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CategoryVO selectVO( Wrapper<CategoryEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<CategoryView> selectListView(Wrapper<CategoryEntity> wrapper) {
		// TODO Auto-generated method stub
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CategoryView selectView(Wrapper<CategoryEntity> wrapper) {
		// TODO Auto-generated method stub
		return baseMapper.selectView(wrapper);
	}

}
