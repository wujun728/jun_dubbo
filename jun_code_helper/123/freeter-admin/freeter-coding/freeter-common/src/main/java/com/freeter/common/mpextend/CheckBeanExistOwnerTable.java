package com.freeter.common.mpextend;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import com.freeter.common.annotation.MpLike;
import com.freeter.common.annotation.OuterTable;
import com.freeter.common.annotation.OwnerTable;
import com.freeter.common.mpextend.parser.CheckFieldOnClass;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;

public class CheckBeanExistOwnerTable {
	public static <T> boolean checkBeanExistUseOwnerTable(T t, OwnerTable owner) {
		Map<String, Object> keyMap = BeanUtil.beanToMap(t, false, true);
 		Set<String> setkey = keyMap.keySet();
 		boolean ifOwner = true;
 		if(owner != null) {
 			ifOwner = true;
 			for(String key:setkey) {
 				Field f = ReflectUtil.getField(owner.value(), key); 
 				
 				
 				if(f == null) {
 					ifOwner = false;
 					break;
 				}

 				if(f.isAnnotationPresent(OuterTable.class)) {
 					ifOwner = false;
 					break;
 				}
 	 		}
 		}
		return ifOwner;
	}
	
	 
}
