<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         id="WebApp_ID" version="3.0">

    <display-name>${conf.webModuleName}</display-name>

    <!-- this listener must be defined before the spring listener -->
    <!--<listener>-->
        <!--<listener-class>com.alibaba.dubbo.remoting.http.servlet.BootstrapListener</listener-class>-->
    <!--</listener>-->

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <listener>
        <listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
    </listener>

    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>
            classpath*:applicationContext-shiro.xml,
            classpath*:applicationContext-server.xml,
            classpath*:applicationContext-dao.xml,
            classpath*:applicationContext-core.xml
            <!--classpath*:applicationContext-scheduler.xml,-->
            <!--classpath*:cxf-demo-provider.xml,-->
            <!--classpath*:msa-demo-provider.xml,-->
            <!--classpath*:rabbitmq-demo-consumer.xml-->
        </param-value>
    </context-param>

    <!-- log4j 日志配置 -->
    <!--<listener>-->
        <!--<listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>-->
    <!--</listener>-->
    <!--<context-param>-->
        <!--<param-name>log4jRefreshInterval</param-name>-->
        <!--<param-value>60000</param-value>-->
    <!--</context-param>-->
    <!--<context-param>-->
        <!--<param-name>webAppRootKey</param-name>-->
        <!--<param-value>${conf.webModuleName}.root</param-value>-->
    <!--</context-param>-->
    <!--<context-param>-->
        <!--<param-name>log4jConfigLocation</param-name>-->
        <!--<param-value>classpath:log4j.xml</param-value>-->
    <!--</context-param>-->
    <!-- END -->

    <!-- log4j2 日志配置 -->
    <listener>
        <listener-class>org.apache.logging.log4j.web.Log4jServletContextListener</listener-class>
    </listener>
    <context-param>
        <param-name>isLog4jAutoInitializationDisabled</param-name>
        <param-value>false</param-value>
    </context-param>
    <context-param>
        <param-name>log4jContextName</param-name>
        <param-value>${conf.webModuleName}.root</param-value>
    </context-param>
    <context-param>
        <param-name>log4jConfiguration</param-name>
        <param-value>classpath:log4j2.xml</param-value>
    </context-param>

    <filter>
        <filter-name>log4j2ServletFilter</filter-name>
        <filter-class>org.apache.logging.log4j.web.Log4jServletFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>log4j2ServletFilter</filter-name>
        <url-pattern>/*</url-pattern>
        <dispatcher>REQUEST</dispatcher>
        <dispatcher>FORWARD</dispatcher>
        <dispatcher>INCLUDE</dispatcher>
        <dispatcher>ERROR</dispatcher>
    </filter-mapping>
    <!-- END -->

    <!-- logback 日志配置 start -->
    <!--<context-param>-->
        <!--<param-name>logbackConfigLocation</param-name>-->
        <!--<param-value>classpath:logback.xml</param-value>-->
    <!--</context-param>-->

    <!--<listener>-->
        <!--<listener-class>ch.qos.logback.ext.spring.web.LogbackConfigListener</listener-class>-->
    <!--</listener>-->
    <!-- logback 日志配置 end -->

    <!-- Filter 配置 START -->
    <!-- request 编码, 放在所有filter之前 -->
    <filter>
        <filter-name>Spring character encoding filter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>Spring character encoding filter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- 解决xss & sql漏洞 -->
    <filter>
        <filter-name>SafeFilter</filter-name>
        <filter-class>${conf.basePackage}.base.web.xss.HttpServletRequestSafeFilter</filter-class>
        <init-param>
            <param-name>filterXSS</param-name>
            <param-value>true</param-value>
        </init-param>
        <init-param>
            <param-name>filterSQL</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>SafeFilter</filter-name>
        <url-pattern>/*</url-pattern>
        <dispatcher>REQUEST</dispatcher>
    </filter-mapping>

    <!--解决tomcat部署跨域问题  -->
    <filter>
        <filter-name>CORS</filter-name>
        <filter-class>com.thetransactioncompany.cors.CORSFilter</filter-class>
        <init-param>
            <param-name>cors.allowOrigin</param-name>
            <param-value>*</param-value>
        </init-param>
        <init-param>
            <param-name>cors.supportedMethods</param-name>
            <param-value>GET, POST, HEAD, PUT, DELETE</param-value>
        </init-param>
        <init-param>
            <param-name>cors.supportedHeaders</param-name>
            <param-value>Accept, Origin, X-Requested-With, Content-Type, Last-Modified</param-value>
        </init-param>
        <init-param>
            <param-name>cors.exposedHeaders</param-name>
            <param-value>Set-Cookie, oauthstatus</param-value>
        </init-param>
        <init-param>
            <param-name>cors.supportsCredentials</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CORS</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- Shiro 权限控制 -->
    <filter>
        <filter-name>shiroFilter</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
        <init-param>
            <param-name>targetFilterLifecycle</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>shiroFilter</filter-name>
        <url-pattern>/*</url-pattern>
        <dispatcher>REQUEST</dispatcher>
        <dispatcher>FORWARD</dispatcher>
    </filter-mapping>

    <!-- 连接池 启用Web监控统计功能 -->
    <filter>
        <filter-name>DruidWebStatFilter</filter-name>
        <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
        <init-param>
            <param-name>exclusions</param-name>
            <param-value>*.js,*mp3,*.swf,*.xls,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
        </init-param>
        <init-param>
            <param-name>sessionStatMaxCount</param-name>
            <param-value>1000</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>DruidWebStatFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

    <!-- MdcLogFilter 配置 -->
    <filter>
        <filter-name>MdcLogFilter</filter-name>
        <filter-class>${conf.basePackage}.base.web.filter.MdcLogFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>MdcLogFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <!-- Filter 配置 START -->

    <!-- Servlet 配置 START -->
    <servlet>
        <servlet-name>DruidStatView</servlet-name>
        <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
        <!--deny优先于allow，如果在deny列表中，就算在allow列表中，也会被拒绝。-->
        <!--如果allow没有配置或者为空，则允许所有访问-->
        <init-param>
            <param-name>allow</param-name>
            <param-value/>
        </init-param>
        <init-param>
            <param-name>deny</param-name>
            <param-value/>
        </init-param>
        <init-param>
            <!-- 允许清空统计数据 -->
            <param-name>resetEnable</param-name>
            <param-value>true</param-value>
        </init-param>
        <init-param>
            <!-- 用户名 -->
            <param-name>loginUsername</param-name>
            <param-value>admin</param-value>
        </init-param>
        <init-param>
            <!-- 密码 -->
            <param-name>loginPassword</param-name>
            <param-value>123456</param-value>
        </init-param>
    </servlet>

    <servlet-mapping>
        <servlet-name>DruidStatView</servlet-name>
        <url-pattern>/druid/*</url-pattern>
    </servlet-mapping>
    <!-- 连接池 启用Web监控统计功能 end-->

    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath*:dispatcher-servlet.xml</param-value>
        </init-param>
        <load-on-startup>0</load-on-startup>
        <async-supported>true</async-supported>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

    <!--<servlet>-->
        <!--<servlet-name>CXFServlet</servlet-name>-->
        <!--<servlet-class>org.apache.cxf.transport.servlet.CXFServlet</servlet-class>-->
        <!--<load-on-startup>1</load-on-startup>-->
    <!--</servlet>-->
    <!--<servlet-mapping>-->
        <!--<servlet-name>CXFServlet</servlet-name>-->
        <!--<url-pattern>/ws/*</url-pattern>-->
    <!--</servlet-mapping>-->

    <!--<servlet>-->
        <!--<servlet-name>RpcDispatcher</servlet-name>-->
        <!--<servlet-class>com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet</servlet-class>-->
        <!--<load-on-startup>1</load-on-startup>-->
    <!--</servlet>-->

    <!--<servlet-mapping>-->
        <!--<servlet-name>RpcDispatcher</servlet-name>-->
        <!--<url-pattern>/rpc/*</url-pattern>-->
    <!--</servlet-mapping>-->
    <!-- Servlet 配置 END -->

    <!-- 设置session超时时间，单位：分钟 -->
    <session-config>
        <session-timeout>30</session-timeout>
    </session-config>

    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.jsp</welcome-file>
        <welcome-file>default.html</welcome-file>
        <welcome-file>default.htm</welcome-file>
        <welcome-file>default.jsp</welcome-file>
    </welcome-file-list>

    <error-page>
        <error-code>400</error-code>
        <location>/error/error400</location>
    </error-page>
    <error-page>
        <error-code>401</error-code>
        <location>/error/error401</location>
    </error-page>
    <error-page>
        <error-code>403</error-code>
        <location>/error/error403</location>
    </error-page>
    <error-page>
        <error-code>404</error-code>
        <location>/error/error404</location>
    </error-page>
    <error-page>
        <error-code>405</error-code>
        <location>/error/error405</location>
    </error-page>
    <error-page>
        <exception-type>java.lang.Throwable</exception-type>
        <location>/error/error500</location>
    </error-page>
    <error-page>
        <error-code>500</error-code>
        <location>/error/error500</location>
    </error-page>

    <mime-mapping>
        <extension>apk</extension>
        <mime-type>application/vnd.android.package-archive</mime-type>
    </mime-mapping>
    <mime-mapping>
        <extension>ipa</extension>
        <mime-type>application/vnd.iphone</mime-type>
    </mime-mapping>
</web-app>
