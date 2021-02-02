package com.freeter.common.mpextend.parser;

import java.lang.reflect.Field;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.freeter.common.annotation.ConditionType;
import com.freeter.common.annotation.MpBetween;
import com.freeter.common.annotation.MpIn;
import com.freeter.common.annotation.OuterTable;
import com.freeter.common.mpextend.ClearSuffix;
import com.freeter.common.utils.MPUtil;

import cn.hutool.core.util.StrUtil;

public class ParseInWrapper {

	 
	public static void parseWrapper(EntityWrapper wrapper, Map<String, Object> map, Field field, String camelFieldName,
			Class ownerClass) {
		MpIn fieldInAnno = field.getAnnotation(MpIn.class);
		if(fieldInAnno == null) {
			return;
		}
		OuterTable outer = field.getAnnotation(OuterTable.class);
		Object value = (Object) map.get(camelFieldName);
		map.remove(camelFieldName);
		Class[] tables = {};
		if (outer != null) {
			tables = outer.value();
		}
		int realNameLength = 0;
		String  classRealNameArr = "";
		if(fieldInAnno != null) {
			
			classRealNameArr = fieldInAnno.value();
			if(StringUtils.isNotEmpty(classRealNameArr)) {
				camelFieldName =MPUtil.camelToUnderline(classRealNameArr);
			}
			if(value instanceof Object[]) {
				wrapper.in(StrUtil.toUnderlineCase(ClearSuffix.clearSuffix(ownerClass))  
						+ camelFieldName, (Object[])value);
			}
			if(value instanceof String) {
				wrapper.in(StrUtil.toUnderlineCase(ClearSuffix.clearSuffix(ownerClass))  
						+ camelFieldName, (String)value);
			}
 			
 			
			 
		}
		 
		 
	
	}

	 

}
