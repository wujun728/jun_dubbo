package com.gf.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Title:RecordLogUtil </p>
 * <p>Description: 记录日志工具类 </p>
 * <p>Company: </p>
 * @author lijiang
 * @date 2016-6-12
 */
public class RecordLogUtil {

	//	private static Logger logger = Logger.getLogger(RecordLogUtil.class);
	private static Logger logger = LoggerFactory.getLogger(RecordLogUtil.class);
	private static String split  = ", ";
	private static String user   = "用户=";
	private static String param  = "参数=";
	private static int LV = 2;//调用层级

	/**
	 *
	 * <p>Title: getClassName
	 * <p>Description: 得到调用者的名字
	 * @author lijiang lijiang@youedata.com
	 * @date 2016年8月22日
	 */
	private static void setClassName() {
		Throwable ex = new Throwable();
		StackTraceElement[] stackElements = ex.getStackTrace();
		if (stackElements != null) {
			String clazz = stackElements[LV].getClassName() + "." + stackElements[LV].getMethodName();
			logger = LoggerFactory.getLogger(clazz);
		} else {
			logger = LoggerFactory.getLogger(RecordLogUtil.class);
		}
	}

	/**
	 *
	 * <p>Title: getClassName
	 * <p>Description: 得到调用者的名字
	 * @author lijiang lijiang@youedata.com
	 * @date 2016年8月22日
	 */
	private static void setClassName(int lv) {
		Throwable ex = new Throwable();
		StackTraceElement[] stackElements = ex.getStackTrace();
		if (stackElements != null) {
			String clazz = stackElements[lv].getClassName() + "." + stackElements[lv].getMethodName();
			logger = LoggerFactory.getLogger(clazz);
		} else {
			logger = LoggerFactory.getLogger(RecordLogUtil.class);
		}
	}

	/**
	 * 记录追踪常规日志
	 * @param userName
	 * @param method
	 * @param args
	 */
	public static void traceLog(String userName, String method, Object args) {
		setClassName();
		logger.info(getLogMsg(userName, method, args));
	}
	/**
	 * 记录异常日志
	 * @param userName
	 * @param method
	 * @param args
	 */
	public static void errorLog(String userName, String method, Object args, Throwable e) {
		setClassName();
		logger.error(getLogMsg(userName, method, args), e);
	}

	/**
	 * 得到封装后的参数信息
	 * @param userName
	 * @param method
	 * @param args
	 * @return
	 */
	private static String getLogMsg(String userName, String method, Object args) {
		StringBuffer infoMsg = new StringBuffer();
		infoMsg.append(method);
		infoMsg.append(split);
		infoMsg.append(user);
		infoMsg.append(userName);
		if (args != null) {
			infoMsg.append(split);
			infoMsg.append(param);
			infoMsg.append(args);
		}
		return infoMsg.toString();
	}

	/**
	 * 针对单一的日志记录
	 * @param msg
	 */
	public static void info(String msg) {
		setClassName();
		logger.info(msg);
	}

	/**
	 * 针对单一的日志记录
	 * @param msg
	 */
	public static void info(String... msg) {
		if (msg.length < 2) {
			return;
		}
		setClassName();
		logger.info(msg[0], msg[1]);
	}

	/**
	 * 只提供错误信息和异常信息
	 * @param msg
	 * @param e
	 */
	public static void error(String msg, Throwable e) {
		setClassName();
		logger.error(msg, e);
	}

	/**
	 * 只提供错误信息和异常信息
	 * @param msg
	 */
	public static void error(String msg) {
		setClassName();
		logger.error(msg);
	}
	/**
	 * 只提供错误信息和异常信息
	 * @param msg
	 * @param e
	 */
	public static void error(String msg, Throwable e, int lv) {
		setClassName(lv);
		logger.error(msg, e);
	}

	/**
	 * 只提供错误信息和异常信息
	 * @param msg
	 */
	public static void error(String msg, int lv) {
		setClassName(lv);
		logger.error(msg);
	}
}
