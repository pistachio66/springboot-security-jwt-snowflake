/**
 * 
 */
package smarthome.security.test.service;

import java.math.BigInteger;
import java.util.List;

import smarthome.security.test.bean.Role;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月24日 下午5:55:01
* @description 
*/

public interface RoleService {
	List<Role> findRoleByUsername(BigInteger userId);
}
