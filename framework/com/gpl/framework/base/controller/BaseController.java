package com.gpl.framework.base.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import com.gpl.framework.util.Page;

public class BaseController {

	/**
	 * 默认每页记录数
	 */
	private static final int DEFAULT_PAGE_SIZE = 20;
	private static final Logger LOGGER = Logger.getLogger(BaseController.class);
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	

	/**
	 * ModelAttribute注解的作用：
	 * 1、放在方法的形参上表示引用Model中的数据；
	 * 2、放在方法上面，表示请求该类的 每个controller前都会执行它，也可以将一些准备数据的操作放在该方法里面
	 * 
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		
	}
	
	/**
	 * 上述方法也可以这样实现
	 * request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	 * response = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
	 * 该种方法尚未测试过
	 * 以上俩中方法来源：
	 * http://blog.csdn.net/sonnet123/article/details/12168265
	 */
	
	/**
	 * 以String方式返回key值为name的参数值，如果name对应的值不存在，则返回null
	 * @param name
	 * @return
	 */
	public String getString(String name){
		try{
			return request.getParameter(name);
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * 以Integer方式返回key值为name的参数值，如果name对应的值不存在，返回null
	 * @param name
	 * @return
	 */
	public Integer getInt(String name){
		try{
			return Integer.valueOf(request.getParameter(name));
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * 以Float方式返回key值为name的参数，如果name对应的值不存在，返回null
	 * @param name
	 * @return
	 */
	public Float getFloat(String name){
		try{
			return Float.valueOf(request.getParameter(name));
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * 以Double方式返回key值为name的参数值，如果name对应的属性不存在，返回null
	 * @param name
	 * @return
	 */
	public Double getDouble(String name){
		try{
			return Double.valueOf(request.getParameter(name));
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * 以Boolean方式返回key值为name的参数值，如果name对应的属性不存在，返回null
	 * @param name
	 * @return
	 */
	public Boolean getBool(String name){
		try{
			return Boolean.valueOf(request.getParameter(name));
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * 获取request请求中的所有参数
	 * @return
	 */
	public Map<String, Object> getAllParams(){
		return getAllParams(false);
	}
	
	public Map<String, Object> getAllParams(boolean isAllowNull){
		Map<String, Object> map = new HashMap<String,Object>();
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
			String key = params.nextElement();
			String value = request.getParameter(key);
			if(isAllowNull){
				if(value == null || value.equals("")){
					map.put(key, null);
				}else{
					map.put(key, value);
				}
			}else if(value != null && !value.equals("")){
				map.put(key, value);
			}
		}
		return map;
	}
	
	/**
	 * 通过request中的参数构造page对象
	 * @return
	 */
	public Page getPage(){
		Page page = new Page();
		if(getInt(Page.PAGE_NO) != null){
			page.setPageNo(getInt(Page.PAGE_NO).intValue());
		}
		if(getInt(Page.PAGE_SIZE) != null){
			page.setPageSize(getInt(Page.PAGE_SIZE).intValue());
		}
		
		String orderBy = getString(Page.ORDER_BY);
		String order = getString(Page.ORDER);
		if(StringUtils.isNotEmpty(orderBy)){
			page.setOrderBy(orderBy);
		}
		if(StringUtils.isNotEmpty(order)){
			page.setOrder(order);
		}
		return page;
	}

	/**
	 * 重定向
	 * @param path
	 *//*
	public void redirect(String path){
		try {
			response.getOutputStream().print("<script type='text/javascript'>window.location = \"" + 
		request.getScheme()+"://"+request.getServerName() + ":" + request.getServerPort() 
		+ request.getContextPath() + "/" + path +"\"</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpSession getSession() {
		return session;
	}
	
	/**
	 * 将object对象转换成json数据
	 * @param value
	 * @return
	 */
	public String renderJsonStr(Object value){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(value);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
