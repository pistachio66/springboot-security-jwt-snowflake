/**
 * 
 */
package smarthome.security.test.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smarthome.security.test.bean.Role;
import smarthome.security.test.mapper.RoleMapper;
import smarthome.security.test.service.RoleService;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月24日 下午5:56:41
* @description 
*/

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findRoleByUsername(BigInteger userId) {
		// TODO Auto-generated method stub
		
		return roleMapper.getRoleByUserId(userId);
	}

}
