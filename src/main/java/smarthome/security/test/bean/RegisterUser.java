/**
 * 
 */
package smarthome.security.test.bean;

import java.math.BigInteger;
import java.util.Date;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月27日 下午5:03:54
* @description 
*/
public class RegisterUser {
	private BigInteger userId;
	private String username;
	private String email;
	// 必需
	private String phoneNumber;
	// 手机验证码，必需
	private String phoneVerifyCode;
	// 必需
	private String password;
	private String role;
	private Date createTime;
	
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneVerifyCode() {
		return phoneVerifyCode;
	}
	public void setPhoneVerifyCode(String phoneVerifyCode) {
		this.phoneVerifyCode = phoneVerifyCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "RegisterUser [userId=" + userId + ", username=" + username + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", phoneVerifyCode=" + phoneVerifyCode + ", password=" + password + ", role=" + role
				+ ", createTime=" + createTime + "]";
	}

	
}
