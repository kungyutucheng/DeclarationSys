package com.gpl.module.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpl.framework.base.controller.BaseController;
import com.gpl.framework.model.AjaxModel;
import com.gpl.framework.util.Page;
import com.gpl.module.base.biz.EnterpriseBiz;

@Controller
@RequestMapping(path = "ent")
public class EnterpriseController extends BaseController{

	@Autowired
	private EnterpriseBiz enterpriseBiz;
	
	@RequestMapping(path = "/searchGrid",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String searchGrid(){
		Page page = getPage();
		page.setParams(getAllParams());
		return renderJsonStr(enterpriseBiz.queryPage(page));
	}
	
	@RequestMapping(path = "/getAll",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getAll(){
		return renderJsonStr(enterpriseBiz.getAll());
	}
}
