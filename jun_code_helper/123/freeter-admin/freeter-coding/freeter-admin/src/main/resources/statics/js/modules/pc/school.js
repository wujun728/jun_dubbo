$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pc/school/list',
        datatype: "json",
        colModel: [			
			{ label: 'schoolId', name: 'schoolId', index: 'school_id', width: 50, key: true },
			{ label: '排序', name: 'schoolName', index: 'school_name', width: 80 }, 			
			{ label: '排序', name: 'sort', index: 'sort', width: 80 }, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }			
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
		school: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.school = {};
		},
		update: function (event) {
			var schoolId = getSelectedRow();
			if(schoolId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(schoolId)
		},
		saveOrUpdate: function (event) {
			var url = vm.school.schoolId == null ? "pc/school/save" : "pc/school/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.school),
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
			var schoolIds = getSelectedRows();
			if(schoolIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "pc/school/delete",
                    contentType: "application/json",
				    data: JSON.stringify(schoolIds),
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
		getInfo: function(schoolId){
			$.get(baseURL + "pc/school/info/"+schoolId, function(r){
                vm.school = r.school;
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