function getchannelList() {//获取频道列表
 
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
				alert("请先添加频道数据")
			} 
			 $('#oneCategory').empty();
			 $('#twoCategory').empty();
			$.each(data.data, function(i) {
				$('#channelId').append(
						"<option value=" + data.data[i].channelId + ">"
								+ data.data[i].name + "</option>");
			});
  			
 		//	$('#channelId').selectpicker('val', '');
 			$('#channelId').selectpicker('render');
 			  $('#channelId').selectpicker('val', vm.goodInfo.channelId);
 			 $('#channelId').selectpicker('refresh');
 		 
 
		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

} 


/*获取商品一级分类*/
function getOneCategoryList() {//获取下拉学校列表
	var channelId =   $('#channelId').selectpicker('val');
	 
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
 			$('#oneCategory').empty();
 			console.info( vm.goodInfo.oneCategoryId);
 			if( !vm.goodInfo.oneCategoryId){
 				$('#oneCategory').append(
						"<option  value= ''> 全部分类</option>");
  			}
			$.each(data.data, function(i) {
				$('#oneCategory').append(
						"<option value=" + data.data[i].categoryId   + ">"
								+ data.data[i].name + "</option>");
			});
  			
  			
   			//$('#oneCategory').selectpicker('val', vm.goodInfo.oneCategoryId);
			$('#oneCategory').selectpicker('val',  vm.goodInfo.oneCategoryId);
 			$('#oneCategory').selectpicker('render');
 			$('#oneCategory').selectpicker('refresh');
 			$('#twoCategory').empty();
 			 
 			//getTwoCategoryList();
		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}

/*获取商品二级分类数据
*/function getTwoCategoryList() {//获取下拉列表
	var oneCategory =   $('#oneCategory').selectpicker('val');
	if(oneCategory){
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
			 
			 $('#twoCategory').empty();
			 
			$.each(data.data, function(i) {
				$('#twoCategory').append(
						"<option value=" + data.data[i].categoryId + ">"
								+ data.data[i].name + "</option>");
			});
  		 
  		 
 			$('#twoCategory').selectpicker('val', vm.goodInfo.categoryId);
 			$('#twoCategory').selectpicker('refresh');
 			$('#twoCategory').selectpicker('render');

		},
		error : function(data) {
			 $('#twoCategory').empty();
			alert("查询失败" + data);

		}
	})
	}
	else{
		 $('#twoCategory').empty();
		alert("分类已经删除了，请重新添加");
	}
	
}

