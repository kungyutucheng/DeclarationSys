package com.gpl.module.log.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.framework.annotation.SystemControllerLog;
import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.util.Page;
import com.gpl.module.log.biz.SystemLogBiz;

@RequestMapping(path = "/exceptionLog")
@Controller
public class ExceptionLogController extends BaseController{

	
	@Autowired
	private SystemLogBiz systemLogBiz;
	
	/**
	 * 获取异常日志查询页面
	 * @return
	 */
	@SystemControllerLog(desc = "获取异常日志查询页面")
	@RequestMapping(path = "/list")
	public ModelAndView list(){
		return new ModelAndView("log/exceptionLog/list");
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@SystemControllerLog(desc = "分页查询")
	@RequestMapping(path = "/searchgrid" , method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String searchgrid(){
		Page page = getPage();
		Map<String, Object> params = getAllParams();
		params.put("type", 2);
		page.setParams(params);
		return renderJsonStr(systemLogBiz.queryPage(page));
	}
}
