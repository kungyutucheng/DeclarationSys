package com.gpl.module.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gpl.framework.base.controller.BaseController;
import com.gpl.module.base.biz.CurrencyBiz;
import com.gpl.module.base.model.Currency;

@Controller
@RequestMapping(path = "/currency")
public class CurrencyController extends BaseController{

	@Autowired
	private CurrencyBiz currencyBiz;
	
	@RequestMapping(path = "/getAll",method = RequestMethod.POST,produces = "text/application;charset=utf-8")
	@ResponseBody
	public String getAll(){
		return renderJsonStr(currencyBiz.getAll(Currency.class.getName()));
	}
}
