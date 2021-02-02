package com.freeter.modules.good.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.good.dao.GoodDao;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.view.GoodView;
import com.freeter.modules.good.entity.vo.GoodVO;
import com.freeter.modules.good.service.GoodService;


@Service("goodService")
public class GoodServiceImpl extends ServiceImpl<GoodDao, GoodEntity> implements GoodService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodEntity> page = this.selectPage(
                new Query<GoodEntity>(params).getPage(),
                new EntityWrapper<GoodEntity>()
        );

        return new PageUtils(page);
    }
    
    /*@Override
   public PageUtils queryGoodPage(Map<String, Object> params ) {
        Page<GoodEntity> page = this.selectPage(
                new Query<GoodEntity>(params).getPage(),
                new EntityWrapper<GoodEntity>()
        );

        return new PageUtils(page);
    }*/
    
    @Override
	public List<GoodVO> selectListVO( Wrapper<GoodEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodVO selectVO( Wrapper<GoodEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodView> selectListView(Wrapper<GoodEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodView selectView(Wrapper<GoodEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	@Override
	public   Page<GoodView> queryPage(Map<String, Object> params, Wrapper<GoodEntity> wrapper) {
		  Page<GoodView> page =new Query<GoodView>(params).getPage();
	        return page.setRecords(  baseMapper.selectCategoryChannelByGood(page,wrapper));
 	}

	 

}
