package com.freeter.modules.user.api.controller;

import java.io.IOException;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.freeter.common.util.Constant;
import com.freeter.common.util.SMSUtil;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.RedisUtils;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.form.SpeedForm;
import com.freeter.modules.user.entity.UserEntity;
import com.freeter.modules.user.entity.view.UserView;
import com.freeter.modules.user.service.UserService;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


/**
 * 用户表
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-19 13:46:34
 */
@RestController
@RequestMapping("user")
@Api(tags="用户表接口")
public class UserApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;


    /**
     * 发送验证码
     */
    @GetMapping("sendCodeResetPass")
    @ApiOperation("修改密码发送短信验证码")
    public R sendCode(String userId){
        UserEntity userEntity=userService.selectById(userId);
        String phone=userEntity.getUserName();
        //ValidatorUtils.validateEntity(phone);
        if( redisUtils.get(Constant.RESET_PASS_SMS_OVERTIME_KEY+phone)!= null) {
            return R.error("发送验证码比较频繁，等一分钟之后再试试");
        }
        String number = RandomUtil.randomNumbers(6);
        SMSUtil.sendSMS(phone, "尊敬的用户：您的校验码："+number+"，工作人员不会索取，请勿泄漏。", "0");
        redisUtils.set(Constant.RESET_PASS_SMS_CODE_KEY+phone, number, 60 * 15);
        redisUtils.set(Constant.RESET_PASS_SMS_OVERTIME_KEY+phone, number, 60 * 1);
        return R.ok("验证码获取成功").put("data", number);
    }

    /**
     * 修改密码
     */
    @PostMapping("resetPass")
    @ApiOperation("修改密码")
    public R resetPass(Integer userId,String password,String confirmPassword,String code){
        UserEntity userEntity=userService.selectById(userId);
        String phone=userEntity.getUserName();
        Assert.notBlank(code,"短信验证码不能为空");
        String codeRedis = redisUtils.get(Constant.RESET_PASS_SMS_CODE_KEY+phone);
        if(codeRedis == null) {
            return R.error("验证码已经失效，请重新获取");
        }
        if(code.equals(codeRedis)) {
            return R.error("输入验证码有误，请重新填写");
        }

        if(password==null || "".equals(password)){
            return R.error("新密码不能为空");
        }
        if(confirmPassword==null || "".equals(confirmPassword)){
            return R.error("请确认新密码");
        }
        if(!password.equals(confirmPassword)){
            return R.error("二次密码输入不一致,请重新输入新密码");
        }
        EntityWrapper<UserEntity> entityWrapper=new EntityWrapper<UserEntity>();
        userEntity.setPassword(password);
        entityWrapper.setEntity(userEntity);
        userService.updateAllColumnById(userEntity);
        return R.ok("修改密码成功");
    }


    /**
     * 设置图像
     */
    @PostMapping("setHeadPortrait")
    @ApiOperation("设置头像")
    public R setImage(String headPortraitUrl,String userId) throws FileUploadException {

          EntityWrapper<UserEntity> userEntityWrapper=new EntityWrapper<UserEntity>();
          Wrapper<UserEntity> userWrapper=userEntityWrapper.eq("id",userId);
          UserEntity userEntity=userService.selectOne(userWrapper);
          userEntity.setPicImg(headPortraitUrl);
          userService.updateAllColumnById(userEntity);
          return R.ok("图像设置成功");

    }

    /**
     * 设置昵称
     */
    @PostMapping("setNickName")
    @ApiOperation("设置昵称")
    public R setNickName(String nickName,String userId) throws FileUploadException {

        EntityWrapper<UserEntity> userEntityWrapper=new EntityWrapper<UserEntity>();
        Wrapper<UserEntity> userWrapper=userEntityWrapper.eq("id",userId);
        UserEntity userEntity=userService.selectOne(userWrapper);
        userEntity.setUserName(nickName);
        userService.updateAllColumnById(userEntity);
        return R.ok("昵称设置成功");

    }


    /**
     * 实名认证
     */
    @PostMapping("realNameAuth")
    @ApiOperation("实名认证")
    public R realNameAuth(String realName,String idCard,String idCardFrontImg,String idCardBackImg,String userId){
         EntityWrapper<UserEntity> userEntityWrapper=new EntityWrapper<UserEntity>();
         Wrapper<UserEntity> userWrapper=userEntityWrapper.eq("id",userId);
         UserEntity userEntity=userService.selectOne(userWrapper);
         userEntity.setRealName(realName);
         userEntity.setIdCard(idCard);
         userEntity.setIdcardFrontImg(idCardFrontImg);
         userEntity.setIdcardBackImg(idCardBackImg);
         userService.updateAllColumnById(userEntity);
         return R.ok("实名认证通过");
    }


}
