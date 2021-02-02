package com.freeter.modules.adverts.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;

import com.freeter.modules.adverts.dao.AdvertsDetailDao;
import com.freeter.modules.adverts.entity.AdvertsDetailEntity;
import com.freeter.modules.adverts.service.AdvertsDetailService;
import com.freeter.modules.adverts.entity.vo.AdvertsDetailVO;
import com.freeter.modules.adverts.entity.view.AdvertsDetailView;
import com.freeter.common.utils.PageInfo;


@SuppressWarnings("rawtypes")
@Service("advertsDetailService")
public class AdvertsDetailServiceImpl extends ServiceImpl<AdvertsDetailDao, AdvertsDetailEntity> implements AdvertsDetailService {


    @Override
	public PageUtils queryPage(PageInfo pageInfo, Wrapper<AdvertsDetailEntity> wrapper) {
		  	Page<AdvertsDetailView> page =pageInfo.getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<AdvertsDetailVO> selectListVO( Wrapper<AdvertsDetailEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AdvertsDetailVO selectVO( Wrapper<AdvertsDetailEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AdvertsDetailView> selectListView(Wrapper<AdvertsDetailEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AdvertsDetailView selectView(Wrapper<AdvertsDetailEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
