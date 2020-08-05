/**
 * 
 */
package smarthome.security.test.service.impl;

import java.math.BigInteger;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import smarthome.security.test.bean.RegisterUser;
import smarthome.security.test.bean.ResultMessage;
import smarthome.security.test.bean.User;
import smarthome.security.test.enumeration.ResultEnum;
import smarthome.security.test.mapper.UserMapper;
import smarthome.security.test.service.UserService;
import smarthome.security.test.util.SnowflakeIdWorker;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月24日 下午5:56:08
* @description 
*/

@Service
public class UserServiceImpl implements UserService{
	private static final String ROLE_USER = "ROLE_USER";
	private ResultMessage<RegisterUser> resultMessage;
	
	@Autowired
	private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Override
	public ResultMessage<RegisterUser> userReg(RegisterUser registerUser) {
		// TODO Auto-generated method stub
        RegisterUser registerUser1 = new RegisterUser();
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        long userId = idWorker.nextId();
		registerUser1.setUserId(BigInteger.valueOf(userId));
        registerUser1.setUsername(registerUser.getUsername());
        registerUser1.setPhoneNumber(registerUser.getPhoneNumber());
        registerUser1.setPassword(bCryptPasswordEncoder.encode(registerUser.getPassword()));
        registerUser1.setRole(ROLE_USER);
        registerUser1.setCreateTime(new Date());
        int i = userMapper.insert(registerUser1);
        resultMessage = new ResultMessage<RegisterUser>();
        
        if(i==1) {
        	ResultEnum resultEnum=ResultEnum.SUCCESS;
        	resultMessage.setCode(resultEnum.getCode());
        	resultMessage.setMessage(resultEnum.getMessage());
        	resultMessage.setStatus("" + HttpServletResponse.SC_OK);
        	resultMessage.setData(registerUser1);
        	return resultMessage;
        }else {
        	ResultEnum resultEnum=ResultEnum.FAILURE;
        	resultMessage.setCode(resultEnum.getCode());
        	resultMessage.setMessage(resultEnum.getMessage());
        	resultMessage.setStatus("" + HttpServletResponse.SC_BAD_REQUEST);
        	resultMessage.setData(null);
        	return resultMessage;
        }
	}

	@Override
	public User login(String username) {
		// TODO Auto-generated method stub
		return userMapper.findByUsername(username);
	}

}
