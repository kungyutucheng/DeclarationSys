package com.wyc.framework.interceptor;

import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TrimPageInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		/*Enumeration<String> keys = request.getParameterNames();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			String value = request.getParameter(key);
			Object value2 = value;
			if(value2 instanceof String[]){
				String [] values = (String[])value2;
				for(String temp : values){
					temp = temp.trim();
				}
				request.setAttribute(key, value);
			}else{
				request.setAttribute(key, value.toString().trim());
			}
		}*/
		System.out.println(1);

		Map<String, String[]> map = request.getParameterMap();
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			String[] value = map.get(key);
			for(String value1 : value){
				value1 = value1.trim();
			}
			map.put(key, value);
		}
		return true;
	}

}
