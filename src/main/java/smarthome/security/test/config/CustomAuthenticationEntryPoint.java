package smarthome.security.test.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import smarthome.security.test.bean.ResultMessage;
import smarthome.security.test.enumeration.ResultEnum;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @author Michaelzxh E-mail:michael_zxh@163.com
* @version 创建时间：2020年7月24日 下午5:56:08
* @description 统计处理身份验证错误
*/
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	private ResultMessage<String> resultMessage;
	
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
    	resultMessage = new ResultMessage<String>();
    	ResultEnum resultEnum=ResultEnum.UNKNOWN;
    	
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        resultMessage.setCode(resultEnum.getCode());
        resultMessage.setStatus("" + HttpServletResponse.SC_FORBIDDEN);
        resultMessage.setMessage(resultEnum.getMessage() + authException.getMessage());
        //response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(new ObjectMapper().writeValueAsString(resultMessage));
    }
}
