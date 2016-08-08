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
	 * Ĭ��ÿҳ��¼��
	 */
	private static final int DEFAULT_PAGE_SIZE = 20;
	private static final Logger LOGGER = Logger.getLogger(BaseController.class);
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	

	/**
	 * ModelAttributeע������ã�
	 * 1�����ڷ������β��ϱ�ʾ����Model�е����ݣ�
	 * 2�����ڷ������棬��ʾ�������� ÿ��controllerǰ����ִ������Ҳ���Խ�һЩ׼�����ݵĲ������ڸ÷�������
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
	 * ��������Ҳ��������ʵ��
	 * request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	 * response = ((ServletWebRequest) RequestContextHolder.getRequestAttributes()).getResponse();
	 * ���ַ�����δ���Թ�
	 * �������з�����Դ��
	 * http://blog.csdn.net/sonnet123/article/details/12168265
	 */
	
	/**
	 * ��String��ʽ����keyֵΪname�Ĳ���ֵ�����name��Ӧ��ֵ�����ڣ��򷵻�null
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
	 * ��Integer��ʽ����keyֵΪname�Ĳ���ֵ�����name��Ӧ��ֵ�����ڣ�����null
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
	 * ��Float��ʽ����keyֵΪname�Ĳ��������name��Ӧ��ֵ�����ڣ�����null
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
	 * ��Double��ʽ����keyֵΪname�Ĳ���ֵ�����name��Ӧ�����Բ����ڣ�����null
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
	 * ��Boolean��ʽ����keyֵΪname�Ĳ���ֵ�����name��Ӧ�����Բ����ڣ�����null
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
	 * ��ȡrequest�����е����в���
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
	 * ͨ��request�еĲ�������page����
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
	 * �ض���
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
	 * ��object����ת����json����
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
