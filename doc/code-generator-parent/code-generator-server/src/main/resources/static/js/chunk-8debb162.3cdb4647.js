(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-8debb162","chunk-2d0da03f"],{"6a97":function(e,t,a){"use strict";a.r(t);a("a4d3"),a("99af"),a("4de4"),a("4160"),a("caad"),a("c975"),a("d81d"),a("fb6a"),a("45fc"),a("a9e3"),a("e439"),a("dbb4"),a("b64b"),a("2532"),a("159b");var r=a("2638"),s=a.n(r),i=a("2fa7"),o=a("9839"),n=a("1834"),l=a("b775");function c(e,t){var a=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),a.push.apply(a,r)}return a}function d(e){for(var t=1;t<arguments.length;t++){var a=null!=arguments[t]?arguments[t]:{};t%2?c(Object(a),!0).forEach((function(t){Object(i["a"])(e,t,a[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(a)):c(Object(a)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(a,t))}))}return e}t["default"]={model:{prop:"value",event:"change"},data:function(){return{localOptions:[],localValue:this.value||this.defaultValue||void 0,optionData:[]}},props:Object.assign({},o["d"].props,{placeholder:{type:String,default:"请选择"},allowClear:{type:Boolean,default:!0},showSearch:{type:Boolean,default:!0},remote:{type:Object,default:function(){return{url:"",method:"get",params:{},formatter:function(){},properties:{label:"",value:""}}}},dType:{type:String},data:{type:Array,default:function(){return[]}},pageNum:{type:Number,default:15}}),watch:{value:function(e,t){this.localValue=e||this.defaultValue},data:function(e,t){this.loadLocalData(!0)},remote:function(){this.loadLocalData()},dType:function(){this.loadLocalData()}},created:function(){this.loadLocalData()},methods:{loadLocalData:function(e){var t=this;if(e||this.data&&this.data.length>0)this.translateData(this.data);else if(this.remote&&this.remote.url){var a=Object.assign({header:{"Content-Type":"application/json;charset=UTF-8"},method:"get",params:{},formatter:function(){},properties:{label:"",value:""}},this.remote);Object(l["b"])(a,this.remote).then((function(e){t.translateData(e.data||[])}))}else this.dType&&this.translateData(n["a"].query(this.dType)||[])},translateData:function(e){var t=[];e.forEach((function(e){t.push({title:"".concat(e.label),value:e.value,key:e.value+"",disabled:e.disabled||!1,_$origin:e})})),this.optionData=t,this.filterLocalOptions()},handleChange:function(e,t){this.localValue=e;var a=[];this.localOptions.some((function(t){if(t.value===e)return a=t,!0})),this.$emit("change",e,a,t)},handleSearch:function(e){this.filterLocalOptions(e||"")},handleFilterOption:function(e,t){return t.componentOptions.children[0].text.toLowerCase().indexOf(e.toLowerCase())>=0},filterLocalOptions:function(e){var t=this;if(e&&(e=(e+"").toLowerCase()),!e&&this.pageNum<1)this.localOptions=this.optionData;else{this.localOptions.length>0&&this.localOptions.slice(0,this.localOptions.length);var a=this,r=[];this.optionData.some((function(s){if(a.pageNum>0&&r.length>=t.pageNum)return!0;e?s.title.indexOf(e)>-1&&r.push(s):r.push(s)})),this.localOptions=r}}},render:function(){var e=this,t=arguments[0],a={},r=Object.keys(this.$data);Object.keys(o["d"].props).forEach((function(t){var s="local".concat(t.substring(0,1).toUpperCase()).concat(t.substring(1));return r.includes(s)?(a[t]=e[s],a[t]):(e[t]&&(a[t]=e[t]),a[t])}));var i=t("a-select",s()([{},{props:a,scopedSlots:d({},this.$scopedSlots)},{attrs:{"filter-option":this.handleFilterOption},on:{change:this.handleChange,search:this.handleSearch}}]),[Object.keys(this.$slots).map((function(a){return t("template",{slot:a},[e.$slots[a]])}))]);return i}}},"75af":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a-drawer",{attrs:{title:e.data.id?"数据源-修改":"数据源-新增",placement:"bottom",closable:!1,visible:e.visible,height:"350"},on:{close:e.onClose}},[a("a-form",{attrs:{form:e.form,layout:"vertical","hide-required-mark":""}},[a("a-row",{attrs:{gutter:16}},[a("a-col",{attrs:{span:6}},[a("a-form-item",{attrs:{label:"连接名称"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["connectionName",{rules:[{required:!0,message:"此项为必填项"}]}],expression:"[\n              'connectionName',\n              {\n                rules: [{ required: true, message: '此项为必填项' }]\n              }\n            ]"}],staticStyle:{width:"100%"},attrs:{placeholder:"请给连接命个名"}})],1)],1),a("a-col",{attrs:{span:6}},[a("a-form-item",{attrs:{label:"数据库类型"}},[a("c-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["dbType",{rules:[{required:!0,message:"此项为必选项"}]}],expression:"[\n              'dbType',\n              {\n                rules: [{ required: true, message: '此项为必选项' }]\n              }\n            ]"}],attrs:{"d-type":"dev_tool_db_type",placeholder:"请选择数据库类型"}})],1)],1),a("a-col",{attrs:{span:6}},[a("a-form-item",{attrs:{label:"驱动信息"}},[a("c-select",{directives:[{name:"decorator",rawName:"v-decorator",value:["driverName",{rules:[{required:!0,message:"此项为必选项"}]}],expression:"[\n              'driverName',\n              {\n                rules: [{ required: true, message: '此项为必选项' }]\n              }\n            ]"}],attrs:{data:e.drivers,placeholder:"请选择连接驱动"}})],1)],1),a("a-col",{attrs:{span:6}},[a("a-form-item",{attrs:{label:"连接地址"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["url",{rules:[{required:!0,message:"此项为必填项"}]}],expression:"[\n              'url',\n              {\n                rules: [{ required: true, message: '此项为必填项' }]\n              }\n            ]"}],attrs:{placeholder:"请输入标准连接URL"}})],1)],1)],1),a("a-row",{attrs:{gutter:16}},[a("a-col",{attrs:{span:6}},[a("a-form-item",{attrs:{label:"Schema 模式"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["schemaName"],expression:"['schemaName']"}],attrs:{placeholder:"适用于PG、Oracle类型库"}})],1)],1),a("a-col",{attrs:{span:6}},[a("a-form-item",{attrs:{label:"用户名"}},[a("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["username",{rules:[{required:!0,message:"此项为必填项"}]}],expression:"[\n              'username',\n              {\n                rules: [{ required: true, message: '此项为必填项' }]\n              }\n            ]"}],staticStyle:{width:"100%"},attrs:{placeholder:"输入数据库用户名"}})],1)],1),a("a-col",{attrs:{span:6}},[a("a-form-item",{attrs:{label:"密码",help:e.data.id?"为保障密码安全，若修改密码请输入新密码，否则默认不变更":""}},[a("a-input-password",{directives:[{name:"decorator",rawName:"v-decorator",value:["password",e.data.id?{}:{rules:[{required:!0,message:"此项为必填项"}]}],expression:"[\n              'password',\n              data.id ? {} :\n              {\n                rules: [{ required: true, message: '此项为必填项' }]\n              }\n            ]"}],attrs:{placeholder:"输入连接密码"}})],1)],1)],1)],1),a("div",{style:{position:"absolute",right:0,bottom:0,width:"100%",borderTop:"1px solid #e9e9e9",padding:"10px 16px",background:"#fff",textAlign:"right",zIndex:1}},[a("a-button",{style:{marginRight:"8px"},on:{click:e.onClose}},[e._v(" 取消 ")]),a("a-button",{attrs:{type:"primary"},on:{click:e.onSubmit}},[e._v(" 提交 ")])],1)],1)},s=[],i=(a("4de4"),a("4160"),a("c975"),a("b64b"),a("159b"),a("1834")),o=a("6a97"),n={name:"DatasourceEdit",components:{CSelect:o["default"]},props:{visible:{type:Boolean,default:!1},data:{type:Object,default:function(){return{}}}},data:function(){var e=this;return{form:this.$form.createForm(this,{onValuesChange:function(t,a,r){a.dbType&&e.changeDbType(a.dbType)}}),submitLoading:!1,drivers:[],fields:["id","connectionName","dbType","driverName","url","schemaName","username","password"]}},methods:{setData:function(e){var t=this;Object.keys(e).forEach((function(a){if(-1!==t.fields.indexOf(a)){t.form.getFieldDecorator(a);var r={};r[a]=e[a],t.form.setFieldsValue(r)}}))},onClose:function(){this.$emit("close"),this.submitLoading=!1,this.form.resetFields()},onSubmit:function(){var e=this;this.submitLoading||this.form.validateFields((function(t,a){if(!t){e.data.id&&(a.id=e.data.id),e.submitLoading=!0;var r=e.data.id?e.$http.put("api/dbsource/update",a):e.$http.post("api/dbsource/add",a);r.then((function(t){e.$emit("submit-success"),e.$message.success("提交处理成功"),e.submitLoading=!1,e.onClose()})).catch((function(t){e.submitLoading=!1}))}}))},changeDbType:function(e){this.form.resetFields("driverName"),this.drivers=[];var t=e;t&&i["a"].query("dev_tool_db_driver",(function(e){this.drivers=e.filter((function(e){return e.kind===t})),this.drivers.length>0&&this.form.setFieldsValue({driverName:this.drivers[0]["value"]})}),this)}}},l=n,c=a("2877"),d=Object(c["a"])(l,r,s,!1,null,"89909fb0",null);t["default"]=d.exports}}]);