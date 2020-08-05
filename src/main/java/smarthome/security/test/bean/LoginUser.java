/**
 * 
 */
package smarthome.security.test.bean;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月27日 下午4:51:51
* @description 
*/
public class LoginUser {
	private String username;
	private String password;
	private String phoneNumber;
	private String verifyCode;
	private Integer rememberMe;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public Integer getRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(Integer rememberMe) {
		this.rememberMe = rememberMe;
	}
	@Override
	public String toString() {
		return "LoginUser [username=" + username + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", verifyCode=" + verifyCode + ", rememberMe=" + rememberMe + "]";
	}	
}
