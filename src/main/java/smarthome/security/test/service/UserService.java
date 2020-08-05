/**
 * 
 */
package smarthome.security.test.service;

import smarthome.security.test.bean.RegisterUser;
import smarthome.security.test.bean.ResultMessage;
import smarthome.security.test.bean.User;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月24日 下午5:54:43
* @description 
*/

public interface UserService {
	ResultMessage<RegisterUser> userReg(RegisterUser registerUser);
	User login(String username);
}
