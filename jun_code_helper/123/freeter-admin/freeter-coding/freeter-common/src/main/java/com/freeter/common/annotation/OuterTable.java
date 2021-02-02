package com.freeter.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义关联表的别名
 *
 * @author freeter 171998110@qq.com
 * @since 3.0.0 2018-08-13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE,ElementType.FIELD})
@Documented
public @interface OuterTable {
	
	 /**
     * <p>
     * 关联表的类名 
     * 格式 前缀t_  PersonDetail -->  t_person_detail 
     * </p>
     */
	 Class[] value() default{}; 
	 
	 
}
