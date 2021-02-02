package com.freeter.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.hutool.core.util.StrUtil;

public class GenUtils {
	public static final char UNDERLINE = '_';

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
	   System.out.println(StrUtil.toUnderlineCase("ABCddfANM"));
   }
   
   public static Map camelToUnderlineMap(Map param,String pre) {
	
   	 Map<String, Object> newMap = new HashMap<String, Object>();
   	    Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
   	    while (it.hasNext()) {
   	      Map.Entry<String, Object> entry = it.next();
   	      String key = entry.getKey();
   	      String newKey = camelToUnderline(key);
   	     //StrUtil.toUnderlineCase(key);
   	      newMap.put(pre+newKey, entry.getValue());
   	    }
   	    return newMap;
   }
}
