package com.freeter.common.mpextend.parser;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.annotation.MpIgnore;
import com.freeter.common.annotation.MpLike;
import com.freeter.common.annotation.OuterTable;
import com.freeter.common.annotation.OwnerTable;
import com.freeter.common.mpextend.CheckBeanExistOwnerTable;
import com.freeter.common.mpextend.OrderGoodModel;
import com.freeter.common.utils.MPUtil;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;

public class ParseWrapper {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static  EntityWrapper parseWrapper(Object t)  {
		EntityWrapper wrapper = new EntityWrapper();
		
		Field[] fArr = ReflectUtil.getFields(t.getClass());
		OuterTable outer = t.getClass().getAnnotation(OuterTable.class);
		OwnerTable owner = t.getClass().getAnnotation(OwnerTable.class);
		 
		Map<String, Object> map = BeanUtil.beanToMap(t, true, true);
		 
 		
		boolean ifOwner = CheckBeanExistOwnerTable.checkBeanExistUseOwnerTable(t, owner);
 		
 		
 		
 		for (Field field : fArr) {
			field.setAccessible(true);
			try {
				if (field.get(t) == null) {
					continue;
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				//return null
				continue;
			}

			boolean ignore = field.isAnnotationPresent(MpIgnore.class);
			String fieldName = field.getName();
			String camelFieldName = MPUtil.camelToUnderline(fieldName);

			boolean fieldHasLikeAnno = field.isAnnotationPresent(MpLike.class);

			boolean fieldHasOuterTableAnno = field.isAnnotationPresent(OuterTable.class);

			if (ignore) {
				map.remove(camelFieldName);
				continue;
			}
			
			
			
			if (owner != null) {
				Class ownerClass = owner.value();
				
				Field ownerField = ReflectUtil.getField(ownerClass, fieldName);
				if (fieldHasOuterTableAnno) {
					OuterTable fieldOuterAnno = field.getAnnotation(OuterTable.class);
					Class[] classArr = fieldOuterAnno.value();
					if (classArr.length > 0) {
						ownerClass = classArr[0];
					}
				}
				if (ownerField != null || fieldHasOuterTableAnno) {

					if(ifOwner) {
						ownerClass = null;
					}
					ParseBetweenWrapper.parseWrapper(wrapper, map, field, camelFieldName, ownerClass);
					ParseInWrapper.parseWrapper(wrapper, map, field, camelFieldName, ownerClass);

					if (fieldHasLikeAnno) {
						ParseLikeWrapper.parseWrapper(wrapper, map, field, camelFieldName, ownerClass);
					} else {
						ParseEQWrapper.parseWrapper(wrapper,map,field, camelFieldName, ownerClass);
					}
				}

				else if (outer != null) {
					
					Class[] outerArr = outer.value();

					for (Class outerTableClassName : outerArr) {
						Field outerField = CheckFieldOnClass.checkFieldOnClass(fieldName, outerTableClassName);
						if (outerField != null) {
							ParseBetweenWrapper.parseWrapper(wrapper, map, field, camelFieldName, outerTableClassName);
							ParseInWrapper.parseWrapper(wrapper, map, outerField, camelFieldName, outerTableClassName);
							if (fieldHasLikeAnno) {
								ParseLikeWrapper.parseWrapper(wrapper, map, field, camelFieldName, outerTableClassName);
							} else {
								ParseEQWrapper.parseWrapper(wrapper,map, field,camelFieldName, outerTableClassName);
							}

						}
					}
				}
			}
		}

		FilterMap.filterMap(t, map);
 		if(map.isEmpty()) {
			wrapper.eq("1", 1);
		}
		wrapper.allEq(map);
		String sql = wrapper.getSqlSegment();

		System.out.println(sql);
		return wrapper;
	}


	
	public static void main(String[] ages) throws Exception {
 		OrderGoodModel ogd = new OrderGoodModel();
		ogd.setGoodId(1);
		ogd.setGoodCount(2);
		ogd.setGoodName("TEST");
		ogd.setGoodSpec("223");
		//ogd.setUserId(32);
		ogd.setOrderNo("222");
		//unitPrice
		ogd.setUnitPrice(new BigDecimal(0));
		ogd.setIds(new Integer[] {1,2,3});
		ogd.setIdstr("1,2,3");
		parseWrapper(ogd);
	}
}
