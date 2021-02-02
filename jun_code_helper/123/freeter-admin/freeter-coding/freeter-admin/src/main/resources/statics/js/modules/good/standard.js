var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: '商品规格', 
        spec:[] ,
        speclist:[] ,
        goodId:T.p('id'),
        categoryId:T.p('categoryId')
    } ,
    methods:{
    	insertSpec:function (type){
    		 let specObj = {};
    		 
     		 var addvalue = $("#spec"+type.id).val();
     		 if(addvalue == ''){
     			 alert("请输入规格值");
     			 return false;
     		 }
			specObj.specValue = addvalue;
			specObj.categorySpecId = type.id;
			specObj.goodId = this.goodId;
    		 vm.speclist.push(specObj); 
			console.info(JSON.stringify(vm.speclist));

    	},
    	remove:function (item) {
    	      this.speclist.splice(this.speclist.indexOf(item), 1)
        },
        save:function(){
         var url = "good/goodspecvalue/saveGoodSpecValue"
   			$.ajax({
				type: "POST",
			    url: baseURL + url,
               contentType: "application/json",
			    data: JSON.stringify(vm.speclist),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.next();
						});
					}else{
						alert(r.msg);
					}
				}
			});
        },
		next: function (event) {
			location.href='modules/good/stock.html?goodId='+vm.goodId;
		}
        
    },
  
    created: function () {
     
    }
    
})

function getSpec(){
	$.ajax({
		url : baseURL +"good/categoryspec/specList",//写你自己的方法，返回map，我返回的map包含了两个属性：data：集合，total：集合记录数量，所以后边会有data.data的写法。。。
		// 数据发送方式
		type : "get",
		// 接受数据格式
		dataType : "json",
		// 要传递的数据
		data : {is_show:1,categoryId:vm.categoryId},
		// 回调函数，接受服务器端返回给客户端的值，即result值
		success : function(data) {
			 
			 if(!data.data||data.data.length==0){
				alert("请先添加规格数据")
			} 
				$.each(data.data, function(i) {
					 let specObj = {};
					specObj.specName =  data.data[i].specName;
					specObj.id = data.data[i].id;
					 vm.spec.push(specObj);
 					 
				});

		},
		error : function(data) {

			alert("查询失败" + data);

		}
	})

}

$(document).on("ready", function() {
	
	getSpec();
	
// 添加属性值start
var AddButton = $(".AddMoreFileBox");  
var FieldCount=1;  
  
$(AddButton).on('click',(function (e) { 
	alert(1);
   var addvalue= $(this).prev('div').find('input').val();
   var addname= $(this).prev('div').find('input').attr("name");
   alert(addname);
    console.log(addvalue)
    FieldCount++; //text box added increment  
    //add input box  
    if(addvalue!==""){
    $(this).next('.InputsWrapper').append('<div class="col"><label class="col-sm-2 control-label"></label><div class="col-sm-4"><input  class="form-control" type="text"  readonly="" name="mytext[]" id="field_'+ FieldCount +'" value="'+addvalue+'"/></div><button type="button" class="btn btn-default" onclick="remove('+FieldCount+')">删除</button></div>'); 
		$(this).prev('div').find('input').val(""); 
			} else{
        alert("请输入属性值")
    } 

}));
// 添加属性值end   
})
 function remove (FieldCount){ 
	$("#field_"+FieldCount).parents('.col').remove()
}