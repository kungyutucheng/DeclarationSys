package com.gpl.framework.base.controller;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gpl.framework.util.Page;

public class BaseController {

	/**
	 * 
	 */
	private static final int DEFAULT_PAGE_SIZE = 20;
	private static final Logger LOGGER = Logger.getLogger(BaseController.class);
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	

	/**
	 * ModelAttribute属性会在此controller的每个方法执行前被执行
	 * 
	 * @param request
	 * @param response
	 */
	@ModelAttribute
	public void setRequestAndResponse(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		
	}
	
	/**
	 * 另一种实现方式
	 * request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	 * response = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
	 * 然后web.xml中需要配置如下listener
	 * <listener-class>org.springframework.web.context.request.RequestContentListener</listener-class> 
	 * 来源
	 * http://blog.csdn.net/sonnet123/article/details/12168265
	 */
	
	/**
	 * 获取string类型的参数
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
	 * 获取int类型的参数
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
	 * 获取float类型的参数
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
	 * 获取double类型的参数
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
	 * 获取bool类型的参数
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
	 * 获取全部参数
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
	 * 根据参数组建分页类 
	 * @return
	 */
	public Page getPage(){
		
		Page page = new Page();
		if(getInt(Page.PAGE_NO) != null){
			page.setPage(getInt(Page.PAGE_NO).intValue());
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
	 * 将object转换为json
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
