
$(function() {
    $(window).on('resize', function () {
        var $content = $('#larry-tab .layui-tab-content');
        $content.height($(this).height() - 140);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
        });
    }).resize();
})
 

var menuItem2 = Vue.extend({
    name: 'menu-item2',
    props: {item: {},index:null},
    template: [
'<li :lay-id="index" v-if="item.type === 0" @click="estest(item.list)"  class="" :url="item.url" ><em>{{item.name}}</em><i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>'
 

].join('')
});

function estest(obj){
	vm.menuList = obj;
}
//生成菜单
var menuItem = Vue.extend({
    name: 'menu-item',
    props: {item: {}},
    template: [
        '<li class="layui-nav-item" >',
        '<a v-if="item.type === 0" href="javascript:;">',
        '<i v-if="item.icon != null" :class="item.icon"></i>',
        '<span>{{item.name}}</span>',
        '<em class="layui-nav-more"></em>',
        '</a>',
        '<dl v-if="item.type === 0" class="layui-nav-child">',
        '<dd v-for="item in item.list" >',
        '<a v-if="item.type === 1" href="javascript:;" :data-url="item.url"><i v-if="item.icon != null" :class="item.icon" :data-icon="item.icon"></i> <span>{{item.name}}</span></a>',
        '</dd>',
        '</dl>',
        '<a v-if="item.type === 1" href="javascript:;" :data-url="item.url"><i v-if="item.icon != null" :class="item.icon" :data-icon="item.icon"></i> <span>{{item.name}}</span></a>',
        '</li>'
    ].join('')
});

//注册菜单组件
Vue.component('menuItem', menuItem);
Vue.component('menuItem2', menuItem2);
isquery=true;
var vm = new Vue({
    el: '#layui_layout',
    data: {
    	system:'飞特',
        user: {},
        menuList: {},
        menuList2: {},
        mList:{},
        password: '',
        newPassword: '',
        navTitle: "首页"
    },
    methods: {
    	estest:function (obj){
    		console.info(obj);
    	},
        getMenuList: function () {
            $.getJSON("sys/menu/nav", function (r) {
               // vm.menuList = r.menuList;
                vm.menuList2 = r.menuList;
            });
        },
        getUser: function () {
            $.getJSON("sys/user/info?_" + $.now(), function (r) {
                vm.user = r.user;
            });
        },
        updatePassword: function () {
            layer.open({
                type: 1,
                skin: 'layui-layer-molv',
                title: "修改密码",
                area: ['550px', '270px'],
                shadeClose: false,
                content: jQuery("#passwordLayer"),
                btn: ['修改', '取消'],
                btn1: function (index) {
                    var data = "password=" + vm.password + "&newPassword=" + vm.newPassword;
                    $.ajax({
                        type: "POST",
                        url: "sys/user/password",
                        data: data,
                        dataType: "json",
                        success: function (result) {
                            if (result.code == 0) {
                                layer.close(index);
                                layer.alert('修改成功', function (index) {
                                    location.reload();
                                });
                            } else {
                                layer.alert(result.msg);
                            }
                        }
                    });
                }
            });
        },
        donate: function () {
            layer.open({
                type: 2,
                title: false,
                area: ['806px', '467px'],
                closeBtn: 1,
                shadeClose: false,
                content: ['http://img.cnadmart.com/20180621/f4bb4447a6894653b2da80fcd745390a.jpg', 'no']
            });
        }
    },
    created: function () {
        this.getMenuList();
        this.getUser();
    },updated:function(){

        $(".layui-tab-title").find('li').each(function(i, e) {
      	  var $this = $(this);
      	  console.info($this);
      	  $(this).on('click', function () {
      		  console.info($this.attr("url"));
      		  console.info( $("#memu-frame"));
      		  $("#memu-frame").attr("src",($this.attr("url")));
      		  //location.href=$this.attr("url");
      	  });
      });
    	
       /* if($("#larry-side .layui-nav-item>a").length==0 || !isquery){
            return;
        }*/
        console.log("执行")
        isquery=false;
        layui.config({
            base: 'statics/js/',
        }).use(['navtab','layer'], function(){
            window.jQuery = window.$ = layui.jquery;
            window.layer = layui.layer;
            var element = layui.element;
            var  navtab = layui.navtab({
                elem: '.larry-tab-box',
                closed:false
            });
            
            
          
            $('#larry-nav-side').children('ul').find('li').each(function () {
                var $this = $(this);
            	console.info("list:",$this);
                		
                   // var $dd = $this.find('dd').each(function () {
                        $(this).on('click', function () {
                        	console.info($this);
                            var $a = $(this).children('a');
                            var href = $a.attr("data-url")
                            
                             
                            console.info(href);
                            $("#test").attr("src",href);
                          //  navtab.tabAdd(data);
                        });
                   // });
                 
            });
            $('.larry-side-menu').click(function () {
                var sideWidth = $('#larry-side').width();
                if (sideWidth === 200) {
                    $('#larry-body').animate({
                        left: '0'
                    },1);
                    $('#larry-footer').animate({
                        left: '0'
                    },1);
                    $('#larry-side').animate({
                        width: '0'
                    },1);
                } else {
                    $('#larry-body').animate({
                        left: '200px'
                    },1);
                    $('#larry-footer').animate({
                        left: '200px'
                    },1);
                    $('#larry-side').animate({
                        width: '200px'
                    },1);
                }
            });

        });
    }
});