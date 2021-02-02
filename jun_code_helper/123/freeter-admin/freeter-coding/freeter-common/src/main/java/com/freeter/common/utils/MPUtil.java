package com.freeter.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.mapper.Wrapper;

import cn.hutool.core.bean.BeanUtil;

/**
 * Mybatis-Plus工具类
 *
 * @author xc 171998110@qq.com
 * @since 3.0.0
 */
public class MPUtil {
	public static final char UNDERLINE = '_';

	
	//mybatis plus allEQ 表达式转换
		public static Map allEQMapPre(Object bean,String pre) {
		   Map<String, Object> map =BeanUtil.beanToMap(bean);
		  return camelToUnderlineMap(map,pre);
	   }

		//mybatis plus allEQ 表达式转换
		public static Map allEQMap(Object bean) {
		   Map<String, Object> map =BeanUtil.beanToMap(bean);
		   return camelToUnderlineMap(map,"");
	   }

		public static Wrapper allLikePre(Wrapper wrapper,Object bean,String pre) {
			   Map<String, Object> map =BeanUtil.beanToMap(bean);
			   Map result = camelToUnderlineMap(map,pre);
			 
			return genLike(wrapper,result);
		}
	
		public static Wrapper allLike(Wrapper wrapper,Object bean) {
			  Map result = BeanUtil.beanToMap(bean, true, true);			 
			return genLike(wrapper,result);
		}
	
	
		public static Wrapper genLike( Wrapper wrapper,Map param) {
			Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> entry = it.next();
				String key = entry.getKey();
				String value = (String) entry.getValue();
				wrapper.like(key, value);
				wrapper.or();
			}
			return wrapper;
		}
	
	
	
	
	
	
	
	/**
	 * 驼峰格式字符串转换为下划线格式字符串
	 * 
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append(UNDERLINE);
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] ages) {
		System.out.println(camelToUnderline("ABCddfANM"));
	}
	
	public static Map camelToUnderlineMap(Map param, String pre) {

		Map<String, Object> newMap = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = camelToUnderline(key);
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {

				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		return newMap;
	}
}
