package com.freeter.modules.user.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.form.LoginForm;
import com.freeter.form.PhoneForm;
import com.freeter.form.RegisterForm;
import com.freeter.modules.user.entity.UserEntity;

/**
 * 用户表
 *
 * @author liuqi
 * @email 171998110@qq.com
 * @date 2018-05-19 13:46:34
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

	UserEntity queryByMobile(String mobile);

	Map<String, Object> login(LoginForm form);
	
	
	R register(RegisterForm form);

	Map speedRegister(PhoneForm form);
}

