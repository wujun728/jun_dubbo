function getchannelList() {//获取下拉学校列表
 
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
			$.each(data.data, function(i) {
				$('#channelId').append(
						"<option value=" + data.data[i].channelId + ">"
								+ data.data[i].name + "</option>");
			});
  			$('#channelId').selectpicker('refresh');
 			$('#channelId').selectpicker('val', '');
 			$('#channelId').selectpicker('render');

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}

function deleteFiles(filePath) {//删除文件列表
	$.ajax({
		url : baseURL +"sys/oss/deleteFile",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "post",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : {filePath:filePath},
		
 		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			 alert("删除成功");

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}



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
				alert("请先添加一级分类数据")
			} 
 			$('#oneCategory').empty();
			$.each(data.data, function(i) {
				$('#oneCategory').append(
						"<option value=" + data.data[i].categoryId   + ">"
								+ data.data[i].name + "</option>");
			});
  			$('#oneCategory').selectpicker('refresh');
 			$('#oneCategory').selectpicker('val', '');
 			$('#oneCategory').selectpicker('render');

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}


function getTwoCategoryList() {//获取下拉学校列表
	var oneCategory =   $('#oneCategory').selectpicker('val');
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
				alert("请先添加二级分类数据")
			} 
			 $('#twoCategory').empty();
			$.each(data.data, function(i) {
				$('#twoCategory').append(
						"<option value=" + data.data[i].categoryId + ">"
								+ data.data[i].name + "</option>");
			});
  			$('#twoCategory').selectpicker('refresh');
 			$('#twoCategory').selectpicker('val', '');
 			$('#twoCategory').selectpicker('render');

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}

