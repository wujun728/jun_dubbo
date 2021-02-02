$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'adverts/adverts/page',
        datatype: "json",
        colModel: [			
			{ label: 'advertsId', name: 'advertsId', index: 'adverts_id', width: 50, key: true },
			{ label: '名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '宽度', name: 'width', index: 'width', width: 80 }, 			
			{ label: '高度', name: 'height', index: 'height', width: 80 }, 			
			{ label: '描述', name: 'description', index: 'description', width: 180 }, 			
/*			{ label: '模版内容', name: 'template', index: 'template', width: 80 }, 			
*//*			{ label: '默认显示个数', name: 'defultNumber', index: 'defult_number', width: 80 }, 			
*/			{ label: '广告数量', name: 'number', index: 'number', width: 80 }, 						
			{ label: '启用状态', name: 'status', index: 'status', width: 80 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">开启</span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">关闭</span>';
	            }  
	            return '<span class="label label-primary">开启</span>';
	           
	        }}, 						 						
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
		adverts: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.adverts = {};
		},
		status: function(){
			var advertsId = getSelectedRow();
			if(advertsId == null){
				return ;
			}
			  vm.getInfo(advertsId)
 			 layer.open({
			        type: 1,
			        offset: '50px',
			        skin: 'layui-layer-molv',
			        title: "设置规格",
			        area: ['300px', '300px'],
			        shade: 0,
			        shadeClose: false,
			        content: jQuery("#statusLayer"),
			        btn: ['确定', '取消'],
			        btn1: function (index) {
			        	$.ajax({
							type: "POST",
						    url: baseURL + "adverts/adverts/update",
			                contentType: "application/json",
						    data: JSON.stringify(vm.adverts),
						    success: function(r){
						    	if(r.code === 0){
									alert('操作成功', function(data){
										 layer.close(index);
									});
								}else{
									alert(r.msg, function(data){
									 layer.close(index);
									});
								} 
						    	vm.reload();
							}
						});
			           
			        }
			       
			    });
		},
		update: function (event) {
			var advertsId = getSelectedRow();
			if(advertsId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(advertsId)
		},
		saveOrUpdate: function (event) {
			var url = vm.adverts.advertsId == null ? "adverts/adverts/save" : "adverts/adverts/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.adverts),
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
			var advertsIds = getSelectedRows();
			if(advertsIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "adverts/adverts/delete",
                    contentType: "application/json",
				    data: JSON.stringify(advertsIds),
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
		getInfo: function(advertsId){
			$.get(baseURL + "adverts/adverts/info/"+advertsId, function(r){
                vm.adverts = r.adverts;
            });
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