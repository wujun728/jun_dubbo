package com.freeter.modules.user.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.exception.RRException;
import com.freeter.common.utils.JwtUtils;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.common.utils.R;
import com.freeter.common.validator.Assert;
import com.freeter.form.LoginForm;
import com.freeter.form.PhoneForm;
import com.freeter.form.RegisterForm;
import com.freeter.modules.user.dao.UserDao;
import com.freeter.modules.user.entity.UserEntity;
import com.freeter.modules.user.service.UserService;
import com.freeter.service.TokenService;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<UserEntity> page = this.selectPage(new Query<UserEntity>(params).getPage(),
				new EntityWrapper<UserEntity>());
		return new PageUtils(page);
	}

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setPhone(mobile);
		EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
		ew.setEntity(userEntity);
		return userService.selectOne(ew);
	}

	@Override
	public Map<String, Object> login(LoginForm form) {

		EntityWrapper<UserEntity> ew = new EntityWrapper<UserEntity>();
		UserEntity ue = new UserEntity(form);
		// 用户登录
		ew.setEntity(ue);
		ue = this.selectOne(ew);

		UserEntity user = queryByMobile(form.getPhone());
		Assert.isNull(user, "手机号或密码错误");

		// 密码错误
		if (!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))) {
			throw new RRException("手机号或密码错误");
		}

		// 获取登录token
		// TokenEntity tokenEntity = tokenService.createToken(user.getUserId());
		// 生成token

		/*
		 * Map<String, Object> map = new HashMap<>(2); map.put("token",
		 * tokenEntity.getToken()); map.put("expire",
		 * tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());
		 */
		String token = jwtUtils.generateToken(user.getUserId());
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("expire", jwtUtils.getExpire());

		return map;
	}

	@Override
	public R register(RegisterForm form) {

		UserEntity user = new UserEntity();
		user.setPhone(form.getPhone());
		user.setUserName(form.getPhone());
		if (!StringUtils.isEmpty(form.getPassword())) {
			
			user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
		}
		user.setRegeistTime(new Date());
		List<UserEntity> ue = userDao.queryUserLock(user);
		if (ue.size()>0) {
			return R.error("用户已经注册过了");
		}
		userService.insert(user);
		return R.ok();
	}
	
	@Override
	public Map speedRegister(PhoneForm form) {

		UserEntity user = new UserEntity(form);
		user.setUserName(form.getPhone());
		user.setRegeistTime(new Date());
		List<UserEntity> ue = userDao.queryUserLock(user);
		if (ue.size()>0) {
			String token = jwtUtils.generateToken(ue.get(0).getUserId());
			Map<String, Object> map = new HashMap<>();
			map.put("token", token);
			map.put("expire", jwtUtils.getExpire());
			return map;
		}
		userService.insert(user);
		String token = jwtUtils.generateToken(user.getUserId());
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("expire", jwtUtils.getExpire());
		return map;
		 
	}

}
