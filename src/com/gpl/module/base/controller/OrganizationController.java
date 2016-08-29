package com.gpl.module.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpl.framework.annotation.SystemControllerLog;
import com.gpl.framework.base.controller.BaseController;
import com.gpl.module.base.biz.OrganizationBiz;
import com.gpl.module.base.model.Organization;

@Controller
@RequestMapping(path = "/org")
public class OrganizationController extends BaseController{

	@Autowired
	private OrganizationBiz organizationBiz;
	
	/**
	 * 获取审核机构全部数据
	 * @return
	 */
	@SystemControllerLog(desc = "获取审核机构全部数据")
	@RequestMapping(path = "/getAll",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getAll(){
		return renderJsonStr(organizationBiz.getAll(Organization.class.getName()));
	}
}
