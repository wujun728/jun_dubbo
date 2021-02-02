 function querySpecVal(goodId){
	 $.ajax({
			url : baseURL +"good/goodspecvalue/list",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
			// 数据发送方式
			type : "get",
			// 接受数据格式
			dataType : "json",
			// 要传递的数据
			data : {goodId:goodId},
			// 回调函数，接受服务器端返回给客户端的值，即result值
			success : function(data) {
				 vm.specVal = [];
				 if(!data.data||data.data.length==0){
					alert("请先添加规格数据")
				} 
					$.each(data.data, function(i) {
						 
						 vm.specVal.push(data.data[i]);
	 					 
					});

			},
			error : function(data) {

				alert("查询失败" + data);

			}
		})

 }
/* 查看规格值*/
function getSpecVal(){
	$.ajax({
		url : baseURL +"good/categoryspec/specList",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "get",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : {is_show:1,categoryId:vm.oneCategoryId},
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			 vm.spec = [];
			 if(!data.data||data.data.length==0){
				alert("请先添加规格数据")
			} 
				$.each(data.data, function(i) {
					 let specObj = {};
					specObj.specName =  data.data[i].specName;
					specObj.id = data.data[i].id;
					 vm.spec.push(specObj);
 					 
				});

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}

/*获取商城频道列表*/
function getchannelList() {//获取下拉频道列表
	$.ajax({
		url : baseURL +"good/channel/getChannelList",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "get",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : 'data',
		
 		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			console.info(data);
			 if(!data.data||data.data.length==0){
				alert("频道数据还未出现")
			} 
				$('#search_channelId').append(
				"<option value=''>所有频道 </option>");
			$.each(data.data, function(i) {
				$('#search_channelId').append(
						"<option value=" + data.data[i].channelId + ">"
								+ data.data[i].name + "</option>");
			});
  			$('#search_channelId').selectpicker('refresh');
 			$('#search_channelId').selectpicker('val', '');
 			$('#search_channelId').selectpicker('render');

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}
/*获取商品规格*/
function getGoodSpecPrice(goodId){
	$.ajax({
		url : baseURL +"good/goodspecprice/getGoodSpecPricelist",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "get",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : {goodId:goodId},
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			console.info(data);
			 if(!data.data||data.data.length==0){
 				alert('请先添加商品规格数据', function(index){
  					//location.href=baseURL + "modules/good/standard.html?id="+vm.goodInfo.goodId+"&categoryId="+vm.goodInfo.oneCategoryId;
				});
			} 
			 vm.goodPrice = data.data;
 		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})
}

/*获取商品一级分类*/
function getOneCategoryList() {//获取下拉学校列表
	var channelId =   $('#search_channelId').selectpicker('val');
 	$.ajax({
		url : baseURL +"good/category/getOneCategorylist",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "get",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : {type:1,status:1,channelId:channelId},
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
 			 if(!data.data||data.data.length==0){
				alert("一级分类一晃而过")
			} 
 			$('#search_oneCategory').empty();
 			$('#search_oneCategory').append(
			"<option value=''>所有分类 </option>");
			$.each(data.data, function(i) {
				$('#search_oneCategory').append(
						"<option value=" + data.data[i].categoryId   + ">"
								+ data.data[i].name + "</option>");
			});
  			$('#search_oneCategory').selectpicker('refresh');
 			$('#search_oneCategory').selectpicker('val', '');
 			$('#search_oneCategory').selectpicker('render');
 			$('#search_twoCategory').empty();
 			$('#search_twoCategory').selectpicker('refresh');
		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}

/*获取商品二级分类数据
*/function getTwoCategoryList() {//获取下拉列表
	var oneCategory =   $('#search_oneCategory').selectpicker('val');
	$.ajax({
		url : baseURL +"good/category/getOneCategorylist",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "get",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : {type:2,status:1,parentId:oneCategory},
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			console.info(data);
			 if(!data.data||data.data.length==0){
				alert("二级分类数据悄悄溜走")
			} 
			 
			 $('#search_twoCategory').empty();
				$('#search_twoCategory').append(
				"<option value=''>所有分类 </option>");
			$.each(data.data, function(i) {
				$('#search_twoCategory').append(
						"<option value=" + data.data[i].categoryId + ">"
								+ data.data[i].name + "</option>");
			});
  			$('#search_twoCategory').selectpicker('refresh');
 			$('#search_twoCategory').selectpicker('val', '');
 			$('#search_twoCategory').selectpicker('render');

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}


function spec(goodId){
 	getGoodSpecPrice(goodId);
	 layer.open({
        type: 1,
        offset: '50px',
        skin: 'layui-layer-molv',
        title: "设置规格",
        area: ['700px', '450px'],
        shade: 0,
        maxmin: true,
        shadeClose: false,
        content: jQuery("#specLayer"),
        btn: ['确定', '取消'],
        btn1: function (index) {
        	$.ajax({
				type: "POST",
			    url: baseURL + "good/goodspecprice/saveGoodSpecPriceEntity",
                contentType: "application/json",
			    data: JSON.stringify(vm.goodPrice),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(data){
							vm.reload(); 
							layer.close(index);
							 
						});
					}else{
						alert(r.msg, function(data){
						 layer.close(index);
						});
					} 
				}
			});
           
        }
       
    });
}

function specValLayer(){
	 layer.open({
        type: 1,
        offset: '50px',
        skin: 'layui-layer-molv',
        title: "设置规格",
        area: ['700px', '450px'],
        shade: 0,
        shadeClose: false,
        maxmin: true,
        content: jQuery("#specValLayer"),
        btn: ['重置规格','更新规格', '关闭'],
        yes: function (index) {
        	var goodId = getSelectedRow();
			if(goodId == null){
				return ;
			}	 
		 confirm('是否删除所有的商品规格吗', function(){
			        	$.ajax({
							type: "POST",
						    url: baseURL + "good/goodspecvalue/deleteSpec",
 						    data: {goodId:goodId},
						    success: function(r){
						    	if(r.code === 0){
									alert('操作成功', function(data){
										 layer.close(index);
 									});
								}else{
									alert(r.msg, function(data){
										 
 									});
								} 
							}
						});
			});    
        },
	 btn2: function (index) {
		 confirm('是否确定要重新生成商品规格吗', function(){
			  var url = "good/goodspecvalue/saveGoodSpecValue"
		 			$.ajax({
						type: "POST",
					    url: baseURL + url,
		             contentType: "application/json",
					    data: JSON.stringify(vm.specVal),
					    success: function(r){
					    	if(r.code === 0){
								alert('操作成功', function(data){
									layer.close(index);
								});
							}else{
								alert(r.msg,function(data){
									 
									});
							}
						}
					});
			 
		 
		 });
		 return false;

}
       
    });
}

function picImg(goodId){
	$('#input-702').fileinput('destroy');

 	//$('#input-702').fileinput('refresh')
	 getImage(goodId);
	 layer.open({
         type: 1,
         offset: '50px',
         skin: 'layui-layer-molv',
         title: "图片预览",
         area: ['800px', '550px'],
         shade: 0,
         shadeClose: false,
         content: jQuery("#imgLayer"),
         btn: ['规格删除','重新生成规格', '取消'],
         btn1: function (index) {
        	 
             layer.close(index);
         },
         zIndex : 100
     });
}

function getInitialPreviewConfig(){
 	var goodImage = vm.goodImage;
	var goodImageIds = vm.goodImageIds;
	vm.initialPreviewConfig=[];
	for(var index in goodImage){
		 var jsonStr = '{"filePath[]":"['+goodImage[index]+']","picImgIds":['+goodImageIds[index]+']}';
		 $.parseJSON(jsonStr);
		vm.initialPreviewConfig.push(new Object());
		vm.initialPreviewConfig[index].url=baseURL +"good/goodimage/delete";
		vm.initialPreviewConfig[index].width="120px";
		vm.initialPreviewConfig[index].extra=$.parseJSON(jsonStr);
		vm.initialPreviewConfig[index].key=goodImage[index];
	}
}


function getImage(goodId){
	//$('#input-id').fileinput('refresh');

 	 vm.goodImage=[];
	 vm.goodImageIds=[];
	$.get(baseURL + "good/goodimage/goodImageList",{goodId:goodId}, function(r){
		$(r.goodImage).each(function(i,n){
			
			 vm.goodImage.push(n.picImg);
			 vm.goodImageIds.push(n.picImgId);
	 	})
 		getInitialPreviewConfig();
	 	  // 图片上传star
	    $("#input-702").fileinput({
	        theme: 'fa',
	        uploadUrl: baseURL + "good/goodimage/saveGoodImage",
	        uploadAsync: false,
	        minFileCount: 1,
	        maxFileCount: 5,
	        overwriteInitial: false,
	        showRemove:false,
	        showUpload: false, 
	        language : 'zh',
	        initialPreview: vm.goodImage,
	        initialPreviewAsData: true, // identify if you are sending preview data only and not the raw markup
	        initialPreviewFileType: 'image', // image is the default and can be overridden in config below
	        initialPreviewConfig: vm.initialPreviewConfig,
	        uploadExtraData: {
	            goodId: goodId
 	        }
	    }).on('filesorted', function(e, params) {
	        console.log('file sorted', e, params);
	    }).on('fileuploaded', function(e, params) {
	     
	        console.log('file uploaded', e, params);
	    }).on('filebatchuploadsuccess', function(event, data, previewId, index) {
	   	 
	    	  getImage();
	    	   console.log('filebatchuploadsuccess', event, data, previewId, index);
	    }).on('filesuccessremove', function(event, data, index,e) {
	    	console.log(event, data, index,e);
	    	console.log("filesuccessremove");
	    	 
	    		index = jQuery.inArray(data, vm.goodImageIds)
	    		
	     
	    		var filePath = [];
	    		filePath.push(vm.goodImage[index]);
	    		deleteFiles(filePath);
	    		vm.goodImageIds.splice(index,1); 
	    		vm.goodImage.splice(index,1); 

	    	//return false;
	    }).on('filecleared', function(event, data, previewId, index) {
	    	console.log(event, data, previewId,index);
	    	console.log("filecleared");
	    	deleteFiles(vm.goodImage);
	    	vm.goodImage=[];
	    	vm.goodImageIds=[];
	    }).on('filedeleted', function(event, data, previewId, index) {
	    	console.log(event, data, previewId,index);
	    	console.log("filedeleted");
	    }).on('filepreremove', function(event, data, previewId, index) {
	    	console.log(event, data, previewId,index);
	    	console.log("filepreremove");
	    }).on('fileclear', function(event, data, previewId, index) {
	    	console.log(event, data);
	    	console.log("fileclear");
	    }).on('filepreupload', function(event, data, previewId, index) {
	    	console.log(event, data);
	    	console.log("filepreupload");
	    }).on('filebatchuploadcomplete', function(event, data, previewId, index) {
	    	getImage();
	    	console.log(event, data);
	    	console.log("filebatchuploadcomplete");
	    }).on('beforeSend', function(event, data, previewId, index) {
	    	console.log(event, data);
	    	console.log("beforeSend");
	    }).on('filebatchselected', function(event, data, previewId, index) {
	    	console.log("filebatchselected");
	     
	    }).on('fileselect', function(event, data, previewId, index) {
	    }).on('fileimagesloaded', function(event) {
	        console.log("fileimagesloaded");
	    }).on('fileloaded', function(event, file, previewId, index, reader) {
	        console.log("fileloaded");
	    }).on('fileimageloaded', function(event, file, previewId, index, reader) {
	        console.log("fileimageloaded");
	    });
	    // 图片上传end
      });
	//$('#input-702').fileinput('refresh');

}
$(function () {
	$("#search_channelId").selectpicker({  
	    noneSelectedText : '请选择频道'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
	$("#search_oneCategory").selectpicker({  
	    noneSelectedText : '请选择一级分类'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
	$("#search_twoCategory").selectpicker({  
	    noneSelectedText : '请选择二级分类'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
		getchannelList();
	  $('#search_channelId').change(function(){ 
		  getOneCategoryList();  
	  });
	
	
	  $('#search_oneCategory').change(function(){ 
		  getTwoCategoryList();  
	  });// 图片上传star
	
	
	//getImage();
    $("#jqGrid").jqGrid({
        url: baseURL + 'good/good/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'goodId', index: 'good_id', width: 80, key: true },
			{ label: '商品名称', name: 'goodName', index: 'good_name', width: 150 }, 			
			{ label: '频道', name: 'channelName', index: 'channelName', width: 150 }, 			
			{ label: '分类', name: 'categoryParentName', index: 'categoryParentName', width: 200 ,formatter: function(cellvalue, options, rowObject){
 	            if(cellvalue == null || cellvalue == ''){
 	           	return   "它的分类被删除了";
 	            }
 	            
				return   rowObject.categoryParentName+"->"+rowObject.categoryName;
	           
	        }},  			
	        { label: '商品分类', name: 'oneCategoryId', index: 'oneCategoryId', width: 150,hidden:true }, 			
 			{ label: '详情图片', name: 'goodId', index: 'good_id', width: 120,formatter: function(cellvalue, options, rowObject){
			 
	            return       '<a class="btn btn-sm btn-info" onclick="picImg('+cellvalue+')"><i class="fa fa-file-photo-o"></i>&nbsp;预览</a>';
	           
	        }}, 
			{ label: '缩略图', name: 'picImg', index: 'pic_img', width: 150,formatter: function(cellvalue, options, rowObject){
				 if(cellvalue){
					 
					 return       '<a class="btn btn-sm btn-success" href="'+cellvalue+'"  target="_blank"><i class="fa fa-file-photo-o"></i>&nbsp;预览</a>';
				 }else{
					 return       '<a class="btn btn-sm btn-warning" ><i class="fa fa-file-photo-o"></i>&nbsp;暂无图片</a>';

				 }
	           
	        }}, 
	        { label: '规格', name: 'goodId', index: 'pic_img', width: 120,formatter: function(cellvalue, options, rowObject){
				 
	            return       '<a class="btn btn-sm btn-info"  onclick="spec('+cellvalue+')"><i class="fa fa-cogs"></i>&nbsp;规格</a>';
	           
	        }}, 
			{ label: '置顶', name: 'showInTop', index: 'show_in_top', width: 120 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">默认</span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">置顶</span>';
	            }  
	            return '<span class="label label-primary">默认</span>';
	           
	        }}, 						
			{ label: '导航栏', name: 'showInNav', index: 'show_in_nav', width: 120 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">隐藏</span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">显示</span>';
	            }  
	            return '<span class="label label-primary">隐藏</span>';
	           
	        }}, 						 			
/*			{ label: '猜你喜欢 1=显示/0=隐藏', name: 'showInLike', index: 'show_in_like', width: 80 }, 			
*/			{ label: '热门 ', name: 'showInHot', index: 'show_in_hot', width: 120 ,formatter: function(cellvalue, options, rowObject){
	if(cellvalue == 0){
        return '<span class="label label-primary">默认</span>';
    }
    if(cellvalue == 1){
        return '<span class="label label-success">热门</span>';
    }  
    return '<span class="label label-primary">默认</span>';
   
}}, 						 			 			
			{ label: '上架', name: 'showInShelve', index: 'show_in_shelve', width: 120 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">下架</span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">上架</span>';
	            }  
	            return '<span class="label label-primary">上架</span>';
	           
	        }}, 	
	    	{ label: '激活', name: 'activate', index: 'activate', width: 120 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">未激活</span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">激活</span>';
	            }  
	            return '<span class="label label-primary">未激活</span>';
	           
	        }}, 
/*			{ label: '搜索的关键词', name: 'searchKey', index: 'search_key', width: 80 }, 			
*/			{ label: '总销量', name: 'salesVolume', index: 'salesVolume', width: 100 }, 
			{ label: '总库存', name: 'stock', index: 'stock', width: 100 }, 		
			{ label: '访问量', name: 'pageViews', index: 'pageViews', width: 100 }, 		
			/*{ label: '页面标题', name: 'pageTitle', index: 'page_title', width: 80 }, 			
			{ label: '页面的描述', name: 'pageDescription', index: 'page_description', width: 80 }, 			
			{ label: '页面的关键词', name: 'pageKeyword', index: 'page_keyword', width: 80 }, 	*/		
		/*	{ label: '备注信息', name: 'remarks', index: 'remarks', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建者', name: 'createBy', index: 'create_by', width: 80 }, 			*/
			{ label: '上架时间', name: 'shelveTime', index: 'shelve_time', width: 120 }, 			
			/*{ label: '上架人', name: 'shelveBy', index: 'shelve_by', width: 120 }, 			
			{ label: '更新者', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }, 		*/	
			{ label: '商户', name: 'martId', index: 'mart_id', width: 80 ,formatter: function(cellvalue, options, rowObject){
			 if(!cellvalue || cellvalue == 1)
	         return '<span class="label label-success">自营</span>';
			 return '<span class="label label-primary">非自营</span>';
	        }}
			
			/*{ label: '', name: 'delFlag', index: 'del_flag', width: 80 }	*/		
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        //rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		oneCategoryId:null,
		showList: true,
		title: null,
		goodPrice:{},
		spec:[],
		specVal:[],
		good: {},
		goodImage:[],
		goodImageIds:[],
		initialPreviewConfig:[],
		search:{}
	},
	methods: {
		specReset:function(){
			var goodId = getSelectedRow();
			if(!goodId){
				return
			}
			 vm.oneCategoryId = $("#jqGrid").jqGrid("getRowData",goodId).oneCategoryId;
			 getSpecVal();
			 querySpecVal(goodId);
			 specValLayer();
		},
		query: function () {
			vm.search.channelId =$('#search_channelId').selectpicker('val');
			vm.search.oneCategoryId =$('#search_oneCategory').selectpicker('val');
			vm.search.categoryId =$('#search_twoCategory').selectpicker('val');
			 
			vm.reload();
		},
		add: function(){
		 
			location.href=baseURL + 'modules/good/sort.html';
		},
		update: function (event) {
			var goodId = getSelectedRow();
			if(goodId == null){
				return ;
			}

			location.href=baseURL + 'modules/good/type.html?goodId='+goodId;
		},
		 
		shelve1: function (event) {
			var goodId = getSelectedRow();
			if(goodId == null){
				return ;
			}
			confirm('确定要上架吗', function(){
			        	$.ajax({
							type: "POST",
						    url: baseURL + "good/good/updateShelve",
 						    data: {showInShelve:1,goodId:goodId},
						    success: function(r){
						    	if(r.code === 0){
									alert('操作成功', function(data){
										vm.reload();
									});
								}else{
									alert(r.msg, function(data){
										vm.reload();
 									});
								} 
							}
						});
			});  
			 
		},
		 	 
		shelve0: function (event) {
			var goodId = getSelectedRow();
			if(goodId == null){
				return ;
			}
			confirm('确定要下架吗', function(){
			        	$.ajax({
							type: "POST",
						    url: baseURL + "good/good/updateShelve",
 						    data: {showInShelve:0,goodId:goodId},
						    success: function(r){
						    	if(r.code === 0){
									alert('操作成功', function(data){
										vm.reload();
									});
								}else{
									alert(r.msg, function(data){
										vm.reload();
 									});
								} 
							}
						});
			});  
			 
		},
		activate: function (event) {
			var goodId = getSelectedRow();
			if(goodId == null){
				return ;
			}
			confirm('确定要激活吗', function(){
			        	$.ajax({
							type: "POST",
						    url: baseURL + "good/good/updateShelve",
 						    data: {activate:1,goodId:goodId},
						    success: function(r){
						    	if(r.code === 0){
									alert('操作成功', function(data){
										vm.reload();
									});
								}else{
									alert(r.msg, function(data){
										vm.reload();
 									});
								} 
							}
						});
			});  
			 
		},
		noactivate: function (event) {
			var goodId = getSelectedRow();
			if(goodId == null){
				return ;
			}
			confirm('确定要未激活吗', function(){
			        	$.ajax({
							type: "POST",
						    url: baseURL + "good/good/updateShelve",
 						    data: {activate:0,goodId:goodId},
						    success: function(r){
						    	if(r.code === 0){
									alert('操作成功', function(data){
										vm.reload();
									});
								}else{
									alert(r.msg, function(data){
										vm.reload();
 									});
								} 
							}
						});
			});  
			 
		},
		insertSpec:function (type){
   		 let specObj = {};
   		 
    		 var addvalue = $("#spec"+type.id).val();
    		 if(addvalue == ''){
    			 alert("请输入规格值");
    			 return false;
    		 }
			specObj.specValue = addvalue;
			specObj.categorySpecId = type.id;
			specObj.goodId = this.goodId;
   		 vm.specVal.push(specObj); 
 
   	},
   	remove:function (item) {
   	      this.specVal.splice(this.specVal.indexOf(item), 1)
       },
		 	 
		saveOrUpdate: function (event) {
			var url = vm.good.goodId == null ? "good/good/save" : "good/good/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.good),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var goodIds = getSelectedRows();
			if(goodIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "good/good/delete",
                    contentType: "application/json",
				    data: JSON.stringify(goodIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(goodId){
			$.get(baseURL + "good/good/info/"+goodId, function(r){
                vm.good = r.good;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:vm.search,
                page:page
            }).trigger("reloadGrid");
		},
	}
});