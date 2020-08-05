/**
 * 
 */
package smarthome.security.test.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import smarthome.security.test.bean.CustomUserDetails;
import smarthome.security.test.bean.LoginUser;
import smarthome.security.test.bean.ResultMessage;
import smarthome.security.test.enumeration.ResultEnum;
import smarthome.security.test.util.JwtTokenUtils;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月27日 下午4:26:02
* @description 
*/
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private ResultMessage<String> resultMessage;
	private ThreadLocal<Integer> rememberMe=new ThreadLocal<>();
	private AuthenticationManager authenticationManager;
	
	public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager=authenticationManager;
		super.setFilterProcessesUrl("/auth/login");
	}
	
	@Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        // 从输入流中获取到登录的信息
        try {
            LoginUser loginUser = new ObjectMapper().readValue(request.getInputStream(), LoginUser.class);
            rememberMe.set(loginUser.getRememberMe());
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	// 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
    	    	
        CustomUserDetails customUserDetails = (CustomUserDetails) authResult.getPrincipal();
        rememberMe.set(1);
        boolean isRemember = rememberMe.get() == 1;

        String role = "";
        Collection<? extends GrantedAuthority> authorities = customUserDetails.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }

        String token = JwtTokenUtils.generateToken(customUserDetails.getUsername(), role, isRemember);
        // 返回创建成功的token
        // 按照jwt的规定，请求时原样是 `Bearer token`
        response.setHeader(JwtTokenUtils.TOKEN_HEADER, JwtTokenUtils.TOKEN_PREFIX + token);
        resultMessage = new ResultMessage<String>();
        ResultEnum resultEnum=ResultEnum.SUCCESS;
        resultMessage.setCode(resultEnum.getCode());
        resultMessage.setMessage(resultEnum.getMessage());
        resultMessage.setStatus("" + HttpServletResponse.SC_OK);
        resultMessage.setData(JwtTokenUtils.TOKEN_PREFIX + token);
        response.getWriter().write(new ObjectMapper().writeValueAsString(resultMessage));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        resultMessage = new ResultMessage<String>();
        ResultEnum resultEnum=ResultEnum.FAILURE;
        resultMessage.setCode(resultEnum.getCode());
        resultMessage.setMessage(resultEnum.getMessage());
        resultMessage.setStatus("" + HttpServletResponse.SC_FORBIDDEN);
        resultMessage.setData("authentication failed, reason: " + e.getMessage());
    	response.getWriter().write(new ObjectMapper().writeValueAsString(resultMessage));
    }
}
