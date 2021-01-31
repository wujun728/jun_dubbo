/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */


package com.company.project.Blog
{
	
	import javacommon.flex.base.*;
	import javacommon.flex.page.*;
	import javacommon.flex.util.*;
	
	import com.company.project.vo.*;

	
	import mx.rpc.IResponder;
	
	public class DeleteBlogCommand extends BaseResponder implements IResponder,ICommand
	{
		[Bindable]
		private var model : BlogModelLocator = BlogModelLocator.getInstance();
		private var ids : Array;
		public function DeleteBlogCommand(ids : Array)
		{
			this.ids = ids;
		}
	
		public function execute():void
		{
			var delegate: BlogDelegate = new BlogDelegate(this);
			delegate.del(ids);
		}
		
		override public function result(data:Object):void
		{
			CollectionUtils.removeByPropertyEqual(model.list,'id',ids);
			if(model.list.length > 0) {
				model.selectedItem = model.list.getItemAt(0) as Blog;
			}else {
				model.selectedItem = new Blog();
			}
		}
		
	}
}