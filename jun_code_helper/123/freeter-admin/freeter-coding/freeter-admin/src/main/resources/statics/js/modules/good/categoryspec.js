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
 			 if(!data.data||data.data.length==0){
				alert("请先添加频道数据")
			} 
 			$('#search_channelId').append(
			"<option value=''>所有频道 </option>");
 			
				$('#channelId').append(
				"<option value=''>所有频道 </option>");
			$.each(data.data, function(i) {
				$('#search_channelId').append(
						"<option value=" + data.data[i].channelId + ">"
								+ data.data[i].name + "</option>");
				$('#channelId').append(
						"<option value=" + data.data[i].channelId + ">"
								+ data.data[i].name + "</option>");
			});
  			$('#channelId').selectpicker('refresh');
 			$('#channelId').selectpicker('val', '');
 			$('#channelId').selectpicker('render');
 			$('#search_channelId').selectpicker('refresh');
 			$('#search_channelId').selectpicker('val', '');
 			$('#search_channelId').selectpicker('render');

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}
function getOneCategoryList() {//
	var channelId =   $('#channelId').selectpicker('val');
	if(!channelId){
		channelId =   $('#search_channelId').selectpicker('val');
	}
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
			console.info(data);
			 if(!data.data||data.data.length==0){
				alert("请先添加商品分类数据")
			} 
				$('#search_oneCategory').empty();
	 			$('#search_oneCategory').append(
				"<option value=''>所有分类 </option>");
	 			
			$('#categoryIdAdd').empty();
	 			$('#categoryId').empty();
			$.each(data.data, function(i) {
				$('#search_oneCategory').append(
						"<option value=" + data.data[i].categoryId   + ">"
								+ data.data[i].name + "</option>");
				
				$('#categoryId').append(
						"<option value=" + data.data[i].categoryId + ">"
								+ data.data[i].name + "</option>");
				
				$('#categoryIdAdd').append(
						"<option value=" + data.data[i].categoryId + ">"
						+ data.data[i].name + "</option>");
			});
  			$('#categoryId').selectpicker('refresh');
 			$('#categoryId').selectpicker('val', '');
 			$('#categoryIdAdd').selectpicker('refresh');
 			$('#categoryIdAdd').selectpicker('val', '');
 			$('#search_oneCategory').selectpicker('refresh');
 			$('#search_oneCategory').selectpicker('val', '');
		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

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
	
	  $('#search_channelId').change(function(){ 
		  getOneCategoryList();  
	  });
	
	  $('#channelId').change(function(){ 
		  getOneCategoryList();  
	  });
	
	$(".selectpicker").selectpicker({  
	    noneSelectedText : '请选择'  ,
	    liveSearchPlaceholder : "请输入关键字",
	    noneResultsText : "内容无法匹配"
	});
	getchannelList();
	getOneCategoryList();
    $("#jqGrid").jqGrid({
        url: baseURL + 'good/categoryspec/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '商品分类', name: 'categoryName', index: 'categoryName', width: 80 }, 			
			{ label: '规格名称', name: 'specName', index: 'spec_name', width: 80 }, 			
			{ label: '规格排序', name: 'sort', index: 'sort', width: 80 }, 			
			{ label: '是否可见 ', name: 'isShow', index: 'is_show', width: 80 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">隐藏</span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">显示</span>';
	            }  
	            return '<span class="label label-primary">隐藏</span>';
	           
	        }}, 			
			{ label: '手机端是否可见', name: 'isMobileShow', index: 'is_mobile_show', width: 80 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">隐藏</span>';
	            }
				
	            if(cellvalue == 1){
	                return '<span class="label label-success">显示</span>';
	            }  
	            return '<span class="label label-primary">隐藏</span>';
	        }}			
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		categorySpec: {},
		 addShow:true,
		 search:{}
	},
	methods: {
		query: function () {
			vm.search.categoryId =$('#search_oneCategory').selectpicker('val');
			vm.reload();
		},
		add: function(){
			$('#channelId').selectpicker('val', '');
			vm.addShow=true;
			vm.showList = false;
			vm.title = "新增";
			vm.categorySpec = {sort:0,isShow:1,isMobileShow:1};
		},
		update: function (event) {
			$('#channelId').selectpicker('val', '');
			vm.addShow=false;
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
        	$.get(baseURL + "good/categoryspec/info/"+id, function(r){
                vm.categorySpec = r.categorySpec;
                $('#categoryId').selectpicker('val', vm.categorySpec.categoryId);
            });
          
		},
		saveOrUpdate: function (event) {
			var url = vm.categorySpec.id == null ? "good/categoryspec/save" : "good/categoryspec/update";
			vm.categorySpec.categoryId =$('#categoryId').selectpicker('val');
			vm.categorySpec.categoryIds =$('#categoryIdAdd').selectpicker('val');
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.categorySpec),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "good/categoryspec/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get(baseURL + "good/categoryspec/info/"+id, function(r){
                vm.categorySpec = r.categorySpec;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
			    postData:vm.search,
                page:page
            }).trigger("reloadGrid");
		}
	}
});