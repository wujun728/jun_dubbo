package com.freeter.common.mpextend.parser;

import java.lang.reflect.Field;

public class CheckFieldOnClass   {

	
	public static Field checkFieldOnClass(String fieldName, Class className) {
		Field[] Fields = className.getDeclaredFields();

		Field Field = null;
		for (int i = 0; i < Fields.length; i++) {
			if (Fields[i].getName() == fieldName) {
				Field = Fields[i];
				break;
			}
		}
		return Field;
	}

}
