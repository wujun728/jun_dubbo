package com.freeter.modules.adverts.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;

import com.freeter.modules.adverts.dao.AdvertsDao;
import com.freeter.modules.adverts.entity.AdvertsEntity;
import com.freeter.modules.adverts.service.AdvertsService;
import com.freeter.modules.adverts.entity.vo.AdvertsVO;
import com.freeter.modules.adverts.entity.view.AdvertsView;
import com.freeter.common.utils.PageInfo;


@Service("advertsService")
public class AdvertsServiceImpl extends ServiceImpl<AdvertsDao, AdvertsEntity> implements AdvertsService {


    @Override
	public PageUtils queryPage(PageInfo pageInfo, Wrapper<AdvertsEntity> wrapper) {
		  	Page<AdvertsView> page =pageInfo.getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<AdvertsVO> selectListVO( Wrapper<AdvertsEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AdvertsVO selectVO( Wrapper<AdvertsEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AdvertsView> selectListView(Wrapper<AdvertsEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AdvertsView selectView(Wrapper<AdvertsEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
