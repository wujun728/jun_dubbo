/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */


package com.company.project.vo{
	
	import javacommon.flex.base.*;
	import javacommon.flex.page.*;
	import javacommon.flex.util.*;
	
	import com.company.project.vo.*;

	
	[Bindable]
	[RemoteClass(alias="com.company.project.model.Blog")]
	public class Blog extends BaseEntity
	{
		
		//alias
		public static const ALIAS_ID:String = "id";
		public static const ALIAS_USERNAME:String = "username";
		public static const ALIAS_BIRTH_DATE:String = "birthDate";
		public static const ALIAS_SEX:String = "sex";
		public static const ALIAS_TITLE:String = "title";
		public static const ALIAS_LENGTH:String = "length";
		public static const ALIAS_CONTENT:String = "content";

		//date formats
		public static const FORMAT_BIRTH_DATE : String = DATE_FORMAT;
				
		//columns START
		public var id:Number;
		public var username:String;
		public var birthDate:Date;
		public var sex:String;
		public var title:String;
		public var length:Number;
		public var content:String;
		//columns END

		public function get birthDateString():String{
			return DateConvertUtils.format(this.birthDate,FORMAT_BIRTH_DATE);
		}		
		
		
	}
	
	
}