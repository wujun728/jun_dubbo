package com.freeter.common.mpextend.parser;

import java.lang.reflect.Field;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.annotation.MpLike;
import com.freeter.common.annotation.OuterTable;
import com.freeter.common.mpextend.ClearSuffix;
import com.freeter.common.utils.MPUtil;

import cn.hutool.core.util.StrUtil;

public class ParseLikeWrapper {

	public static void parseWrapper(EntityWrapper wrapper, Map<String, Object> map, Field field, String camelFieldName,
			Class ownerClass) {
		MpLike fieldAnno = field.getAnnotation(MpLike.class);
		OuterTable outer = field.getAnnotation(OuterTable.class);
		Object value = (Object) map.get(camelFieldName);
		map.remove(MPUtil.camelToUnderline(field.getName()));
		Class[] tables = {};
		if (outer != null) {
			tables = outer.value();
		}

 		int realNameLength = 0;
		String[] classRealNameArr = new String[]{};
		if(fieldAnno != null) {
			
			classRealNameArr = fieldAnno.value();
			realNameLength = classRealNameArr.length;
		}
 		if (realNameLength > 0) {
			if (realNameLength > 1) {
				wrapper.eq("1", 1);
				wrapper.andNew();
			}
			for (int i = 0; i < realNameLength; i++) {
				if (tables.length == realNameLength) {
					ownerClass = tables[i];
				}
				camelFieldName = MPUtil.camelToUnderline(classRealNameArr[i]);
				if(value == null) {
					value = "";
				}
				wrapper.like(StrUtil.toUnderlineCase(ClearSuffix.clearSuffix(ownerClass))  
						+ camelFieldName, value.toString());
				if (i != realNameLength - 1) {
					wrapper.or();
				}

				if (i == classRealNameArr.length - 1 && i > 0) {
					wrapper.andNew();
				}

			}

		}

		else {

			wrapper.like(
					StrUtil.toUnderlineCase(ClearSuffix.clearSuffix(ownerClass)) + camelFieldName,
					value.toString());

		}

	}

}
