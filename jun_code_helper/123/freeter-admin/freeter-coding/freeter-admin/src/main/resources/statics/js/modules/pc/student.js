$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'pc/student/page',
        datatype: "json",
        colModel: [			
			{ label: 'studentId', name: 'studentId', index: 'student_id', width: 50, key: true },
			{ label: '性别（1：男，0：女）', name: 'sex', index: 'sex', width: 80 }, 			
			{ label: '姓名', name: 'studentName', index: 'student_name', width: 80 }, 			
			{ label: '身份证', name: 'idCart', index: 'id_cart', width: 80 }, 			
			{ label: '学号', name: 'studentNo', index: 'student_no', width: 80 }, 			
			{ label: '学校id', name: 'schoolId', index: 'school_id', width: 80 }, 			
			{ label: '专业id', name: 'professionalId', index: 'professional_id', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建人', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '会员标识(1:会员 0：普通)', name: 'member', index: 'member', width: 80 }, 			
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
		student: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.student = {};
		},
		update: function (event) {
			var studentId = getSelectedRow();
			if(studentId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(studentId)
		},
		saveOrUpdate: function (event) {
			var url = vm.student.studentId == null ? "pc/student/save" : "pc/student/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.student),
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
			var studentIds = getSelectedRows();
			if(studentIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "pc/student/delete",
                    contentType: "application/json",
				    data: JSON.stringify(studentIds),
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
		getInfo: function(studentId){
			$.get(baseURL + "pc/student/info/"+studentId, function(r){
                vm.student = r.student;
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