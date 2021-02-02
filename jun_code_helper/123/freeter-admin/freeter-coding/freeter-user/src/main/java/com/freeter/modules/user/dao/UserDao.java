package com.freeter.modules.user.dao;

import com.freeter.modules.user.entity.UserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.user.entity.vo.UserVO;
import com.freeter.modules.user.entity.view.UserView;


/**
 * 用户表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 13:55:47
 */
public interface UserDao extends BaseMapper<UserEntity> {
	
	List<UserVO> selectListVO(@Param("ew") Wrapper<UserEntity> wrapper);
	
	UserVO selectVO(@Param("ew") Wrapper<UserEntity> wrapper);
	
	
	List<UserView> selectListView(@Param("ew") Wrapper<UserEntity> wrapper);

	List<UserView> selectListView(Pagination page,@Param("ew") Wrapper<UserEntity> wrapper);
	
	UserView selectView(@Param("ew") Wrapper<UserEntity> wrapper);
}
