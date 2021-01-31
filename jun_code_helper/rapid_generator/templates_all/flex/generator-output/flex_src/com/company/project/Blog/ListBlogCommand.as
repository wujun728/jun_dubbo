/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */


package com.company.project.Blog
{
	
	import mx.rpc.IResponder;
	
	import javacommon.flex.base.*;
	import javacommon.flex.page.*;
	import javacommon.flex.util.*;
	
	import com.company.project.vo.*;

	
	public class ListBlogCommand extends DefaultResponder implements  IResponder,ICommand
	{
		private var pageRequest : PageRequest;
		private var model : BlogModelLocator = BlogModelLocator.getInstance();
		public function ListBlogCommand(pageRequest : PageRequest)
		{
			this.pageRequest = pageRequest;
		}
	
		public function execute():void
		{
			var delegate: BlogDelegate = new BlogDelegate(this);
			delegate.list(pageRequest);
		}
		
		override public function result(data:Object):void
		{
			model.list = data.result.result;
			if(model.list.length > 0){
				model.selectedItem = model.list.getItemAt(0) as Blog;
			}
			BeanUtils.copyProperties(model.page,data.result);
		}
		
	}
}