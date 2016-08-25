package com.gpl.framework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;

import com.gpl.authorization.model.User;
import com.gpl.framework.context.UserContext;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		String uri = httpRequest.getRequestURI();
		String assertUri = "assert";
		String imagesUri = "images";
		//login路径及静态资源文件不做处理
		if(uri.contains("login/login") || uri.contains(assertUri) || uri.endsWith(".jpg") || uri.endsWith(".png") || 
				uri.endsWith(".js") || uri.endsWith(".css")){
			chain.doFilter(request, response); 
		}else{
			//记录入session中
			User user = (User) session.getAttribute("user");
			//放入上下文环境
			UserContext.setContext(user);
			//已登录
			if(user != null){
				chain.doFilter(request, response);
			}else{
				//未登录
				httpResponse.sendRedirect(httpRequest.getContextPath() + "/login/loginPage");
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
