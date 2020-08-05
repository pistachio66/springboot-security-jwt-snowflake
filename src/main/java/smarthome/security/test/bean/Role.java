/**
 * 
 */
package smarthome.security.test.bean;

import java.math.BigInteger;
import java.util.Date;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月24日 下午4:12:44
* @description 
*/
public class Role {
	private BigInteger roleId;
	private String roleName;
	private Date createTime;
	private Date updateTime;
	public BigInteger getRoleId() {
		return roleId;
	}
	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
}
