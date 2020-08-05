# springboot-jwt-SnowflakeldWorker-demo

## 简介
这是一个使用了springboot+springSecurity+jwt+SnowflakeldWorker实现的基于token的权限管理的一个demo,代码规范符合阿里巴巴Java开发手册

具体说明可以看 **[这里](https://github.com/pistachio66/springboot-security-jwt/master/HELP.md)**

## 使用
修改`application.properites`的数据库的一些配置信息，然后就可以运行了。
表结构文件smarthome_security_test.sql在resources文件夹下，需要到数据库中手工操作。

首先注册的url是`/auth/register-user`
参数:

{
	"username":"admin",//username,phoneNumber可以都要，也可以二选一
	"password":"123456",
    "phoneNumber":"17800000000",//username,phoneNumber可以都要，也可以二选一
    "phoneVerifyCode":"123456"//手机验证码，预留
}

注册成功，返回：

{
    "code": "00",
    "status": "200",
    "message": "success.",
    "data": {
        "userId": 738770816124059648,
        "username": "admin3",
        "email": null,
        "phoneNumber": "17800000003",
        "phoneVerifyCode": null,
        "password": "$2a$10$xA8hbmKaJqdKqoPnD9CwR.sP3Kri2.pSu84iEI3iL6j61Ar4l.6hm",
        "role": "ROLE_USER",
        "createTime": "2020-07-31T06:51:28.442+00:00"
    }
}

然后登陆是`/auth/login`

参数:

{
	"username":"admin",//username,phoneNumber可以都要，也可以二选一
	"password":"123456",
    "phoneNumber":"17800000000",//username,phoneNumber可以都要，也可以二选一
    "verifyCode":"123456"//随机验证码，预留
}

登陆成功响应头里和体里都可以找到token：
 
{"code":"00","status":"200","message":"success.","data":"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJST0xFX1VTRVIiLCJpc3MiOiJNaWNoYWVsIiwiZXhwIjoxNTk2NzgyODQ2LCJpYXQiOjE1OTYxNzgwNDZ9.fcNTd_KAxndauQqGQ1vC7YPmAfkoGd0ByNyLko9Zkpy47LQPE7MgAGkgZGIf8XM7_iI5US5RXNng32unFZ4Cdw"}

推荐使用postman去测试。

之后就可以访问`/resources`了

后续将进一步完善...

加好友请刷码：


# springboot-security-jwt-snowflake
# springboot-security-jwt-snowflake
