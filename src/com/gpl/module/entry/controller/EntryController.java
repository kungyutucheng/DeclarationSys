package com.gpl.module.entry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gpl.framework.base.controller.BaseController;

@Controller
@RequestMapping(path = "/entry")
public class EntryController extends BaseController{

	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public ModelAndView list(){
		return new ModelAndView("entry/list");
	}
}
