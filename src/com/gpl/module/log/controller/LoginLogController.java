package com.gpl.module.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.framework.annotation.SystemControllerLog;
import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.util.Page;
import com.gpl.module.log.biz.LoginLogBiz;

@RequestMapping(path = "/loginLog")
@Controller
public class LoginLogController extends BaseController{

	@Autowired
	private LoginLogBiz loginLogBiz;
	
	/**
	 * 获取登录日志查询页面
	 * @return
	 */
	@SystemControllerLog(desc = "获取登录日志查询页面")
	@RequestMapping(path = "/list")
	public ModelAndView list(){
		return new ModelAndView("log/loginLog/list");
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@SystemControllerLog(desc = "分页查询")
	@RequestMapping(path = "/searchgrid",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String searchgrid(){
		Page page = getPage();
		page.setParams(getAllParams());
		System.out.println(getAllParams().toString());
		return renderJsonStr(loginLogBiz.queryPage(page));
		
	}
}
