/**
 * 
 */
package smarthome.security.test.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import smarthome.security.test.bean.RegisterUser;
import smarthome.security.test.bean.User;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月24日 上午11:41:50
* @description 
*/
@Mapper
public interface UserMapper {
	@Insert("INSERT INTO user(user_id,username,password,phone_number,email,create_time)"
			+ "values(#{userId},#{username},#{password},#{phoneNumber},#{email},#{createTime})")
	int insert(RegisterUser registerUser);
	
	@Select("SELECT user_id as userId,username,password,phone_number as phoneNumber,email,"
			+ "account_non_expired as accountNonExpired,account_non_locked as accountNonLocked,"
			+ "credentials_non_expired as credentialsNonExpired,enabled FROM user "
			+ "WHERE phone_number=#{username} or username=#{username} or email=#{username}")
	User findByUsername(String username);
	
	
	//如果没有检索到数据,返回0元素的list，map,set而不是null
    //List result = Collections.EMPTY_LIST;
}
