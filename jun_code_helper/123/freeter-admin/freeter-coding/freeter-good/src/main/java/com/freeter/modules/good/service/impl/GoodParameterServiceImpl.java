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
import com.freeter.modules.good.dao.GoodParameterDao;
import com.freeter.modules.good.entity.GoodParameterEntity;
import com.freeter.modules.good.entity.view.GoodParameterView;
import com.freeter.modules.good.entity.vo.GoodParameterVO;
import com.freeter.modules.good.service.GoodParameterService;


@Service("goodParameterService")
public class GoodParameterServiceImpl extends ServiceImpl<GoodParameterDao, GoodParameterEntity> implements GoodParameterService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodParameterEntity> page = this.selectPage(
                new Query<GoodParameterEntity>(params).getPage(),
                new EntityWrapper<GoodParameterEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<GoodParameterVO> selectListVO( Wrapper<GoodParameterEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodParameterVO selectVO( Wrapper<GoodParameterEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodParameterView> selectListView(Wrapper<GoodParameterEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodParameterView selectView(Wrapper<GoodParameterEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
