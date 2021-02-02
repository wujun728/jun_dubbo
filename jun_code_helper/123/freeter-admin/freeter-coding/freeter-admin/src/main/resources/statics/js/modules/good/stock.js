var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: '添加库存', 
        type:[
            {typename:"大小",id:'0'},
            {typename:"面积",id:'1'},
            {typename:"重量",id:'2'}
        ],
		good:[
		],
		goodId:T.p('goodId')
    } ,
    methods: {
        
    	saveOrUpdate: function(){
    		$.ajax({
				type: "POST",
			    url: baseURL + "good/goodspecprice/saveGoodSpecPriceEntity",
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
        reload: function(){
        	location.href="modules/good/good.html";
        	}
        }
})

function getGoodSpec(){
	$.ajax({
		url : baseURL +"good/goodspecprice/getGoodSpecPricelist",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "get",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : {goodId:vm.goodId},
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			console.info(data);
			 if(!data.data||data.data.length==0){
				alert("请先添加商品规格数据")
			} 
			 vm.good = data.data;

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}

$(function() {
	getGoodSpec();
	
	
});


function putin(){
	 
	var stock= $('#stock').val();
	var price= $('#price').val();
	var brand= $('#brand').val();
	var size= $('.size').val();
	var good = vm.good;
	for(var good in good){
		if(stock){
		vm.good[good].stock= stock;
		 
		}
		if(price){
		vm.good[good].price=price;
			 
		}
		if(brand){
			vm.good[good].salesVolume= brand;
		 
		}
	}
	 $('#stock').val('');
	 $('#price').val('');
	 $('#brand').val('');
	 $('.size').val('');
	}