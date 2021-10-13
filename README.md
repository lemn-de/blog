# 一个多人博客/论坛

## 项目说明

本项目实现了登录注册，文章浏览，最热文章，最新文章，最热标签，文章分类，文章标签，文章归档，写文章，评论等各个模块

## 技术说明

- 登录采用redis+JWT令牌的登录方式，redis对登录用户做了缓存，灵活控制用户过期；
- threadLocal保存用户信息，请求的线程之内可以随时获取登录的用户，做了线程隔离
- 使用了线程池进行异步更新文章阅读数；
- 使用了AOP实现了一个自定义日志，AOP实现统一redis缓存处理
- 图片上传采用的是Gitee图床，后端api接口压缩图片上传到Gitee仓库，返回url地址



## 项目展示

主页展示：

![image-20211013165930801](https://gitee.com/lemndo/picture/raw/master/img/image-20211013165930801.png)

文章分类页：

![image-20211013170011086](https://gitee.com/lemndo/picture/raw/master/img/image-20211013170011086.png)

文章标签页：

![image-20211013170732188](https://gitee.com/lemndo/picture/raw/master/img/image-20211013170732188.png)

文章归档：

![image-20211013170747264](https://gitee.com/lemndo/picture/raw/master/img/image-20211013170747264.png)

其他实现：图片上传，评论功能，登录注册

包括了一个markdown编辑器

![image-20211013170759480](https://gitee.com/lemndo/picture/raw/master/img/image-20211013170759480.png)

## 项目文件说明
blog-api:项目后端

相关技术：springboot,mybatis-plus,JWT

blog-app:项目前端

相关技术：Vue+ElementUI

blog-admin:管理后台

相关技术：Spring Security