var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: '添加商品',
        good:{
        	showInTop:0,
        	showInHot:0,
        	martId:1,
        	goodId:null,
        	categoryName:null,
            categoryId:null,
            orderNum:0,
            goodName:"",
            introduce:"",
            images:[],
            imageIds:[]
         },
        type:[
            {typename:"大小",id:'0'},
            {typename:"面积",id:'1'},
            {typename:"重量",id:'2'}
        ]
            // form: {
            //     name: '桌子',
            //     dialogImageUrl: '',
            //     dialogVisible: false
            // }
    },
   methods: {
	   save: function (event) {
			var url = vm.good.goodId == null ? "good/good/saveGood" : "good/good/update";
			vm.good.categoryId = $('#twoCategory').selectpicker('val');
			vm.good.categoryName = $('#twoCategory').selectpicker().text();
			vm.good.oneCategoryId = $('#oneCategory').selectpicker('val');
   			$.ajax({
				type: "POST",
			    url: baseURL + url,
               contentType: "application/json",
			    data: JSON.stringify(vm.good),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.good.goodId = r.data.id;
							vm.good.categoryId = r.data.categoryId;
							vm.next();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		reload: function (event) {
			location.href=baseURL+'modules/good/good.html';
		},
		next: function (event) {
 			location.href='modules/good/standard.html?id='+vm.good.goodId+'&categoryId='+vm.good.categoryId;
		}
	   
    //     onSubmit:function () {
    //         console.log('submit!');
    //     },
    //     handleRemove:function  (file, fileList) {
    //         console.log(file, fileList);
    //     },
    //     handlePictureCardPreview:function  (file) {
    //         this.dialogImageUrl = file.url;
    //         this.dialogVisible = true;
    //     }
    
     } 
 })
$(document).on("ready", function() {
	$("#input-7021").fileinput({
	     theme: 'fa',
	    uploadUrl: baseURL + "sys/oss/mulUpload",
	    uploadAsync: false,
	    minFileCount: 1,
	    maxFileCount: 1,
	    overwriteInitial: false,
        showRemove:false,
        showUpload: false, 
	    language : 'zh',
	    initialPreview: [
	        // "http://lorempixel.com/800/460/people/1",
	        // "http://lorempixel.com/800/460/people/2"
	    ],
	    initialPreviewAsData: true, // identify if you are sending preview data only and not the raw markup
	    initialPreviewFileType: 'image', // image is the default and can be overridden in config below
	    initialPreviewConfig: [
	        // {caption: "People-1.jpg", size: 576237, width: "120px", url: "/site/file-delete", key: 1},
	        // {caption: "People-2.jpg", size: 932882, width: "120px", url: "/site/file-delete", key: 2}, 
	    ] 
	}).on('filesorted', function(e, params) {
	    console.log('file sorted', e, params);
	}).on('fileuploaded', function(event, data, previewId, index) {
 		 var urls = Array.from(data.response.urls);
			$(urls).each(function(i,n){
	 		vm.good.picImg=n;
	 	})
	 	
	 }).on('filesuccessremove', function(event, data, index,e) {
			var filePath = [];
			filePath.push(vm.good.picImg);
			deleteFiles(filePath);
			vm.good.picImg="";
		//return false;
	}).on('filecleared', function(event, data, previewId, index) {
		console.log(event, data, previewId,index);
		console.log("filecleared");
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
		 
		console.log(event, data);
		console.log("filebatchuploadcomplete");
	}).on('beforeSend', function(event, data, previewId, index) {
		console.log(event, data);
		console.log("beforeSend");
	}) .on('fileselect', function(event, data, previewId, index) {
		 
		console.log(event, data,previewId,index);
		console.log("fileselect");
	 
	}).on('filebatchpreupload', function(event, data, previewId, index) {
	
	 
	}).on('filepreajax', function(event, data, previewId, index) {
		 var test = $("#picimg .file-preview-thumbnails .kv-preview-thumb").length;
		 if(test >1){alert("只能上传一个文件");
			 var container = $(".file-input");
			var processDiv = container.find('.kv-upload-progress');
			processDiv.hide();
			console.log(event, data,previewId,index);
			console.log("filepreajax");
			 return false;
		 }
		
	 
	});;
	
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
	  $('#channelId').change(function(){ 
		  getOneCategoryList();  
	  });
	
	
	  $('#oneCategory').change(function(){ 
		  getTwoCategoryList();  
	  });// 图片上传star
$("#input-702").fileinput({
     theme: 'fa',
    uploadUrl: baseURL + "sys/oss/mulUpload",
    uploadAsync: false,
    minFileCount: 1,
    maxFileCount: 5,
    overwriteInitial: false,
    language : 'zh',
    initialPreview: [
        // "http://lorempixel.com/800/460/people/1",
        // "http://lorempixel.com/800/460/people/2"
    ],
    initialPreviewAsData: true, // identify if you are sending preview data only and not the raw markup
    initialPreviewFileType: 'image', // image is the default and can be overridden in config below
    initialPreviewConfig: [
        // {caption: "People-1.jpg", size: 576237, width: "120px", url: "/site/file-delete", key: 1},
        // {caption: "People-2.jpg", size: 932882, width: "120px", url: "/site/file-delete", key: 2}, 
    ],
    uploadExtraData: {
        img_key: "1000",
        img_keywords: "happy, places",
    }
}).on('filesorted', function(e, params) {
    console.log('file sorted', e, params);
}).on('fileuploaded', function(event, data, previewId, index) {
	 vm.good.imageIds = [];
		var test = $(".file-preview-thumbnails .kv-preview-thumb").each(function(){
		  
		    vm.good.imageIds.push(    $(this).attr("id"));
		});
		var urls = Array.from(data.response.urls);
		$(urls).each(function(i,n){
 		vm.good.images.push(n);
 	})
 	
 }).on('filebatchuploadsuccess', function(event, data, previewId, index) {
	 
	var urls = Array.from(data.response.urls);
	$(urls).each(function(i,n){
 		vm.good.images.push(n);
 	})
	   console.log('filebatchuploadsuccess', event, data, previewId, index);
}).on('filesuccessremove', function(event, data, index,e) {
	console.log(event, data, index,e);
	console.log("filesuccessremove");
	 
		index = jQuery.inArray(data, vm.good.imageIds)
		
 
		var filePath = [];
		filePath.push(vm.good.images[index]);
		deleteFiles(filePath);
		vm.good.imageIds.splice(index,1); 
		vm.good.images.splice(index,1); 

	//return false;
}).on('filecleared', function(event, data, previewId, index) {
	console.log(event, data, previewId,index);
	console.log("filecleared");
	deleteFiles(vm.good.images);
	vm.good.images=[];
	vm.good.imageIds=[];
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
	 vm.good.imageIds = [];
		var test = $(".file-preview-thumbnails .kv-preview-thumb").each(function(){
		  
		    vm.good.imageIds.push(    $(this).attr("id"));
		});
		
	console.log(event, data);
	console.log("filebatchuploadcomplete");
}).on('beforeSend', function(event, data, previewId, index) {
	console.log(event, data);
	console.log("beforeSend");
});

// 图片上传end
})
