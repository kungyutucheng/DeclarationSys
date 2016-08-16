package com.gpl.module.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpl.framework.base.controller.BaseController;
import com.gpl.module.base.biz.ChargeTypeBiz;
import com.gpl.module.base.model.ChargeType;

@Controller
@RequestMapping(path = "/chargeType")
public class ChargeTypeController extends BaseController{

	@Autowired
	private ChargeTypeBiz chargeTypeBiz;
	
	@RequestMapping(path = "/getAll",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getAll(){
		return renderJsonStr(chargeTypeBiz.getAll(ChargeType.class.getName()));
	}
}
