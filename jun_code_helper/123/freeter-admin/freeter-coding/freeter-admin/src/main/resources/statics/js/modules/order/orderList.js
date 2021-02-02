function getOrderStatus(orderStatus){
	  switch(orderStatus){
      case 0:
         return "待支付";
          break;
      case 1:
    	  return("待支付关闭");
          break;
      case 2:
    	  return("待发货");
          break;
      case 3:
    	  return("待收货");
          break;
      case 4:
    	  return("已收货");
          break;
      case 5:
    	  return("待评价");
          break;
      case 6:
    	  return("申请退款");
          break;
      case 7:
    	  return("退款完成");
          break;
      case 8:
    	  return("已完成订单");
          break;
  }
}
$(function () {
    $('.buttoonnamber input').removeClass('active')
    $('.buttoonnamber input').eq(0).addClass('active');
    $('.buttoonnamber input').click(function(){

        $('.buttoonnamber input').removeClass('active');
        $(this).addClass('active');


    })
    $("#selectType").bind("change",function(){
        var selectTypeValue=$(this).val();
        if(selectTypeValue=="userName"){
            $(".form-control")[1].placeholder="请输入用户名";
        }else if(selectTypeValue=="tel"){
            $(".form-control")[1].placeholder="请输入收货人电话";
        }else{
            $(".form-control")[1].placeholder="请输入订单号";
        }
    });
    $("#jqGrid").jqGrid({
        url: baseURL + 'order/orderList',
        datatype: "json",
        colModel: [
           /* { label: '用户名称', name: 'userName', width: 90 },
            { label: '订单编号', name: 'orderNo', width: 100},
            { label: '订单金额', name: 'totalAmount',  width: 90 },
            { label: '收货人', name: 'consignee',  width: 100 },
            { label: '订单提交时间', name: 'createdTime', width: 130 },
            { label: '收货地址', name: 'address',  width: 90},
            { label: '电话', name: 'tel', width: 70 },
            { label: '快递单号', name: 'expressNumber', width: 120 },
            { label: '快递公司', name: 'expressCompanyNo', width: 130 },
            { label: '订单状态', name: 'orderStatus', width: 90 },
            {
                label: '查看商品', name: '', index: 'operate', width: 50, align: 'center',
                formatter: function (cellvalue, options, rowObject) {
                    var detail="<input type='button' value='查看商品' onclick='getOrderGood(\""+rowObject.orderId+"\")'>";
                    return detail;
                },
            },
            { label: '订单id',  name:'orderId',width:80,hidden:'true'}*/
            { label: '用户名', name: 'userName', width: 120 },
            { label: '订单编号', name: 'orderNo', width: 210},
            { label: '总额', name: 'totalMoney',  width: 60 },
            { label: '收货人', name: 'consignee',  width: 180 , formatter: function (cellvalue, options, rowObject) {
                 
                return cellvalue +" ("+rowObject.tel+")";
            }},
            { label: '订单提交时间', name: 'createdTime', width: 180 },
            { label: '收货地址', name: 'detailedAddress',width: 210},
          /*  { label: '收货人电话', name: 'tel', width: 70 },*/
            { label: '快递单号', name: 'expressNumber', width: 210, formatter: function (cellvalue, options, rowObject) {
                 if(rowObject.expressCompanyName){
                	 
                	 return cellvalue +" ("+rowObject.expressCompanyName+")";
                 }
                 return cellvalue + "（暂无快递公司）";
                 
            }},
          /*  { label: '快递公司', name: 'expressCompanyName' },*/
            { label: '订单状态', name: 'orderStatus', width: 80, formatter: function (cellvalue, options, rowObject) {     
             	return getOrderStatus(cellvalue);
            }},
            {
                label: '订单商品', name: '', index: 'operate', width: 80, align: 'center',
                formatter: function (cellvalue, options, rowObject) {
                    var detail="<input type='button' value='查看' onclick='getOrderGood(\""+rowObject.id+"\")'>";
                    return detail;
                },
            },
            { label: '订单id',  name:'id',width:80,hidden:'true'}


        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList : [10,30,50],
        rownumbers: false,
        rownumWidth: 25,
        autowidth:true,
        shrinkToFit:true,
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
            sel: null
        },
        showList: true,
        showGoodList:true,
        title: null,
        orderModel:{},
        orderGoodModel:{},
        selectType:null


    },
    methods: {
        query: function (orderStatus) {
            vm.reload(orderStatus);
        },
        reload: function (orderStatus) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam','page');
            var selectType=$("#selectType").val();
            console.log(selectType);
            $("#jqGrid").jqGrid('setGridParam',{
                postData:{"selectValue":vm.q.sel ,"orderStatus":orderStatus,"selectType":selectType},
                page:page
            }).trigger("reloadGrid");
        },
        update:function(event){
            //var rowId=$("#jqGrid").jqGrid("getGridParam","selrow");
            var rowId=getSelectedRow();
            var orderId = $("#jqGrid").jqGrid("getRowData",rowId).orderId;
            if(orderId == null){
                return ;
            }
            vm.showList = false;
            vm.showGoodList=true;
            vm.title = "修改";
            vm.getInfo(orderId);
        },
        saveOrUpdate: function (event) {
            var url = vm.orderModel.orderId == null ? "order/save" : "order/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.orderModel),
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
        getInfo: function(orderId){
            $.get(baseURL + "order/info/"+orderId, function(r){
                vm.orderModel = r.orderModel;
            });
        }

    }
});
var i=0;
function getOrderGood(orderId){
    i++;
    if(i>1){
        $("#goodTable").jqGrid("setGridParam",{
            url: baseURL + 'order/good/'+orderId
        }).trigger("reloadGrid");
    }
    console.log(orderId);
        vm.showGoodList=false;
        $("#goodTable").jqGrid({
                url:baseURL+'order/good/'+orderId,
                datatype: "json",
                colModel: [
                    { label: '商品名称', name: 'goodName', width: 200 },
                    { label: '商品规格', name: 'goodSpec', width: 400},
                    { label: '单价', name: 'unitPrice', width: 200},
                    { label: '购买数量', name: 'goodCount',  width: 300 }
                ],
                viewrecords: true,
                height: 200,
                rowNum: 10,
                rowList : [10,30,50],
                rownumbers: true,
                rownumWidth: 25,
                autowidth:true,
                multiselect: false,
                pager: "#orderGoodPager",
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
                    $("#goodTable").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
                }
            }
        )


}




