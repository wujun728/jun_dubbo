/*
 * Copyright 2008 [rapid-framework], Inc. All rights reserved.
 * Website: http://www.rapid-framework.org.cn
 */


package com.company.project.Blog{
	import com.adobe.cairngorm.model.IModelLocator;
	
	import mx.collections.ArrayCollection;
	
	import javacommon.flex.base.*;
	import javacommon.flex.page.*;
	import javacommon.flex.util.*;
	
	import com.company.project.vo.*;

	[Bindable]
	 public class BlogModelLocator implements IModelLocator
	 {
	 	
	    private static var instance : BlogModelLocator;
	 	
	    public function BlogModelLocator() 
	    {   
	       if ( instance != null )
	       {
	          throw new Error("BlogModelLocator is singleton" );
	       }
	    }
	    
	    public static function getInstance() : BlogModelLocator 
	    {
	       if ( instance == null )
	       		instance = new BlogModelLocator();
	           
	       return instance;
	    }
	  
		public var selectedItem: Blog = new Blog();
		public var list: ArrayCollection = new ArrayCollection(); 
		
		public var pageRequest: PageRequest = new PageRequest();
		public var page: Page = new Page(); 
		
	 }
}