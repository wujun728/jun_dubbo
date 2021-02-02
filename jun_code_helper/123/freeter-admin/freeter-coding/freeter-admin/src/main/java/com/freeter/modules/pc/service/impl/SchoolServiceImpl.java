package com.freeter.modules.pc.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;

import com.freeter.modules.pc.dao.SchoolDao;
import com.freeter.modules.pc.entity.SchoolEntity;
import com.freeter.modules.pc.service.SchoolService;
import com.freeter.modules.pc.entity.vo.SchoolVO;
import com.freeter.modules.pc.entity.view.SchoolView;


@Service("schoolService")
public class SchoolServiceImpl extends ServiceImpl<SchoolDao, SchoolEntity> implements SchoolService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SchoolEntity> page = this.selectPage(
                new Query<SchoolEntity>(params).getPage(),
                new EntityWrapper<SchoolEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public List<SchoolVO> selectListVO( Wrapper<SchoolEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SchoolVO selectVO( Wrapper<SchoolEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SchoolView> selectListView(Wrapper<SchoolEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SchoolView selectView(Wrapper<SchoolEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
