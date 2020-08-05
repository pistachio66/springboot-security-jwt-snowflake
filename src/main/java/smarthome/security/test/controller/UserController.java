package smarthome.security.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import smarthome.security.test.bean.RegisterUser;
import smarthome.security.test.bean.ResultMessage;
import smarthome.security.test.service.UserService;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月27日 下午2:40:11
* @description 
*/
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register-user")
    public @ResponseBody ResultMessage<RegisterUser> registerUser(@RequestBody RegisterUser registerUser){
        return userService.userReg(registerUser);
    }
}
