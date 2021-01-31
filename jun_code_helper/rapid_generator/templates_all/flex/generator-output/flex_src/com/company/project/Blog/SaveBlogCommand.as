/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */


package com.company.project.Blog
{
	
	import mx.collections.ArrayCollection;
	import mx.rpc.IResponder;
	
	import javacommon.flex.base.*;
	import javacommon.flex.page.*;
	import javacommon.flex.util.*;
	
	import com.company.project.vo.*;

	
	public class SaveBlogCommand extends DefaultResponder implements  IResponder,ICommand
	{
		private var model :BlogModelLocator = BlogModelLocator.getInstance();
		
		private var blog : Blog;
		
		public function SaveBlogCommand(blog : Blog)
		{
			this.blog = blog;
		}
	
		public function execute():void
		{
			var delegate: BlogDelegate = new BlogDelegate(this);
			delegate.save(blog);
		}
		
		override public function result(data:Object):void
		{
			var blog:Blog = data.result as Blog;
			if(CollectionUtils.isPropertyEqual(model.list,blog,"id")) {
				// is update
				BeanUtils.copyProperties(model.selectedItem,data.result);
				model.list.refresh();
			}else {
				// is new 
				model.list.addItemAt(blog, 0);
				model.selectedItem = blog;
			}
		}
		
	}
}