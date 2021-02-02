###   **飞特后台管理系统是接私活利器，企业级快速开发框架**

 
###  **技术选型** 

- 注册中心：zookeeper
- 分布式治理框架 :dubbo
- 核心框架：Spring Boot
- 权限框架：Apache Shiro
- 模板引擎：Freemarker
- 持久层框架：MyBatis 和 MyBatis-plus
- 数据库连接池：Alibaba Druid
- 缓存框架：J2cache、Redis
- 日志管理：LogBack
- 工具类：Apache Commons、HuTools
- 视图框架：Spring MVC
- 定时器：Quartz
- 数据库连接池：Druid
- 日志管理：logback
- 页面交互：layui
- 下拉框：bootstrap-select
- 文件上传：Bootstrap File Input
- 热部署 jrebel
- 验证框架 hibernate-validator



### 
### **具有如下特点** 

###  **

 **-  **飞特** 的目标是接近 **人工智能** 。
** 

** 
- 火爆的商场模块，后续会加入更多的商城模块
- 超级代码生成器，可直接生成到IDE中，eclipse和ij都可以
- 引入2Cache 是 OSChina 目前正在使用的两级缓存框架
- 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
- 完善的部门管理及数据权限，通过注解实现数据权限的控制
- 完善的XSS防范及脚本过滤，支持白名单过滤,彻底杜绝XSS攻击
- 支持分布式部署，session存储在redis中
- 友好的代码结构及注释，便于阅读及二次开发
- 引入quartz定时任务，可动态完成任务的添加、修改、删除、暂停、恢复及日志查看等功能
- 页面交互使用layui,vue.js，极大的提高了开发效率
- 引入swagger文档支持，方便编写API接口文档
- 提供了超级代码生成器，可以生成hibernate-validtor验证注解如非空字段的验证，swagger-ui注解，
多表分页查询sql,后端模块代码 （控制器 到 视图），移动端模块代码（接口）只需编写30%左右代码，
其余的代码交给系统自动生成，可快速完成开发任务。现已支持mysql、oracle代码生成。 


<br>

###  **项目结构** 


:fa-minus: freeter-coding<br>
:fa-minus: freeter-admin 后台管理 <br>
:fa-minus: freeter-common 公共模块<br>
:fa-minus: freeter-good 商品模块<br>
:fa-minus: freeter-user 会员模块<br>
:fa-minus: freeter-job  定时任务模块<br>
:fa-minus: freeter-api 移动端接口模块<br>
:fa-minus: freeter-generator 独立代码生成器模块 

<br> 

 

###  **商城模块** 




频道列表： 可以理解为一级分类， 特殊的分类 底下可以不挂分类也可以挂视频，图片等等。

商品分类：有两级分类  商品可以修改二级分类 一级分类可以修改 因为一级分类绑定了规格而二级分类没有。

商品规格： 可以设置通用规格 也可以与一级分类绑定设置规格。商品规格可以重置 可以删除

商品基础功能全部完成。

会员管理

 **软件需求** 
- JDK1.8
- MySQL5.5+
- Tomcat8+
- Maven3.0+

<br>

### 本地部署




1.git下载https://gitee.com/xcOschina/freeter-admin.git项目,完成后导入到ide中 <br>
2.eclipse File import... Maven Existing Projects into Workspace 选择项目的根路径。<br>
3.IDE会下载maven依赖包，自动编译 如果有报错 请update project... jdk环境配置。<br>
4.执行doc/freeter.sql文件，初始化数据【按需导入表结构及数据】<br>
5.最后修改数据库连接参数,配置文件在src/main/resources/application.yml<br>
6.j2cache:
    config-location: /cache/j2cache-no.properties     
    open-spring-cache: true  

 :fa-star: j2cache-no.properties    就是不使用缓存 <br>
 :fa-star: j2cache-redis.properties redis 使用二级缓存<br>
 :fa-star:j2cache-caffeine.properties 使用一级缓存<br>

7.在freeter-coding目录下，执行mvn clean install
<br>
8、如何运行
- Eclipse或IDEA运行AdminApplication.java，则可启动项目【freeter-admin】
- freeter-admin访问路径：http://localhost:8080/freeter-admin/index.html
- 账号密码：admin/admin




<br>
 
 ** **后端项目演示**** 
- 演示地址：<a href="http://47.106.39.83:8080/freeter-admin/login.html"  target="_blank">
47.106.39.83:8080/freeter-admin/login.htm</a>
- 账号密码：admin/admin




**如何交流、反馈、参与贡献？** 
- 开发文档：https://gitee.com/xcOschina/freeter-admin.git
- 官方免费QQ群：806251058<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=4469c242246546fbe5548083e31b154f5f27df10c777c9ace61b094fbf7d922f"><img border="0" src="//pub.idqqimg.com/wpa/images/group.png" alt="飞特开源技术交流" title="飞特开源技术交流"></a>
- gitee仓库：https://gitee.com/xcOschina/freeter-admin.git![输入图片说明]

- github仓库：暂不考虑，支持国产
- 如需关注项目最新动态，请Watch、Star项目，同时也是对项目最好的支持
- 技术讨论、二次开发等咨询、问题和建议，请移步到官方免费QQ群，我会在第一时间进行解答和回复！
- 微信扫码并关注【飞特开源】，获得项目最新动态及更新提醒，暂未开放<br>
- 点击链接加入群聊【飞特开源技术交流】：https://jq.qq.com/?_wv=1027&k=5DJ0G9i

<br>
<br>
<br>

**代码生成器：**
 **- 项目结构** 
![输入图片说明](https://images.gitee.com/uploads/images/2018/0822/091848_caa9c86a_728634.png "在这里输入图片标题")

<br>

 **- 通过注解可以实现like查询并支持多表** 
![输入图片说明](https://images.gitee.com/uploads/images/2018/0822/091350_1abba2da_728634.png "屏幕截图.png")




<br>

**后端模块自动生成的实体类：**

    @TableName("cn_good") 
    @ApiModel(value = "Good")
    public class GoodEntity<T> implements Serializable {

	private static final long serialVersionUID = 1L;


	public GoodEntity() {
		
	}
	
	public GoodEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 商品ID
	 */
	
	@TableId 					
	@ApiModelProperty(value = "商品ID",hidden = true)
	private Integer goodId;
	
	/**
	 * 商品名称
	 */
				
	@NotBlank (message = "商品名称不能为空") 			
	@ApiModelProperty(value = "商品名称")
	private String goodName;
	

**mapper 有外键自动生成多表关联语句：**

`<select id="selectListView"  `

resultType="com.freeter.modules.pc.entity.view.StudentView"`>`

`SELECT  student.* FROM t_student  student `			   
        left join  t_professional  professional on `

 professional.professional_id = student.professional_id 	`	   
        left join t_school  school on  school.school_id = student.school_id   `
      
        <where> 1=1 ${ew.sqlSegment}</where>
	</select>`
	



特别鸣谢：


baomidou / mybatis-plus

 红薯 / J2Cache

![捐赠](http://img.cnadmart.com/20180621/f4bb4447a6894653b2da80fcd745390a.jpg "捐赠") !