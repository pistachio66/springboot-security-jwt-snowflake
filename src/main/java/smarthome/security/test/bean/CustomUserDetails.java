package smarthome.security.test.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月24日 下午5:56:08
* @description 
*/
public class CustomUserDetails implements UserDetails {
	private static final String ROLE_USER="ROLE_USER";
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigInteger id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails() {
    }

    // 写一个能直接使用user创建jwtUser的构造器
    public CustomUserDetails(User user) {
        id = user.getUserId();
        username = user.getUsername();
        password = user.getPassword();
        authorities = Collections.singleton(new SimpleGrantedAuthority(ROLE_USER));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public String toString() {
		return "CustomUserDetails [id=" + id + ", username=" + username + ", password=" + password + ", authorities="
				+ authorities + "]";
	}

}
