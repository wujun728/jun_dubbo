package com.freeter.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 定义所在表的别名
 *
 * @author freeter 171998110@qq.com
 * @since 3.0.0 2018-08-13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface OwnerTable {
	 /**
     * <p>
     * 所在表的类名
     * 请指定类名默认由代码生成器生成的别名 
     * </p>
     */
	 Class value() ; 
	 
	 
}
