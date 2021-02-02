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

import com.freeter.modules.good.dao.GoodAttributeDao;
import com.freeter.modules.good.entity.GoodAttributeEntity;
import com.freeter.modules.good.service.GoodAttributeService;
import com.freeter.modules.good.entity.vo.GoodAttributeVO;
import com.freeter.modules.good.entity.view.GoodAttributeView;


@Service("goodAttributeService")
public class GoodAttributeServiceImpl extends ServiceImpl<GoodAttributeDao, GoodAttributeEntity> implements GoodAttributeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodAttributeEntity> page = this.selectPage(
                new Query<GoodAttributeEntity>(params).getPage(),
                new EntityWrapper<GoodAttributeEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoodAttributeEntity> wrapper) {
		  Page<GoodAttributeView> page =new Query<GoodAttributeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<GoodAttributeVO> selectListVO( Wrapper<GoodAttributeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodAttributeVO selectVO( Wrapper<GoodAttributeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodAttributeView> selectListView(Wrapper<GoodAttributeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodAttributeView selectView(Wrapper<GoodAttributeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
