$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/good/list',
        datatype: "json",
        colModel: [			
			{ label: 'goodId', name: 'goodId', index: 'good_id', width: 50, key: true },
			{ label: '商品名称', name: 'goodName', index: 'good_name', width: 80 }, 			
			{ label: '商品编号', name: 'goodNumber', index: 'good_number', width: 80 }, 			
			{ label: '显示价格', name: 'showPrice', index: 'show_price', width: 80 }, 			
			{ label: '商品简介', name: 'introduce', index: 'introduce', width: 80 }, 			
			{ label: '展示图片', name: 'picImg', index: 'pic_img', width: 80 }, 			
			{ label: '是否置顶 1=置顶/0=默认', name: 'showInTop', index: 'show_in_top', width: 80 }, 			
			{ label: '是否导航栏 1=显示/0=隐藏', name: 'showInNav', index: 'show_in_nav', width: 80 }, 			
			{ label: '是否热门 1=热门/0=默认', name: 'showInHot', index: 'show_in_hot', width: 80 }, 			
			{ label: '是否上架：1=上架/0=下架', name: 'showInShelve', index: 'show_in_shelve', width: 80 }, 			
			{ label: '搜索的关键词', name: 'searchKey', index: 'search_key', width: 80 }, 			
			{ label: '页面标题', name: 'pageTitle', index: 'page_title', width: 80 }, 			
			{ label: '页面的描述', name: 'pageDescription', index: 'page_description', width: 80 }, 			
			{ label: '页面的关键词', name: 'pageKeyword', index: 'page_keyword', width: 80 }, 			
			{ label: '备注信息', name: 'remarks', index: 'remarks', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '创建者', name: 'createBy', index: 'create_by', width: 80 }, 			
			{ label: '上架时间', name: 'shelveTime', index: 'shelve_time', width: 80 }, 			
			{ label: '上架人', name: 'shelveBy', index: 'shelve_by', width: 80 }, 			
			{ label: '更新者', name: 'updateBy', index: 'update_by', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }			
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
		good: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.good = {};
		},
		update: function (event) {
			var goodId = getSelectedRow();
			if(goodId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(goodId)
		},
		saveOrUpdate: function (event) {
			var url = vm.good.goodId == null ? "sys/good/save" : "sys/good/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.good),
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
			var goodIds = getSelectedRows();
			if(goodIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/good/delete",
                    contentType: "application/json",
				    data: JSON.stringify(goodIds),
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
		getInfo: function(goodId){
			$.get(baseURL + "sys/good/info/"+goodId, function(r){
                vm.good = r.good;
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