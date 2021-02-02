$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'user/user/page',
        datatype: "json",
        colModel: [			
			{ label: 'userId', name: 'userId', index: 'user_id', width: 50, key: true },
			{ label: '手机号', name: 'phone', index: 'phone', width: 80 }, 				
			{ label: '用户昵称', name: 'userName', index: 'user_name', width: 80 }, 			
			{ label: '真实姓名', name: 'realName', index: 'real_name', width: 80 }, 			
			{ label: '性别', name: 'sex', index: 'sex', width: 80 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '男';
	            }
	            if(cellvalue == 1){
	                return '女';
	            }  
	            return '男';
	           
	        }}, 								 			
			{ label: '出生日期', name: 'birth', index: 'birth', width: 80 }, 			
			{ label: '年龄', name: 'age', index: 'age', width: 80 }, 			
			{ label: '用户头像', name: 'picImg', index: 'pic_img', width: 200 ,formatter: function(cellvalue, options, rowObject){
				 if(cellvalue)
			            return '<img  style="width:200x;height:200px;" src="'+cellvalue+'" />';
					 else
						 return '暂无图片';
			           
	           
	        }}, 			
			{ label: '状态 ', name: 'status', index: 'status', width: 80 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue == 0){
	                return '<span class="label label-primary">正常/span>';
	            }
	            if(cellvalue == 1){
	                return '<span class="label label-success">冻结</span>';
	            }  
	            return '<span class="label label-primary">正常</span>';
	           
	        }}, 								
			{ label: '总金额', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '用户类型', name: 'userType', index: 'user_type', width: 80 ,formatter: function(cellvalue, options, rowObject){
				if(cellvalue === 0){
	                return '<span class="label label-primary">会员/span>';
	            }
	            if(cellvalue === 1){
	                return '<span class="label label-success">其他</span>';
	            }  
	            return '<span class="label label-primary">会员</span>';
	           
	        }}, 											
			{ label: '注册时间', name: 'regeistTime', index: 'regeist_time', width: 80 }, 			
			/*{ label: '创建者', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '修改时间', name: 'updateTime', index: 'update_time', width: 80 }, 			
			{ label: '修改人', name: 'updateBy', index: 'update_by', width: 80 }, 	*/		
		/*	{ label: '身份证正面照', name: 'idcardFrontImg', index: 'idcard_front_img', width: 80 }, 			
			{ label: '身份证反面照', name: 'idcardBackImg', index: 'idcard_back_img', width: 80 }			*/
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
		user: {},
		search : {},
		selectSearch : 'phone',
		selectSearchVal : null

	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.user = {};
		},
		update: function (event) {
			var userId = getSelectedRow();
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(userId)
		},
		saveOrUpdate: function (event) {
			var birth =$("#test1").val();
			vm.user.birth = birth;
			var url = vm.user.userId == null ? "user/user/save" : "user/user/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.user),
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
			var userIds = getSelectedRows();
			if(userIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "user/user/delete",
                    contentType: "application/json",
				    data: JSON.stringify(userIds),
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
		getInfo: function(userId){
			$.get(baseURL + "user/user/info/"+userId, function(r){
                vm.user = r.user;
            	var birth =$("#test1").val(vm.user.birth );
    			 
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
  			 var search =  vm.search;
  			 //清空元素的值
  			for (var Key in search){
  		      search[Key] = "";
  		    }
			Vue.set(vm.search, vm.selectSearch, vm.selectSearchVal);
			 
			$("#jqGrid").jqGrid('setGridParam',{
					postData: vm.search,
					 page:page
					}).trigger("reloadGrid");
			 
		}, mounted: function () {
		 
			 
			 
        } 
	}
});