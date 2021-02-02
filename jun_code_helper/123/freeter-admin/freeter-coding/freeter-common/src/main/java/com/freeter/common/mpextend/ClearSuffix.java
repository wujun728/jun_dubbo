package com.freeter.common.mpextend;

import java.lang.reflect.Field;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import cn.hutool.core.util.StrUtil;

public   class  ClearSuffix {

	public  static String clearSuffix(Class className) {
		if(className == null) {
			return "";
		}
		 
		return StrUtil.removeSuffix(className.getSimpleName(), "Entity")+".";
	}

	
 
}
