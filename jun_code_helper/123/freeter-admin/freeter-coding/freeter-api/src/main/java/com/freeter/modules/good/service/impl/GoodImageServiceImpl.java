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
import com.freeter.modules.good.dao.GoodImageDao;
import com.freeter.modules.good.entity.GoodImageEntity;
import com.freeter.modules.good.entity.vo.GoodImageVO;
import com.freeter.modules.good.service.GoodImageService;


@Service("goodImageService")
public class GoodImageServiceImpl extends ServiceImpl<GoodImageDao, GoodImageEntity> implements GoodImageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodImageEntity> page = this.selectPage(
                new Query<GoodImageEntity>(params).getPage(),
                new EntityWrapper<GoodImageEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<GoodImageVO> selectListVO( Wrapper<GoodImageEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodImageVO selectVO( Wrapper<GoodImageEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

}
