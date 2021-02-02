package com.freeter.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freeter.annotation.Login;
import com.freeter.common.util.Constant;
import com.freeter.common.util.SMSUtil;
import com.freeter.common.utils.R;
import com.freeter.common.utils.RedisUtils;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.form.LoginForm;
import com.freeter.form.PhoneForm;
import com.freeter.form.SpeedForm;
import com.freeter.modules.user.service.UserService;
import com.freeter.service.TokenService;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 登录接口
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/login")
@Api(tags="登录接口")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisUtils redisUtils;
    
    @PostMapping("sign")
    @ApiOperation("登录")
    @Login
    public R login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);
        
        //用户登录
        Map<String, Object> map = userService.login(form);

        return R.ok(map);
    }

    @Login
    @GetMapping("sendCode")
    @ApiOperation("发送短信验证码")
    public R sendCode( SpeedForm form){
    	  //表单校验
    	ValidatorUtils.validateEntity(form);
    	 if( redisUtils.get(Constant.SMS_OVERTIME_KEY+form.getPhone())!= null) {
        	 return R.error("发送验证码比较频繁，等一分钟之后再试试");
        }
    	String number = RandomUtil.randomNumbers(6);
        SMSUtil.sendSMS(form.getPhone(), "尊敬的用户：您的校验码："+number+"，工作人员不会索取，请勿泄漏。", "0");   
        redisUtils.set(Constant.SMS_CODE_KEY+form.getPhone(), number, 60 * 15);
        redisUtils.set(Constant.SMS_OVERTIME_KEY+form.getPhone(), number, 60 * 1);
        return R.ok("验证码获取成功").put("data", number);
    }
    
    @Login
    @PostMapping("speedLogin")
    @ApiOperation("快捷登陆")
    public R speedLogin(PhoneForm form){
        //表单校验
    	ValidatorUtils.validateEntity(form);
    	Assert.notBlank(form.getCode(),"短信验证码不能为空");
    	String code = redisUtils.get(Constant.SMS_CODE_KEY+form.getPhone());
    	if(code == null) {
    		return R.error("验证码已经失效，请重新获取");
    	}
    	if(!form.getCode().equals(code)) {
    		   return R.error("输入验证码有误，请重新填写");
    	}
    	
         return R.ok(userService.speedRegister(form));
    }
    
    
    @PostMapping("logout")
    @ApiOperation("退出")
    public R logout(@ApiIgnore @RequestAttribute("userId") long userId){
        tokenService.expireToken(userId);
        return R.ok();
    }

}
