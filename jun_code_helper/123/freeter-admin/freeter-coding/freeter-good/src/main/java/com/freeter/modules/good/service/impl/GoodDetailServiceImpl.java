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
import com.freeter.modules.good.dao.GoodDetailDao;
import com.freeter.modules.good.entity.GoodDetailEntity;
import com.freeter.modules.good.entity.view.GoodDetailView;
import com.freeter.modules.good.entity.vo.GoodDetailVO;
import com.freeter.modules.good.service.GoodDetailService;


@Service("goodDetailService")
public class GoodDetailServiceImpl extends ServiceImpl<GoodDetailDao, GoodDetailEntity> implements GoodDetailService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodDetailEntity> page = this.selectPage(
                new Query<GoodDetailEntity>(params).getPage(),
                new EntityWrapper<GoodDetailEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<GoodDetailVO> selectListVO( Wrapper<GoodDetailEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodDetailVO selectVO( Wrapper<GoodDetailEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodDetailView> selectListView(Wrapper<GoodDetailEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodDetailView selectView(Wrapper<GoodDetailEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
