/**
 * 
 */
package smarthome.security.test.enumeration;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月31日 上午10:34:36
* @description 
*/
public enum ResultEnum {
	// 错误统一返回
	UNKNOWN("-1","error:"),
	SUCCESS("00","success."),
	FAILURE("01","failure.");
	
	private final String code;
	private final String message;
	
	ResultEnum(String code,String message){
		this.code=code;
		this.message=message;
	}
	public String getCode() {
		return this.code;
	}
	public String getMessage() {
		return this.message;
	}
}
