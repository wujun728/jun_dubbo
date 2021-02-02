$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'good/goodattribute/page',
        datatype: "json",
        colModel: [			
			{ label: 'attributeId', name: 'attributeId', index: 'attribute_id', width: 50, key: true },
			{ label: '商品ID', name: 'goodId', index: 'good_id', width: 80 }, 			
			{ label: '总库存', name: 'stock', index: 'stock', width: 80 }, 			
			{ label: '销售量', name: 'salesVolume', index: 'sales_volume', width: 80 }, 			
			{ label: '总访问量', name: 'pageViews', index: 'page_views', width: 80 }, 			
			{ label: '评论数量', name: 'commentNumber', index: 'comment_number', width: 80 }, 			
			{ label: '累计评价', name: 'commentTotal', index: 'comment_total', width: 80 }, 			
			{ label: '平均评价', name: 'commentAverage', index: 'comment_average', width: 80 }, 			
			{ label: '收藏数', name: 'favoriteNumber', index: 'favorite_number', width: 80 }, 			
			{ label: '提问数', name: 'questionNumber', index: 'question_number', width: 80 }			
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
		goodAttribute: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.goodAttribute = {};
		},
		update: function (event) {
			var attributeId = getSelectedRow();
			if(attributeId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(attributeId)
		},
		saveOrUpdate: function (event) {
			var url = vm.goodAttribute.attributeId == null ? "good/goodattribute/save" : "good/goodattribute/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.goodAttribute),
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
			var attributeIds = getSelectedRows();
			if(attributeIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "good/goodattribute/delete",
                    contentType: "application/json",
				    data: JSON.stringify(attributeIds),
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
		getInfo: function(attributeId){
			$.get(baseURL + "good/goodattribute/info/"+attributeId, function(r){
                vm.goodAttribute = r.goodAttribute;
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