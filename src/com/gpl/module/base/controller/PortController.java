package com.gpl.module.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpl.framework.annotation.SystemControllerLog;
import com.gpl.framework.base.controller.BaseController;
import com.gpl.module.base.biz.PortBiz;
import com.gpl.module.base.model.Port;

@Controller
@RequestMapping(path = "/port")
public class PortController extends BaseController{

	@Autowired
	private PortBiz portBiz;
	
	/**
	 * 获取港口全部数据
	 * @return
	 */
	@SystemControllerLog(desc = "获取港口全部数据")
	@RequestMapping(path = "/getAll",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getAll(){
		return renderJsonStr(portBiz.getAll(Port.class.getName()));
	}
}