var editor;
var vm = new Vue({
	el:'#rrapp',
    showList: true,
    data:{
    	goodDetail:{},
    	goodParam:[],
		goodInfo: {},
		goodImage:[],
		goodImageIds:[],
		goodPrice:{},
		goodId:T.p('goodId'),
		initialPreviewConfig:[],
		uploadExtraData:[]
	},
    created:function() {
  	   Vue.nextTick(function () {
  		   var E = window.wangEditor;
  	          editor = new E('#editor');
  	        // 配置服务器端地址
  	       editor.customConfig.uploadFileName = 'file';
  	        editor.customConfig.uploadImgServer = baseURL +'sys/oss/wangEditorupload';
  	        editor.create();
  	         }); 
  	 
    },
	methods: {
		insertGoodParam:function (type){
   		 	let goodParam = {};
   		  var addvalue1= $("#paramName").val();
           var addvalue2= $("#paramVal").val();
          if(addvalue1!==""&&addvalue2!==""){
          	goodParam.name = addvalue1;
          	goodParam.value = addvalue2;
          	goodParam.goodId = this.goodId;
        	vm.goodParam.push(goodParam);
        	$("#paramName").val("");
        	$("#paramVal").val("");
           } else{
              alert("请输入属性值")
          }
			 

   	}
	,delParam: function (id) {
   		var arr = [];
   		arr.push(id);
 		$.ajax({
			type: "POST",
		    url: baseURL + "good/goodparameter/delete",
            contentType: "application/json",
		    data: JSON.stringify(arr),
		    success: function(r){
		    	if(r.code === 0){
					alert('操作成功', function(index){
						getGoodParam();
						//vm.reload();
					});
				}else{
					alert(r.msg);
				}
			}
		});
	}, 
		goodInfoSaveOrUpdate: function (event) {
			vm.goodInfo.categoryId = $('#twoCategory').selectpicker('val');
			vm.goodInfo.categoryName = $('#twoCategory').selectpicker().text();
			vm.goodInfo.oneCategoryId = $('#oneCategory').selectpicker('val');
			var url =  "good/good/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.goodInfo),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){

							 vm.Jsreload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		}, reload: function(){
	    	location.href=baseURL + "modules/good/good.html";
	    }, Jsreload: function(){
	    	location.href="modules/good/good.html";
	    },
	    saveGoodDetail: function(){
	    	vm.goodDetail.goodId = vm.goodId;
	    	vm.goodDetail.description =editor.txt.html();
	    	$.ajax({
				type: "POST",
			    url: baseURL + "good/gooddetail/update",
                contentType: "application/json",
			    data: JSON.stringify(vm.goodDetail),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.Jsreload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
	 	    },
    	saveGoodSpecPrice: function(){
    		$.ajax({
				type: "POST",
			    url: baseURL + "good/goodspecprice/saveGoodSpecPriceEntity",
                contentType: "application/json",
			    data: JSON.stringify(vm.goodPrice),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.Jsreload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
	 
        },saveGoodPam: function(){
    		$.ajax({
				type: "POST",
			    url: baseURL + "good/goodparameter/insertOrUpdateAllBatch",
                contentType: "application/json",
			    data: JSON.stringify(vm.goodParam),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							getGoodParam();
							//vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
	 
        },
	},
   
    
	mounted: function(){


	}
	
}) 

function getInfo(){
	$.ajaxSettings.async = false;
	$.get(baseURL + "good/good/info/"+vm.goodId, function(r){
        vm.goodInfo = r.good;
        var jsonStr = '{"filePath":"'+vm.goodInfo.picImg+'","goodId":"'+vm.goodInfo.goodId+'"}';
		 $.parseJSON(jsonStr);
		 var picImg =  vm.goodInfo.picImg;
		 var initialPreview =  picImg=='' ||picImg==null ? []:picImg;
		 
		var initialPreviewConfig =  picImg=='' || picImg==null ?[]:[{url:baseURL +"good/good/deleteImage",width:'120px',extra:$.parseJSON(jsonStr),key:1}];
        // 图片上传star
 	    $("#input-701").fileinput({
	        theme: 'fa',
	        uploadUrl: baseURL + "good/good/updateImage",
	        uploadAsync: false,
	        minFileCount: 1,
	        maxFileCount: 1,
	        overwriteInitial: false,
	        showRemove:false,
	        showUpload: false, 
	        language : 'zh',
	        initialPreview: initialPreview,
	        initialPreviewAsData: true, // identify if you are sending preview data only and not the raw markup
	        initialPreviewFileType: 'image', // image is the default and can be overridden in config below
	        initialPreviewConfig:initialPreviewConfig,
	        uploadExtraData: {goodId:vm.goodInfo.goodId}

	    }).on('filedeleted', function(event, data, previewId, index) {
	    	vm.goodInfo.picImg='';
	    })
        getGoodSpec();
    });
	$.ajaxSettings.async = true;
}
function getDetail(){
	$.get(baseURL + "good/gooddetail/goodDetail?goodId="+vm.goodId,function(r){
		if(r.goodDetail){
			vm.goodDetail = r.goodDetail;
		}
		if(vm.goodDetail){
	    	  
	    	  editor.txt.html(vm.goodDetail.description);
	      }
     });
}
function getGoodParam(){
	$.get(baseURL + "good/goodparameter/goodparameterList?goodId="+vm.goodId, function(r){
        vm.goodParam = r.data;
     });
}


function getInitialPreviewConfig(){
 	var goodImage = vm.goodImage;
	var goodImageIds = vm.goodImageIds;
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
 

function getImage(){
	$.get(baseURL + "good/goodimage/goodImageList",{goodId:vm.goodId}, function(r){
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
	            goodId: vm.goodId
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
	    	console.log($('#input-702').fileinput('getPreview'));
	    	console.log($('#input-702').fileinput('getFileStack'));
	    	console.log(event, data,previewId,index);
	    	console.log("fileselect");
	    	var test = $(".file-preview-thumbnails .kv-preview-thumb").each(function(){
	    		  
	    		   console.info(    $(this).attr("id"));
	    		});
	    }).on('fileimagesloaded', function(event) {
	        console.log("fileimagesloaded");
	    }).on('fileloaded', function(event, file, previewId, index, reader) {
	        console.log("fileloaded");
	    }).on('fileimageloaded', function(event, file, previewId, index, reader) {
	        console.log("fileimageloaded");
	    });
	    // 图片上传end

     });
}
function getGoodSpec(){
	if(vm.goodInfo.oneCategoryId){
		$.ajax({
	
		url : baseURL +"good/goodspecprice/getGoodSpecPricelist",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "get",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : {goodId:vm.goodId},
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			console.info(data);
			 if(!data.data||data.data.length==0){
 				alert('请先添加商品规格数据', function(index){
  					location.href=  "modules/good/standard.html?id="+vm.goodInfo.goodId+"&categoryId="+vm.goodInfo.oneCategoryId;
				});
			} 
			 vm.goodPrice = data.data;
 		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})
	}
}
$(document).on("ready", function() { 
	getInfo();
	
	$("#channelId").selectpicker({  
	    noneSelectedText : '请选择频道'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
	$("#oneCategory").selectpicker({  
	    noneSelectedText : '请选择一级分类'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
	$("#twoCategory").selectpicker({  
	    noneSelectedText : '请选择二级分类'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
	getchannelList();
	  $('#channelId').on('refreshed.bs.select', function (e) {
		  getOneCategoryList();
	  });
	  $('#channelId').change(function(){ 
		  getOneCategoryList();  
	  });
	  
	  $('#oneCategory').on('refreshed.bs.select', function (e) {
		  getTwoCategoryList(); 
	  });
	
	  $('#oneCategory').change(function(){ 
		  getTwoCategoryList();  
	  });// 图片上传star
	
	getGoodParam();
	getImage();
	getDetail();
    $('.tabwrap>div').hide();
    $('.tabwrap>div').eq(0).show();
    $('.tab_head>div').click(function(){
        var index=$(this).index();
        $(this).addClass('active');
        $(this).siblings().removeClass('active')
        $('.tabwrap>div').hide();
        $('.tabwrap>div').eq(index).show();
    })

  
})

function putin(){
	 
	var stock= $('#stock').val();
	var price= $('#price').val();
	var brand= $('#brand').val();
	var size= $('.size').val();
	var good = vm.goodPrice;
	for(var good in good){
		if(stock){
		vm.goodPrice[good].stock= stock;
		}
		if(price){
		vm.goodPrice[good].price=price;
			 
		}
		if(brand){
			vm.goodPrice[good].salesVolume= brand;
		 
		}
	}
	 $('#stock').val('');
	 $('#price').val('');
	 $('#brand').val('');
	 $('.size').val('');
	
}