package com.freeter.modules.good.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.good.dao.CategoryGoodDao;
import com.freeter.modules.good.entity.CategoryGoodEntity;
import com.freeter.modules.good.entity.view.CategoryGoodView;
import com.freeter.modules.good.entity.vo.CategoryGoodVO;
import com.freeter.modules.good.service.CategoryGoodService;


@Service("categoryGoodService")
public class CategoryGoodServiceImpl extends ServiceImpl<CategoryGoodDao, CategoryGoodEntity> implements CategoryGoodService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CategoryGoodEntity> page = this.selectPage(
                new Query<CategoryGoodEntity>(params).getPage(),
                new EntityWrapper<CategoryGoodEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<CategoryGoodVO> selectListVO( Wrapper<CategoryGoodEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CategoryGoodVO selectVO( Wrapper<CategoryGoodEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CategoryGoodView> selectListView(Wrapper<CategoryGoodEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CategoryGoodView selectView(Wrapper<CategoryGoodEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
