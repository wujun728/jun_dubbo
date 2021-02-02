package com.freeter.common.mpextend.parser;

import java.lang.reflect.Field;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.freeter.common.annotation.ConditionType;
import com.freeter.common.annotation.MpBetween;
import com.freeter.common.annotation.OuterTable;
import com.freeter.common.mpextend.ClearSuffix;
import com.freeter.common.utils.MPUtil;

import cn.hutool.core.util.StrUtil;

public class ParseBetweenWrapper {

	 
	public static void parseWrapper(EntityWrapper wrapper, Map<String, Object> map, Field field, String camelFieldName,
			Class ownerClass) {
		MpBetween fieldBTAnno = field.getAnnotation(MpBetween.class);
		if(fieldBTAnno == null) {
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
		if(fieldBTAnno != null) {
			
			classRealNameArr = fieldBTAnno.value();
			if(StringUtils.isNotEmpty(classRealNameArr)) {
				camelFieldName =MPUtil.camelToUnderline(classRealNameArr);
			}
			ConditionType type =fieldBTAnno.type();
			 genBetweenWrapper(wrapper, camelFieldName, ownerClass, value, type);
			 
		}
		 
		 
	
	}

	public static void genBetweenWrapper(EntityWrapper wrapper, String camelFieldName, Class ownerClass, Object value,
			ConditionType type) {
		if(type.equals(ConditionType.$gt)) {
			 wrapper.gt(StrUtil.toUnderlineCase(ClearSuffix.clearSuffix(ownerClass)) + camelFieldName, value);
			 return;
		 }
		 if(type.equals(ConditionType.$lt)) {
			 wrapper.lt(StrUtil.toUnderlineCase(ClearSuffix.clearSuffix(ownerClass)) + camelFieldName, value);
			 return;
		 }
		 if(type.equals(ConditionType.$gte)) {
			 wrapper.ge(StrUtil.toUnderlineCase(ClearSuffix.clearSuffix(ownerClass)) + camelFieldName, value); 
			 return;
		 }
		 if(type.equals(ConditionType.$lte)) {
			 wrapper.le(StrUtil.toUnderlineCase(ClearSuffix.clearSuffix(ownerClass)) + camelFieldName, value);
			 return; 
		 }
	}

}
