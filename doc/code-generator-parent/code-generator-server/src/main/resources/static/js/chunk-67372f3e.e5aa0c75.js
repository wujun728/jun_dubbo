(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-67372f3e","chunk-2d0decf4"],{"0fea":function(e,t,n){"use strict";n.d(t,"c",(function(){return o})),n.d(t,"b",(function(){return i})),n.d(t,"a",(function(){return s}));var a=n("b775"),r={user:"/user",role:"/role",service:"/service",permission:"/permission",permissionNoPager:"/permission/no-pager",orgTree:"/org/tree"};function o(e){return Object(a["b"])({url:r.user,method:"get",params:e})}function i(e){return Object(a["b"])({url:r.service,method:"get",params:e})}function s(e){return Object(a["b"])({url:r.orgTree,method:"get",params:e})}},"4b10":function(e,t,n){"use strict";var a=n("de65"),r=n.n(a);r.a},"82c7":function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("a-card",{attrs:{bordered:!1}},[n("a-row",{attrs:{gutter:8}},[n("a-col",{attrs:{span:5}},[n("s-tree",{attrs:{dataSource:e.orgTree,openKeys:e.openKeys,search:!0},on:{"update:openKeys":function(t){e.openKeys=t},"update:open-keys":function(t){e.openKeys=t},click:e.handleClick,add:e.handleAdd,titleClick:e.handleTitleClick}})],1),n("a-col",{attrs:{span:19}},[n("s-table",{ref:"table",attrs:{size:"default",columns:e.columns,data:e.loadData,alert:!1,rowSelection:{selectedRowKeys:e.selectedRowKeys,onChange:e.onSelectChange}},scopedSlots:e._u([{key:"action",fn:function(t,a){return n("span",{},[e.$auth("table.update")?[n("a",{on:{click:function(t){return e.handleEdit(a)}}},[e._v("编辑")]),n("a-divider",{attrs:{type:"vertical"}})]:e._e(),n("a-dropdown",[n("a",{staticClass:"ant-dropdown-link"},[e._v(" 更多 "),n("a-icon",{attrs:{type:"down"}})],1),n("a-menu",{attrs:{slot:"overlay"},slot:"overlay"},[n("a-menu-item",[n("a",{attrs:{href:"javascript:;"}},[e._v("详情")])]),e.$auth("table.disable")?n("a-menu-item",[n("a",{attrs:{href:"javascript:;"}},[e._v("禁用")])]):e._e(),e.$auth("table.delete")?n("a-menu-item",[n("a",{attrs:{href:"javascript:;"}},[e._v("删除")])]):e._e()],1)],1)],2)}}])})],1)],1),n("org-modal",{ref:"modal",on:{ok:e.handleSaveOk,close:e.handleSaveClose}})],1)},r=[],o=(n("99af"),n("1bff")),i=n("2af9"),s=n("86dd"),c=n("0fea"),l={name:"TreeList",components:{STable:i["g"],STree:o["a"],OrgModal:s["default"]},data:function(){var e=this;return{openKeys:["key-01"],queryParam:{},columns:[{title:"#",dataIndex:"no"},{title:"成员名称",dataIndex:"description"},{title:"登录次数",dataIndex:"callNo",sorter:!0,needTotal:!0,customRender:function(e){return e+" 次"}},{title:"状态",dataIndex:"status",needTotal:!0},{title:"更新时间",dataIndex:"updatedAt",sorter:!0},{title:"操作",dataIndex:"action",width:"150px",scopedSlots:{customRender:"action"}}],loadData:function(t){return Object(c["b"])(Object.assign(t,e.queryParam)).then((function(e){return e.result}))},orgTree:[],selectedRowKeys:[],selectedRows:[]}},created:function(){var e=this;Object(c["a"])().then((function(t){e.orgTree=t.result}))},methods:{handleClick:function(e){this.queryParam={key:e.key},this.$refs.table.refresh(!0)},handleAdd:function(e){this.$message.info("提示：你点了 ".concat(e.key," - ").concat(e.title," ")),this.$refs.modal.add(e.key)},handleTitleClick:function(e){},titleClick:function(e){},handleSaveOk:function(){},handleSaveClose:function(){},onSelectChange:function(e,t){this.selectedRowKeys=e,this.selectedRows=t}}},d=l,u=(n("4b10"),n("2877")),f=Object(u["a"])(d,a,r,!1,null,null,null);t["default"]=f.exports},"86dd":function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("a-modal",{attrs:{title:"操作",width:600,visible:e.visible,confirmLoading:e.confirmLoading},on:{ok:e.handleOk,cancel:e.handleCancel}},[n("a-spin",{attrs:{spinning:e.confirmLoading}},[n("a-form",{attrs:{form:e.form}},[n("a-form-item",{attrs:{label:"父级ID"}},[n("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["parentId",{}],expression:"['parentId', {}]"}],attrs:{disabled:""}})],1),n("a-form-item",{attrs:{label:"机构名称"}},[n("a-input",{directives:[{name:"decorator",rawName:"v-decorator",value:["orgName",{}],expression:"['orgName', {}]"}]})],1)],1)],1)],1)},r=[],o=(n("a4d3"),n("4de4"),n("4160"),n("e439"),n("dbb4"),n("b64b"),n("d3b7"),n("159b"),n("2fa7"));function i(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function s(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?i(Object(n),!0).forEach((function(t){Object(o["a"])(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):i(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}var c={name:"OrgModal",data:function(){return{labelCol:{xs:{span:24},sm:{span:5}},wrapperCol:{xs:{span:24},sm:{span:16}},visible:!1,confirmLoading:!1,mdl:{}}},beforeCreate:function(){this.form=this.$form.createForm(this)},created:function(){},methods:{add:function(e){this.edit({parentId:e})},edit:function(e){var t=this;this.mdl=Object.assign({},e),this.visible=!0,this.$nextTick((function(){t.form.setFieldsValue(s({},e))}))},close:function(){this.$emit("close"),this.visible=!1},handleOk:function(){var e=this;this.form.validateFields((function(t,n){t||(e.confirmLoading=!0,new Promise((function(e){setTimeout((function(){return e()}),2e3)})).then((function(){e.$message.success("保存成功"),e.$emit("ok")})).catch((function(){})).finally((function(){e.confirmLoading=!1,e.close()})))}))},handleCancel:function(){this.close()}}},l=c,d=n("2877"),u=Object(d["a"])(l,a,r,!1,null,null,null);t["default"]=u.exports},de65:function(e,t,n){}}]);