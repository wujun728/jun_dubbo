package com.freeter.modules.user.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.freeter.modules.user.entity.UserEntity;

/**
 * 用户表
 * 
 * @author liuqi
 * @email 171998110@qq.com
 * @date 2018-05-19 13:46:34
 */
public interface UserDao extends BaseMapper<UserEntity> {

	public List<UserEntity> queryUserLock(UserEntity ue);

}
