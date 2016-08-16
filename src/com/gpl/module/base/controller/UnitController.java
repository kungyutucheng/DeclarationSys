package com.gpl.module.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpl.framework.base.controller.BaseController;
import com.gpl.module.base.biz.UnitBiz;
import com.gpl.module.base.model.Unit;

@Controller
@RequestMapping(path = "/unit")
public class UnitController extends BaseController{

	@Autowired
	private UnitBiz unitBiz;
	
	@RequestMapping(path = "/getAll",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getAll(){
		return renderJsonStr(unitBiz.getAll(Unit.class.getName()));
	}
}
