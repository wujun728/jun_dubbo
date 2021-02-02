package com.freeter.common.mpextend.parser;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.freeter.common.annotation.OwnerTable;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;

public class FilterMap  {

	public static <T> void filterMap(T t, Map<String, Object> map) {
		Map<String, Object> beanMap = BeanUtil.beanToMap(t, true, true);
		Set<String> set = beanMap.keySet();
		Set<String> mapSet = map.keySet();
		Iterator<String> iterator =mapSet.iterator();

		while (iterator.hasNext()) {
			String key = iterator.next();
			if (beanMap.containsKey(key)) {
				OwnerTable owner = t.getClass().getAnnotation(OwnerTable.class);
				Field ownerField = ReflectUtil.getField(owner.value(), StrUtil.toCamelCase(key));
				
				if(ownerField != null) {
					continue;
				}
				map.remove(key);
			}
		 

		}
		 
		 
	}

}
