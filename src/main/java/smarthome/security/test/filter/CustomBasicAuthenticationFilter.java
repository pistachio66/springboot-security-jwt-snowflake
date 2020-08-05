/**
 * 
 */
package smarthome.security.test.filter;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import smarthome.security.test.util.JwtTokenUtils;


/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月27日 下午3:13:14
* @description 
*/
public class CustomBasicAuthenticationFilter extends BasicAuthenticationFilter{
	public CustomBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain chain) throws IOException,ServletException{
		String tokenHeader=request.getHeader(JwtTokenUtils.TOKEN_HEADER);
		//如果头部中没有token或者token前缀错误放行
		if(tokenHeader==null || !tokenHeader.startsWith(JwtTokenUtils.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		//如果头部中有token则进行解析并设置认证信息
		SecurityContextHolder.getContext().setAuthentication(getAuthentication(tokenHeader));
		super.doFilterInternal(request, response, chain);
	}
	/**
	 * @return
	 */
	private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
		// TODO Auto-generated method stub
		String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX,"");
		String username=JwtTokenUtils.getUsername(token);
		String role=JwtTokenUtils.getUserRole(token);
		if(username!=null) {
			return new UsernamePasswordAuthenticationToken(username,null,
					Collections.singleton(new SimpleGrantedAuthority(role)));
		}
		return null;
	}
	
}
