/*获取商城频道列表*/
function getAdvertsList() {//获取下拉频道列表
	$.ajax({
		url : baseURL +"adverts/adverts/list",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
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
				alert("广告位置数据还未出现，请先添加广告位");
			} 
			 
			$.each(data.data, function(i) {
				$('#advertsId').append(
						"<option value=" + data.data[i].advertsId + ">"
								+ data.data[i].name + "</option>");
			});
  			 $('#advertsId').selectpicker('refresh'); 
 			$('#advertsId').selectpicker('val', '');
 			//$('#advertsId').selectpicker('render');

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}
$(function () {
	$("#advertsId").selectpicker({  
	    noneSelectedText : '请选择广告位'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
	getAdvertsList();
	  $('#advertsId').change(function(){ 
		console.info(	$('#advertsId').selectpicker('val'));
		console.info(	$("#advertsId  option:selected").text()  );
 	  });
    $("#jqGrid").jqGrid({
        url: baseURL + 'adverts/advertsdetail/page',
        datatype: "json",
        colModel: [			
			{ label: 'advertsDetailId', name: 'advertsDetailId', index: 'adverts_detail_id', width: 50, key: true },
			{ label: '广告位置', name: 'name', index: 'name', width: 150 }, 			
			{ label: '广告位ID', name: 'advertsId', index: 'adverts_id', width: 80,hidden:true}, 			
			{ label: '标题', name: 'title', index: 'title', width: 120 }, 			
			{ label: '链接地址', name: 'href', index: 'href', width: 100 }, 			
			{ label: '类型', name: 'type', index: 'type', width: 80, formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">图文</span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">图片</span>';
	            }  
	            if(cellvalue == 2){
	                return '<span class="label label-success">视频链接</span>';
	            }  
	            return '<span class="label label-primary">图文</span>';
	           
	        }},  			
			{ label: '状态 ', name: 'status', index: 'status', width: 80 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">显示</span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">隐藏</span>';
	            }  
	            return '<span class="label label-primary">显示</span>';
	           
	        }}, 						 									
			{ label: '展示图片', name: 'picImg', index: 'pic_img', width: 200 ,formatter: function(cellvalue, options, rowObject){
				 if(cellvalue)
			            return '<img  style="width:200x;height:200px;" src="'+cellvalue+'" />';
					 else
						 return '暂无图片';
			           
	           
	        }}, 										
		/*	{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建者', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '更新者', name: 'updateBy', index: 'update_by', width: 80 }, 	*/		
			
			{ label: '广告起始时间', name: 'beginTime', index: 'begin_time', width: 220 }, 			
			{ label: '广告结束时间', name: 'endTime', index: 'end_time', width: 220 }, 			
			{ label: '广告内容', name: 'content', index: 'content', width: 180 },
			{ label: '备注信息', name: 'remarks', index: 'remarks', width: 80 }, 			
		 { label: '排序', name: 'sort', index: 'sort', width: 80 } 
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
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
var editor;
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		advertsDetail: {},
		picImg:true,
		href:true,
		content:true,
		type:null,
		startDate:'',
		endDate:'',
		startTime:'',
		endTime:'',
		src:''
	},
	watch:{
		type(val, oldVal){
           
            if(val == 0){
            	  Vue.nextTick(function () {
             		   var E = window.wangEditor;
             	       editor = new E('#editor');
             	        // 配置服务器端地址
             	       editor.customConfig.uploadFileName = 'file';
             	       editor.customConfig.uploadImgServer = baseURL +'sys/oss/wangEditorupload';
             	       editor.create();
             	       if(vm.advertsDetail){
             	    	   
             	    	   editor.txt.html(vm.advertsDetail.content);
             	       } 
             	         });  
            }
            else if(val == 1){
            	  Vue.nextTick(function () {
            	layui.use('upload', function(){
            		  var $ = layui.jquery
            		  ,upload = layui.upload;
            		  
            		  //普通图片上传
            		  var uploadInst = upload.render({
            		    elem: '#test1'
            		    ,url: baseURL +'sys/oss/wangEditorupload'
            		    ,before: function(obj){
            		      //预读本地文件示例，不支持ie8
            		      obj.preview(function(index, file, result){
            		        $('#demo1').attr('src', result); //图片链接（base64）
            		      });
            		    }
            		    ,done: function(res){
            		      //如果上传失败
            		      if(res.code > 0){
            		        return layer.msg('上传失败');
            		      }
            		      vm.advertsDetail.picImg=res.data[0];
            		      
            		      //上传成功
            		    }
            		    ,error: function(){
            		      //演示失败状态，并实现重传
            		      var demoText = $('#demoText');
            		      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
            		      demoText.find('.demo-reload').on('click', function(){
            		        uploadInst.upload();
            		      });
            		    }
            		  });
            	});
            	  });
            }
        },
        advertsDetail:{//深度监听，可监听到对象、数组的变化
            handler(val, oldVal){
            	vm.type=val.type;
            },
            deep:true
        }
        
    },
    created:function() {

  	 /*  Vue.nextTick(function () {
  		   var E = window.wangEditor;
  	       editor = new E('#editor');
  	        // 配置服务器端地址
  	       editor.customConfig.uploadFileName = 'file';
  	       editor.customConfig.uploadImgServer = baseURL +'sys/oss/wangEditorupload';
  	       editor.create();
  	         });  */
    },
    
    　 
  
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
		
			vm.showList = false;
			vm.title = "新增";
			vm.advertsDetail = {};
			vm.advertsDetail = {type:0,status:0,sort:1};
			if(editor){
				
				editor.txt.html('');
			}
			vm.src='';
			vm.type=0;
			 
	            $("#test6").val('');
	            $("#test9").val('');
		},
		update: function (event) {
			var advertsDetailId = getSelectedRow();
			if(advertsDetailId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(advertsDetailId);
            
            vm.startDate='';
        	vm.startTime='';
        	vm.endDate= '';
            vm.endTime= '';
            if(  vm.advertsDetail.beginTime){
            	vm.advertsDetail.beginTime.split(" ");
            	
            	vm.startDate= vm.advertsDetail.beginTime.split(" ")[0];
            	vm.startTime= vm.advertsDetail.beginTime.split(" ")[1];
            	
            }

            if(  vm.advertsDetail.endTime){
            	vm.advertsDetail.endTime.split(" ");
            vm.endDate= vm.advertsDetail.endTime.split(" ")[0];
            vm.endTime= vm.advertsDetail.endTime.split(" ")[1];
            }
            
         
            	if(editor){ 
                editor.txt.html(vm.advertsDetail.content);
            }
            
            $('#advertsId').selectpicker('val', vm.advertsDetail.advertsId);
          
     
          /*  $(' #demo1').attr('src', vm.advertsDetail.picImg); */
            vm.src=vm.advertsDetail.picImg;
          /*  console.info(  $('#demo1'));*/
            var laydate = layui.laydate;
            if(vm.endTime){
            	var start =vm.startDate+" - "+vm.endDate;
            	var end =vm.startTime+" - "+vm.endTime;
            }else{
            	var start = "";
            	var end = "";
            }
            
            $("#test6").val(start);
            $("#test9").val(end);
           
		},
		saveOrUpdate: function (event) {
			if(!$("#test6").val()){
				alert("日期范围不能为空");
			 
			}else if(!$("#test9").val()){
				alert("时间范围不能为空");
			}
			
			else{
				
				vm.advertsDetail.advertsId=$('#advertsId').selectpicker('val');
				vm.advertsDetail.name=$("#advertsId  option:selected").text();
				if(editor){
					
					vm.advertsDetail.content =editor.txt.html();
				}
				vm.advertsDetail.beginTime=vm.startDate+" "+vm.startTime;
				vm.advertsDetail.endTime=vm.endDate+" "+vm.endTime;
				/*if(vm.advertsDetail.type==0){
				vm.advertsDetail.picImg = '';
				vm.advertsDetail.href = '';
 			}else if(vm.advertsDetail.type==1){
 				vm.advertsDetail.href = '';
				vm.advertsDetail.content = '';
			}else if(vm.advertsDetail.type==2){
				vm.advertsDetail.picImg = '';
 				vm.advertsDetail.content = '';
			}*/
				var url = vm.advertsDetail.advertsDetailId == null ? "adverts/advertsdetail/save" : "adverts/advertsdetail/update";
				$.ajax({
					type: "POST",
					url: baseURL + url,
					contentType: "application/json",
					data: JSON.stringify(vm.advertsDetail),
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
			}
		},
		del: function (event) {
			var advertsDetailIds = getSelectedRows();
			if(advertsDetailIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "adverts/advertsdetail/delete",
                    contentType: "application/json",
				    data: JSON.stringify(advertsDetailIds),
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
		getInfo: function(advertsDetailId){
			$.ajaxSettings.async = false;
			$.get(baseURL + "adverts/advertsdetail/info/"+advertsDetailId, function(r){
                vm.advertsDetail = r.advertsDetail;
            	
                
                	 
            });
			$.ajaxSettings.async = true;
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});