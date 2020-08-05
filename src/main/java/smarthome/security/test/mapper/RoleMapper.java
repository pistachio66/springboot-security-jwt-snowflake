/**
 * 
 */
package smarthome.security.test.mapper;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import smarthome.security.test.bean.Role;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月24日 上午11:42:18
* @description 
*/
@Mapper
public interface RoleMapper {
	@Select("SELECT role_id as roleId,role_name as roleName FROM role r left join user_role ur "
			+ "on r.user_id=ur.user_id Where ur.user_id=#{userId}")
	List<Role> getRoleByUserId(BigInteger userId);
}
