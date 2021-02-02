$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'good/channel/list',
        datatype: "json",
        colModel: [			
			{ label: 'channelId', name: 'channelId', index: 'channel_id', width: 50, key: true },
			{ label: '频道名称', name: 'name', index: 'name', width: 80 }, 			
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

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		channel: {}
	},
	methods: {
		 
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.channel = {};
			vm.channel.sort=0;
		},
		update: function (event) {
			var channelId = getSelectedRow();
			if(channelId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(channelId)
		},
		saveOrUpdate: function (event) {
			var url = vm.channel.channelId == null ? "good/channel/save" : "good/channel/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.channel),
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
			var channelIds = getSelectedRows();
			if(channelIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "good/channel/delete",
                    contentType: "application/json",
				    data: JSON.stringify(channelIds),
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
		getInfo: function(channelId){
			$.get(baseURL + "good/channel/info/"+channelId, function(r){
                vm.channel = r.channel;
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