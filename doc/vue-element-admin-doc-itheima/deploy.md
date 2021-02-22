# 构建和发布

## 关闭 mock 数据

打开 `/src/main.js` 注释 `mock`

```js
...
// import './mock0' // simulation data
...
```

## 构建

当项目开发完毕，只需要运行一行命令就可以打包你的应用：

```bash
# 打包正式环境
npm run build
```

## 发布

对于发布来讲，只需要将最终生成的静态文件，也就是通常情况下 `dist` 文件夹的静态文件发布到你的 cdn 或者静态服务器即可，需要注意的是其中的 `index.html` 通常会是你后台服务的入口页面，在确定了 js 和 css 的静态之后可能需要改变页面的引入路径。
?> 部署是可能会发现资源路径不对 ,只需修改 `config/index.js` 文件资源路径即可。

```js
assetsPublicPath: './' //请根据自己路径来配置更改
```

### 前端路由与服务端的结合

vue-element-admin 中，前端路由使用的是 `vue-router`，所以你可以选择两种方式：`browserHistory` 和 `hashHistory`。

两者的区别简单来说是对路由方式的处理不一样，`hashHistory` 是以 `#` 后面的路径进行处理，通过 [HTML 5 History](https://developer.mozilla.org/en-US/docs/Web/API/History_API) 进行前端路由管理，而 `browserHistory` 则是类似我们通常的页面访问路径，并没有 `#`，但要通过服务端的配置，能够访问指定的 url 都定向到当前页面，从而能够进行前端的路由管理。

本项目默认使用的是 `hashHistory` ，所以如果你的 url 里有 `#`，想去掉的话，需要切换为 `browserHistory`。修改 `src/router/index.js` 中的 mode 即可

```js
export default new Router({
  // mode: 'history', //后端支持可开
})
```

如果你使用的是静态站点，那么使用 `browserHistory` 可能会无法访问你的应用，因为假设你访问 `http://localhost:9527/dashboard`，那么其实你的静态服务器并没有能够映射的文件，而使用 `hashHistory` 则不会有这个问题，因为它的页面路径是以 `#` 开始的，所有访问都在前端完成，如：`http://localhost:9527/#/dashboard/`。

不过如果你有对应的后台服务器，那么我们推荐采用 `browserHistory`，只需要在服务端做一个映射，比如：

Apache

```bash
<IfModule mod_rewrite.c>
  RewriteEngine On
  RewriteBase /
  RewriteRule ^index\.html$ - [L]
  RewriteCond %{REQUEST_FILENAME} !-f
  RewriteCond %{REQUEST_FILENAME} !-d
  RewriteRule . /index.html [L]
</IfModule>
```

nginx

```bash
location / {
  try_files $uri $uri/ /index.html;
}
```

?> 更多配置请查看 [vue-router 文档](https://router.vuejs.org/zh-cn/essentials/history-mode.html)

## apache

1.  需要修改`router/index.js`中`new Router` 配置，加一个`base: '/vue/'`, 它指定应用的基路径，该应用是服务于`localhost/vue`路径下，所以必须加`base`配置，否则应用会展示 404 页面
2.  需要修改`config/index.js`中 build 下的`assetsPublicPath: '/vue/'`，如果用相对路径，chunk 文件会报错找不到。
3.  修改`httpd.conf`文件，开启 rewrite_module 功能。

* `LoadModule rewrite_module libexec/apache2/mod_rewrite.so`，去掉前面的#。
* 然后找到`AllowOverride None`的那行，把它改成`AllowOverride All`，来使`.htaccess`文件生效。

4.  在 apache 的`www/vue` 目录下新建`.htaccess`文件, 需要修改`RewriteRule` 为`/vue/index.html`, 否则刷新页面服务端会直接报 404 错误。

.htaccess 文件内容

```
<IfModule mod_rewrite.c>
  RewriteEngine On
  RewriteBase /
  RewriteRule ^index\.html$ - [L]
  RewriteCond %{REQUEST_FILENAME} !-f
  RewriteCond %{REQUEST_FILENAME} !-d
  RewriteRule . /vue/index.html [L]
</IfModule>
```

## nginx api 请求转发

编辑 `/usr/local/nginx/conf/nginx.conf`

* 简单配置

```bash
server {
  listen       80;
  server_name  localhost;      # 这里指定域名
  root /home/www/vue-web-site;
  # 匹配 api 路由的反向代理到API服务
  location ^~/api/ {
    rewrite ^/(.*)$ /$1 break;
    proxy_pass http://127.0.0.1:8080;
  }
}
```

* 复杂情况例子

```bash
upstream server-api{
  # api 代理服务地址
  server 127.0.0.1:8080;
}
upstream server-resource{
  # 静态资源 代理服务地址
  server 127.0.0.1:8090;
}
server {
  listen       80;
  server_name  localhost;      # 这里指定域名
  root /home/www/vue-web-site;
  # 匹配 api 路由的反向代理到API服务
  location ^~/api/ {
    rewrite ^/(.*)$ /$1 break;
    proxy_pass http://server-api;
  }
  # 假设这里验证码也在API服务中
  location ^~/captcha {
    rewrite ^/(.*)$ /$1 break;
    proxy_pass http://server-api;
  }
  # 假设你的图片资源全部在另外一个服务上面
  location ^~/img/ {
    rewrite ^/(.*)$ /$1 break;
    proxy_pass http://server-resource;
  }
}
```
