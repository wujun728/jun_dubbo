$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'good/goodparameter/list',
        datatype: "json",
        colModel: [			
			{ label: 'goodParameterId', name: 'goodParameterId', index: 'good_parameter_id', width: 50, key: true },
			{ label: '商品ID', name: 'goodId', index: 'good_id', width: 80 }, 			
			{ label: '参数名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '参数值', name: 'value', index: 'value', width: 80 }, 			
			{ label: '状态：1.显示；0.隐藏', name: 'status', index: 'status', width: 80 }, 			
			{ label: '排序', name: 'sort', index: 'sort', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建者', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '更新者', name: 'updateBy', index: 'update_by', width: 80 }			
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
		goodParameter: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.goodParameter = {};
		},
		update: function (event) {
			var goodParameterId = getSelectedRow();
			if(goodParameterId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(goodParameterId)
		},
		saveOrUpdate: function (event) {
			var url = vm.goodParameter.goodParameterId == null ? "good/goodparameter/save" : "good/goodparameter/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.goodParameter),
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
			var goodParameterIds = getSelectedRows();
			if(goodParameterIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "good/goodparameter/delete",
                    contentType: "application/json",
				    data: JSON.stringify(goodParameterIds),
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
		getInfo: function(goodParameterId){
			$.get(baseURL + "good/goodparameter/info/"+goodParameterId, function(r){
                vm.goodParameter = r.goodParameter;
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