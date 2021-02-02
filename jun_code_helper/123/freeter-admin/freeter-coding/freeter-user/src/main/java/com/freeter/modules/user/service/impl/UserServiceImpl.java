package com.freeter.modules.user.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;

import com.freeter.modules.user.dao.UserDao;
import com.freeter.modules.user.entity.UserEntity;
import com.freeter.modules.user.service.UserService;
import com.freeter.modules.user.entity.vo.UserVO;
import com.freeter.modules.user.entity.view.UserView;
import com.freeter.common.utils.PageInfo;

@SuppressWarnings({"unchecked","rawtypes"})
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {


    @Override
	public PageUtils queryPage(PageInfo pageInfo, Wrapper<UserEntity> wrapper) {
		  	Page<UserView> page =pageInfo.getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<UserVO> selectListVO( Wrapper<UserEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public UserVO selectVO( Wrapper<UserEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<UserView> selectListView(Wrapper<UserEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public UserView selectView(Wrapper<UserEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
