$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL +'sys/generator/list',
        datatype: "json",
        colModel: [			
			{ label: '表名', name: 'tableName', width: 100, key: true },
			{ label: 'Engine', name: 'engine', width: 70},
			{ label: '表备注', name: 'comments', width: 100 },
			{ label: '创建时间', name: 'createTime', width: 100 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50,100,200],
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
		q:{
			tableName: null
		}
	},
	methods: {
		query: function () {
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'tableName': vm.q.tableName},
                page:1 
            }).trigger("reloadGrid");
		},
		generator: function() {
			var tableNames = getSelectedRows();
			if(tableNames == null){
				return ;
			}
			location.href = baseURL +"sys/generator/code?tables=" +   tableNames.join();
		},
		generatorAll: function() {
			var tableNames = getSelectedRows();
			if(tableNames == null){
				return ;
			}
			confirm('是否覆盖后端接口代码', function(){
			 $.get( baseURL +"sys/generator/allcode?tables=" +  tableNames.join(), function(r){
				  if(r.code == 0){
					  alert(r.msg, function(){
                         vm.reload();
                     });
                 }else{
                     alert(r.msg);
                 }
	            });
			});
 		},
 		genAPI: function() {
			var tableNames = getSelectedRows();
			if(tableNames == null){
				return ;
			}
			confirm('是否覆盖移动端接口代码', function(){
			 $.get( baseURL +"sys/generator/genAPI?tables=" +  tableNames.join(), function(r){
				  if(r.code == 0){
					  alert(r.msg, function(){
                         vm.reload();
                     });
                 }else{
                     alert(r.msg);
                 }
	            });
			});
 		},
 		generatorDoc: function() {
			 
			confirm('是否要数据库生成文档，高版本word打开，并另存为doc', function(){
				location.href = "sys/generator/doc";
			});
 		},
 		genVO: function() {
			var tableNames = getSelectedRows();
			if(tableNames == null){
				return ;
			}
			confirm('是否生成VO实体类代码', function(){
			  $.get( baseURL +"sys/generator/genVO?tables=" +   tableNames.join(), function(r){
				  if(r.code == 0){
					  alert(r.msg, function(){
                          vm.reload();
                      });
                  }else{
                      alert(r.msg);
                  }
	            });
			});
		},
 		genEntity: function() {
			var tableNames = getSelectedRows();
			if(tableNames == null){
				return ;
			}
			confirm('是否只生成实体类代码', function(){
			  $.get( baseURL +"sys/generator/genEntity?tables=" +  tableNames.join(), function(r){
				  if(r.code == 0){
					  alert(r.msg, function(){
                          vm.reload();
                      });
                  }else{
                      alert(r.msg);
                  }
	            });
			});
		},
		genController: function() {
			var tableNames = getSelectedRows();
			if(tableNames == null){
				return ;
			}
			confirm('是否只生成后端controller代码', function(){
			  $.get( baseURL +"sys/generator/genController?tables=" +   tableNames.join(), function(r){
				  if(r.code == 0){
					  alert(r.msg, function(){
                          vm.reload();
                      });
                  }else{
                      alert(r.msg);
                  }
	            });
			  }); 
		}
	}
});

