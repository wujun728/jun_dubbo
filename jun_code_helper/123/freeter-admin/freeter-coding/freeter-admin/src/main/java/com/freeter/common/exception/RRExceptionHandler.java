
package com.freeter.common.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.freeter.common.utils.R;

/**
 * 异常处理器
 *
 * @author xc 171998110@qq.com
 * @since 2018-06-22
 */
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RRException.class)
	public R handleRRException(RRException e){
		R r = new R();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}
 	@ExceptionHandler(DuplicateKeyException.class)
	public R handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return R.error("数据库中已存在该记录");
	}

	@ExceptionHandler(AuthorizationException.class)
	public R handleAuthorizationException(AuthorizationException e){
		logger.error(e.getMessage(), e);
		return R.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public R handleIllegalArgumentExceptionException(Exception e){
		logger.error(e.getMessage(), e);
		if("Error: entityList must not be empty".equals(e.getMessage())) {
			return R.error("数据不能为空");
		}
		return R.error(e.getMessage());
	}
	
	@ExceptionHandler(NullPointerException.class)
	public R handleNullPointerException(Exception e){
		logger.error(e.getMessage(), e);
		 
		return R.error(e.getMessage());
	}
	@ExceptionHandler(Exception.class)
	public R handleException(Exception e){
		logger.error(e.getMessage(), e);
		 

		if("Error: entityList must not be empty".equals(e.getMessage())) {
			return R.error("数据不能为空");
		}
		return R.error();
	}
	
}
