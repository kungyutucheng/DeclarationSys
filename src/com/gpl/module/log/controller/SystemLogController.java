package com.gpl.module.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.util.Page;
import com.gpl.module.log.biz.SystemLogBiz;

@RequestMapping(path = "/systemLog")
@Controller
public class SystemLogController extends BaseController{

	
	@Autowired
	private SystemLogBiz systemLogBiz;
	
	@RequestMapping(path = "/list")
	public ModelAndView list(){
		return new ModelAndView("log/systemLog/list");
	}
	
	@RequestMapping(path = "/searchgrid" , method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String searchgrid(){
		Page page = getPage();
		page.setParams(getAllParams());
		return renderJsonStr(systemLogBiz.queryPage(page));
	}
}
