/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */

 
package com.company.project.Blog
{
	import com.adobe.cairngorm.business.ServiceLocator;
	import mx.rpc.remoting.mxml.RemoteObject;
	import mx.rpc.AsyncToken;
	import mx.rpc.IResponder;
	
	import javacommon.flex.base.*;
	import javacommon.flex.page.*;
	import javacommon.flex.util.*;
	
	import com.company.project.vo.*;

	
	public class BlogDelegate extends DelegateBase
	{
		private var blogFlexService: Object;
		public function BlogDelegate(responder:IResponder)
		{
			this.responder = responder;
			//this.blogFlexService = ServiceLocator.getInstance().getRemoteObject("blogFlexService");
			this.blogFlexService = new RemoteObject("blogFlexService");
			this.blogFlexService.endpoint = '../messagebroker/amf';
			this.blogFlexService.showBusyCursor = true;
		}
		
		public function save(blog:Blog):void{
			var call:AsyncToken = blogFlexService.save(blog);
			call.addResponder(this.responder);
		}
				
		public function del(ids:Array):void{
			var call:AsyncToken = blogFlexService.del(ids);
			call.addResponder(this.responder);
		}
		
		public function list(pageRequest:PageRequest):void{
			var call:AsyncToken = blogFlexService.list(pageRequest);
			call.addResponder(this.responder);
		}
		
	}
	
}