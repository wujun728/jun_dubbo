package net.chenlin.dp.shiro.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.chenlin.dp.common.utils.CaptchaUtil;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import net.chenlin.dp.common.annotation.SysLog;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.MD5Utils;
import net.chenlin.dp.common.utils.ShiroUtils;

/**
 * 用户controller
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午2:48:50
 */
@Controller
@RequestMapping("/sys")
public class SysLoginController {
	
	@Autowired
	private Producer producer;

	/**
	 * 验证码
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("/code.jpg")
	public void checkCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		int width = NumberUtils.toInt(request.getParameter("width"), 100);
		int height = NumberUtils.toInt(request.getParameter("height"), 30);
		int codeCount = NumberUtils.toInt(request.getParameter("codeCount"), 4);
		int lineCount = NumberUtils.toInt(request.getParameter("lineCount"), 10);
		if (width > 1000) {
			width = 100;
		}
		if (height > 300) {
			height = 30;
		}
		if (codeCount > 10) {
			codeCount = 4;
		}
		if (lineCount > 100) {
			lineCount = 10;
		}
		// 设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 自定义参数
		CaptchaUtil code = new CaptchaUtil(width, height, codeCount, lineCount);
		String sessionId = session.getId();
//		RedisUtil.set("captcha_" + sessionId, code.getCode(), 60 * 30);
		code.write(response.getOutputStream());
	}
	
	/**
	 * 验证码
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/captcha.jpg")
	public void captcha(HttpServletResponse response)throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
	}
	
	/**
	 * 登录
	 */
	@SysLog("登录")
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public R login(String username, String password, String captcha)throws IOException {
		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");
		}
		
		try{
			Subject subject = ShiroUtils.getSubject();
			//sha256加密
			password = MD5Utils.encrypt(username, password);
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
		}catch (UnknownAccountException e) {
			return R.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			return R.error(e.getMessage());
		}catch (LockedAccountException e) {
			return R.error(e.getMessage());
		}catch (AuthenticationException e) {
			return R.error("账户验证失败");
		}
	    
		return R.ok();
	}
	
	/**
	 * 退出
	 */
	@SysLog("退出系统")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();
		return "redirect:login.html";
	}
	
}
